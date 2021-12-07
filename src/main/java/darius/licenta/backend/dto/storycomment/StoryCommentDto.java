package darius.licenta.backend.dto.storycomment;

import java.io.Serializable;
import java.time.LocalDateTime;

public class StoryCommentDto implements Serializable {
    private long id;
    private String content;
    private LocalDateTime postedAt;

    public StoryCommentDto(long id, String content, LocalDateTime postedAt) {
        this.id = id;
        this.content = content;
        this.postedAt = postedAt;
    }

    public StoryCommentDto() {
    }

    public long getId() {
        return this.id;
    }

    public String getContent() {
        return this.content;
    }

    public LocalDateTime getPostedAt() {
        return this.postedAt;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPostedAt(LocalDateTime postedAt) {
        this.postedAt = postedAt;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof StoryCommentDto)) return false;
        final StoryCommentDto other = (StoryCommentDto) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$content = this.getContent();
        final Object other$content = other.getContent();
        if (this$content == null ? other$content != null : !this$content.equals(other$content)) return false;
        final Object this$postedAt = this.getPostedAt();
        final Object other$postedAt = other.getPostedAt();
        if (this$postedAt == null ? other$postedAt != null : !this$postedAt.equals(other$postedAt)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof StoryCommentDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final Object $content = this.getContent();
        result = result * PRIME + ($content == null ? 43 : $content.hashCode());
        final Object $postedAt = this.getPostedAt();
        result = result * PRIME + ($postedAt == null ? 43 : $postedAt.hashCode());
        return result;
    }

    public String toString() {
        return "StoryCommentDto(id=" + this.getId() + ", content=" + this.getContent() + ", postedAt=" + this.getPostedAt() + ")";
    }
}
