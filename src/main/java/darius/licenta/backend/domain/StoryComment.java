package darius.licenta.backend.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = StoryComment.TABLE_NAME)
public class StoryComment {
    public static final String TABLE_NAME = "story_comment";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "content", nullable = false, length = 512)
    private String content;

    @Column(name = "posted_at", nullable = false)
    private LocalDateTime postedAt;

    @OneToMany(mappedBy="storyComment", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<CommentAttachment> commentAttachments;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private StoryTask storyTask;

    public StoryComment(Long id, String content, LocalDateTime postedAt, Set<CommentAttachment> commentAttachments, StoryTask storyTask) {
        this.id = id;
        this.content = content;
        this.postedAt = postedAt;
        this.commentAttachments = commentAttachments;
        this.storyTask = storyTask;
    }

    public StoryComment() {
    }

    public long getId() {
        return this.id;
    }

    public String getContent() {
        return this.content;
    }

    public LocalDateTime getPostedAt() {
        return this.postedAt;
    }

    public Set<CommentAttachment> getCommentAttachments() {
        return this.commentAttachments;
    }

    public StoryTask getStoryTask() {
        return this.storyTask;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPostedAt(LocalDateTime postedAt) {
        this.postedAt = postedAt;
    }

    public void setCommentAttachments(Set<CommentAttachment> commentAttachments) {
        this.commentAttachments = commentAttachments;
    }

    public void setStoryTask(StoryTask storyTask) {
        this.storyTask = storyTask;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof StoryComment)) return false;
        final StoryComment other = (StoryComment) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$content = this.getContent();
        final Object other$content = other.getContent();
        if (!Objects.equals(this$content, other$content)) return false;
        final Object this$postedAt = this.getPostedAt();
        final Object other$postedAt = other.getPostedAt();
        if (!Objects.equals(this$postedAt, other$postedAt)) return false;
        final Object this$commentAttachments = this.getCommentAttachments();
        final Object other$commentAttachments = other.getCommentAttachments();
        if (!Objects.equals(this$commentAttachments, other$commentAttachments))
            return false;
        final Object this$storyTask = this.getStoryTask();
        final Object other$storyTask = other.getStoryTask();
        if (!Objects.equals(this$storyTask, other$storyTask)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof StoryComment;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final Object $content = this.getContent();
        result = result * PRIME + ($content == null ? 43 : $content.hashCode());
        final Object $postedAt = this.getPostedAt();
        result = result * PRIME + ($postedAt == null ? 43 : $postedAt.hashCode());
        final Object $commentAttachments = this.getCommentAttachments();
        result = result * PRIME + ($commentAttachments == null ? 43 : $commentAttachments.hashCode());
        final Object $storyTask = this.getStoryTask();
        result = result * PRIME + ($storyTask == null ? 43 : $storyTask.hashCode());
        return result;
    }

    public String toString() {
        return "StoryComment(id=" + this.getId() + ", content=" + this.getContent() + ", postedAt=" + this.getPostedAt() + ", commentAttachments=" + this.getCommentAttachments() + ", storyTask=" + this.getStoryTask() + ")";
    }
}