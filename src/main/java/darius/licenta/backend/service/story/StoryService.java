package darius.licenta.backend.service.story;

import darius.licenta.backend.dto.story.*;
import darius.licenta.backend.dto.story.response.StoryDto;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.payload.response.PaginatedResponse;

public interface StoryService {
    ApiResponse<StoryDto> insert(InsertStoryDto insertStoryDto);

    ApiResponse<StoryDto> updateCategory(UpdateStoryCategory updateStoryCategory);

    ApiResponse<StoryDto> updatePriority(UpdateStoryPriority updateStoryPriority);

    ApiResponse<StoryDto> updateSoftwareApplication(UpdateStorySoftwareApplication updateStorySoftwareApplication);

    ApiResponse<StoryDto> findById(Long id);

    ApiResponse<StoryDto> deleteById(Long id);

    ApiResponse<PaginatedResponse<StoryDto>> findByPriority(Long priorityId, int page, int size);

    ApiResponse<PaginatedResponse<StoryDto>> findByCategory(Long categoryId, int page, int size);

    ApiResponse<PaginatedResponse<StoryDto>> findByDescription(String description, int page, int size);

    ApiResponse<PaginatedResponse<StoryDto>> findBySoftwareApplicationId(Long softwareApplicationId, int page, int size);

    ApiResponse<Long> countAll();

    ApiResponse<PaginatedResponse<StoryDto>> findAll(int page, int size);
}
