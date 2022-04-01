package darius.licenta.backend.controller;

import darius.licenta.backend.dto.elasticsearch.filter.FilterByMultipleFieldsDto;
import darius.licenta.backend.dto.elasticsearch.search.CollectionNamesForFieldReturn;
import darius.licenta.backend.dto.elasticsearch.search.ElasticSearchResultQuery;
import darius.licenta.backend.dto.elasticsearch.search.ReturnPropertyNamesDto;
import darius.licenta.backend.dto.elasticsearch.search.SearchByKeywordDto;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.service.elasticsearch.exactquery.ElasticSearchExactQueryService;
import darius.licenta.backend.service.elasticsearch.query.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/elasticsearch")
@CrossOrigin(origins = "http://localhost:3000")
public class FilterController {

    private final ElasticSearchExactQueryService elasticSearchExactQueryService;

    @Autowired
    public FilterController(ElasticSearchExactQueryService elasticSearchExactQueryService) {
        this.elasticSearchExactQueryService = elasticSearchExactQueryService;
    }

    @PostMapping(value = "/filter/exact")
    public ApiResponse<ElasticSearchResultQuery> queryForExactHits(@RequestBody FilterByMultipleFieldsDto filterByMultipleFieldsDto) throws IOException {
        return new ApiResponse<>(elasticSearchExactQueryService.getExactSearchFromFilters(filterByMultipleFieldsDto),
                HttpStatus.OK);
    }

}
