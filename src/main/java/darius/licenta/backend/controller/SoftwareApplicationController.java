package darius.licenta.backend.controller;

import darius.licenta.backend.domain.UserRole;
import darius.licenta.backend.dto.position.CreatePositionDto;
import darius.licenta.backend.dto.position.PositionDto;
import darius.licenta.backend.dto.softwareapplication.InsertSoftwareApplicationDto;
import darius.licenta.backend.dto.softwareapplication.SoftwareApplicationDto;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.service.position.PositionService;
import darius.licenta.backend.service.softwareapplication.SoftwareApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/softwareapplication")
@CrossOrigin(origins = "http://localhost:3000")
public class SoftwareApplicationController {

    private final SoftwareApplicationService softwareApplicationService;

    @Autowired
    public SoftwareApplicationController(SoftwareApplicationService softwareApplicationService) {
        this.softwareApplicationService = softwareApplicationService;
    }


    @PostMapping("/")
    @Secured(UserRole.Rank.ADMIN)
    public ApiResponse<SoftwareApplicationDto> addSoftwareApplication(@RequestBody InsertSoftwareApplicationDto insertSoftwareApplicationDto) {
        return softwareApplicationService.insert(insertSoftwareApplicationDto);
    }

    @GetMapping("/")
    @Secured({UserRole.Rank.ADMIN})
    public ApiResponse<List<SoftwareApplicationDto>> getSoftwareApplication() {
        return softwareApplicationService.findAll();
    }
}
