package darius.licenta.backend.dto.normal.storytask.fullinformation;

import lombok.Data;

import java.io.Serializable;
import java.sql.Blob;

@Data
public class PostedByUserDto implements Serializable {
    private final String username;
    private final Blob profilePicture;
}
