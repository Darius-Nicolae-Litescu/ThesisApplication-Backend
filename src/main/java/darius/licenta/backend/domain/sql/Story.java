package darius.licenta.backend.domain.sql;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = Story.TABLE_NAME)
public class Story {
    public static final String TABLE_NAME = "story";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = 512)
    private String title;

    @Column(name = "description", nullable = false, length = 1024)
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date modificationDate;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "story_id", updatable = true, nullable = true)
    private Set<Category> categories;

    @OneToMany(mappedBy = "story", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<StoryTask> storySubtasks;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "priority_id", updatable = true, nullable = true)
    private Priority priority;

    @OneToMany(mappedBy="story", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Comment> comments;

    @OneToMany(mappedBy = "story", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Attachment> storyAttachments;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private SoftwareApplication softwareApplication;

    public Story(Long id, String title, String description, Set<Category> categories, Set<StoryTask> storySubtasks, Priority priority, Set<Comment> comments, Set<Attachment> storyAttachments, SoftwareApplication softwareApplication) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.categories = categories;
        this.storySubtasks = storySubtasks;
        this.priority = priority;
        this.comments = comments;
        this.storyAttachments = storyAttachments;
        this.softwareApplication = softwareApplication;
    }

    public Story(Long id, String description, Set<Category> categories, Set<StoryTask> storySubtasks, Priority priority, Set<Comment> comments, Set<Attachment> storyAttachments, SoftwareApplication softwareApplication) {
        this.id = id;
        this.description = description;
        this.categories = categories;
        this.storySubtasks = storySubtasks;
        this.priority = priority;
        this.comments = comments;
        this.storyAttachments = storyAttachments;
        this.softwareApplication = softwareApplication;
    }

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


    public void addStoryComment(Comment comment)
    {
        this.comments.add(comment);
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public String getTitle() {
        return title;
    }

    public Set<Comment> getComments() {
        return comments;
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

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Story story = (Story) o;

        if (!Objects.equals(id, story.id)) return false;
        if (!Objects.equals(title, story.title)) return false;
        return Objects.equals(description, story.description);
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
        return "Story{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

