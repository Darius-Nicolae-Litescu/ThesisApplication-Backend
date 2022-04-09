package darius.licenta.backend.service.user;

import darius.licenta.backend.dto.normal.story.response.table.TableUserDto;
import darius.licenta.backend.dto.normal.user.*;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.payload.response.PaginatedResponse;

import java.util.List;

public interface UserService {
    ApiResponse<ResponseUserWithJwtDto> getUserProfileDetailsById(Long id);

    ApiResponse<List<UserStoryActivityDto>> getUserLatestActivity(Long id);

    ApiResponse<ResponseUserDto> getUserById(Long id);

    ApiResponse<ResponseUserDto> changePassword(UpdateUserPasswordDto updateUserPasswordDto);

    ApiResponse<ResponseUserDto> changeEmail(UpdateUserEmailDto updateUserEmailDto);

    ApiResponse<ResponseUserDto> changeProfilePicture(UpdateUserProfilePictureDto updateUserProfilePictureDto);

    ApiResponse<ResponseUserDto> deleteUserById(Long id);

    ApiResponse<PaginatedResponse<TableUserDto>> getAllUsers(int page, int size);

    ApiResponse<List<UserBasicInfoDto>> getAllUsersBasicInfo();
}
