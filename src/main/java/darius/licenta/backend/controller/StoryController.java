package darius.licenta.backend.controller;

import darius.licenta.backend.domain.sql.UserRole;
import darius.licenta.backend.dto.normal.comment.story.InsertStoryCommentDto;
import darius.licenta.backend.dto.normal.story.request.insert.InsertStoryDto;
import darius.licenta.backend.dto.normal.story.request.update.ChangeStoryGeneralDetails;
import darius.licenta.backend.dto.normal.story.request.update.ChangeStoryTitleAndDescription;
import darius.licenta.backend.dto.normal.story.response.fulldetails.FullDetailsResponseStoryDto;
import darius.licenta.backend.dto.normal.story.response.table.TableStoryDto;
import darius.licenta.backend.dto.normal.storytask.ChangeStoryTaskGeneralDetails;
import darius.licenta.backend.dto.normal.storytask.ChangeStoryTaskTitleAndDescription;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.payload.response.PaginatedResponse;
import darius.licenta.backend.service.story.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

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
    public ApiResponse<FullDetailsResponseStoryDto> addStory(Principal principal, @RequestBody InsertStoryDto insertStoryDto) {
        String username = principal.getName();
        return storyService.insert(insertStoryDto, username);
    }

    @PostMapping(value = "/comment", consumes = "multipart/form-data")
    @Secured(UserRole.Rank.ADMIN)
    public ApiResponse<FullDetailsResponseStoryDto> addComment(Principal principal, @ModelAttribute InsertStoryCommentDto insertStoryCommentDto) {
        String username = principal.getName();
        return storyService.insertStoryComment(insertStoryCommentDto, username);
    }


    @GetMapping("/{id}")
    @Secured({UserRole.Rank.ADMIN})
    public ApiResponse<FullDetailsResponseStoryDto> findStoryById(@PathVariable Long id) {
        return storyService.findById(id);
    }

    @DeleteMapping("/{id}")
    @Secured({UserRole.Rank.ADMIN})
    public ApiResponse<FullDetailsResponseStoryDto> deleteStoryById(@PathVariable Long id) {
        return storyService.deleteById(id);
    }

    @GetMapping("/pageable")
    @Secured({UserRole.Rank.ADMIN})
    public ApiResponse<PaginatedResponse<TableStoryDto>> getStoriesPageable(@RequestParam Integer page,
                                                                            @RequestParam Integer size) {
        return storyService.findAll(page, size);
    }

    @PutMapping("/general")
    @Secured(UserRole.Rank.ADMIN)
    public ApiResponse<ChangeStoryGeneralDetails> updateStoryTaskGeneralInfo(@RequestBody ChangeStoryGeneralDetails changeStoryGeneralDetails) {
        return storyService.updateStoryGeneralDetails(changeStoryGeneralDetails);
    }

    @PutMapping("/details")
    @Secured(UserRole.Rank.ADMIN)
    public ApiResponse<ChangeStoryTitleAndDescription> updateStoryTaskTitleAndDescription(@RequestBody ChangeStoryTitleAndDescription changeStoryTaskTitleAndDescription) {
        return storyService.updateStoryTitleAndDescription(changeStoryTaskTitleAndDescription);
    }

    @GetMapping("/count")
    @Secured({UserRole.Rank.ADMIN})
    public ApiResponse<Long> getCount() {
        return storyService.countAll();
    }
}
