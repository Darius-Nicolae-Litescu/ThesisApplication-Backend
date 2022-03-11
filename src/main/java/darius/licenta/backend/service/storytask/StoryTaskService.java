package darius.licenta.backend.service.storytask;

import darius.licenta.backend.dto.normal.comment.storytask.InsertStoryTaskCommentDto;
import darius.licenta.backend.dto.normal.storytask.InsertStoryTaskDto;
import darius.licenta.backend.dto.normal.storytask.ResponseStoryTaskDto;
import darius.licenta.backend.dto.normal.storytask.UpdateStoryTaskDto;
import darius.licenta.backend.dto.normal.storytask.fullinformation.FullInformationStoryTaskDto;
import darius.licenta.backend.payload.response.ApiResponse;

import java.util.List;

public interface StoryTaskService {

    ApiResponse<ResponseStoryTaskDto> insert(InsertStoryTaskDto storyTaskDto, String username);

    ApiResponse<FullInformationStoryTaskDto> insertStoryTaskComment(InsertStoryTaskCommentDto storyTaskCommentDto, String username);

    ApiResponse<ResponseStoryTaskDto> update (UpdateStoryTaskDto updateStoryTaskDto);

    ApiResponse<List<FullInformationStoryTaskDto>> findStoryTasksByCreatedBy(String username);

    ApiResponse<List<FullInformationStoryTaskDto>> findStoryTasksByAssignedTo(String username);

    ApiResponse<List<FullInformationStoryTaskDto>> findAllStoryTasksByStoryId(Long storyId);

    ApiResponse<FullInformationStoryTaskDto> findStoryTaskById(Long storyTaskId);

    ApiResponse<ResponseStoryTaskDto> deleteStoryTask(Long id);
}
