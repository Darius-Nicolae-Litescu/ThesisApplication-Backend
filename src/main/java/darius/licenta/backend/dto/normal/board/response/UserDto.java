package darius.licenta.backend.dto.normal.board.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {
    private final Long id;
    private final String username;
    private final String email;
}
