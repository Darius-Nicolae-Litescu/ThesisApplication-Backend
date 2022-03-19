package darius.licenta.backend.service.elasticsearch.exactquery;

import darius.licenta.backend.dto.elasticsearch.filter.*;
import darius.licenta.backend.dto.elasticsearch.search.ElasticSearchResultQuery;
import org.elasticsearch.action.search.MultiSearchRequest;
import org.elasticsearch.action.search.MultiSearchResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.core.TimeValue;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ElasticSearchExactQueryServiceImpl implements ElasticSearchExactQueryService {
    private RestHighLevelClient restHighLevelClient;

    @Autowired
    public ElasticSearchExactQueryServiceImpl(RestHighLevelClient restHighLevelClient) {
        this.restHighLevelClient = restHighLevelClient;
    }


    @Override
    public ElasticSearchResultQuery getExactSearchFromFilters(FilterByMultipleFieldsDto filterByMultipleFieldsDto) {
        SearchRequest storySearchRequest = getStoryFilterRequest(filterByMultipleFieldsDto.getFilterStoryDto());
        SearchRequest storyTaskSearchRequest = getStoryTaskFilterRequest(filterByMultipleFieldsDto.getFilterStoryTaskDto());
        SearchRequest softwareApplicationSearchRequest = getSoftwareApplicationFilterRequest(filterByMultipleFieldsDto.getFilterSoftwareApplicationDto());
        SearchRequest commentSearchRequest = getCommentFilterRequest(filterByMultipleFieldsDto.getFilterCommentDto());
        SearchRequest userSearchRequest = getUserFilterRequest(filterByMultipleFieldsDto.getFilterUserDto());

        MultiSearchRequest request = new MultiSearchRequest();
        if (storySearchRequest != null) {
            request.add(storySearchRequest);
        }
        if (storyTaskSearchRequest != null) {
            request.add(storyTaskSearchRequest);
        }
        if (softwareApplicationSearchRequest != null) {
            request.add(softwareApplicationSearchRequest);
        }
        if (commentSearchRequest != null) {
            request.add(commentSearchRequest);
        }
        if (userSearchRequest != null) {
            request.add(userSearchRequest);
        }


        try {
            MultiSearchResponse multiSearchResponse = restHighLevelClient.msearch(request, RequestOptions.DEFAULT);
            TimeValue took = multiSearchResponse.getTook();
            long seconds = took.millis();
            long totalHitsNumber = 0;

            List<String> sourceAsString = new ArrayList<>();
            for (MultiSearchResponse.Item item : multiSearchResponse.getResponses()) {
                SearchResponse searchResponse = item.getResponse();
                totalHitsNumber += searchResponse.getHits().getTotalHits().value;
                for (SearchHit hit : searchResponse.getHits()) {
                    String stringObject = hit.getSourceAsString();
                    sourceAsString.add(stringObject);
                }
            }

            return new ElasticSearchResultQuery((float) seconds, totalHitsNumber, sourceAsString.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    private SearchRequest getStoryFilterRequest(FilterStoryDto filterStoryDto) {
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        if (filterStoryDto != null) {
            String title = filterStoryDto.getTitle();
            if (title != null) {
                boolQuery = boolQuery.should(QueryBuilders.matchPhraseQuery("title", title));
            }

            String description = filterStoryDto.getDescription();
            if (description != null) {
                boolQuery = boolQuery.should(QueryBuilders.matchPhraseQuery("description", description));
            }

            Long priorityId = filterStoryDto.getPriorityId();
            if (priorityId != null) {
                boolQuery = boolQuery.should(QueryBuilders.matchPhraseQuery("priorityId", priorityId));
            }

            String priorityTitle = filterStoryDto.getPriorityTitle();
            if (priorityTitle != null) {
                boolQuery = boolQuery.should(QueryBuilders.matchPhraseQuery("priorityTitle", priorityTitle));
            }

            String priorityDescription = filterStoryDto.getPriorityDescription();
            if (priorityDescription != null) {
                boolQuery = boolQuery.should(QueryBuilders.matchPhraseQuery("priorityDescription", priorityDescription));
            }

            Integer priorityLevel = filterStoryDto.getPriorityLevel();
            if (priorityLevel != null) {
                boolQuery = boolQuery.should(QueryBuilders.matchPhraseQuery("priorityLevel", priorityLevel));
            }

            String softwareApplicationName = filterStoryDto.getSoftwareApplicationName();
            if (softwareApplicationName != null) {
                boolQuery = boolQuery.should(QueryBuilders.matchPhraseQuery("softwareApplicationName", softwareApplicationName));
            }

            String softwareApplicationDescription = filterStoryDto.getSoftwareApplicationDescription();
            if (softwareApplicationDescription != null) {
                boolQuery = boolQuery.should(QueryBuilders.matchPhraseQuery("softwareApplicationDescription", softwareApplicationDescription));
            }

            String category = filterStoryDto.getCategory();
            if (category != null) {
                boolQuery = boolQuery.should(QueryBuilders.matchPhraseQuery("category", category));
            }


            SearchRequest searchRequest = new SearchRequest();
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

            //searchSourceBuilder.from(filterByMultipleFieldsDto.getStartFromResult());
            //searchSourceBuilder.size(filterByMultipleFieldsDto.getPageSize());
            searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

            searchSourceBuilder.query(boolQuery);
            searchRequest.indices("story");
            searchRequest.source(searchSourceBuilder);
            return searchRequest;
        } else {
            return null;
        }
    }

    private SearchRequest getStoryTaskFilterRequest(FilterStoryTaskDto filterStoryTaskDto) {

        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        if (filterStoryTaskDto != null) {
            String title = filterStoryTaskDto.getTitle();
            if (title != null) {
                boolQuery = boolQuery.should(QueryBuilders.matchPhraseQuery("title", title));
            }

            String description = filterStoryTaskDto.getDescription();
            if (description != null) {
                boolQuery = boolQuery.should(QueryBuilders.matchPhraseQuery("description", description));
            }

            Long storyPoints = filterStoryTaskDto.getStoryPoints();
            if (storyPoints != null) {
                boolQuery = boolQuery.should(QueryBuilders.matchPhraseQuery("storyPoints", storyPoints));
            }

            String createdByUsername = filterStoryTaskDto.getCreatedByUsername();
            if (createdByUsername != null) {
                boolQuery = boolQuery.should(QueryBuilders.matchPhraseQuery("createdByUsername", createdByUsername));
            }

            String assignedToUsername = filterStoryTaskDto.getCreatedByUsername();
            if (assignedToUsername != null) {
                boolQuery = boolQuery.should(QueryBuilders.matchPhraseQuery("assignedToUsername", assignedToUsername));
            }

            String status = filterStoryTaskDto.getStatus();
            if (status != null) {
                boolQuery = boolQuery.should(QueryBuilders.matchPhraseQuery("status", status));
            }


            SearchRequest searchRequest = new SearchRequest();
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

            //searchSourceBuilder.from(filterByMultipleFieldsDto.getStartFromResult());
            //searchSourceBuilder.size(filterByMultipleFieldsDto.getPageSize());
            searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

            searchSourceBuilder.query(boolQuery);
            searchRequest.indices("storytask");
            searchRequest.source(searchSourceBuilder);
            return searchRequest;
        } else {
            return null;
        }
    }

    private SearchRequest getSoftwareApplicationFilterRequest(FilterSoftwareApplicationDto filterSoftwareApplicationDto) {
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        if (filterSoftwareApplicationDto != null) {
            String name = filterSoftwareApplicationDto.getName();
            if (name != null) {
                boolQuery = boolQuery.should(QueryBuilders.matchPhraseQuery("name", name));
            }

            String description = filterSoftwareApplicationDto.getDescription();
            if (description != null) {
                boolQuery = boolQuery.should(QueryBuilders.matchPhraseQuery("description", description));
            }


            SearchRequest searchRequest = new SearchRequest();
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

            //searchSourceBuilder.from(filterByMultipleFieldsDto.getStartFromResult());
            //searchSourceBuilder.size(filterByMultipleFieldsDto.getPageSize());
            searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

            searchSourceBuilder.query(boolQuery);
            searchRequest.indices("softwareapplication");
            searchRequest.source(searchSourceBuilder);
            return searchRequest;
        } else {
            return null;
        }
    }

    private SearchRequest getCommentFilterRequest(FilterCommentDto filterCommentDto) {
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        if (filterCommentDto != null) {
            String content = filterCommentDto.getContent();
            if (content != null) {
                boolQuery = boolQuery.should(QueryBuilders.matchPhraseQuery("content", content));
            }


            SearchRequest searchRequest = new SearchRequest();
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

            //searchSourceBuilder.from(filterByMultipleFieldsDto.getStartFromResult());
            //searchSourceBuilder.size(filterByMultipleFieldsDto.getPageSize());
            searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

            searchSourceBuilder.query(boolQuery);
            searchRequest.indices("comment");
            searchRequest.source(searchSourceBuilder);
            return searchRequest;
        } else {
            return null;
        }
    }

    private SearchRequest getUserFilterRequest(FilterUserDto filterUserDto) {
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        if (filterUserDto != null) {
            String username = filterUserDto.getUsername();
            if (username != null) {
                boolQuery = boolQuery.should(QueryBuilders.matchPhraseQuery("username", username));
            }
            String email = filterUserDto.getEmail();
            if (email != null) {
                boolQuery = boolQuery.should(QueryBuilders.matchPhraseQuery("email", email));
            }


            SearchRequest searchRequest = new SearchRequest();
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

            //searchSourceBuilder.from(filterByMultipleFieldsDto.getStartFromResult());
            //searchSourceBuilder.size(filterByMultipleFieldsDto.getPageSize());
            searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

            searchSourceBuilder.query(boolQuery);
            searchRequest.indices("user");
            searchRequest.source(searchSourceBuilder);
            return searchRequest;
        } else {
            return null;
        }
    }

}
