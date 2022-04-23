package darius.licenta.backend.dto.normal.storytask;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class UpdateStoryTaskDto implements Serializable {
    private final Long id;
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

    public UpdateStoryTaskDto(Long id, String title, String description, int storyPoints, long createdById, String createdByUsername, LocalDateTime createdAt, long assignedToId, String assignedToUsername, String status, LocalDateTime finishedAt) {
        this.id = id;
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

    public Long getId() {
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

    public Long getCreatedById() {
        return this.createdById;
    }

    public String getCreatedByUsername() {
        return this.createdByUsername;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public Long getAssignedToId() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UpdateStoryTaskDto that = (UpdateStoryTaskDto) o;

        if (storyPoints != that.storyPoints) return false;
        if (createdById != that.createdById) return false;
        if (assignedToId != that.assignedToId) return false;
        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(title, that.title)) return false;
        if (!Objects.equals(description, that.description)) return false;
        if (!Objects.equals(createdByUsername, that.createdByUsername))
            return false;
        if (!Objects.equals(createdAt, that.createdAt)) return false;
        if (!Objects.equals(assignedToUsername, that.assignedToUsername))
            return false;
        if (!Objects.equals(status, that.status)) return false;
        return Objects.equals(finishedAt, that.finishedAt);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + storyPoints;
        result = 31 * result + (int) (createdById ^ (createdById >>> 32));
        result = 31 * result + (createdByUsername != null ? createdByUsername.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (int) (assignedToId ^ (assignedToId >>> 32));
        result = 31 * result + (assignedToUsername != null ? assignedToUsername.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (finishedAt != null ? finishedAt.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UpdateStoryTaskDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", storyPoints=" + storyPoints +
                ", createdById=" + createdById +
                ", createdByUsername='" + createdByUsername + '\'' +
                ", createdAt=" + createdAt +
                ", assignedToId=" + assignedToId +
                ", assignedToUsername='" + assignedToUsername + '\'' +
                ", status='" + status + '\'' +
                ", finishedAt=" + finishedAt +
                '}';
    }
}
