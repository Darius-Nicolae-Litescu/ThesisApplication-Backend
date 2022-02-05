package darius.licenta.backend.controller;

import darius.licenta.backend.domain.UserRole;
import darius.licenta.backend.dto.category.CategoryDto;
import darius.licenta.backend.dto.story.InsertStoryDto;
import darius.licenta.backend.dto.story.StoryDto;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.payload.response.PaginatedResponse;
import darius.licenta.backend.service.category.CategoryService;
import darius.licenta.backend.service.story.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/story")
@CrossOrigin(origins = "http://localhost:3000")
public class StoryController {

    private final StoryService storyService;

    @Autowired
    public StoryController(StoryService storyService) {
        this.storyService = storyService;
    }

    @PostMapping("/")
    @Secured(UserRole.Rank.ADMIN)
    public ApiResponse<StoryDto> addStory(@RequestBody InsertStoryDto insertStoryDto) {
        return storyService.insert(insertStoryDto);
    }

    @GetMapping("/")
    @Secured({UserRole.Rank.ADMIN})
    public ApiResponse<PaginatedResponse<StoryDto>> getStories(@RequestParam int page,
                                                               @RequestParam int size) {
        return storyService.findAll(page, size);
    }

    @GetMapping("/count")
    @Secured({UserRole.Rank.ADMIN})
    public ApiResponse<Long> getCount() {
        return storyService.countAll();
    }
}
