package darius.licenta.backend.dto.normal.comment.story;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;

@Data
public class InsertStoryCommentDto implements Serializable {
    private final String content;
    private final Long storyId;
    private final List<MultipartFile> commentAttachments;
}
