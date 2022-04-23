package darius.licenta.backend.dto.normal.story.response.table;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

public class TableStoryDto implements Serializable {
    private final Long id;
    private final String title;
    private final String description;
    private final LocalDateTime createdAt;
    private final Long createdById;
    private final Set<Long> categoryIds;
    private final Set<Long> storySubtaskIds;
    private final Long priorityId;
    private final Long softwareApplicationId;
    private final Boolean isFinished;
    private final Long totalStoryPoints;

    public TableStoryDto(Long id, String title, String description, LocalDateTime createdAt, Long createdById, Set<Long> categoryIds, Set<Long> storySubtaskIds, Long priorityId, Long softwareApplicationId, Boolean isFinished, Long totalStoryPoints) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.createdById = createdById;
        this.categoryIds = categoryIds;
        this.storySubtaskIds = storySubtaskIds;
        this.priorityId = priorityId;
        this.softwareApplicationId = softwareApplicationId;
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

    public Long getCreatedById() {
        return this.createdById;
    }

    public Set<Long> getCategoryIds() {
        return this.categoryIds;
    }

    public Set<Long> getStorySubtaskIds() {
        return this.storySubtaskIds;
    }

    public Long getPriorityId() {
        return this.priorityId;
    }

    public Long getSoftwareApplicationId() {
        return this.softwareApplicationId;
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

        TableStoryDto that = (TableStoryDto) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(title, that.title)) return false;
        if (!Objects.equals(description, that.description)) return false;
        if (!Objects.equals(createdAt, that.createdAt)) return false;
        if (!Objects.equals(createdById, that.createdById)) return false;
        if (!Objects.equals(categoryIds, that.categoryIds)) return false;
        if (!Objects.equals(storySubtaskIds, that.storySubtaskIds))
            return false;
        if (!Objects.equals(priorityId, that.priorityId)) return false;
        if (!Objects.equals(softwareApplicationId, that.softwareApplicationId))
            return false;
        if (!Objects.equals(isFinished, that.isFinished)) return false;
        return Objects.equals(totalStoryPoints, that.totalStoryPoints);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (createdById != null ? createdById.hashCode() : 0);
        result = 31 * result + (categoryIds != null ? categoryIds.hashCode() : 0);
        result = 31 * result + (storySubtaskIds != null ? storySubtaskIds.hashCode() : 0);
        result = 31 * result + (priorityId != null ? priorityId.hashCode() : 0);
        result = 31 * result + (softwareApplicationId != null ? softwareApplicationId.hashCode() : 0);
        result = 31 * result + (isFinished != null ? isFinished.hashCode() : 0);
        result = 31 * result + (totalStoryPoints != null ? totalStoryPoints.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TableStoryDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", createdById=" + createdById +
                ", categoryIds=" + categoryIds +
                ", storySubtaskIds=" + storySubtaskIds +
                ", priorityId=" + priorityId +
                ", softwareApplicationId=" + softwareApplicationId +
                ", isFinished=" + isFinished +
                ", totalStoryPoints=" + totalStoryPoints +
                '}';
    }
}
