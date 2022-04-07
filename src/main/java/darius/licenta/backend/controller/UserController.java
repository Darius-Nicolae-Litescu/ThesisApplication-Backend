package darius.licenta.backend.controller;

import darius.licenta.backend.domain.sql.UserRole;
import darius.licenta.backend.dto.normal.person.PersonDto;
import darius.licenta.backend.dto.normal.story.response.table.TableUserDto;
import darius.licenta.backend.dto.normal.user.ResponseUserDto;
import darius.licenta.backend.dto.normal.user.ResponseUserWithJwtDto;
import darius.licenta.backend.dto.normal.user.UserStoryActivityDto;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.payload.response.PaginatedResponse;
import darius.licenta.backend.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}/activity")
    public ApiResponse<List<UserStoryActivityDto>> getUserActivity(@PathVariable Long userId) {
        return userService.getUserLatestActivity(userId);
    }

    @GetMapping(value = "/{userId}")
    @Secured(UserRole.Rank.USER)
    public ApiResponse<ResponseUserWithJwtDto> getProfileDetails(@PathVariable Long userId) {
        return userService.getUserProfileDetailsById(userId);
    }

    @GetMapping("/pageable")
    @Secured({UserRole.Rank.ADMIN})
    public ApiResponse<PaginatedResponse<TableUserDto>> getUsers(@RequestParam int page,
                                                                 @RequestParam int size) {
        return userService.getAllUsers(page, size);
    }
}
