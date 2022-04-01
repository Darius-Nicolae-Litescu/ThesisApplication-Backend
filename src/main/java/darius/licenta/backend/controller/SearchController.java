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
public class SearchController {
    private final SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping(value = "/query")
    public ApiResponse<ElasticSearchResultQuery> search(@RequestBody SearchByKeywordDto searchByKeywordDto) throws IOException {
        return new ApiResponse<>(searchService.searchFromQuery(
                searchByKeywordDto.getCollections(),
                searchByKeywordDto.getReturnFields(),
                searchByKeywordDto.getTerm().trim().toLowerCase(),
                searchByKeywordDto.getFields(), searchByKeywordDto.getFrom(),
                searchByKeywordDto.getSize()),
                HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ApiResponse<ReturnPropertyNamesDto> getFieldNames(@RequestBody CollectionNamesForFieldReturn collectionNamesForFieldReturn) throws IOException {
        return new ApiResponse<>(searchService.getFieldNamesFromQuery(collectionNamesForFieldReturn.getCollectionNames()),
                HttpStatus.OK);
    }
}
