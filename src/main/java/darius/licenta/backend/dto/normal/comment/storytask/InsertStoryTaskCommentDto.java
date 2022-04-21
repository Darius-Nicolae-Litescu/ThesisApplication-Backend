package darius.licenta.backend.dto.normal.comment.storytask;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class InsertStoryTaskCommentDto implements Serializable {
    private final String content;
    private final Long storyTaskId;
    private final List<MultipartFile> commentAttachments;

    public InsertStoryTaskCommentDto(String content, Long storyTaskId, List<MultipartFile> commentAttachments) {
        this.content = content;
        this.storyTaskId = storyTaskId;
        this.commentAttachments = commentAttachments;
    }

    public String getContent() {
        return this.content;
    }

    public Long getStoryTaskId() {
        return this.storyTaskId;
    }

    public List<MultipartFile> getCommentAttachments() {
        return this.commentAttachments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InsertStoryTaskCommentDto that = (InsertStoryTaskCommentDto) o;

        if (!Objects.equals(content, that.content)) return false;
        if (!Objects.equals(storyTaskId, that.storyTaskId)) return false;
        return Objects.equals(commentAttachments, that.commentAttachments);
    }

    @Override
    public int hashCode() {
        int result = content != null ? content.hashCode() : 0;
        result = 31 * result + (storyTaskId != null ? storyTaskId.hashCode() : 0);
        result = 31 * result + (commentAttachments != null ? commentAttachments.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "InsertStoryTaskCommentDto{" +
                "content='" + content + '\'' +
                ", storyTaskId=" + storyTaskId +
                ", commentAttachments=" + commentAttachments +
                '}';
    }
}
