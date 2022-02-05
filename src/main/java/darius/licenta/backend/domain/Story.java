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
    private Long id;

    @Column(name = "description", nullable = false, length = 512)
    private String description;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "categories", nullable = false, updatable=false, insertable=false)
    private Set<Category> categories;

    @OneToMany(mappedBy = "story", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<StoryTask> storySubtasks;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "priority_id", nullable = false, updatable=false, insertable=false)
    private Priority priority;

    @OneToMany(mappedBy = "story", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Attachment> storyAttachments;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private SoftwareApplication softwareApplication;

    public Story(Long id, String description, Set<Category> categories, Set<StoryTask> storySubtasks, Priority priority, SoftwareApplication softwareApplication) {
        this.id = id;
        this.description = description;
        this.categories = categories;
        this.storySubtasks = storySubtasks;
        this.priority = priority;
        this.softwareApplication = softwareApplication;
    }

    public Story() {
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public Long getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public Set<StoryTask> getStorySubtasks() {
        return this.storySubtasks;
    }

    public Priority getPriority() {
        return priority;
    }

    public Set<Attachment> getStoryAttachments() {
        return this.storyAttachments;
    }

    public SoftwareApplication getSoftwareApplication() {
        return this.softwareApplication;
    }

    public void setId(Long id) {
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

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Story story = (Story) o;

        if (id != story.id) return false;
        if (description != null ? !description.equals(story.description) : story.description != null) return false;
        if (categories != null ? !categories.equals(story.categories) : story.categories != null) return false;
        if (storySubtasks != null ? !storySubtasks.equals(story.storySubtasks) : story.storySubtasks != null)
            return false;
        if (priority != null ? !priority.equals(story.priority) : story.priority != null) return false;
        if (storyAttachments != null ? !storyAttachments.equals(story.storyAttachments) : story.storyAttachments != null)
            return false;
        return softwareApplication != null ? softwareApplication.equals(story.softwareApplication) : story.softwareApplication == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (categories != null ? categories.hashCode() : 0);
        result = 31 * result + (storySubtasks != null ? storySubtasks.hashCode() : 0);
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        result = 31 * result + (storyAttachments != null ? storyAttachments.hashCode() : 0);
        result = 31 * result + (softwareApplication != null ? softwareApplication.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Story{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", categories=" + categories +
                ", storySubtasks=" + storySubtasks +
                ", priority=" + priority +
                ", storyAttachments=" + storyAttachments +
                ", softwareApplication=" + softwareApplication +
                '}';
    }
}

