package darius.licenta.backend.dto.elasticsearch.filter;

import java.util.Objects;

public class FilterStoryTaskDto {
    private final String title;
    private final String description;
    private final Long storyPoints;
    private final String createdByUsername;
    private final String assignedToUsername;
    private final String status;

    public FilterStoryTaskDto(String title, String description, Long storyPoints, String createdByUsername, String assignedToUsername, String status) {
        this.title = title;
        this.description = description;
        this.storyPoints = storyPoints;
        this.createdByUsername = createdByUsername;
        this.assignedToUsername = assignedToUsername;
        this.status = status;
    }


    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public Long getStoryPoints() {
        return this.storyPoints;
    }

    public String getCreatedByUsername() {
        return this.createdByUsername;
    }

    public String getAssignedToUsername() {
        return this.assignedToUsername;
    }

    public String getStatus() {
        return this.status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilterStoryTaskDto that = (FilterStoryTaskDto) o;

        if (!Objects.equals(title, that.title)) return false;
        if (!Objects.equals(description, that.description)) return false;
        if (!Objects.equals(storyPoints, that.storyPoints)) return false;
        if (!Objects.equals(createdByUsername, that.createdByUsername))
            return false;
        if (!Objects.equals(assignedToUsername, that.assignedToUsername))
            return false;
        return Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (storyPoints != null ? storyPoints.hashCode() : 0);
        result = 31 * result + (createdByUsername != null ? createdByUsername.hashCode() : 0);
        result = 31 * result + (assignedToUsername != null ? assignedToUsername.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FilterStoryTaskDto{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", storyPoints=" + storyPoints +
                ", createdByUsername='" + createdByUsername + '\'' +
                ", assignedToUsername='" + assignedToUsername + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
