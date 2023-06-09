package darius.licenta.backend.domain.sql;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = StoryTask.TABLE_NAME)
public class StoryTask {
    public static final String TABLE_NAME = "story_task";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = 512)
    private String title;

    @Column(name = "description", nullable = false, length = 10000)
    private String description;

    @Column(name = "story_points")
    private int storyPoints;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User createdBy;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "assigned_to")
    private User assignedTo;

    @Column(name = "status", nullable = false, length = 512)
    private String status;

    @Column(name = "finished_at", nullable = true)
    private LocalDateTime finishedAt;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date modificationDate;

    @OrderBy("id ASC")
    @OneToMany(mappedBy = "storyTask", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToMany(mappedBy = "storyTask", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Attachment> commentAttachments;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Story story;

    public StoryTask(Long id, String title, String description, int storyPoints, User createdBy, LocalDateTime createdAt, User assignedTo, String status, LocalDateTime finishedAt, List<Comment> comments, Set<Attachment> commentAttachments, Story story) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.storyPoints = storyPoints;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.assignedTo = assignedTo;
        this.status = status;
        this.finishedAt = finishedAt;
        this.comments = comments;
        this.commentAttachments = commentAttachments;
        this.story = story;
    }

    public StoryTask() {
    }

    public void addStoryTaskComment(Comment comment) {
        this.comments.add(comment);
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStoryPoints() {
        return this.storyPoints;
    }

    public void setStoryPoints(int storyPoints) {
        this.storyPoints = storyPoints;
    }

    public User getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public User getAssignedTo() {
        return this.assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getFinishedAt() {
        return this.finishedAt;
    }

    public void setFinishedAt(LocalDateTime finishedAt) {
        this.finishedAt = finishedAt;
    }

    public List<Comment> getStoryComments() {
        return this.comments;
    }

    public void setStoryComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Set<Attachment> getCommentAttachments() {
        return this.commentAttachments;
    }

    public void setCommentAttachments(Set<Attachment> commentAttachments) {
        this.commentAttachments = commentAttachments;
    }

    public Story getStory() {
        return this.story;
    }

    public void setStory(Story story) {
        this.story = story;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StoryTask storyTask = (StoryTask) o;

        if (storyPoints != storyTask.storyPoints) return false;
        if (!Objects.equals(id, storyTask.id)) return false;
        if (!Objects.equals(title, storyTask.title)) return false;
        if (!Objects.equals(description, storyTask.description))
            return false;
        if (!Objects.equals(createdAt, storyTask.createdAt)) return false;
        if (!Objects.equals(status, storyTask.status)) return false;
        return Objects.equals(finishedAt, storyTask.finishedAt);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + storyPoints;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (finishedAt != null ? finishedAt.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StoryTask{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", storyPoints=" + storyPoints +
                ", createdAt=" + createdAt +
                ", finishedAt=" + finishedAt +
                '}';
    }
}