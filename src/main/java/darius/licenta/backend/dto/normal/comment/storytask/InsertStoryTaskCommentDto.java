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

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof InsertStoryTaskCommentDto)) return false;
        final InsertStoryTaskCommentDto other = (InsertStoryTaskCommentDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$content = this.getContent();
        final Object other$content = other.getContent();
        if (!Objects.equals(this$content, other$content)) return false;
        final Object this$storyTaskId = this.getStoryTaskId();
        final Object other$storyTaskId = other.getStoryTaskId();
        if (!Objects.equals(this$storyTaskId, other$storyTaskId))
            return false;
        final Object this$commentAttachments = this.getCommentAttachments();
        final Object other$commentAttachments = other.getCommentAttachments();
        if (!Objects.equals(this$commentAttachments, other$commentAttachments))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof InsertStoryTaskCommentDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $content = this.getContent();
        result = result * PRIME + ($content == null ? 43 : $content.hashCode());
        final Object $storyTaskId = this.getStoryTaskId();
        result = result * PRIME + ($storyTaskId == null ? 43 : $storyTaskId.hashCode());
        final Object $commentAttachments = this.getCommentAttachments();
        result = result * PRIME + ($commentAttachments == null ? 43 : $commentAttachments.hashCode());
        return result;
    }

    public String toString() {
        return "InsertStoryTaskCommentDto(content=" + this.getContent() + ", storyTaskId=" + this.getStoryTaskId() + ", commentAttachments=" + this.getCommentAttachments() + ")";
    }
}
