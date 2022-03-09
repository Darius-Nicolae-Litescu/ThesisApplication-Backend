package darius.licenta.backend.service.story;

import darius.licenta.backend.dto.normal.comment.story.InsertStoryCommentDto;
import darius.licenta.backend.dto.normal.story.request.insert.InsertStoryDto;
import darius.licenta.backend.dto.normal.story.request.update.UpdateStoryCategories;
import darius.licenta.backend.dto.normal.story.request.update.UpdateStoryPriority;
import darius.licenta.backend.dto.normal.story.request.update.UpdateStorySoftwareApplication;
import darius.licenta.backend.dto.normal.story.response.fulldetails.FullDetailsResponseStoryDto;
import darius.licenta.backend.dto.normal.story.response.table.ResponseStoryDtoWithoutFullDetails;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.payload.response.PaginatedResponse;

public interface StoryService {
    ApiResponse<FullDetailsResponseStoryDto> insert(InsertStoryDto insertStoryDto, String username);

    ApiResponse<FullDetailsResponseStoryDto> insertStoryComment(InsertStoryCommentDto insertStoryCommentDto, String username);

    ApiResponse<FullDetailsResponseStoryDto> updateCategories(UpdateStoryCategories updateStoryCategories);

    ApiResponse<FullDetailsResponseStoryDto> updatePriority(UpdateStoryPriority updateStoryPriority);

    ApiResponse<FullDetailsResponseStoryDto> updateSoftwareApplication(UpdateStorySoftwareApplication updateStorySoftwareApplication);

    ApiResponse<FullDetailsResponseStoryDto> findById(Long id);

    ApiResponse<FullDetailsResponseStoryDto> deleteById(Long id);

    ApiResponse<PaginatedResponse<ResponseStoryDtoWithoutFullDetails>> findByPriority(Long priorityId, int page, int size);

    ApiResponse<PaginatedResponse<ResponseStoryDtoWithoutFullDetails>> findByCategory(Long categoryId, int page, int size);

    ApiResponse<PaginatedResponse<ResponseStoryDtoWithoutFullDetails>> findByDescription(String description, int page, int size);

    ApiResponse<PaginatedResponse<ResponseStoryDtoWithoutFullDetails>> findBySoftwareApplicationId(Long softwareApplicationId, int page, int size);

    ApiResponse<Long> countAll();

    ApiResponse<PaginatedResponse<ResponseStoryDtoWithoutFullDetails>> findAll(int page, int size);
}
