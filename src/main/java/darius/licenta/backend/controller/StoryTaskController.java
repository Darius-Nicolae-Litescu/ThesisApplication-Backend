package darius.licenta.backend.controller;

import darius.licenta.backend.domain.sql.UserRole;
import darius.licenta.backend.dto.normal.comment.story.InsertStoryCommentDto;
import darius.licenta.backend.dto.normal.comment.storytask.InsertStoryTaskCommentDto;
import darius.licenta.backend.dto.normal.story.response.fulldetails.FullDetailsResponseStoryDto;
import darius.licenta.backend.dto.normal.storytask.ChangeStoryTaskGeneralDetails;
import darius.licenta.backend.dto.normal.storytask.ChangeStoryTaskTitleAndDescription;
import darius.licenta.backend.dto.normal.storytask.InsertStoryTaskDto;
import darius.licenta.backend.dto.normal.storytask.ResponseStoryTaskDto;
import darius.licenta.backend.dto.normal.storytask.fullinformation.FullInformationStoryTaskDto;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.service.storytask.StoryTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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
    public ApiResponse<ResponseStoryTaskDto> addStoryTask(Principal principal, @RequestBody InsertStoryTaskDto insertStoryTaskDto) {
        String username = principal.getName();
        return storyTaskService.insert(insertStoryTaskDto, username);
    }

    @PutMapping("/task/general")
    @Secured(UserRole.Rank.ADMIN)
    public ApiResponse<ChangeStoryTaskGeneralDetails> updateStoryTaskGeneralInfo(@RequestBody ChangeStoryTaskGeneralDetails changeStoryTaskGeneralDetails) {
        return storyTaskService.updateStoryTaskGeneralDetails(changeStoryTaskGeneralDetails);
    }

    @PutMapping("/task/details")
    @Secured(UserRole.Rank.ADMIN)
    public ApiResponse<ChangeStoryTaskTitleAndDescription> updateStoryTaskTitleAndDescription(@RequestBody ChangeStoryTaskTitleAndDescription changeStoryTaskTitleAndDescription) {
        return storyTaskService.updateStoryTaskTitleAndDescription(changeStoryTaskTitleAndDescription);
    }

    @PostMapping(value = "/task/comment", consumes = "multipart/form-data")
    @Secured(UserRole.Rank.ADMIN)
    public ApiResponse<FullInformationStoryTaskDto> addComment(Principal principal, @ModelAttribute InsertStoryTaskCommentDto insertStoryCommentDto) {
        String username = principal.getName();
        return storyTaskService.insertStoryTaskComment(insertStoryCommentDto, username);
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
