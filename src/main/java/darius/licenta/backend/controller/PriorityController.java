package darius.licenta.backend.controller;

import darius.licenta.backend.domain.sql.UserRole;
import darius.licenta.backend.dto.normal.priority.InsertPriorityDto;
import darius.licenta.backend.dto.normal.priority.PriorityDto;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.service.priority.PriorityService;
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
    public ApiResponse<PriorityDto> addPriority(@RequestBody InsertPriorityDto priorityDto) {
        return priorityService.insert(priorityDto);
    }

    @GetMapping("/")
    @Secured({UserRole.Rank.ADMIN})
    public ApiResponse<List<PriorityDto>> getPriorities() {
        return priorityService.getAllPriorities();
    }
}
