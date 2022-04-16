package darius.licenta.backend.service.user;

import darius.licenta.backend.dto.normal.user.*;
import darius.licenta.backend.payload.response.ApiResponse;

import javax.servlet.http.HttpServletRequest;

public interface UserAccountOperationsService {
    ApiResponse<ResponseUserWithJwtDto> signin(String username, String password);

    ApiResponse<ResponseUserDto> updateUserBio(UpdateUserBioDto updateUserBioDto, String username);

    ApiResponse<ResponseUserDto> updateUserEmail(String jwtUsername, UpdateUserEmailDto updateUserEmailDto);

    ApiResponse<ResponseUserDto> updateUserPassword(String jwtUsername, UpdateUserPasswordDto updateUserPasswordDto);

    ApiResponse<ResponseUserWithJwtDto> insert(CreateUserDto createUserDto);

    String refreshJwtToken(String username);

    ApiResponse<ResponseUserDto> search(String username);

    ApiResponse<ResponseUserWithJwtDto> whoami(HttpServletRequest req);

    ApiResponse<ResponseUserDto> deleteUserByUsername(String username);

}
