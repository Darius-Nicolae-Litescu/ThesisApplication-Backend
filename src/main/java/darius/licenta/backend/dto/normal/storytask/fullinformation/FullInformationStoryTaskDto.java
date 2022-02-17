package darius.licenta.backend.dto.normal.storytask.fullinformation;

import java.io.Serializable;
import java.sql.Blob;
import java.time.LocalDateTime;
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
    private final Set<StoryCommentDto> storyComments;
    private final Set<AttachmentDto> commentAttachments;
    private final long storyId;
    private final String storyDescription;

    public FullInformationStoryTaskDto(long id, String title, String description, int storyPoints, long createdById, String createdByUsername, String createdByEmail, LocalDateTime createdAt, long assignedToId, String assignedToUsername, String assignedToEmail, String status, LocalDateTime finishedAt, Set<StoryCommentDto> storyComments, Set<AttachmentDto> commentAttachments, long storyId, String storyDescription) {
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
        this.storyComments = storyComments;
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

    public Set<StoryCommentDto> getStoryComments() {
        return this.storyComments;
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

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof FullInformationStoryTaskDto))
            return false;
        final FullInformationStoryTaskDto other = (FullInformationStoryTaskDto) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        if (this.getStoryPoints() != other.getStoryPoints()) return false;
        if (this.getCreatedById() != other.getCreatedById()) return false;
        final Object this$createdByUsername = this.getCreatedByUsername();
        final Object other$createdByUsername = other.getCreatedByUsername();
        if (this$createdByUsername == null ? other$createdByUsername != null : !this$createdByUsername.equals(other$createdByUsername))
            return false;
        final Object this$createdByEmail = this.getCreatedByEmail();
        final Object other$createdByEmail = other.getCreatedByEmail();
        if (this$createdByEmail == null ? other$createdByEmail != null : !this$createdByEmail.equals(other$createdByEmail))
            return false;
        final Object this$createdAt = this.getCreatedAt();
        final Object other$createdAt = other.getCreatedAt();
        if (this$createdAt == null ? other$createdAt != null : !this$createdAt.equals(other$createdAt)) return false;
        if (this.getAssignedToId() != other.getAssignedToId()) return false;
        final Object this$assignedToUsername = this.getAssignedToUsername();
        final Object other$assignedToUsername = other.getAssignedToUsername();
        if (this$assignedToUsername == null ? other$assignedToUsername != null : !this$assignedToUsername.equals(other$assignedToUsername))
            return false;
        final Object this$assignedToEmail = this.getAssignedToEmail();
        final Object other$assignedToEmail = other.getAssignedToEmail();
        if (this$assignedToEmail == null ? other$assignedToEmail != null : !this$assignedToEmail.equals(other$assignedToEmail))
            return false;
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        final Object this$finishedAt = this.getFinishedAt();
        final Object other$finishedAt = other.getFinishedAt();
        if (this$finishedAt == null ? other$finishedAt != null : !this$finishedAt.equals(other$finishedAt))
            return false;
        final Object this$storyComments = this.getStoryComments();
        final Object other$storyComments = other.getStoryComments();
        if (this$storyComments == null ? other$storyComments != null : !this$storyComments.equals(other$storyComments))
            return false;
        final Object this$commentAttachments = this.getCommentAttachments();
        final Object other$commentAttachments = other.getCommentAttachments();
        if (this$commentAttachments == null ? other$commentAttachments != null : !this$commentAttachments.equals(other$commentAttachments))
            return false;
        if (this.getStoryId() != other.getStoryId()) return false;
        final Object this$storyDescription = this.getStoryDescription();
        final Object other$storyDescription = other.getStoryDescription();
        if (this$storyDescription == null ? other$storyDescription != null : !this$storyDescription.equals(other$storyDescription))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof FullInformationStoryTaskDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        result = result * PRIME + this.getStoryPoints();
        final long $createdById = this.getCreatedById();
        result = result * PRIME + (int) ($createdById >>> 32 ^ $createdById);
        final Object $createdByUsername = this.getCreatedByUsername();
        result = result * PRIME + ($createdByUsername == null ? 43 : $createdByUsername.hashCode());
        final Object $createdByEmail = this.getCreatedByEmail();
        result = result * PRIME + ($createdByEmail == null ? 43 : $createdByEmail.hashCode());
        final Object $createdAt = this.getCreatedAt();
        result = result * PRIME + ($createdAt == null ? 43 : $createdAt.hashCode());
        final long $assignedToId = this.getAssignedToId();
        result = result * PRIME + (int) ($assignedToId >>> 32 ^ $assignedToId);
        final Object $assignedToUsername = this.getAssignedToUsername();
        result = result * PRIME + ($assignedToUsername == null ? 43 : $assignedToUsername.hashCode());
        final Object $assignedToEmail = this.getAssignedToEmail();
        result = result * PRIME + ($assignedToEmail == null ? 43 : $assignedToEmail.hashCode());
        final Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        final Object $finishedAt = this.getFinishedAt();
        result = result * PRIME + ($finishedAt == null ? 43 : $finishedAt.hashCode());
        final Object $storyComments = this.getStoryComments();
        result = result * PRIME + ($storyComments == null ? 43 : $storyComments.hashCode());
        final Object $commentAttachments = this.getCommentAttachments();
        result = result * PRIME + ($commentAttachments == null ? 43 : $commentAttachments.hashCode());
        final long $storyId = this.getStoryId();
        result = result * PRIME + (int) ($storyId >>> 32 ^ $storyId);
        final Object $storyDescription = this.getStoryDescription();
        result = result * PRIME + ($storyDescription == null ? 43 : $storyDescription.hashCode());
        return result;
    }

    public String toString() {
        return "FullInformationStoryTaskDto(id=" + this.getId() + ", title=" + this.getTitle() + ", description=" + this.getDescription() + ", storyPoints=" + this.getStoryPoints() + ", createdById=" + this.getCreatedById() + ", createdByUsername=" + this.getCreatedByUsername() + ", createdByEmail=" + this.getCreatedByEmail() + ", createdAt=" + this.getCreatedAt() + ", assignedToId=" + this.getAssignedToId() + ", assignedToUsername=" + this.getAssignedToUsername() + ", assignedToEmail=" + this.getAssignedToEmail() + ", status=" + this.getStatus() + ", finishedAt=" + this.getFinishedAt() + ", storyComments=" + this.getStoryComments() + ", commentAttachments=" + this.getCommentAttachments() + ", storyId=" + this.getStoryId() + ", storyDescription=" + this.getStoryDescription() + ")";
    }

    public static class StoryCommentDto implements Serializable {
        private final long id;
        private final String content;
        private final LocalDateTime postedAt;

        public StoryCommentDto(long id, String content, LocalDateTime postedAt) {
            this.id = id;
            this.content = content;
            this.postedAt = postedAt;
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

        public boolean equals(final Object o) {
            if (o == this) return true;
            if (!(o instanceof StoryCommentDto))
                return false;
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
            return "FullInformationStoryTaskDto.StoryCommentDto(id=" + this.getId() + ", content=" + this.getContent() + ", postedAt=" + this.getPostedAt() + ")";
        }
    }

    public static class AttachmentDto implements Serializable {
        private final long id;
        private final String contentType;
        private final Blob content;
        private final LocalDateTime postedAt;

        public AttachmentDto(long id, String contentType, Blob content, LocalDateTime postedAt) {
            this.id = id;
            this.contentType = contentType;
            this.content = content;
            this.postedAt = postedAt;
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

        public boolean equals(final Object o) {
            if (o == this) return true;
            if (!(o instanceof AttachmentDto))
                return false;
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
            return "FullInformationStoryTaskDto.AttachmentDto(id=" + this.getId() + ", contentType=" + this.getContentType() + ", content=" + this.getContent() + ", postedAt=" + this.getPostedAt() + ")";
        }
    }
}
