package darius.licenta.backend.dto.elasticsearch.filter;

import java.util.Objects;

public class FilterStoryDto {
    private final String title;
    private final String description;
    private final String category;
    private final Long priorityId;
    private final String priorityTitle;
    private final String priorityDescription;
    private final Integer priorityLevel;
    private final String softwareApplicationName;
    private final String softwareApplicationDescription;

    public FilterStoryDto(String title, String description, String category, Long priorityId, String priorityTitle, String priorityDescription, Integer priorityLevel, String softwareApplicationName, String softwareApplicationDescription) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.priorityId = priorityId;
        this.priorityTitle = priorityTitle;
        this.priorityDescription = priorityDescription;
        this.priorityLevel = priorityLevel;
        this.softwareApplicationName = softwareApplicationName;
        this.softwareApplicationDescription = softwareApplicationDescription;
    }


    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public String getCategory() {
        return this.category;
    }

    public Long getPriorityId() {
        return this.priorityId;
    }

    public String getPriorityTitle() {
        return this.priorityTitle;
    }

    public String getPriorityDescription() {
        return this.priorityDescription;
    }

    public Integer getPriorityLevel() {
        return this.priorityLevel;
    }

    public String getSoftwareApplicationName() {
        return this.softwareApplicationName;
    }

    public String getSoftwareApplicationDescription() {
        return this.softwareApplicationDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilterStoryDto that = (FilterStoryDto) o;

        if (!Objects.equals(title, that.title)) return false;
        if (!Objects.equals(description, that.description)) return false;
        if (!Objects.equals(category, that.category)) return false;
        if (!Objects.equals(priorityId, that.priorityId)) return false;
        if (!Objects.equals(priorityTitle, that.priorityTitle))
            return false;
        if (!Objects.equals(priorityDescription, that.priorityDescription))
            return false;
        if (!Objects.equals(priorityLevel, that.priorityLevel))
            return false;
        if (!Objects.equals(softwareApplicationName, that.softwareApplicationName))
            return false;
        return Objects.equals(softwareApplicationDescription, that.softwareApplicationDescription);
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (priorityId != null ? priorityId.hashCode() : 0);
        result = 31 * result + (priorityTitle != null ? priorityTitle.hashCode() : 0);
        result = 31 * result + (priorityDescription != null ? priorityDescription.hashCode() : 0);
        result = 31 * result + (priorityLevel != null ? priorityLevel.hashCode() : 0);
        result = 31 * result + (softwareApplicationName != null ? softwareApplicationName.hashCode() : 0);
        result = 31 * result + (softwareApplicationDescription != null ? softwareApplicationDescription.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FilterStoryDto{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", priorityId=" + priorityId +
                ", priorityTitle='" + priorityTitle + '\'' +
                ", priorityDescription='" + priorityDescription + '\'' +
                ", priorityLevel=" + priorityLevel +
                ", softwareApplicationName='" + softwareApplicationName + '\'' +
                ", softwareApplicationDescription='" + softwareApplicationDescription + '\'' +
                '}';
    }
}
