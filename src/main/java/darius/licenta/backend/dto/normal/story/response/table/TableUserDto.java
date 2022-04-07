package darius.licenta.backend.dto.normal.story.response.table;

import lombok.Data;

import java.io.Serializable;

@Data
public class TableUserDto implements Serializable {
    private final Long id;
    private final String username;
    private final String bioDescription;
    private final String email;
}
