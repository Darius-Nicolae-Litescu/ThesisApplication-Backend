package darius.licenta.backend.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = Attachment.TABLE_NAME)
public class Attachment {
    public static final String TABLE_NAME = "attachment";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content_type", nullable = false, length = 256)
    private String contentType;

    @Column(name = "content", nullable = false)
    @Lob
    private Blob content;

    @CreationTimestamp
    @Column(name = "uploaded_at", nullable = false)
    private LocalDateTime postedAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User uploadedBy;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private Comment comment;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private StoryTask storyTask;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "story_id", nullable = true, insertable = false, updatable = false)
    private Story story;

    public Attachment(Long id, String contentType, Blob content, LocalDateTime postedAt, User uploadedBy, Comment comment, StoryTask storyTask, Story story) {
        this.id = id;
        this.contentType = contentType;
        this.content = content;
        this.postedAt = postedAt;
        this.uploadedBy = uploadedBy;
        this.comment = comment;
        this.storyTask = storyTask;
        this.story = story;
    }

    public Attachment(Long id, String contentType, Blob content, LocalDateTime postedAt, StoryTask storyTask, Story story) {
        this.id = id;
        this.contentType = contentType;
        this.content = content;
        this.postedAt = postedAt;
        this.storyTask = storyTask;
        this.story = story;
    }

    public Attachment() {
    }

    public User getUploadedBy() {
        return uploadedBy;
    }

    public Comment getStoryComment() {
        return comment;
    }

    public Long getId() {
        return this.id;
    }

    public String getContentType() {
        return this.contentType;
    }

    public Blob getContent() {
        return this.content;
    }

    public LocalDateTime getPostedAt() {
        return this.postedAt;
    }

    public StoryTask getStoryTask() {
        return this.storyTask;
    }

    public Story getStory() {
        return this.story;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setContent(Blob content) {
        this.content = content;
    }

    public void setPostedAt(LocalDateTime postedAt) {
        this.postedAt = postedAt;
    }

    public void setStoryTask(StoryTask storyTask) {
        this.storyTask = storyTask;
    }

    public void setStory(Story story) {
        this.story = story;
    }

    public void setUploadedBy(User uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public void setStoryComment(Comment comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Attachment that = (Attachment) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(contentType, that.contentType)) return false;
        return Objects.equals(postedAt, that.postedAt);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (contentType != null ? contentType.hashCode() : 0);
        result = 31 * result + (postedAt != null ? postedAt.hashCode() : 0);
        return result;
    }
}