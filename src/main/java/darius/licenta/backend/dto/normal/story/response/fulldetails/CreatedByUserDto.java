package darius.licenta.backend.dto.normal.story.response.fulldetails;

import lombok.Data;

import java.io.Serializable;
import java.sql.Blob;

@Data
public class CreatedByUserDto implements Serializable {
    private final Long id;
    private final String username;
    private final Blob profilePicture;
}
