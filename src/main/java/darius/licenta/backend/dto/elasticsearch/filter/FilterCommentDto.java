package darius.licenta.backend.dto.elasticsearch.filter;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FilterCommentDto {
    private final String content;
}
