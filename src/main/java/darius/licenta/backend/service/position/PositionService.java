package darius.licenta.backend.service.position;

import darius.licenta.backend.dto.normal.position.CreatePositionDto;
import darius.licenta.backend.dto.normal.position.PositionDto;
import darius.licenta.backend.dto.normal.position.UpdatePositionDto;
import darius.licenta.backend.payload.response.ApiResponse;

import java.util.List;

public interface PositionService {

    ApiResponse<PositionDto> insert(CreatePositionDto createPositionDto);

    ApiResponse<PositionDto> getPositionById(Long id);

    ApiResponse<PositionDto> updatePosition(Long id, UpdatePositionDto updatePositionDto);

    ApiResponse<PositionDto> updatePositionSeniorityLevel(UpdatePositionDto updatePositionDto);

    ApiResponse<PositionDto> findPositionByUserId(String username);

    ApiResponse<List<PositionDto>> findAllPositions();


    ApiResponse<PositionDto> deleteById(Long positionId);

    ApiResponse<PositionDto> deletePositionByName(String positionName);

}
