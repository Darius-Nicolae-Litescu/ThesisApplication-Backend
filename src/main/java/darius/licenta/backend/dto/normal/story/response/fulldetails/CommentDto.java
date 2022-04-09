package darius.licenta.backend.dto.normal.story.response.fulldetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import darius.licenta.backend.dto.normal.attachment.AttachmentResponseDto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class CommentDto implements Serializable {
    private final Long id;
    private final String content;
    private final PostedByUserDto postedBy;
    private final LocalDateTime postedAt;
    private final Date modificationDate;
    @JsonIgnore
    private final Set<AttachmentDto> commentAttachments;
    private List<AttachmentResponseDto> attachmentResponseDto;

    public CommentDto(Long id, String content, PostedByUserDto postedBy, LocalDateTime postedAt, Date modificationDate, Set<AttachmentDto> commentAttachments) {
        this.id = id;
        this.content = content;
        this.postedBy = postedBy;
        this.postedAt = postedAt;
        this.modificationDate = modificationDate;
        this.commentAttachments = commentAttachments;
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

    public Set<AttachmentDto> getCommentAttachments() {
        return this.commentAttachments;
    }

    public List<AttachmentResponseDto> getAttachmentResponseDto() {
        return this.attachmentResponseDto;
    }

    public void setAttachmentResponseDto(List<AttachmentResponseDto> attachmentResponseDto) {
        this.attachmentResponseDto = attachmentResponseDto;
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
        final Object this$commentAttachments = this.getCommentAttachments();
        final Object other$commentAttachments = other.getCommentAttachments();
        if (!Objects.equals(this$commentAttachments, other$commentAttachments))
            return false;
        final Object this$attachmentResponseDto = this.getAttachmentResponseDto();
        final Object other$attachmentResponseDto = other.getAttachmentResponseDto();
        if (this$attachmentResponseDto == null ? other$attachmentResponseDto != null : !this$attachmentResponseDto.equals(other$attachmentResponseDto))
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
        final Object $commentAttachments = this.getCommentAttachments();
        result = result * PRIME + ($commentAttachments == null ? 43 : $commentAttachments.hashCode());
        final Object $attachmentResponseDto = this.getAttachmentResponseDto();
        result = result * PRIME + ($attachmentResponseDto == null ? 43 : $attachmentResponseDto.hashCode());
        return result;
    }

    public String toString() {
        return "CommentDto(id=" + this.getId() + ", content=" + this.getContent() + ", postedBy=" + this.getPostedBy() + ", postedAt=" + this.getPostedAt() + ", modificationDate=" + this.getModificationDate() + ", commentAttachments=" + this.getCommentAttachments() + ", attachmentResponseDto=" + this.getAttachmentResponseDto() + ")";
    }

    public static class AttachmentDto implements Serializable {
        private final Long id;
        private final LocalDateTime postedAt;

        public AttachmentDto(Long id, LocalDateTime postedAt) {
            this.id = id;
            this.postedAt = postedAt;
        }

        public Long getId() {
            return this.id;
        }

        public LocalDateTime getPostedAt() {
            return this.postedAt;
        }

        public boolean equals(final Object o) {
            if (o == this) return true;
            if (!(o instanceof AttachmentDto))
                return false;
            final AttachmentDto other = (AttachmentDto) o;
            if (!other.canEqual((Object) this)) return false;
            final Object this$id = this.getId();
            final Object other$id = other.getId();
            if (!Objects.equals(this$id, other$id)) return false;
            final Object this$postedAt = this.getPostedAt();
            final Object other$postedAt = other.getPostedAt();
            if (!Objects.equals(this$postedAt, other$postedAt)) return false;
            return true;
        }

        protected boolean canEqual(final Object other) {
            return other instanceof AttachmentDto;
        }

        public int hashCode() {
            final int PRIME = 59;
            int result = 1;
            final Object $id = this.getId();
            result = result * PRIME + ($id == null ? 43 : $id.hashCode());
            final Object $postedAt = this.getPostedAt();
            result = result * PRIME + ($postedAt == null ? 43 : $postedAt.hashCode());
            return result;
        }

        public String toString() {
            return "CommentDto.AttachmentDto(id=" + this.getId() + ", postedAt=" + this.getPostedAt() + ")";
        }
    }
}
