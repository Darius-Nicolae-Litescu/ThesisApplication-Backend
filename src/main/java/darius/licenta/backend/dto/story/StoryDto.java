package darius.licenta.backend.dto.story;

import java.io.Serializable;
import java.util.Set;

public class StoryDto implements Serializable {
    private long id;
    private String description;
    private CategoryDto category;
    private Set<StoryTaskDto> storySubtasks;
    private PriorityDto priority;
    private Set<AttachmentDto> storyAttachments;
    private SoftwareApplicationDto softwareApplication;

    public StoryDto(long id, String description, CategoryDto category, Set<StoryTaskDto> storySubtasks, PriorityDto priority, Set<AttachmentDto> storyAttachments, SoftwareApplicationDto softwareApplication) {
        this.id = id;
        this.description = description;
        this.category = category;
        this.storySubtasks = storySubtasks;
        this.priority = priority;
        this.storyAttachments = storyAttachments;
        this.softwareApplication = softwareApplication;
    }

    public StoryDto() {
    }

    public long getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public CategoryDto getCategory() {
        return this.category;
    }

    public Set<StoryTaskDto> getStorySubtasks() {
        return this.storySubtasks;
    }

    public PriorityDto getPriority() {
        return this.priority;
    }

    public Set<AttachmentDto> getStoryAttachments() {
        return this.storyAttachments;
    }

    public SoftwareApplicationDto getSoftwareApplication() {
        return this.softwareApplication;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public void setStorySubtasks(Set<StoryTaskDto> storySubtasks) {
        this.storySubtasks = storySubtasks;
    }

    public void setPriority(PriorityDto priority) {
        this.priority = priority;
    }

    public void setStoryAttachments(Set<AttachmentDto> storyAttachments) {
        this.storyAttachments = storyAttachments;
    }

    public void setSoftwareApplication(SoftwareApplicationDto softwareApplication) {
        this.softwareApplication = softwareApplication;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof StoryDto)) return false;
        final StoryDto other = (StoryDto) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        final Object this$category = this.getCategory();
        final Object other$category = other.getCategory();
        if (this$category == null ? other$category != null : !this$category.equals(other$category)) return false;
        final Object this$storySubtasks = this.getStorySubtasks();
        final Object other$storySubtasks = other.getStorySubtasks();
        if (this$storySubtasks == null ? other$storySubtasks != null : !this$storySubtasks.equals(other$storySubtasks))
            return false;
        final Object this$priority = this.getPriority();
        final Object other$priority = other.getPriority();
        if (this$priority == null ? other$priority != null : !this$priority.equals(other$priority)) return false;
        final Object this$storyAttachments = this.getStoryAttachments();
        final Object other$storyAttachments = other.getStoryAttachments();
        if (this$storyAttachments == null ? other$storyAttachments != null : !this$storyAttachments.equals(other$storyAttachments))
            return false;
        final Object this$softwareApplication = this.getSoftwareApplication();
        final Object other$softwareApplication = other.getSoftwareApplication();
        if (this$softwareApplication == null ? other$softwareApplication != null : !this$softwareApplication.equals(other$softwareApplication))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof StoryDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $category = this.getCategory();
        result = result * PRIME + ($category == null ? 43 : $category.hashCode());
        final Object $storySubtasks = this.getStorySubtasks();
        result = result * PRIME + ($storySubtasks == null ? 43 : $storySubtasks.hashCode());
        final Object $priority = this.getPriority();
        result = result * PRIME + ($priority == null ? 43 : $priority.hashCode());
        final Object $storyAttachments = this.getStoryAttachments();
        result = result * PRIME + ($storyAttachments == null ? 43 : $storyAttachments.hashCode());
        final Object $softwareApplication = this.getSoftwareApplication();
        result = result * PRIME + ($softwareApplication == null ? 43 : $softwareApplication.hashCode());
        return result;
    }

    public String toString() {
        return "StoryDto(id=" + this.getId() + ", description=" + this.getDescription() + ", category=" + this.getCategory() + ", storySubtasks=" + this.getStorySubtasks() + ", priority=" + this.getPriority() + ", storyAttachments=" + this.getStoryAttachments() + ", softwareApplication=" + this.getSoftwareApplication() + ")";
    }
}
