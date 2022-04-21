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
        return Objects.equals(attachmentResponseDto, that.attachmentResponseDto);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (postedBy != null ? postedBy.hashCode() : 0);
        result = 31 * result + (postedAt != null ? postedAt.hashCode() : 0);
        result = 31 * result + (modificationDate != null ? modificationDate.hashCode() : 0);
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
                ", attachmentResponseDto=" + attachmentResponseDto +
                '}';
    }
}
