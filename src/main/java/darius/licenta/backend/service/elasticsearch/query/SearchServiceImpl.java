package darius.licenta.backend.service.elasticsearch.query;

import darius.licenta.backend.dto.elasticsearch.search.ElasticSearchResultQuery;
import darius.licenta.backend.dto.elasticsearch.search.ReturnPropertyNamesDto;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class SearchServiceImpl implements SearchService {
    private static final Logger logger = LoggerFactory.getLogger(SearchServiceImpl.class);

    @Value("${api.elasticsearch.uri}")
    private String elasticSearchUri;

    @Value("${api.elasticsearch.search}")
    private String elasticSearchSearchPrefix;

    @Value("${api.elasticsearch.mapping}")
    private String elasticSearchMappingPrefix;

    @Override
    public ElasticSearchResultQuery searchFromQuery(Optional<List<String>> collections, Optional<List<String>> returnFields, String term, Optional<List<String>> fields, String from, String size) throws IOException {
        String body = QueryHelperBuilder.buildMultipleFieldSearchQuery(term, returnFields, fields, from, size);
        return executeHttpRequestForQueryResults(collections, body);
    }

    @Override
    public ReturnPropertyNamesDto getFieldNamesFromQuery(List<String> collectionNamesForFieldReturn) throws IOException {
        return executeHttpRequestForFieldResults(collectionNamesForFieldReturn);
    }

    private ReturnPropertyNamesDto executeHttpRequestForFieldResults(List<String> collectionNamesForFieldReturn) throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(concatUrl(elasticSearchUri, String.join(",", collectionNamesForFieldReturn), elasticSearchMappingPrefix));
            try {
                HttpResponse response = httpClient.execute(httpGet);
                String message = EntityUtils.toString(response.getEntity());
                JSONObject myObject = new JSONObject(message);
                Map<String, List<String>> collectionNamePropertiesMap = new HashMap<>();
                JSONArray keys = myObject.names();
                for (int i = 0; i < keys.length(); i++) {
                    String currentKey = keys.get(i).toString();
                    JSONObject collectionName = myObject.getJSONObject(currentKey);
                    JSONObject innerObject = collectionName.getJSONObject(ElasticSearchConstants.MAPPPINGS).getJSONObject(ElasticSearchConstants.PROPERTIES);
                    JSONArray propertyNamesKeys = innerObject.names();
                    for (int j = 0; j < propertyNamesKeys.length(); j++) {
                        String currentPropertyNameKey = propertyNamesKeys.get(j).toString();
                        if (collectionNamePropertiesMap.containsKey(currentKey)) {
                            collectionNamePropertiesMap.get(currentKey).add(currentPropertyNameKey);
                        } else {
                            collectionNamePropertiesMap.put(currentKey, new ArrayList<>(Collections.singletonList(currentPropertyNameKey)));
                        }
                    }
                }
                return new ReturnPropertyNamesDto(collectionNamePropertiesMap);
            } catch (IOException | JSONException e) {
                logger.error("Exception: {}", e.getMessage());
                return null;
            }
        }
    }

    private ElasticSearchResultQuery executeHttpRequestForQueryResults(Optional<List<String>> collections, String body) throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            ElasticSearchResultQuery elasticSearchResultQuery = new ElasticSearchResultQuery();

            HttpPost httpPost = collections.map(strings ->
                    new HttpPost(concatUrl(elasticSearchUri, String.join(",", strings),
                            elasticSearchSearchPrefix))).orElseGet(() -> new HttpPost(concatUrl(elasticSearchUri, "", elasticSearchSearchPrefix)));

            httpPost.setHeader(ElasticSearchConstants.CONTENT_ACCEPT, ElasticSearchConstants.APP_TYPE);
            httpPost.setHeader(ElasticSearchConstants.CONTENT_TYPE, ElasticSearchConstants.APP_TYPE);
            try {
                httpPost.setEntity(new StringEntity(body, ElasticSearchConstants.ENCODING_UTF8));
                HttpResponse response = httpClient.execute(httpPost);
                String message = EntityUtils.toString(response.getEntity());
                JSONObject myObject = new JSONObject(message);
                Long totalHits = myObject.getJSONObject(ElasticSearchConstants.HITS).getJSONObject(ElasticSearchConstants.TOTAL_HITS).getLong("value");
                if (totalHits != 0) {
                    elasticSearchResultQuery.setElements(message);
                    elasticSearchResultQuery.setNumberOfResults(totalHits);
                } else {
                    elasticSearchResultQuery.setElements(null);
                    elasticSearchResultQuery.setNumberOfResults(0L);
                }
                elasticSearchResultQuery.setTimeTook((float) ((double) myObject.getInt(ElasticSearchConstants.TOOK) / ElasticSearchConstants.TO_MS));
            } catch (IOException | JSONException e) {
                logger.error("Exception: {}", e.getMessage());
                elasticSearchResultQuery.setNumberOfResults(0L);
            }

            return elasticSearchResultQuery;
        }
    }

    public static String concatUrl(String s1, String s2, String s3) {
        return s1 + s2 + s3;
    }
}