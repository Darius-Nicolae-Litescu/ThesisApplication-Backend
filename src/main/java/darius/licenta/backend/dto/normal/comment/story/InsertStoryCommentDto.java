package darius.licenta.backend.dto.normal.comment.story;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class InsertStoryCommentDto implements Serializable {
    private final String content;
    private final Long storyId;
    private final List<MultipartFile> commentAttachments;

    public InsertStoryCommentDto(String content, Long storyId, List<MultipartFile> commentAttachments) {
        this.content = content;
        this.storyId = storyId;
        this.commentAttachments = commentAttachments;
    }

    public String getContent() {
        return this.content;
    }

    public Long getStoryId() {
        return this.storyId;
    }

    public List<MultipartFile> getCommentAttachments() {
        return this.commentAttachments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InsertStoryCommentDto that = (InsertStoryCommentDto) o;

        if (!Objects.equals(content, that.content)) return false;
        if (!Objects.equals(storyId, that.storyId)) return false;
        return Objects.equals(commentAttachments, that.commentAttachments);
    }

    @Override
    public int hashCode() {
        int result = content != null ? content.hashCode() : 0;
        result = 31 * result + (storyId != null ? storyId.hashCode() : 0);
        result = 31 * result + (commentAttachments != null ? commentAttachments.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "InsertStoryCommentDto{" +
                "content='" + content + '\'' +
                ", storyId=" + storyId +
                ", commentAttachments=" + commentAttachments +
                '}';
    }
}
