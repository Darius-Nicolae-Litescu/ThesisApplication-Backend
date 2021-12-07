package darius.licenta.backend.dto.commentattachment;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CommentAttachmentDto implements Serializable {
    private long id;
    private LocalDateTime postedAt;

    public CommentAttachmentDto(long id, LocalDateTime postedAt) {
        this.id = id;
        this.postedAt = postedAt;
    }

    public CommentAttachmentDto() {
    }

    public long getId() {
        return this.id;
    }

    public LocalDateTime getPostedAt() {
        return this.postedAt;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPostedAt(LocalDateTime postedAt) {
        this.postedAt = postedAt;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CommentAttachmentDto)) return false;
        final CommentAttachmentDto other = (CommentAttachmentDto) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$postedAt = this.getPostedAt();
        final Object other$postedAt = other.getPostedAt();
        if (this$postedAt == null ? other$postedAt != null : !this$postedAt.equals(other$postedAt)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CommentAttachmentDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final Object $postedAt = this.getPostedAt();
        result = result * PRIME + ($postedAt == null ? 43 : $postedAt.hashCode());
        return result;
    }

    public String toString() {
        return "CommentAttachmentDto(id=" + this.getId() + ", postedAt=" + this.getPostedAt() + ")";
    }
}
