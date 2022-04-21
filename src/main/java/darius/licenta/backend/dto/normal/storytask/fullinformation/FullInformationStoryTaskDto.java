package darius.licenta.backend.dto.normal.storytask.fullinformation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import darius.licenta.backend.dto.normal.attachment.AttachmentResponseDto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class FullInformationStoryTaskDto implements Serializable {
    private final long id;
    private final String title;
    private final String description;
    private final int storyPoints;
    private final long createdById;
    private final String createdByUsername;
    private final String createdByEmail;
    private final LocalDateTime createdAt;
    private final long assignedToId;
    private final String assignedToUsername;
    private final String assignedToEmail;
    private final String status;
    private final LocalDateTime finishedAt;
    private final Set<AttachmentDto> commentAttachments;
    private final long storyId;
    private final String storyDescription;
    private List<StoryCommentDto> storyComments;

    public FullInformationStoryTaskDto(long id, String title, String description, int storyPoints, long createdById, String createdByUsername, String createdByEmail, LocalDateTime createdAt, long assignedToId, String assignedToUsername, String assignedToEmail, String status, LocalDateTime finishedAt, Set<AttachmentDto> commentAttachments, long storyId, String storyDescription) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.storyPoints = storyPoints;
        this.createdById = createdById;
        this.createdByUsername = createdByUsername;
        this.createdByEmail = createdByEmail;
        this.createdAt = createdAt;
        this.assignedToId = assignedToId;
        this.assignedToUsername = assignedToUsername;
        this.assignedToEmail = assignedToEmail;
        this.status = status;
        this.finishedAt = finishedAt;
        this.commentAttachments = commentAttachments;
        this.storyId = storyId;
        this.storyDescription = storyDescription;
    }

    public long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public int getStoryPoints() {
        return this.storyPoints;
    }

    public long getCreatedById() {
        return this.createdById;
    }

    public String getCreatedByUsername() {
        return this.createdByUsername;
    }

    public String getCreatedByEmail() {
        return this.createdByEmail;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public long getAssignedToId() {
        return this.assignedToId;
    }

    public String getAssignedToUsername() {
        return this.assignedToUsername;
    }

    public String getAssignedToEmail() {
        return this.assignedToEmail;
    }

    public String getStatus() {
        return this.status;
    }

    public LocalDateTime getFinishedAt() {
        return this.finishedAt;
    }

    public List<StoryCommentDto> getStoryComments() {
        return this.storyComments;
    }

    public void setStoryComments(List<StoryCommentDto> storyComments) {
        this.storyComments = storyComments;
    }

    public Set<AttachmentDto> getCommentAttachments() {
        return this.commentAttachments;
    }

    public long getStoryId() {
        return this.storyId;
    }

    public String getStoryDescription() {
        return this.storyDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FullInformationStoryTaskDto that = (FullInformationStoryTaskDto) o;

        if (id != that.id) return false;
        if (storyPoints != that.storyPoints) return false;
        if (createdById != that.createdById) return false;
        if (assignedToId != that.assignedToId) return false;
        if (storyId != that.storyId) return false;
        if (!Objects.equals(title, that.title)) return false;
        if (!Objects.equals(description, that.description)) return false;
        if (!Objects.equals(createdByUsername, that.createdByUsername))
            return false;
        if (!Objects.equals(createdByEmail, that.createdByEmail))
            return false;
        if (!Objects.equals(createdAt, that.createdAt)) return false;
        if (!Objects.equals(assignedToUsername, that.assignedToUsername))
            return false;
        if (!Objects.equals(assignedToEmail, that.assignedToEmail))
            return false;
        if (!Objects.equals(status, that.status)) return false;
        if (!Objects.equals(finishedAt, that.finishedAt)) return false;
        if (!Objects.equals(storyComments, that.storyComments))
            return false;
        if (!Objects.equals(commentAttachments, that.commentAttachments))
            return false;
        return Objects.equals(storyDescription, that.storyDescription);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + storyPoints;
        result = 31 * result + (int) (createdById ^ (createdById >>> 32));
        result = 31 * result + (createdByUsername != null ? createdByUsername.hashCode() : 0);
        result = 31 * result + (createdByEmail != null ? createdByEmail.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (int) (assignedToId ^ (assignedToId >>> 32));
        result = 31 * result + (assignedToUsername != null ? assignedToUsername.hashCode() : 0);
        result = 31 * result + (assignedToEmail != null ? assignedToEmail.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (finishedAt != null ? finishedAt.hashCode() : 0);
        result = 31 * result + (storyComments != null ? storyComments.hashCode() : 0);
        result = 31 * result + (commentAttachments != null ? commentAttachments.hashCode() : 0);
        result = 31 * result + (int) (storyId ^ (storyId >>> 32));
        result = 31 * result + (storyDescription != null ? storyDescription.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FullInformationStoryTaskDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", storyPoints=" + storyPoints +
                ", createdById=" + createdById +
                ", createdByUsername='" + createdByUsername + '\'' +
                ", createdByEmail='" + createdByEmail + '\'' +
                ", createdAt=" + createdAt +
                ", assignedToId=" + assignedToId +
                ", assignedToUsername='" + assignedToUsername + '\'' +
                ", assignedToEmail='" + assignedToEmail + '\'' +
                ", status='" + status + '\'' +
                ", finishedAt=" + finishedAt +
                ", storyComments=" + storyComments +
                ", commentAttachments=" + commentAttachments +
                ", storyId=" + storyId +
                ", storyDescription='" + storyDescription + '\'' +
                '}';
    }

    public static class StoryCommentDto implements Serializable {
        private final Long id;
        private final String content;
        private final PostedByUserDto postedBy;
        private final LocalDateTime postedAt;
        private final Date modificationDate;
        @JsonIgnore
        private final Set<AttachmentDto> commentAttachments;
        private List<AttachmentResponseDto> attachmentResponseDto;

        public StoryCommentDto(Long id, String content, PostedByUserDto postedBy, LocalDateTime postedAt, Date modificationDate, Set<AttachmentDto> commentAttachments) {
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

            StoryCommentDto that = (StoryCommentDto) o;

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
            return "StoryCommentDto{" +
                    "id=" + id +
                    ", content='" + content + '\'' +
                    ", postedBy=" + postedBy +
                    ", postedAt=" + postedAt +
                    ", modificationDate=" + modificationDate +
                    ", commentAttachments=" + commentAttachments +
                    ", attachmentResponseDto=" + attachmentResponseDto +
                    '}';
        }
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
