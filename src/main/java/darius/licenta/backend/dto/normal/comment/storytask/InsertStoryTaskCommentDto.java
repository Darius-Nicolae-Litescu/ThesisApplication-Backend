package darius.licenta.backend.dto.normal.comment.storytask;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.sql.Blob;
import java.util.List;
import java.util.Set;

@Data
public class InsertStoryTaskCommentDto implements Serializable {
    private final String content;
    private final Long storyTaskId;
    private final List<MultipartFile> commentAttachments;
}
