package darius.licenta.backend.controller;

import darius.licenta.backend.domain.UserRole;
import darius.licenta.backend.dto.story.request.insert.InsertStoryDto;
import darius.licenta.backend.dto.story.response.fulldetails.FullDetailsResponseStoryDto;
import darius.licenta.backend.dto.story.response.fulldetails.StoryTaskDto;
import darius.licenta.backend.dto.storytask.InsertStoryTaskDto;
import darius.licenta.backend.dto.storytask.ResponseStoryTaskDto;
import darius.licenta.backend.dto.storytask.fullinformation.FullInformationStoryTaskDto;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.payload.response.PaginatedResponse;
import darius.licenta.backend.service.story.StoryService;
import darius.licenta.backend.service.storytask.StoryTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/story")
@CrossOrigin(origins = "http://localhost:3000")
public class StoryTaskController {

    private final StoryTaskService storyTaskService;

    @Autowired
    public StoryTaskController(StoryTaskService storyTaskService) {
        this.storyTaskService = storyTaskService;
    }

    @PostMapping("/task")
    @Secured(UserRole.Rank.ADMIN)
    public ApiResponse<ResponseStoryTaskDto> addStoryTask(@RequestBody InsertStoryTaskDto insertStoryTaskDto) {
        return storyTaskService.insert(insertStoryTaskDto);
    }

    @GetMapping("task/{id}")
    @Secured({UserRole.Rank.ADMIN})
    public ApiResponse<FullInformationStoryTaskDto> findStoryTaskById(@PathVariable Long id) {
        return storyTaskService.findStoryTaskById(id);
    }

    @DeleteMapping("task/{id}")
    @Secured({UserRole.Rank.ADMIN})
    public ApiResponse<ResponseStoryTaskDto> deleteStoryTaskById(@PathVariable Long id) {
        return storyTaskService.deleteStoryTask(id);
    }

    @GetMapping("/{storyId}/task")
    @Secured({UserRole.Rank.ADMIN})
    public ApiResponse<List<FullInformationStoryTaskDto>> getAllStoryTasksByStoryId(@PathVariable Long storyId) {
        return storyTaskService.findAllStoryTasksByStoryId(storyId);
    }


}
