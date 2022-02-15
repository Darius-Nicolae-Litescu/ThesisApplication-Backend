package darius.licenta.backend.service.story;

import darius.licenta.backend.dto.comment.story.InsertStoryCommentDto;
import darius.licenta.backend.dto.story.request.insert.InsertStoryDto;
import darius.licenta.backend.dto.story.request.update.UpdateStoryCategories;
import darius.licenta.backend.dto.story.request.update.UpdateStoryPriority;
import darius.licenta.backend.dto.story.request.update.UpdateStorySoftwareApplication;
import darius.licenta.backend.dto.story.response.fulldetails.FullDetailsResponseStoryDto;
import darius.licenta.backend.dto.story.response.table.ResponseStoryDtoWithoutFullDetails;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.payload.response.PaginatedResponse;

public interface StoryService {
    ApiResponse<FullDetailsResponseStoryDto> insert(InsertStoryDto insertStoryDto);

    ApiResponse<FullDetailsResponseStoryDto> insertStoryComment(InsertStoryCommentDto insertStoryCommentDto);

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
