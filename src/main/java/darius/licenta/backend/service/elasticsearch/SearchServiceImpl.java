package darius.licenta.backend.service.elasticsearch;

import com.google.gson.*;
import darius.licenta.backend.dto.elasticsearch.ElasticSearchResultQuery;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    private static final Logger logger = LoggerFactory.getLogger(SearchService.class);
    private static final Gson gson = new Gson();

    @Value("${api.elasticsearch.uri}")
    private String elasticSearchUri;

    @Value("${api.elasticsearch.search}")
    private String elasticSearchSearchPrefix;

    @Override
    public ElasticSearchResultQuery searchFromQuery(List<String> collections, String term, List<String> fields, String from, String size) throws IOException {
        String body = QueryHelperBuilder.buildMultipleFieldSearchQuery(term, fields, from, size);
        return executeHttpRequest(collections, body);
    }

    private ElasticSearchResultQuery executeHttpRequest(List<String> collections, String body) throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            ElasticSearchResultQuery elasticSearchResultQuery = new ElasticSearchResultQuery();
            HttpPost httpPost = new HttpPost(concatUrl(elasticSearchUri, String.join(",", collections), elasticSearchSearchPrefix));
            httpPost.setHeader(ElasticSearchConstants.CONTENT_ACCEPT, ElasticSearchConstants.APP_TYPE);
            httpPost.setHeader(ElasticSearchConstants.CONTENT_TYPE, ElasticSearchConstants.APP_TYPE);
            try {
                httpPost.setEntity(new StringEntity(body, ElasticSearchConstants.ENCODING_UTF8));
                HttpResponse response = httpClient.execute(httpPost);
                String message = EntityUtils.toString(response.getEntity());
                JSONObject myObject = new JSONObject(message);
                int totalHits = myObject.getJSONObject(ElasticSearchConstants.HITS).getJSONObject(ElasticSearchConstants.TOTAL_HITS).getInt("value");
                if (totalHits != 0) {
                    elasticSearchResultQuery.setElements(message);
                    elasticSearchResultQuery.setNumberOfResults(totalHits);
                } else {
                    elasticSearchResultQuery.setElements(null);
                    elasticSearchResultQuery.setNumberOfResults(0);
                }
                elasticSearchResultQuery.setTimeTook((float) ((double) myObject.getInt(ElasticSearchConstants.TOOK) / ElasticSearchConstants.TO_MS));
            } catch (IOException | JSONException e) {
                logger.error("Exception: {}", e.getMessage());
                elasticSearchResultQuery.setNumberOfResults(0);
            }

            return elasticSearchResultQuery;
        }
    }

    public static String concatUrl(String s1, String s2, String s3) {
        return new StringBuilder(s1).append(s2).append(s3).toString();
    }
}