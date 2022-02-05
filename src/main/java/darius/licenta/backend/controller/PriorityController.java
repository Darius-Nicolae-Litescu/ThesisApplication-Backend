package darius.licenta.backend.controller;

import darius.licenta.backend.domain.UserRole;
import darius.licenta.backend.dto.priority.PriorityDto;
import darius.licenta.backend.dto.story.InsertStoryDto;
import darius.licenta.backend.dto.story.StoryDto;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.payload.response.PaginatedResponse;
import darius.licenta.backend.service.priority.PriorityService;
import darius.licenta.backend.service.story.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/priority")
@CrossOrigin(origins = "http://localhost:3000")
public class PriorityController {

    private final PriorityService priorityService;

    @Autowired
    public PriorityController(PriorityService priorityService) {
        this.priorityService = priorityService;
    }

    @PostMapping("/")
    @Secured(UserRole.Rank.ADMIN)
    public ApiResponse<PriorityDto> addPriority(@RequestBody PriorityDto priorityDto) {
        return priorityService.insert(priorityDto);
    }

    @GetMapping("/")
    @Secured({UserRole.Rank.ADMIN})
    public ApiResponse<List<PriorityDto>> getPriorities() {
        return priorityService.getAllPriorities();
    }
}
