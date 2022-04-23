package darius.licenta.backend.dto.normal.story.response.fulldetails;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class StoryTaskDto implements Serializable {
    private final Long id;
    private final String title;
    private final String description;
    private final int storyPoints;
    private final CreatedByUserDto createdBy;
    private final LocalDateTime createdAt;
    private final String status;
    private final LocalDateTime finishedAt;
    private final Date modificationDate;

    public StoryTaskDto(Long id, String title, String description, int storyPoints, CreatedByUserDto createdBy, LocalDateTime createdAt, String status, LocalDateTime finishedAt, Date modificationDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.storyPoints = storyPoints;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.status = status;
        this.finishedAt = finishedAt;
        this.modificationDate = modificationDate;
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

    public CreatedByUserDto getCreatedBy() {
        return this.createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public String getStatus() {
        return this.status;
    }

    public LocalDateTime getFinishedAt() {
        return this.finishedAt;
    }

    public Date getModificationDate() {
        return this.modificationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StoryTaskDto that = (StoryTaskDto) o;

        if (storyPoints != that.storyPoints) return false;
        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(title, that.title)) return false;
        if (!Objects.equals(description, that.description)) return false;
        if (!Objects.equals(createdBy, that.createdBy)) return false;
        if (!Objects.equals(createdAt, that.createdAt)) return false;
        if (!Objects.equals(status, that.status)) return false;
        if (!Objects.equals(finishedAt, that.finishedAt)) return false;
        return Objects.equals(modificationDate, that.modificationDate);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + storyPoints;
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (finishedAt != null ? finishedAt.hashCode() : 0);
        result = 31 * result + (modificationDate != null ? modificationDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StoryTaskDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", storyPoints=" + storyPoints +
                ", createdBy=" + createdBy +
                ", createdAt=" + createdAt +
                ", status='" + status + '\'' +
                ", finishedAt=" + finishedAt +
                ", modificationDate=" + modificationDate +
                '}';
    }
}
