package darius.licenta.backend.dto.storytask;

import java.io.Serializable;
import java.time.LocalDateTime;

public class InsertStoryTaskDto implements Serializable {
    private final String title;
    private final String description;
    private final int storyPoints;
    private final long createdById;
    private final String createdByUsername;
    private final LocalDateTime createdAt;
    private final long assignedToId;
    private final String assignedToUsername;
    private final String status;
    private final LocalDateTime finishedAt;

    public InsertStoryTaskDto(String title, String description, int storyPoints, long createdById, String createdByUsername, LocalDateTime createdAt, long assignedToId, String assignedToUsername, String status, LocalDateTime finishedAt) {
        this.title = title;
        this.description = description;
        this.storyPoints = storyPoints;
        this.createdById = createdById;
        this.createdByUsername = createdByUsername;
        this.createdAt = createdAt;
        this.assignedToId = assignedToId;
        this.assignedToUsername = assignedToUsername;
        this.status = status;
        this.finishedAt = finishedAt;
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

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public long getAssignedToId() {
        return this.assignedToId;
    }

    public String getAssignedToUsername() {
        return this.assignedToUsername;
    }

    public String getStatus() {
        return this.status;
    }

    public LocalDateTime getFinishedAt() {
        return this.finishedAt;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof InsertStoryTaskDto)) return false;
        final InsertStoryTaskDto other = (InsertStoryTaskDto) o;
        if (!other.canEqual((Object) this)) return false;
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
        final Object this$createdAt = this.getCreatedAt();
        final Object other$createdAt = other.getCreatedAt();
        if (this$createdAt == null ? other$createdAt != null : !this$createdAt.equals(other$createdAt)) return false;
        if (this.getAssignedToId() != other.getAssignedToId()) return false;
        final Object this$assignedToUsername = this.getAssignedToUsername();
        final Object other$assignedToUsername = other.getAssignedToUsername();
        if (this$assignedToUsername == null ? other$assignedToUsername != null : !this$assignedToUsername.equals(other$assignedToUsername))
            return false;
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        final Object this$finishedAt = this.getFinishedAt();
        final Object other$finishedAt = other.getFinishedAt();
        if (this$finishedAt == null ? other$finishedAt != null : !this$finishedAt.equals(other$finishedAt))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof InsertStoryTaskDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        result = result * PRIME + this.getStoryPoints();
        final long $createdById = this.getCreatedById();
        result = result * PRIME + (int) ($createdById >>> 32 ^ $createdById);
        final Object $createdByUsername = this.getCreatedByUsername();
        result = result * PRIME + ($createdByUsername == null ? 43 : $createdByUsername.hashCode());
        final Object $createdAt = this.getCreatedAt();
        result = result * PRIME + ($createdAt == null ? 43 : $createdAt.hashCode());
        final long $assignedToId = this.getAssignedToId();
        result = result * PRIME + (int) ($assignedToId >>> 32 ^ $assignedToId);
        final Object $assignedToUsername = this.getAssignedToUsername();
        result = result * PRIME + ($assignedToUsername == null ? 43 : $assignedToUsername.hashCode());
        final Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        final Object $finishedAt = this.getFinishedAt();
        result = result * PRIME + ($finishedAt == null ? 43 : $finishedAt.hashCode());
        return result;
    }

    public String toString() {
        return "InsertStoryTaskDto(title=" + this.getTitle() + ", description=" + this.getDescription() + ", storyPoints=" + this.getStoryPoints() + ", createdById=" + this.getCreatedById() + ", createdByUsername=" + this.getCreatedByUsername() + ", createdAt=" + this.getCreatedAt() + ", assignedToId=" + this.getAssignedToId() + ", assignedToUsername=" + this.getAssignedToUsername() + ", status=" + this.getStatus() + ", finishedAt=" + this.getFinishedAt() + ")";
    }
}
