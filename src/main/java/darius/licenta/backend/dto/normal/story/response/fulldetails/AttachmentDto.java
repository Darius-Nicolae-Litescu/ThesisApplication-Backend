package darius.licenta.backend.dto.normal.story.response.fulldetails;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class AttachmentDto implements Serializable {
    private final Long id;
    private final LocalDateTime postedAt;
}
