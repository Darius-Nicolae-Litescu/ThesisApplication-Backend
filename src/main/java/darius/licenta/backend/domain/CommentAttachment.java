package darius.licenta.backend.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = CommentAttachment.TABLE_NAME)
public class CommentAttachment {
    public static final String TABLE_NAME = "comment_attachment";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentAttachment that = (CommentAttachment) o;

        if (!Objects.equals(id, that.id)) return false;
        return Objects.equals(postedAt, that.postedAt);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (postedAt != null ? postedAt.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CommentAttachment{" +
                "id=" + id +
                ", postedAt=" + postedAt +
                '}';
    }
}