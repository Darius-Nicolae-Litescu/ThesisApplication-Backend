package darius.licenta.backend.controller;

import darius.licenta.backend.domain.sql.UserRole;
import darius.licenta.backend.dto.normal.softwareapplication.InsertSoftwareApplicationDto;
import darius.licenta.backend.dto.normal.softwareapplication.SoftwareApplicationDto;
import darius.licenta.backend.payload.response.ApiResponse;
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

    @PutMapping("/")
    @Secured(UserRole.Rank.ADMIN)
    public ApiResponse<SoftwareApplicationDto> updateSoftwareApplication(@RequestBody SoftwareApplicationDto softwareApplicationDto) {
        return softwareApplicationService.update(softwareApplicationDto);
    }

    @GetMapping("/{id}")
    @Secured({UserRole.Rank.ADMIN})
    public ApiResponse<SoftwareApplicationDto> getSoftwareApplicationById(@PathVariable Long id) {
        return softwareApplicationService.findById(id);
    }

    @DeleteMapping("/{id}")
    @Secured(UserRole.Rank.ADMIN)
    public ApiResponse<SoftwareApplicationDto> deleteSoftwareApplicationById(@PathVariable Long id) {
        return softwareApplicationService.deleteById(id);
    }

    @GetMapping("/")
    @Secured({UserRole.Rank.ADMIN})
    public ApiResponse<List<SoftwareApplicationDto>> getAllSoftwareApplications() {
        return softwareApplicationService.findAll();
    }

}
