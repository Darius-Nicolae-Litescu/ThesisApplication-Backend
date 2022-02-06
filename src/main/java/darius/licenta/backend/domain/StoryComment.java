package darius.licenta.backend.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = StoryComment.TABLE_NAME)
public class StoryComment {
    public static final String TABLE_NAME = "story_comment";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StoryComment that = (StoryComment) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(content, that.content)) return false;
        return Objects.equals(postedAt, that.postedAt);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (postedAt != null ? postedAt.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StoryComment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", postedAt=" + postedAt +
                '}';
    }
}