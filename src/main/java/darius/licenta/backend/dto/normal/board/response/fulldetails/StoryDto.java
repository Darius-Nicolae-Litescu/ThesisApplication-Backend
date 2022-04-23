package darius.licenta.backend.dto.normal.board.response.fulldetails;

import darius.licenta.backend.dto.normal.board.response.PriorityDto;
import darius.licenta.backend.dto.normal.board.response.UserDto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

public class StoryDto implements Serializable {
    private final Long id;
    private final String title;
    private final String description;
    private final LocalDateTime createdAt;
    private final UserDto createdBy;
    private final Date modificationDate;
    private final Set<CategoryDto> categories;
    private final PriorityDto priority;
    private final Boolean isFinished;
    private final Long totalStoryPoints;

    public StoryDto(Long id, String title, String description, LocalDateTime createdAt, UserDto createdBy, Date modificationDate, Set<CategoryDto> categories, PriorityDto priority, Boolean isFinished, Long totalStoryPoints) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.modificationDate = modificationDate;
        this.categories = categories;
        this.priority = priority;
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

    public UserDto getCreatedBy() {
        return this.createdBy;
    }

    public Date getModificationDate() {
        return this.modificationDate;
    }

    public Set<CategoryDto> getCategories() {
        return this.categories;
    }

    public PriorityDto getPriority() {
        return this.priority;
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

        StoryDto storyDto = (StoryDto) o;

        if (!Objects.equals(id, storyDto.id)) return false;
        if (!Objects.equals(title, storyDto.title)) return false;
        if (!Objects.equals(description, storyDto.description))
            return false;
        if (!Objects.equals(createdAt, storyDto.createdAt)) return false;
        if (!Objects.equals(createdBy, storyDto.createdBy)) return false;
        if (!Objects.equals(modificationDate, storyDto.modificationDate))
            return false;
        if (!Objects.equals(categories, storyDto.categories)) return false;
        if (!Objects.equals(priority, storyDto.priority)) return false;
        if (!Objects.equals(isFinished, storyDto.isFinished)) return false;
        return Objects.equals(totalStoryPoints, storyDto.totalStoryPoints);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (modificationDate != null ? modificationDate.hashCode() : 0);
        result = 31 * result + (categories != null ? categories.hashCode() : 0);
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        result = 31 * result + (isFinished != null ? isFinished.hashCode() : 0);
        result = 31 * result + (totalStoryPoints != null ? totalStoryPoints.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StoryDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", createdBy=" + createdBy +
                ", modificationDate=" + modificationDate +
                ", categories=" + categories +
                ", priority=" + priority +
                ", isFinished=" + isFinished +
                ", totalStoryPoints=" + totalStoryPoints +
                '}';
    }
}
