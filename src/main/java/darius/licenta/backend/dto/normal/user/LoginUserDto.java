package darius.licenta.backend.dto.normal.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginUserDto implements Serializable {
    private final String username;
    private final String password;
}
