package darius.licenta.backend.service.story;

import darius.licenta.backend.dto.normal.comment.story.InsertStoryCommentDto;
import darius.licenta.backend.dto.normal.story.request.insert.InsertStoryDto;
import darius.licenta.backend.dto.normal.story.request.update.*;
import darius.licenta.backend.dto.normal.story.response.fulldetails.FullDetailsResponseStoryDto;
import darius.licenta.backend.dto.normal.story.response.notfulldetails.ResponseStoryDtoWithoutFullDetails;
import darius.licenta.backend.dto.normal.story.response.table.TableStoryDto;
import darius.licenta.backend.dto.normal.storytask.ChangeStoryTaskGeneralDetails;
import darius.licenta.backend.dto.normal.storytask.ChangeStoryTaskTitleAndDescription;
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

    ApiResponse<ChangeStoryGeneralDetails> updateStoryGeneralDetails(ChangeStoryGeneralDetails changeStoryGeneralDetails);

    ApiResponse<ChangeStoryTitleAndDescription> updateStoryTitleAndDescription(ChangeStoryTitleAndDescription changeStoryTitleAndDescription);

    ApiResponse<Long> countAll();

    ApiResponse<PaginatedResponse<TableStoryDto>> findAll(Integer page, Integer size);
}
