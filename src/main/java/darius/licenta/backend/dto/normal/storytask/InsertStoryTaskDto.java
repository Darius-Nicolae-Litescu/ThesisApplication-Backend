package darius.licenta.backend.dto.normal.storytask;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class InsertStoryTaskDto implements Serializable {
    private final String title;
    private final String description;
    private final int storyPoints;
    private final LocalDateTime createdAt;
    private final Long assignedToId;
    private final String status;
    private final Long storyId;

    public InsertStoryTaskDto(String title, String description, int storyPoints, LocalDateTime createdAt, Long assignedToId, String status, Long storyId) {
        this.title = title;
        this.description = description;
        this.storyPoints = storyPoints;
        this.createdAt = createdAt;
        this.assignedToId = assignedToId;
        this.status = status;
        this.storyId = storyId;
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

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public Long getAssignedToId() {
        return this.assignedToId;
    }

    public String getStatus() {
        return this.status;
    }

    public Long getStoryId() {
        return this.storyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InsertStoryTaskDto that = (InsertStoryTaskDto) o;

        if (storyPoints != that.storyPoints) return false;
        if (!Objects.equals(title, that.title)) return false;
        if (!Objects.equals(description, that.description)) return false;
        if (!Objects.equals(createdAt, that.createdAt)) return false;
        if (!Objects.equals(assignedToId, that.assignedToId)) return false;
        if (!Objects.equals(status, that.status)) return false;
        return Objects.equals(storyId, that.storyId);
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + storyPoints;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (assignedToId != null ? assignedToId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (storyId != null ? storyId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "InsertStoryTaskDto{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", storyPoints=" + storyPoints +
                ", createdAt=" + createdAt +
                ", assignedToId=" + assignedToId +
                ", status='" + status + '\'' +
                ", storyId=" + storyId +
                '}';
    }
}
