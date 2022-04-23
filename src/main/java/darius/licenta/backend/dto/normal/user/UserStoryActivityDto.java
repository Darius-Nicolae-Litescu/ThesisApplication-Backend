package darius.licenta.backend.dto.normal.user;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class UserStoryActivityDto implements Serializable {
    private final Long id;
    private final String title;
    private final String description;
    private final LocalDateTime createdAt;
    private final Boolean isFinished;
    private final Long totalStoryPoints;

    public UserStoryActivityDto(Long id, String title, String description, LocalDateTime createdAt, Boolean isFinished, Long totalStoryPoints) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.isFinished = isFinished;
        this.totalStoryPoints = totalStoryPoints;
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

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public Boolean getIsFinished() {
        return this.isFinished;
    }

    public Long getTotalStoryPoints() {
        return this.totalStoryPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserStoryActivityDto that = (UserStoryActivityDto) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(title, that.title)) return false;
        if (!Objects.equals(description, that.description)) return false;
        if (!Objects.equals(createdAt, that.createdAt)) return false;
        if (!Objects.equals(isFinished, that.isFinished)) return false;
        return Objects.equals(totalStoryPoints, that.totalStoryPoints);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (isFinished != null ? isFinished.hashCode() : 0);
        result = 31 * result + (totalStoryPoints != null ? totalStoryPoints.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserStoryActivityDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", isFinished=" + isFinished +
                ", totalStoryPoints=" + totalStoryPoints +
                '}';
    }
}
