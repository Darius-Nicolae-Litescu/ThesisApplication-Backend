package darius.licenta.backend.dto.normal.attachment;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AttachmentResponseDto {
    private Long id;
    private LocalDateTime postedAt;
    private String name;
    private String url;
    private String contentType;
    private long size;

}
