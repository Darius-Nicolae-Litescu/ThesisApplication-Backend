package darius.licenta.backend.service.position;

import darius.licenta.backend.dto.position.CreatePositionDto;
import darius.licenta.backend.dto.position.PositionDto;
import darius.licenta.backend.dto.position.UpdatePositionDto;
import darius.licenta.backend.payload.response.ApiResponse;

import java.util.List;

public interface PositionService {

    ApiResponse<PositionDto> findPositionByUserId(String username);

    ApiResponse<List<PositionDto>> findAllPositions();

    ApiResponse<PositionDto> insert(CreatePositionDto createPositionDto);

    ApiResponse<PositionDto> updatePositionSeniorityLevel(UpdatePositionDto updatePositionDto);

    ApiResponse<PositionDto> deletePosition(String positionName);

}
