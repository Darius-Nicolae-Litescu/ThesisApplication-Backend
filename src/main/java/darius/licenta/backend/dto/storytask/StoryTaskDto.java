package darius.licenta.backend.dto.storytask;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

public class StoryTaskDto implements Serializable {
    private long id;
    private String title;
    private String description;
    private int storyPoints;
    private UserDto createdBy;
    private LocalDateTime createdAt;
    private UserDto assignedTo;
    private String status;
    private LocalDateTime finishedAt;
    private Set<StoryCommentDto> storyComments;
    private Set<AttachmentDto> commentAttachments;
    private StoryDto story;

    public StoryTaskDto(long id, String title, String description, int storyPoints, UserDto createdBy, LocalDateTime createdAt, UserDto assignedTo, String status, LocalDateTime finishedAt, Set<StoryCommentDto> storyComments, Set<AttachmentDto> commentAttachments, StoryDto story) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.storyPoints = storyPoints;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.assignedTo = assignedTo;
        this.status = status;
        this.finishedAt = finishedAt;
        this.storyComments = storyComments;
        this.commentAttachments = commentAttachments;
        this.story = story;
    }

    public StoryTaskDto() {
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

    public UserDto getCreatedBy() {
        return this.createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public UserDto getAssignedTo() {
        return this.assignedTo;
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

    public StoryDto getStory() {
        return this.story;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStoryPoints(int storyPoints) {
        this.storyPoints = storyPoints;
    }

    public void setCreatedBy(UserDto createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setAssignedTo(UserDto assignedTo) {
        this.assignedTo = assignedTo;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setFinishedAt(LocalDateTime finishedAt) {
        this.finishedAt = finishedAt;
    }

    public void setStoryComments(Set<StoryCommentDto> storyComments) {
        this.storyComments = storyComments;
    }

    public void setCommentAttachments(Set<AttachmentDto> commentAttachments) {
        this.commentAttachments = commentAttachments;
    }

    public void setStory(StoryDto story) {
        this.story = story;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof StoryTaskDto)) return false;
        final StoryTaskDto other = (StoryTaskDto) o;
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
        final Object this$createdBy = this.getCreatedBy();
        final Object other$createdBy = other.getCreatedBy();
        if (this$createdBy == null ? other$createdBy != null : !this$createdBy.equals(other$createdBy)) return false;
        final Object this$createdAt = this.getCreatedAt();
        final Object other$createdAt = other.getCreatedAt();
        if (this$createdAt == null ? other$createdAt != null : !this$createdAt.equals(other$createdAt)) return false;
        final Object this$assignedTo = this.getAssignedTo();
        final Object other$assignedTo = other.getAssignedTo();
        if (this$assignedTo == null ? other$assignedTo != null : !this$assignedTo.equals(other$assignedTo))
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
        final Object this$story = this.getStory();
        final Object other$story = other.getStory();
        if (this$story == null ? other$story != null : !this$story.equals(other$story)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof StoryTaskDto;
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
        final Object $createdBy = this.getCreatedBy();
        result = result * PRIME + ($createdBy == null ? 43 : $createdBy.hashCode());
        final Object $createdAt = this.getCreatedAt();
        result = result * PRIME + ($createdAt == null ? 43 : $createdAt.hashCode());
        final Object $assignedTo = this.getAssignedTo();
        result = result * PRIME + ($assignedTo == null ? 43 : $assignedTo.hashCode());
        final Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        final Object $finishedAt = this.getFinishedAt();
        result = result * PRIME + ($finishedAt == null ? 43 : $finishedAt.hashCode());
        final Object $storyComments = this.getStoryComments();
        result = result * PRIME + ($storyComments == null ? 43 : $storyComments.hashCode());
        final Object $commentAttachments = this.getCommentAttachments();
        result = result * PRIME + ($commentAttachments == null ? 43 : $commentAttachments.hashCode());
        final Object $story = this.getStory();
        result = result * PRIME + ($story == null ? 43 : $story.hashCode());
        return result;
    }

    public String toString() {
        return "StoryTaskDto(id=" + this.getId() + ", title=" + this.getTitle() + ", description=" + this.getDescription() + ", storyPoints=" + this.getStoryPoints() + ", createdBy=" + this.getCreatedBy() + ", createdAt=" + this.getCreatedAt() + ", assignedTo=" + this.getAssignedTo() + ", status=" + this.getStatus() + ", finishedAt=" + this.getFinishedAt() + ", storyComments=" + this.getStoryComments() + ", commentAttachments=" + this.getCommentAttachments() + ", story=" + this.getStory() + ")";
    }
}
