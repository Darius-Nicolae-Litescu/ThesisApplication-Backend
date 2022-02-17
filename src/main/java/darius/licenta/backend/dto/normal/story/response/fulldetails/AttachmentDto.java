package darius.licenta.backend.dto.normal.story.response.fulldetails;

import lombok.Data;

import java.io.Serializable;
import java.sql.Blob;
import java.time.LocalDateTime;

@Data
public class AttachmentDto implements Serializable {
    private final Long id;
    private final String contentType;
    private final Blob content;
    private final LocalDateTime postedAt;
}
