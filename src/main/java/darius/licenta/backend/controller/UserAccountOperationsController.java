package darius.licenta.backend.controller;

import darius.licenta.backend.domain.sql.UserRole;
import darius.licenta.backend.dto.normal.user.CreateUserDto;
import darius.licenta.backend.dto.normal.user.ResponseUserDto;
import darius.licenta.backend.dto.normal.user.ResponseUserWithJwtDto;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.service.user.UserAccountOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserAccountOperationsController {

    private final UserAccountOperationsService userService;

    @Autowired
    public UserAccountOperationsController(UserAccountOperationsService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ApiResponse<ResponseUserWithJwtDto> login(@RequestParam String username,
                        @RequestParam String password) {
        return userService.signin(username, password);
    }

    @PostMapping("/signup")
    public ApiResponse<ResponseUserWithJwtDto> signup(@RequestBody CreateUserDto userDto) {
        return userService.insert(userDto);
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