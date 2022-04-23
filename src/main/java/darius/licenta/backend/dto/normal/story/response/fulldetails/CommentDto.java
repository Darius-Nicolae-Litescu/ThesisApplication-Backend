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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentDto that = (CommentDto) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(content, that.content)) return false;
        if (!Objects.equals(postedBy, that.postedBy)) return false;
        if (!Objects.equals(postedAt, that.postedAt)) return false;
        if (!Objects.equals(modificationDate, that.modificationDate))
            return false;
        if (!Objects.equals(commentAttachments, that.commentAttachments))
            return false;
        return Objects.equals(attachmentResponseDto, that.attachmentResponseDto);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (postedBy != null ? postedBy.hashCode() : 0);
        result = 31 * result + (postedAt != null ? postedAt.hashCode() : 0);
        result = 31 * result + (modificationDate != null ? modificationDate.hashCode() : 0);
        result = 31 * result + (commentAttachments != null ? commentAttachments.hashCode() : 0);
        result = 31 * result + (attachmentResponseDto != null ? attachmentResponseDto.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CommentDto{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", postedBy=" + postedBy +
                ", postedAt=" + postedAt +
                ", modificationDate=" + modificationDate +
                ", commentAttachments=" + commentAttachments +
                ", attachmentResponseDto=" + attachmentResponseDto +
                '}';
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            AttachmentDto that = (AttachmentDto) o;

            if (!Objects.equals(id, that.id)) return false;
            return Objects.equals(postedAt, that.postedAt);
        }

        @Override
        public int hashCode() {
            int result = id != null ? id.hashCode() : 0;
            result = 31 * result + (postedAt != null ? postedAt.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "AttachmentDto{" +
                    "id=" + id +
                    ", postedAt=" + postedAt +
                    '}';
        }
    }
}
