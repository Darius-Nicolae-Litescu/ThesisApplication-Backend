package darius.licenta.backend.controller;

import darius.licenta.backend.domain.sql.UserRole;
import darius.licenta.backend.dto.normal.user.*;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.service.picture.PictureService;
import darius.licenta.backend.service.user.UserAccountOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserAccountOperationsController {

    private final UserAccountOperationsService userService;
    private final PictureService pictureService;

    @Autowired
    public UserAccountOperationsController(UserAccountOperationsService userService, PictureService pictureService) {
        this.userService = userService;
        this.pictureService = pictureService;
    }

    @PostMapping("/login")
    public ApiResponse<ResponseUserWithJwtDto> login(@RequestBody LoginUserDto loginUserDto) {
        return userService.signin(loginUserDto.getUsername(), loginUserDto.getPassword());
    }

    @PostMapping("/signup")
    public ApiResponse<ResponseUserWithJwtDto> signup(@RequestBody CreateUserDto userDto) {
        return userService.insert(userDto);
    }

    @PutMapping("/update/bio")
    public ApiResponse<ResponseUserDto> updateProfilePicture(Principal principal, @RequestBody UpdateUserBioDto updateUserBioDto) {
        String username = principal.getName();
        return userService.updateUserBio(updateUserBioDto, username);
    }

    @PutMapping("/update/email")
    @Secured({UserRole.Rank.ADMIN,UserRole.Rank.USER})
    public ApiResponse<ResponseUserDto> updateEmail(Principal principal, @RequestBody UpdateUserEmailDto updateUserEmailDto) {
        String jwtUsername = principal.getName();
        return userService.updateUserEmail(jwtUsername, updateUserEmailDto);
    }

    @PutMapping("/update/password")
    @Secured({UserRole.Rank.ADMIN,UserRole.Rank.USER})
    public ApiResponse<ResponseUserDto> updatePassword(Principal principal, @RequestBody UpdateUserPasswordDto updateUserPasswordDto) {
        String jwtUsername = principal.getName();
        return userService.updateUserPassword(jwtUsername, updateUserPasswordDto);
    }

    @PostMapping(value = "/upload-profile-picture", consumes = "multipart/form-data")
    @Secured({UserRole.Rank.ADMIN, UserRole.Rank.USER})
    public ApiResponse<Boolean> uploadProfilePicture(Principal principal, @ModelAttribute AddUserProfilePicture addUserProfilePicture) throws IOException {
        String username = principal.getName();
        return pictureService.uploadProfilePicture(addUserProfilePicture.getProfilePicture(), username);
    }

    @DeleteMapping("/delete-profile-picture")
    @Secured({UserRole.Rank.ADMIN, UserRole.Rank.USER})
    public ApiResponse<Boolean> deleteProfilePicture(Principal principal) {
        String username = principal.getName();
        return pictureService.deleteProfilePicture(username);
    }

    @DeleteMapping(value = "/username/{username}")
    @Secured(UserRole.Rank.ADMIN)
    public ApiResponse<ResponseUserDto> delete(@PathVariable String username) {
        return userService.deleteUserByUsername(username);
    }

    @GetMapping(value = "/username/{username}")
    @Secured(UserRole.Rank.ADMIN)
    public ApiResponse<ResponseUserDto> search(@PathVariable String username) {
        return userService.search(username);
    }

    @GetMapping(value = "/whoami")
    @Secured({UserRole.Rank.ADMIN,UserRole.Rank.USER})
    public ApiResponse<ResponseUserWithJwtDto> whoami(HttpServletRequest req) {
        return userService.whoami(req);
    }

    @GetMapping("/refresh")
    @Secured({UserRole.Rank.ADMIN,UserRole.Rank.USER})
    public String refresh(HttpServletRequest req) {
        return userService.refreshJwtToken(req.getRemoteUser());
    }

}