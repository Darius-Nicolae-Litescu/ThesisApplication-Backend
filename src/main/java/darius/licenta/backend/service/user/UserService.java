package darius.licenta.backend.service.user;

import darius.licenta.backend.domain.User;
import darius.licenta.backend.dto.user.UserDto;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.payload.response.PaginatedResponse;

public interface UserService {
    void saveOrUpdateUserPublicDetails(UserDto userDto);
    boolean deleteUserByUsername(String username);
    boolean deleteUserById(Long id);
    PaginatedResponse<UserDto> getAllUsers(int page, int size);
    ApiResponse<UserDto> getUserById(Long id);
    void insertUser(User user);
}
