package darius.licenta.backend.dto.normal.attachment;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class AttachmentDto implements Serializable {
    private final String id;
    private final String name;
    private final String contentType;
    private final byte[] content;
    private final LocalDateTime postedAt;
    private final String uploadedByUsername;
}
