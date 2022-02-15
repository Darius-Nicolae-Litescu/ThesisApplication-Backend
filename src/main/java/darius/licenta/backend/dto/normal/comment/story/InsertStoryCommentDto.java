package darius.licenta.backend.dto.normal.comment.story;

import lombok.Data;

import java.io.Serializable;

@Data
public class InsertStoryCommentDto implements Serializable {
    private final String content;
    private final Long storyId;
}
