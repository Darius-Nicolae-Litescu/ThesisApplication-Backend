package darius.licenta.backend.domain.sql;

import darius.licenta.backend.domain.sql.kanban.Card;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
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

    @Column(name = "description", nullable = false, length = 10000)
    private String description;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User createdBy;

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

    @OrderBy("id ASC")
    @OneToMany(mappedBy = "story", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToMany(mappedBy = "story", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Attachment> storyAttachments;

    @OneToMany(mappedBy = "story", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Card> cards;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private SoftwareApplication softwareApplication;

    @Formula("(SELECT case when count(storytask.id) = sum(case when storytask.finished_at is null then 0 else 1 end)" +
            " then 1 else 0 end FROM story as story INNER JOIN story_task as storytask" +
            " ON story.id = storytask.story_id where story.id = id)")
    private Boolean isFinished;

    @Formula("(SELECT SUM(storytask.story_points) FROM story as story INNER JOIN story_task as storytask" +
            " ON story.id = storytask.story_id where story.id = id)")
    private Long totalStoryPoints;

    public Story(Long id, String title, String description, LocalDateTime createdAt, User createdBy, Date modificationDate, Set<Category> categories, Set<StoryTask> storySubtasks, Priority priority, List<Comment> comments, Set<Attachment> storyAttachments, Set<Card> cards, SoftwareApplication softwareApplication, Boolean isFinished, Long totalStoryPoints) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.modificationDate = modificationDate;
        this.categories = categories;
        this.storySubtasks = storySubtasks;
        this.priority = priority;
        this.comments = comments;
        this.storyAttachments = storyAttachments;
        this.cards = cards;
        this.softwareApplication = softwareApplication;
        this.isFinished = isFinished;
        this.totalStoryPoints = totalStoryPoints;
    }

    public Story() {
    }

    public void addStoryComment(Comment comment) {
        this.comments.add(comment);
    }

    public Long getTotalStoryPoints() {
        return totalStoryPoints;
    }

    public void setTotalStoryPoints(Long totalStoryPoints) {
        this.totalStoryPoints = totalStoryPoints;
    }

    public Boolean getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(Boolean finished) {
        isFinished = finished;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<StoryTask> getStorySubtasks() {
        return this.storySubtasks;
    }

    public void setStorySubtasks(Set<StoryTask> storySubtasks) {
        this.storySubtasks = storySubtasks;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Set<Attachment> getStoryAttachments() {
        return this.storyAttachments;
    }

    public void setStoryAttachments(Set<Attachment> storyAttachments) {
        this.storyAttachments = storyAttachments;
    }

    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }

    public SoftwareApplication getSoftwareApplication() {
        return this.softwareApplication;
    }

    public void setSoftwareApplication(SoftwareApplication softwareApplication) {
        this.softwareApplication = softwareApplication;
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

