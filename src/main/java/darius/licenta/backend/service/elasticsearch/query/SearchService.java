package darius.licenta.backend.service.elasticsearch.query;

import darius.licenta.backend.dto.elasticsearch.search.ElasticSearchResultQuery;
import darius.licenta.backend.dto.elasticsearch.search.ReturnPropertyNamesDto;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface SearchService {
    ElasticSearchResultQuery searchFromQuery(Optional<List<String>> collections, Optional<List<String>> returnFields, String term, Optional<List<String>> fields, String from, String size) throws IOException;

    ReturnPropertyNamesDto getFieldNamesFromQuery(List<String> CollectionNamesForFieldReturn) throws IOException;
}
