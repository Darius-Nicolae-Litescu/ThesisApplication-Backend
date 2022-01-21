package darius.licenta.backend.service.priority;

import darius.licenta.backend.dto.category.CategoryDto;
import darius.licenta.backend.dto.priority.PriorityDto;
import darius.licenta.backend.payload.response.ApiResponse;

import java.sql.Blob;
import java.util.List;

public interface PriorityService {
    ApiResponse<PriorityDto> insert(PriorityDto priorityDto);

    ApiResponse<PriorityDto> updateGeneralInformation(PriorityDto priorityDto);

    ApiResponse<PriorityDto> updatePicture(Long id, Blob pictureBlob);

    ApiResponse<List<PriorityDto>> findByDescription(String description);

    ApiResponse<List<PriorityDto>> findByTitle(String title);

    ApiResponse<List<PriorityDto>> findByLevel(int level);

    ApiResponse<PriorityDto> findById(Long id);

    ApiResponse<List<PriorityDto>> getAllPriorities();

    ApiResponse<List<PriorityDto>> deleteByTitle(String title);

    ApiResponse<PriorityDto> deleteById(Long id);
}
