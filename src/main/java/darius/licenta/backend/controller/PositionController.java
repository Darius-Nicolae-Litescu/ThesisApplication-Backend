package darius.licenta.backend.controller;

import darius.licenta.backend.domain.sql.UserRole;
import darius.licenta.backend.dto.normal.position.CreatePositionDto;
import darius.licenta.backend.dto.normal.position.PositionDto;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.service.position.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/position")
@CrossOrigin(origins = "http://localhost:3000")
public class PositionController {

    private final PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }


    @PostMapping("/")
    @Secured(UserRole.Rank.ADMIN)
    public ApiResponse<PositionDto> addPosition(@RequestBody CreatePositionDto createPositionDto) {
        return positionService.insert(createPositionDto);
    }

    @GetMapping("/")
    @Secured({UserRole.Rank.ADMIN})
    public ApiResponse<List<PositionDto>> getPositions() {
        return positionService.findAllPositions();
    }
}
