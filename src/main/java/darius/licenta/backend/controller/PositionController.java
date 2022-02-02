package darius.licenta.backend.controller;

import darius.licenta.backend.domain.UserRole;
import darius.licenta.backend.dto.position.CreatePositionDto;
import darius.licenta.backend.dto.position.PositionDto;
import darius.licenta.backend.dto.user.ResponseUserWithJwtDto;
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
