package darius.licenta.backend.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = StoryTask.TABLE_NAME)
public class StoryTask {
    public static final String TABLE_NAME = "story_task";

    @Id
    @GeneratedValue()
    private long id;

    @Column(name = "title", length = 512)
    private String title;

    @Column(name = "description", length = 512)
    private String description;

    @Column(name = "story_points")
    private int storyPoints;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "created_by")
    private User createdBy;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "assigned_to")
    private User assignedTo;

    @Column(name = "status", nullable = false, length = 512)
    private String status;

    @CreationTimestamp
    @Column(name = "finished_at", nullable = false)
    private LocalDateTime finishedAt;

    @OneToMany(mappedBy="storyTask", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<StoryComment> storyComments;

    @OneToMany(mappedBy="commentAttachment", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Attachment> commentAttachments;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Story story;

    public StoryTask() {
    }

    public long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public int getStoryPoints() {
        return this.storyPoints;
    }

    public User getCreatedBy() {
        return this.createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public User getAssignedTo() {
        return this.assignedTo;
    }

    public String getStatus() {
        return this.status;
    }

    public LocalDateTime getFinishedAt() {
        return this.finishedAt;
    }

    public Set<StoryComment> getStoryComments() {
        return this.storyComments;
    }

    public Set<Attachment> getCommentAttachments() {
        return this.commentAttachments;
    }

    public Story getStory() {
        return this.story;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStoryPoints(int storyPoints) {
        this.storyPoints = storyPoints;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setFinishedAt(LocalDateTime finishedAt) {
        this.finishedAt = finishedAt;
    }

    public void setStoryComments(Set<StoryComment> storyComments) {
        this.storyComments = storyComments;
    }

    public void setCommentAttachments(Set<Attachment> commentAttachments) {
        this.commentAttachments = commentAttachments;
    }

    public void setStory(Story story) {
        this.story = story;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof StoryTask)) return false;
        final StoryTask other = (StoryTask) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        if (this.getStoryPoints() != other.getStoryPoints()) return false;
        final Object this$createdBy = this.getCreatedBy();
        final Object other$createdBy = other.getCreatedBy();
        if (this$createdBy == null ? other$createdBy != null : !this$createdBy.equals(other$createdBy)) return false;
        final Object this$createdAt = this.getCreatedAt();
        final Object other$createdAt = other.getCreatedAt();
        if (this$createdAt == null ? other$createdAt != null : !this$createdAt.equals(other$createdAt)) return false;
        final Object this$assignedTo = this.getAssignedTo();
        final Object other$assignedTo = other.getAssignedTo();
        if (this$assignedTo == null ? other$assignedTo != null : !this$assignedTo.equals(other$assignedTo))
            return false;
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        final Object this$finishedAt = this.getFinishedAt();
        final Object other$finishedAt = other.getFinishedAt();
        if (this$finishedAt == null ? other$finishedAt != null : !this$finishedAt.equals(other$finishedAt))
            return false;
        final Object this$storyComments = this.getStoryComments();
        final Object other$storyComments = other.getStoryComments();
        if (this$storyComments == null ? other$storyComments != null : !this$storyComments.equals(other$storyComments))
            return false;
        final Object this$commentAttachments = this.getCommentAttachments();
        final Object other$commentAttachments = other.getCommentAttachments();
        if (this$commentAttachments == null ? other$commentAttachments != null : !this$commentAttachments.equals(other$commentAttachments))
            return false;
        final Object this$story = this.getStory();
        final Object other$story = other.getStory();
        if (this$story == null ? other$story != null : !this$story.equals(other$story)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof StoryTask;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        result = result * PRIME + this.getStoryPoints();
        final Object $createdBy = this.getCreatedBy();
        result = result * PRIME + ($createdBy == null ? 43 : $createdBy.hashCode());
        final Object $createdAt = this.getCreatedAt();
        result = result * PRIME + ($createdAt == null ? 43 : $createdAt.hashCode());
        final Object $assignedTo = this.getAssignedTo();
        result = result * PRIME + ($assignedTo == null ? 43 : $assignedTo.hashCode());
        final Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        final Object $finishedAt = this.getFinishedAt();
        result = result * PRIME + ($finishedAt == null ? 43 : $finishedAt.hashCode());
        final Object $storyComments = this.getStoryComments();
        result = result * PRIME + ($storyComments == null ? 43 : $storyComments.hashCode());
        final Object $commentAttachments = this.getCommentAttachments();
        result = result * PRIME + ($commentAttachments == null ? 43 : $commentAttachments.hashCode());
        final Object $story = this.getStory();
        result = result * PRIME + ($story == null ? 43 : $story.hashCode());
        return result;
    }

    public String toString() {
        return "StoryTask(id=" + this.getId() + ", title=" + this.getTitle() + ", description=" + this.getDescription() + ", storyPoints=" + this.getStoryPoints() + ", createdBy=" + this.getCreatedBy() + ", createdAt=" + this.getCreatedAt() + ", assignedTo=" + this.getAssignedTo() + ", status=" + this.getStatus() + ", finishedAt=" + this.getFinishedAt() + ", storyComments=" + this.getStoryComments() + ", commentAttachments=" + this.getCommentAttachments() + ", story=" + this.getStory() + ")";
    }
}