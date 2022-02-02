package darius.licenta.backend.service.user;

import darius.licenta.backend.domain.User;
import darius.licenta.backend.dto.user.CreateUserDto;
import darius.licenta.backend.dto.user.ResponseUserDto;
import darius.licenta.backend.dto.user.ResponseUserWithJwtDto;
import darius.licenta.backend.payload.response.ApiResponse;

import javax.servlet.http.HttpServletRequest;

public interface UserAccountOperationsService {
    ApiResponse<ResponseUserWithJwtDto> signin(String username, String password);

    ApiResponse<ResponseUserWithJwtDto> insert(CreateUserDto createUserDto);

    String refreshJwtToken(String username);

    ApiResponse<ResponseUserDto> search(String username);

    ApiResponse<ResponseUserDto> whoami(HttpServletRequest req);

    ApiResponse<ResponseUserDto> deleteUserByUsername(String username);

}
