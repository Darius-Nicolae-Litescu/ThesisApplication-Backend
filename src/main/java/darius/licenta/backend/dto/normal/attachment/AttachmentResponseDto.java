package darius.licenta.backend.dto.normal.attachment;

import lombok.Data;

@Data
public class AttachmentResponseDto {
    private String name;
    private String url;
    private String contentType;
    private long size;

}
