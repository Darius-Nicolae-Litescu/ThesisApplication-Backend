package darius.licenta.backend.dto.normal.storytask.fullinformation;

import darius.licenta.backend.dto.normal.attachment.AttachmentResponseDto;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class CommentDto implements Serializable {
    private final Long id;
    private final String content;
    private final PostedByUserDto postedBy;
    private final LocalDateTime postedAt;
    private final Date modificationDate;
    private final AttachmentResponseDto attachmentResponseDto;
}
