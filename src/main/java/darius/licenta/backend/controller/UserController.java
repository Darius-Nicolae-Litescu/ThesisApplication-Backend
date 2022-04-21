package darius.licenta.backend.controller;

import darius.licenta.backend.domain.sql.Picture;
import darius.licenta.backend.domain.sql.UserRole;
import darius.licenta.backend.dto.normal.story.response.table.TableUserDto;
import darius.licenta.backend.dto.normal.user.*;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.payload.response.PaginatedResponse;
import darius.licenta.backend.service.picture.PictureService;
import darius.licenta.backend.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    private final UserService userService;
    private final PictureService pictureService;

    @Autowired
    public UserController(UserService userService, PictureService pictureService) {
        this.userService = userService;
        this.pictureService = pictureService;
    }

    @GetMapping("/{userId}/activity")
    public ApiResponse<List<UserStoryActivityDto>> getUserActivity(@PathVariable Long userId) {
        return userService.getUserLatestActivity(userId);
    }

    @GetMapping(value = "/id/{userId}")
    @Secured({UserRole.Rank.ADMIN, UserRole.Rank.USER})
    public ApiResponse<ResponseUserWithJwtDto> getProfileDetails(@PathVariable Long userId) {
        return userService.getUserProfileDetailsById(userId);
    }

    @PutMapping("/{userId}/change-password")
    @Secured({UserRole.Rank.ADMIN})
    public ApiResponse<ResponseUserDto> changePassword(@RequestBody UpdateUserPasswordDto updateUserPasswordDto) {
        return userService.changePassword(updateUserPasswordDto);
    }

    @PutMapping("/{userId}/change-email")
    @Secured({UserRole.Rank.ADMIN})
    public ApiResponse<ResponseUserDto> changeEmail(@RequestBody UpdateUserEmailDto updateUserEmailDto) {
        return userService.changeEmail(updateUserEmailDto);
    }

    @GetMapping("/{userId}/profile-image")
    public ResponseEntity<byte[]> getProfilePicture(@PathVariable Long userId) {
        try {
            Picture picture = pictureService.getProfilePicture(userId);
            if (picture != null) {
                byte[] base64encodedData = Base64.getEncoder().encode(picture.getContent());
                return ResponseEntity
                        .ok()
                        .contentType(MediaType.valueOf(picture.getContentType()))
                        .body(base64encodedData);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{userId}")
    @Secured({UserRole.Rank.ADMIN})
    public ApiResponse<ResponseUserDto> deleteUserById(@PathVariable Long userId) {
        return userService.deleteUserById(userId);
    }

    @GetMapping("/pageable")
    @Secured({UserRole.Rank.ADMIN})
    public ApiResponse<PaginatedResponse<TableUserDto>> getUsers(@RequestParam Integer page,
                                                                 @RequestParam Integer size) {
        return userService.getAllUsers(page, size);
    }

    @GetMapping("/all")
    @Secured({UserRole.Rank.ADMIN, UserRole.Rank.USER})
    public ApiResponse<List<UserBasicInfoDto>> getUsersBasicInfo() {
        return userService.getAllUsersBasicInfo();
    }
}
