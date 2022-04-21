package darius.licenta.backend.dto.normal.story.response.partialdetails;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

public class ResponseStoryDtoWithoutFullDetails implements Serializable {
    private final Long id;
    private final String title;
    private final String description;
    private final LocalDateTime createdAt;
    private final Long createdById;
    private final String createdByUsername;
    private final String createdByEmail;
    private final Date modificationDate;
    private final Set<CategoryDto> categories;
    private final Set<StoryTaskDto> storySubtasks;
    private final Long priorityId;
    private final String priorityTitle;
    private final String priorityDescription;
    private final int priorityLevel;
    private final Boolean isFinished;
    private final Long totalStoryPoints;

    public ResponseStoryDtoWithoutFullDetails(Long id, String title, String description, LocalDateTime createdAt, Long createdById, String createdByUsername, String createdByEmail, Date modificationDate, Set<CategoryDto> categories, Set<StoryTaskDto> storySubtasks, Long priorityId, String priorityTitle, String priorityDescription, int priorityLevel, Boolean isFinished, Long totalStoryPoints) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.createdById = createdById;
        this.createdByUsername = createdByUsername;
        this.createdByEmail = createdByEmail;
        this.modificationDate = modificationDate;
        this.categories = categories;
        this.storySubtasks = storySubtasks;
        this.priorityId = priorityId;
        this.priorityTitle = priorityTitle;
        this.priorityDescription = priorityDescription;
        this.priorityLevel = priorityLevel;
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

    public String getCreatedByUsername() {
        return this.createdByUsername;
    }

    public String getCreatedByEmail() {
        return this.createdByEmail;
    }

    public Date getModificationDate() {
        return this.modificationDate;
    }

    public Set<CategoryDto> getCategories() {
        return this.categories;
    }

    public Set<StoryTaskDto> getStorySubtasks() {
        return this.storySubtasks;
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

    public int getPriorityLevel() {
        return this.priorityLevel;
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

        ResponseStoryDtoWithoutFullDetails that = (ResponseStoryDtoWithoutFullDetails) o;

        if (priorityLevel != that.priorityLevel) return false;
        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(title, that.title)) return false;
        if (!Objects.equals(description, that.description)) return false;
        if (!Objects.equals(createdAt, that.createdAt)) return false;
        if (!Objects.equals(createdById, that.createdById)) return false;
        if (!Objects.equals(createdByUsername, that.createdByUsername))
            return false;
        if (!Objects.equals(createdByEmail, that.createdByEmail))
            return false;
        if (!Objects.equals(modificationDate, that.modificationDate))
            return false;
        if (!Objects.equals(categories, that.categories)) return false;
        if (!Objects.equals(storySubtasks, that.storySubtasks))
            return false;
        if (!Objects.equals(priorityId, that.priorityId)) return false;
        if (!Objects.equals(priorityTitle, that.priorityTitle))
            return false;
        if (!Objects.equals(priorityDescription, that.priorityDescription))
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
        result = 31 * result + (createdByUsername != null ? createdByUsername.hashCode() : 0);
        result = 31 * result + (createdByEmail != null ? createdByEmail.hashCode() : 0);
        result = 31 * result + (modificationDate != null ? modificationDate.hashCode() : 0);
        result = 31 * result + (categories != null ? categories.hashCode() : 0);
        result = 31 * result + (storySubtasks != null ? storySubtasks.hashCode() : 0);
        result = 31 * result + (priorityId != null ? priorityId.hashCode() : 0);
        result = 31 * result + (priorityTitle != null ? priorityTitle.hashCode() : 0);
        result = 31 * result + (priorityDescription != null ? priorityDescription.hashCode() : 0);
        result = 31 * result + priorityLevel;
        result = 31 * result + (isFinished != null ? isFinished.hashCode() : 0);
        result = 31 * result + (totalStoryPoints != null ? totalStoryPoints.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ResponseStoryDtoWithoutFullDetails{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", createdById=" + createdById +
                ", createdByUsername='" + createdByUsername + '\'' +
                ", createdByEmail='" + createdByEmail + '\'' +
                ", modificationDate=" + modificationDate +
                ", categories=" + categories +
                ", storySubtasks=" + storySubtasks +
                ", priorityId=" + priorityId +
                ", priorityTitle='" + priorityTitle + '\'' +
                ", priorityDescription='" + priorityDescription + '\'' +
                ", priorityLevel=" + priorityLevel +
                ", isFinished=" + isFinished +
                ", totalStoryPoints=" + totalStoryPoints +
                '}';
    }

    public static class CategoryDto implements Serializable {
        private final Long id;
        private final String categoryName;

        public CategoryDto(Long id, String categoryName) {
            this.id = id;
            this.categoryName = categoryName;
        }


        public Long getId() {
            return this.id;
        }

        public String getCategoryName() {
            return this.categoryName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CategoryDto that = (CategoryDto) o;

            if (!Objects.equals(id, that.id)) return false;
            return Objects.equals(categoryName, that.categoryName);
        }

        @Override
        public int hashCode() {
            int result = id != null ? id.hashCode() : 0;
            result = 31 * result + (categoryName != null ? categoryName.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "CategoryDto{" +
                    "id=" + id +
                    ", categoryName='" + categoryName + '\'' +
                    '}';
        }
    }

    public static class StoryTaskDto implements Serializable {
        private final Long id;
        private final String title;
        private final String description;

        public StoryTaskDto(Long id, String title, String description) {
            this.id = id;
            this.title = title;
            this.description = description;
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            StoryTaskDto that = (StoryTaskDto) o;

            if (!Objects.equals(id, that.id)) return false;
            if (!Objects.equals(title, that.title)) return false;
            return Objects.equals(description, that.description);
        }

        @Override
        public int hashCode() {
            int result = id != null ? id.hashCode() : 0;
            result = 31 * result + (title != null ? title.hashCode() : 0);
            result = 31 * result + (description != null ? description.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "StoryTaskDto{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }
    }
}
