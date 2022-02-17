package darius.licenta.backend.service.elasticsearch;

import darius.licenta.backend.dto.elasticsearch.ElasticSearchResultQuery;

import java.io.IOException;
import java.util.List;

public interface SearchService {
    ElasticSearchResultQuery searchFromQuery(List<String> collections, List<String> returnFields, String term, List<String> fields, String from, String size) throws IOException;

}
