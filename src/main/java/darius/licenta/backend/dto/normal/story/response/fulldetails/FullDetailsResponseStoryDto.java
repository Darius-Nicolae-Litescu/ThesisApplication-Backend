package darius.licenta.backend.dto.normal.story.response.fulldetails;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
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
    private List<CommentDto> comments;
    private final Set<AttachmentDto> storyAttachments;
    private final SoftwareApplicationDto softwareApplication;
    private final Boolean isFinished;
    private final Long totalStoryPoints;

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

    public void setComments(List<CommentDto> comments) {
        this.comments = comments;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof FullDetailsResponseStoryDto))
            return false;
        final FullDetailsResponseStoryDto other = (FullDetailsResponseStoryDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        final Object this$createdAt = this.getCreatedAt();
        final Object other$createdAt = other.getCreatedAt();
        if (this$createdAt == null ? other$createdAt != null : !this$createdAt.equals(other$createdAt)) return false;
        final Object this$createdBy = this.getCreatedBy();
        final Object other$createdBy = other.getCreatedBy();
        if (this$createdBy == null ? other$createdBy != null : !this$createdBy.equals(other$createdBy)) return false;
        final Object this$modificationDate = this.getModificationDate();
        final Object other$modificationDate = other.getModificationDate();
        if (this$modificationDate == null ? other$modificationDate != null : !this$modificationDate.equals(other$modificationDate))
            return false;
        final Object this$categories = this.getCategories();
        final Object other$categories = other.getCategories();
        if (this$categories == null ? other$categories != null : !this$categories.equals(other$categories))
            return false;
        final Object this$storySubtasks = this.getStorySubtasks();
        final Object other$storySubtasks = other.getStorySubtasks();
        if (this$storySubtasks == null ? other$storySubtasks != null : !this$storySubtasks.equals(other$storySubtasks))
            return false;
        final Object this$priority = this.getPriority();
        final Object other$priority = other.getPriority();
        if (this$priority == null ? other$priority != null : !this$priority.equals(other$priority)) return false;
        final Object this$comments = this.getComments();
        final Object other$comments = other.getComments();
        if (this$comments == null ? other$comments != null : !this$comments.equals(other$comments)) return false;
        final Object this$storyAttachments = this.getStoryAttachments();
        final Object other$storyAttachments = other.getStoryAttachments();
        if (this$storyAttachments == null ? other$storyAttachments != null : !this$storyAttachments.equals(other$storyAttachments))
            return false;
        final Object this$softwareApplication = this.getSoftwareApplication();
        final Object other$softwareApplication = other.getSoftwareApplication();
        if (this$softwareApplication == null ? other$softwareApplication != null : !this$softwareApplication.equals(other$softwareApplication))
            return false;
        final Object this$isFinished = this.getIsFinished();
        final Object other$isFinished = other.getIsFinished();
        if (this$isFinished == null ? other$isFinished != null : !this$isFinished.equals(other$isFinished))
            return false;
        final Object this$totalStoryPoints = this.getTotalStoryPoints();
        final Object other$totalStoryPoints = other.getTotalStoryPoints();
        if (this$totalStoryPoints == null ? other$totalStoryPoints != null : !this$totalStoryPoints.equals(other$totalStoryPoints))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof FullDetailsResponseStoryDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $createdAt = this.getCreatedAt();
        result = result * PRIME + ($createdAt == null ? 43 : $createdAt.hashCode());
        final Object $createdBy = this.getCreatedBy();
        result = result * PRIME + ($createdBy == null ? 43 : $createdBy.hashCode());
        final Object $modificationDate = this.getModificationDate();
        result = result * PRIME + ($modificationDate == null ? 43 : $modificationDate.hashCode());
        final Object $categories = this.getCategories();
        result = result * PRIME + ($categories == null ? 43 : $categories.hashCode());
        final Object $storySubtasks = this.getStorySubtasks();
        result = result * PRIME + ($storySubtasks == null ? 43 : $storySubtasks.hashCode());
        final Object $priority = this.getPriority();
        result = result * PRIME + ($priority == null ? 43 : $priority.hashCode());
        final Object $comments = this.getComments();
        result = result * PRIME + ($comments == null ? 43 : $comments.hashCode());
        final Object $storyAttachments = this.getStoryAttachments();
        result = result * PRIME + ($storyAttachments == null ? 43 : $storyAttachments.hashCode());
        final Object $softwareApplication = this.getSoftwareApplication();
        result = result * PRIME + ($softwareApplication == null ? 43 : $softwareApplication.hashCode());
        final Object $isFinished = this.getIsFinished();
        result = result * PRIME + ($isFinished == null ? 43 : $isFinished.hashCode());
        final Object $totalStoryPoints = this.getTotalStoryPoints();
        result = result * PRIME + ($totalStoryPoints == null ? 43 : $totalStoryPoints.hashCode());
        return result;
    }

    public String toString() {
        return "FullDetailsResponseStoryDto(id=" + this.getId() + ", title=" + this.getTitle() + ", description=" + this.getDescription() + ", createdAt=" + this.getCreatedAt() + ", createdBy=" + this.getCreatedBy() + ", modificationDate=" + this.getModificationDate() + ", categories=" + this.getCategories() + ", storySubtasks=" + this.getStorySubtasks() + ", priority=" + this.getPriority() + ", comments=" + this.getComments() + ", storyAttachments=" + this.getStoryAttachments() + ", softwareApplication=" + this.getSoftwareApplication() + ", isFinished=" + this.getIsFinished() + ", totalStoryPoints=" + this.getTotalStoryPoints() + ")";
    }
}
