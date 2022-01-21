package darius.licenta.backend.service.storytask;

import darius.licenta.backend.dto.role.RoleDto;
import darius.licenta.backend.dto.storytask.InsertStoryTaskDto;
import darius.licenta.backend.dto.storytask.ResponseStoryTaskDto;
import darius.licenta.backend.dto.storytask.UpdateStoryTaskDto;
import darius.licenta.backend.dto.storytask.fullinformation.FullInformationStoryTaskDto;
import darius.licenta.backend.payload.response.ApiResponse;

import java.util.List;

public interface StoryTaskService {

    ApiResponse<ResponseStoryTaskDto> insert(InsertStoryTaskDto storyTaskDto);

    ApiResponse<ResponseStoryTaskDto> update (UpdateStoryTaskDto updateStoryTaskDto);

    ApiResponse<List<FullInformationStoryTaskDto>> findStoryTasksByCreatedBy(String username);

    ApiResponse<List<FullInformationStoryTaskDto>> findStoryTasksByAssignedTo(String username);

    ApiResponse<List<FullInformationStoryTaskDto>> findAllStoryTasksByStoryId(Long storyId);

    ApiResponse<ResponseStoryTaskDto> deleteStoryTask(Long id);
}
