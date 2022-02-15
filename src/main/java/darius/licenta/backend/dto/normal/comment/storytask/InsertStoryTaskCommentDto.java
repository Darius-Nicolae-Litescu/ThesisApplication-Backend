package darius.licenta.backend.dto.normal.comment.storytask;

import lombok.Data;

import java.io.Serializable;

@Data
public class InsertStoryTaskCommentDto implements Serializable {
    private final String content;
    private final Long storyTaskId;
}