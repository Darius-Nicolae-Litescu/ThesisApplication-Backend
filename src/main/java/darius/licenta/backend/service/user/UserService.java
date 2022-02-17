package darius.licenta.backend.service.user;

import darius.licenta.backend.dto.normal.user.*;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.payload.response.PaginatedResponse;

public interface UserService {
    ApiResponse<ResponseUserDto> getUserById(Long id);

    ApiResponse<ResponseUserDto> changePassword (UpdateUserPasswordDto updateUserPasswordDto);

    ApiResponse<ResponseUserDto> changeEmail (UpdateUserEmailDto updateUserEmailDto);

    ApiResponse<ResponseUserDto> changeProfilePicture (UpdateUserProfilePictureDto updateUserProfilePictureDto);

    ApiResponse<ResponseUserDto> deleteUserById(Long id);

    ApiResponse<PaginatedResponse<ResponseUserDto>> getAllUsers(int page, int size);
}
