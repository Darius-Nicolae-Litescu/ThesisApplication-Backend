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

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof InsertStoryCommentDto)) return false;
        final InsertStoryCommentDto other = (InsertStoryCommentDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$content = this.getContent();
        final Object other$content = other.getContent();
        if (!Objects.equals(this$content, other$content)) return false;
        final Object this$storyId = this.getStoryId();
        final Object other$storyId = other.getStoryId();
        if (!Objects.equals(this$storyId, other$storyId)) return false;
        final Object this$commentAttachments = this.getCommentAttachments();
        final Object other$commentAttachments = other.getCommentAttachments();
        if (!Objects.equals(this$commentAttachments, other$commentAttachments))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof InsertStoryCommentDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $content = this.getContent();
        result = result * PRIME + ($content == null ? 43 : $content.hashCode());
        final Object $storyId = this.getStoryId();
        result = result * PRIME + ($storyId == null ? 43 : $storyId.hashCode());
        final Object $commentAttachments = this.getCommentAttachments();
        result = result * PRIME + ($commentAttachments == null ? 43 : $commentAttachments.hashCode());
        return result;
    }

    public String toString() {
        return "InsertStoryCommentDto(content=" + this.getContent() + ", storyId=" + this.getStoryId() + ", commentAttachments=" + this.getCommentAttachments() + ")";
    }
}
