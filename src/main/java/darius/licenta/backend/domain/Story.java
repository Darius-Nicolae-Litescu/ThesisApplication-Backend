package darius.licenta.backend.domain;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = Story.TABLE_NAME)
public class Story {
    public static final String TABLE_NAME = "story";

    @Id
    @GeneratedValue()
    private long id;

    @Column(name = "description", nullable = false, length = 512)
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category", nullable = false)
    private Category category;

    @OneToMany(mappedBy="story", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<StoryTask> storySubtasks;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "priority", nullable = false)
    private Priority priority;

    @OneToMany(mappedBy="story", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Attachment> storyAttachments;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private SoftwareApplication softwareApplication;

    public Story(long id, String description, Set<StoryTask> storySubtasks, Priority priority, Set<Attachment> storyAttachments, SoftwareApplication softwareApplication) {
        this.id = id;
        this.description = description;
        this.storySubtasks = storySubtasks;
        this.priority = priority;
        this.storyAttachments = storyAttachments;
        this.softwareApplication = softwareApplication;
    }

    public Story() {
    }

    public long getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public Set<StoryTask> getStorySubtasks() {
        return this.storySubtasks;
    }

    public Priority getPriority() {
        return this.priority;
    }

    public Set<Attachment> getStoryAttachments() {
        return this.storyAttachments;
    }

    public SoftwareApplication getSoftwareApplication() {
        return this.softwareApplication;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStorySubtasks(Set<StoryTask> storySubtasks) {
        this.storySubtasks = storySubtasks;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setStoryAttachments(Set<Attachment> storyAttachments) {
        this.storyAttachments = storyAttachments;
    }

    public void setSoftwareApplication(SoftwareApplication softwareApplication) {
        this.softwareApplication = softwareApplication;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Story)) return false;
        final Story other = (Story) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (!Objects.equals(this$description, other$description))
            return false;
        final Object this$storySubtasks = this.getStorySubtasks();
        final Object other$storySubtasks = other.getStorySubtasks();
        if (!Objects.equals(this$storySubtasks, other$storySubtasks))
            return false;
        final Object this$priority = this.getPriority();
        final Object other$priority = other.getPriority();
        if (!Objects.equals(this$priority, other$priority)) return false;
        final Object this$storyAttachments = this.getStoryAttachments();
        final Object other$storyAttachments = other.getStoryAttachments();
        if (!Objects.equals(this$storyAttachments, other$storyAttachments))
            return false;
        final Object this$softwareApplication = this.getSoftwareApplication();
        final Object other$softwareApplication = other.getSoftwareApplication();
        if (!Objects.equals(this$softwareApplication, other$softwareApplication))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Story;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
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
        return "Story(id=" + this.getId() + ", description=" + this.getDescription() + ", storySubtasks=" + this.getStorySubtasks() + ", priority=" + this.getPriority() + ", storyAttachments=" + this.getStoryAttachments() + ", softwareApplication=" + this.getSoftwareApplication() + ")";
    }
}

