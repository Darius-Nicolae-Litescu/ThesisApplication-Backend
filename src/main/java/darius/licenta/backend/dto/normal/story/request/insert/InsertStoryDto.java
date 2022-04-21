package darius.licenta.backend.dto.normal.story.request.insert;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class InsertStoryDto implements Serializable {
    private final String title;
    private final String description;
    private final Set<Long> categoryIds;
    private final Long priorityId;
    private final Long softwareApplicationId;

    public InsertStoryDto(String title, String description, Set<Long> categoryIds, Long priorityId, Long softwareApplicationId) {
        this.title = title;
        this.description = description;
        this.categoryIds = categoryIds;
        this.priorityId = priorityId;
        this.softwareApplicationId = softwareApplicationId;
    }


    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public Set<Long> getCategoryIds() {
        return this.categoryIds;
    }

    public Long getPriorityId() {
        return this.priorityId;
    }

    public Long getSoftwareApplicationId() {
        return this.softwareApplicationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InsertStoryDto that = (InsertStoryDto) o;

        if (!Objects.equals(title, that.title)) return false;
        if (!Objects.equals(description, that.description)) return false;
        if (!Objects.equals(categoryIds, that.categoryIds)) return false;
        if (!Objects.equals(priorityId, that.priorityId)) return false;
        return Objects.equals(softwareApplicationId, that.softwareApplicationId);
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (categoryIds != null ? categoryIds.hashCode() : 0);
        result = 31 * result + (priorityId != null ? priorityId.hashCode() : 0);
        result = 31 * result + (softwareApplicationId != null ? softwareApplicationId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "InsertStoryDto{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", categoryIds=" + categoryIds +
                ", priorityId=" + priorityId +
                ", softwareApplicationId=" + softwareApplicationId +
                '}';
    }
}
