package darius.licenta.backend.dto.normal.story.response.fulldetails;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class FullDetailsResponseStoryDto implements Serializable {
    private final Long id;
    private final String title;
    private final String description;
    private final LocalDateTime createdAt;
    private final CreatedByUserDto createdBy;
    private final Date modificationDate;
    private final Set<CategoryDto> categories;
    private final Set<StoryTaskDto> storySubtasks;
    private final PriorityDto priority;
    private final Set<AttachmentDto> storyAttachments;
    private final SoftwareApplicationDto softwareApplication;
    private final Boolean isFinished;
    private final Long totalStoryPoints;
    private List<CommentDto> comments;

    public FullDetailsResponseStoryDto(Long id, String title, String description, LocalDateTime createdAt, CreatedByUserDto createdBy, Date modificationDate, Set<CategoryDto> categories, Set<StoryTaskDto> storySubtasks, PriorityDto priority, Set<AttachmentDto> storyAttachments, SoftwareApplicationDto softwareApplication, Boolean isFinished, Long totalStoryPoints) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.modificationDate = modificationDate;
        this.categories = categories;
        this.storySubtasks = storySubtasks;
        this.priority = priority;
        this.storyAttachments = storyAttachments;
        this.softwareApplication = softwareApplication;
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

    public CreatedByUserDto getCreatedBy() {
        return this.createdBy;
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

    public PriorityDto getPriority() {
        return this.priority;
    }

    public List<CommentDto> getComments() {
        return this.comments;
    }

    public void setComments(List<CommentDto> comments) {
        this.comments = comments;
    }

    public Set<AttachmentDto> getStoryAttachments() {
        return this.storyAttachments;
    }

    public SoftwareApplicationDto getSoftwareApplication() {
        return this.softwareApplication;
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

        FullDetailsResponseStoryDto that = (FullDetailsResponseStoryDto) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(title, that.title)) return false;
        if (!Objects.equals(description, that.description)) return false;
        if (!Objects.equals(createdAt, that.createdAt)) return false;
        if (!Objects.equals(createdBy, that.createdBy)) return false;
        if (!Objects.equals(modificationDate, that.modificationDate))
            return false;
        if (!Objects.equals(categories, that.categories)) return false;
        if (!Objects.equals(storySubtasks, that.storySubtasks))
            return false;
        if (!Objects.equals(priority, that.priority)) return false;
        if (!Objects.equals(comments, that.comments)) return false;
        if (!Objects.equals(storyAttachments, that.storyAttachments))
            return false;
        if (!Objects.equals(softwareApplication, that.softwareApplication))
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
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (modificationDate != null ? modificationDate.hashCode() : 0);
        result = 31 * result + (categories != null ? categories.hashCode() : 0);
        result = 31 * result + (storySubtasks != null ? storySubtasks.hashCode() : 0);
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (storyAttachments != null ? storyAttachments.hashCode() : 0);
        result = 31 * result + (softwareApplication != null ? softwareApplication.hashCode() : 0);
        result = 31 * result + (isFinished != null ? isFinished.hashCode() : 0);
        result = 31 * result + (totalStoryPoints != null ? totalStoryPoints.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FullDetailsResponseStoryDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", createdBy=" + createdBy +
                ", modificationDate=" + modificationDate +
                ", categories=" + categories +
                ", storySubtasks=" + storySubtasks +
                ", priority=" + priority +
                ", comments=" + comments +
                ", storyAttachments=" + storyAttachments +
                ", softwareApplication=" + softwareApplication +
                ", isFinished=" + isFinished +
                ", totalStoryPoints=" + totalStoryPoints +
                '}';
    }
}
