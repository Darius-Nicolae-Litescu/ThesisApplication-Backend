package darius.licenta.backend.dto.normal.storytask.fullinformation;

import darius.licenta.backend.dto.normal.attachment.AttachmentResponseDto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class CommentDto implements Serializable {
    private final Long id;
    private final String content;
    private final PostedByUserDto postedBy;
    private final LocalDateTime postedAt;
    private final Date modificationDate;
    private final AttachmentResponseDto attachmentResponseDto;

    public CommentDto(Long id, String content, PostedByUserDto postedBy, LocalDateTime postedAt, Date modificationDate, AttachmentResponseDto attachmentResponseDto) {
        this.id = id;
        this.content = content;
        this.postedBy = postedBy;
        this.postedAt = postedAt;
        this.modificationDate = modificationDate;
        this.attachmentResponseDto = attachmentResponseDto;
    }

    public Long getId() {
        return this.id;
    }

    public String getContent() {
        return this.content;
    }

    public PostedByUserDto getPostedBy() {
        return this.postedBy;
    }

    public LocalDateTime getPostedAt() {
        return this.postedAt;
    }

    public Date getModificationDate() {
        return this.modificationDate;
    }

    public AttachmentResponseDto getAttachmentResponseDto() {
        return this.attachmentResponseDto;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CommentDto)) return false;
        final CommentDto other = (CommentDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (!Objects.equals(this$id, other$id)) return false;
        final Object this$content = this.getContent();
        final Object other$content = other.getContent();
        if (!Objects.equals(this$content, other$content)) return false;
        final Object this$postedBy = this.getPostedBy();
        final Object other$postedBy = other.getPostedBy();
        if (!Objects.equals(this$postedBy, other$postedBy)) return false;
        final Object this$postedAt = this.getPostedAt();
        final Object other$postedAt = other.getPostedAt();
        if (!Objects.equals(this$postedAt, other$postedAt)) return false;
        final Object this$modificationDate = this.getModificationDate();
        final Object other$modificationDate = other.getModificationDate();
        if (!Objects.equals(this$modificationDate, other$modificationDate))
            return false;
        final Object this$attachmentResponseDto = this.getAttachmentResponseDto();
        final Object other$attachmentResponseDto = other.getAttachmentResponseDto();
        if (!Objects.equals(this$attachmentResponseDto, other$attachmentResponseDto))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CommentDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $content = this.getContent();
        result = result * PRIME + ($content == null ? 43 : $content.hashCode());
        final Object $postedBy = this.getPostedBy();
        result = result * PRIME + ($postedBy == null ? 43 : $postedBy.hashCode());
        final Object $postedAt = this.getPostedAt();
        result = result * PRIME + ($postedAt == null ? 43 : $postedAt.hashCode());
        final Object $modificationDate = this.getModificationDate();
        result = result * PRIME + ($modificationDate == null ? 43 : $modificationDate.hashCode());
        final Object $attachmentResponseDto = this.getAttachmentResponseDto();
        result = result * PRIME + ($attachmentResponseDto == null ? 43 : $attachmentResponseDto.hashCode());
        return result;
    }

    public String toString() {
        return "CommentDto(id=" + this.getId() + ", content=" + this.getContent() + ", postedBy=" + this.getPostedBy() + ", postedAt=" + this.getPostedAt() + ", modificationDate=" + this.getModificationDate() + ", attachmentResponseDto=" + this.getAttachmentResponseDto() + ")";
    }
}
