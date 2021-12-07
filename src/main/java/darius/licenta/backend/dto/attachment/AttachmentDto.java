package darius.licenta.backend.dto.attachment;

import java.io.Serializable;
import java.sql.Blob;
import java.time.LocalDateTime;

public class AttachmentDto implements Serializable {
    private long id;
    private String contentType;
    private Blob content;
    private LocalDateTime postedAt;

    public AttachmentDto(long id, String contentType, Blob content, LocalDateTime postedAt) {
        this.id = id;
        this.contentType = contentType;
        this.content = content;
        this.postedAt = postedAt;
    }

    public AttachmentDto() {
    }

    public long getId() {
        return this.id;
    }

    public String getContentType() {
        return this.contentType;
    }

    public Blob getContent() {
        return this.content;
    }

    public LocalDateTime getPostedAt() {
        return this.postedAt;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setContent(Blob content) {
        this.content = content;
    }

    public void setPostedAt(LocalDateTime postedAt) {
        this.postedAt = postedAt;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof AttachmentDto)) return false;
        final AttachmentDto other = (AttachmentDto) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$contentType = this.getContentType();
        final Object other$contentType = other.getContentType();
        if (this$contentType == null ? other$contentType != null : !this$contentType.equals(other$contentType))
            return false;
        final Object this$content = this.getContent();
        final Object other$content = other.getContent();
        if (this$content == null ? other$content != null : !this$content.equals(other$content)) return false;
        final Object this$postedAt = this.getPostedAt();
        final Object other$postedAt = other.getPostedAt();
        if (this$postedAt == null ? other$postedAt != null : !this$postedAt.equals(other$postedAt)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AttachmentDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final Object $contentType = this.getContentType();
        result = result * PRIME + ($contentType == null ? 43 : $contentType.hashCode());
        final Object $content = this.getContent();
        result = result * PRIME + ($content == null ? 43 : $content.hashCode());
        final Object $postedAt = this.getPostedAt();
        result = result * PRIME + ($postedAt == null ? 43 : $postedAt.hashCode());
        return result;
    }

    public String toString() {
        return "AttachmentDto(id=" + this.getId() + ", contentType=" + this.getContentType() + ", content=" + this.getContent() + ", postedAt=" + this.getPostedAt() + ")";
    }
}
