package darius.licenta.backend.controller;

import darius.licenta.backend.dto.elasticsearch.ElasticSearchResultQuery;
import darius.licenta.backend.dto.elasticsearch.SearchByKeywordDto;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.service.elasticsearch.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/search")
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
                searchByKeywordDto.getTerm().trim().toLowerCase(),
                searchByKeywordDto.getFields(), searchByKeywordDto.getFrom(),
                searchByKeywordDto.getSize()),
                HttpStatus.OK);
    }
}