package darius.licenta.backend.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = CommentAttachment.TABLE_NAME)
public class CommentAttachment {
    public static final String TABLE_NAME = "comment_attachment";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CreationTimestamp
    @Column(name = "posted_at", nullable = false)
    private LocalDateTime postedAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "story_comment_id", nullable = false)
    private StoryComment storyComment;

    public CommentAttachment(Long id, LocalDateTime postedAt, StoryComment storyComment) {
        this.id = id;
        this.postedAt = postedAt;
        this.storyComment = storyComment;
    }

    public CommentAttachment() {
    }

    public long getId() {
        return this.id;
    }

    public LocalDateTime getPostedAt() {
        return this.postedAt;
    }

    public StoryComment getStoryComment() {
        return this.storyComment;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPostedAt(LocalDateTime postedAt) {
        this.postedAt = postedAt;
    }

    public void setStoryComment(StoryComment storyComment) {
        this.storyComment = storyComment;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CommentAttachment)) return false;
        final CommentAttachment other = (CommentAttachment) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$postedAt = this.getPostedAt();
        final Object other$postedAt = other.getPostedAt();
        if (!Objects.equals(this$postedAt, other$postedAt)) return false;
        final Object this$storyComment = this.getStoryComment();
        final Object other$storyComment = other.getStoryComment();
        return Objects.equals(this$storyComment, other$storyComment);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CommentAttachment;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final Object $postedAt = this.getPostedAt();
        result = result * PRIME + ($postedAt == null ? 43 : $postedAt.hashCode());
        final Object $storyComment = this.getStoryComment();
        result = result * PRIME + ($storyComment == null ? 43 : $storyComment.hashCode());
        return result;
    }

    public String toString() {
        return "CommentAttachment(id=" + this.getId() + ", postedAt=" + this.getPostedAt() + ", storyComment=" + this.getStoryComment() + ")";
    }
}