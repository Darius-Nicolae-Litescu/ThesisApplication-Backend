package darius.licenta.backend.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = Story.TABLE_NAME)
public class Story {
    public static final String TABLE_NAME = "story";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", nullable = false, length = 512)
    private String description;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "story_id", updatable = true, nullable = true)
    private Set<Category> categories;

    @OneToMany(mappedBy = "story", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<StoryTask> storySubtasks;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "priority_id", updatable = true, nullable = true)
    private Priority priority;

    @OneToMany(mappedBy = "story", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Attachment> storyAttachments;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private SoftwareApplication softwareApplication;

    @PersistenceConstructor
    public Story(Long id, String description, Set<Category> categories, Set<StoryTask> storySubtasks, Priority priority, Set<Attachment> storyAttachments, SoftwareApplication softwareApplication) {
        this.id = id;
        this.description = description;
        this.categories = categories;
        this.storySubtasks = storySubtasks;
        this.priority = priority;
        this.storyAttachments = storyAttachments;
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

        if (!Objects.equals(id, story.id)) return false;
        return Objects.equals(description, story.description);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Story{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}

