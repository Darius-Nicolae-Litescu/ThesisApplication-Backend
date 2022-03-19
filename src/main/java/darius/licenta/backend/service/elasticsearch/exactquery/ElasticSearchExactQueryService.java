package darius.licenta.backend.service.elasticsearch.exactquery;

import darius.licenta.backend.dto.elasticsearch.filter.FilterByMultipleFieldsDto;
import darius.licenta.backend.dto.elasticsearch.search.ElasticSearchResultQuery;

public interface ElasticSearchExactQueryService {

    ElasticSearchResultQuery getExactSearchFromFilters(FilterByMultipleFieldsDto filterByMultipleFieldsDto);
}
