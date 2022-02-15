package darius.licenta.backend.dto.normal.attachment;

import java.io.Serializable;
import java.sql.Blob;
import java.time.LocalDateTime;

public class AttachmentDto implements Serializable {
    private final Long id;
    private final String contentType;
    private final Blob content;
    private final LocalDateTime postedAt;
    private final String uploadedByUsername;

    public AttachmentDto(Long id, String contentType, Blob content, LocalDateTime postedAt, String uploadedByUsername) {
        this.id = id;
        this.contentType = contentType;
        this.content = content;
        this.postedAt = postedAt;
        this.uploadedByUsername = uploadedByUsername;
    }

    public Long getId() {
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

    public String getUploadedByUsername() {
        return this.uploadedByUsername;
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
        final Object this$uploadedByUsername = this.getUploadedByUsername();
        final Object other$uploadedByUsername = other.getUploadedByUsername();
        if (this$uploadedByUsername == null ? other$uploadedByUsername != null : !this$uploadedByUsername.equals(other$uploadedByUsername))
            return false;
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
        final Object $uploadedByUsername = this.getUploadedByUsername();
        result = result * PRIME + ($uploadedByUsername == null ? 43 : $uploadedByUsername.hashCode());
        return result;
    }

    public String toString() {
        return "AttachmentDto(id=" + this.getId() + ", contentType=" + this.getContentType() + ", content=" + this.getContent() + ", postedAt=" + this.getPostedAt() + ", uploadedByUsername=" + this.getUploadedByUsername() + ")";
    }
}
