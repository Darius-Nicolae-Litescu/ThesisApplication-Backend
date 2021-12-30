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
    @GeneratedValue()
    private long id;

    @Column(name = "content_type", nullable = false, length = 256)
    private String contentType;

    @Column(name = "content", nullable = false)
    @Lob
    private Blob content;

    @CreationTimestamp
    @Column(name = "uploaded_at", nullable = false)
    private LocalDateTime postedAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private CommentAttachment commentAttachment;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private StoryTask storyTask;

    @OneToOne(fetch = FetchType.LAZY, optional = true)
    private Story story;

    public Attachment(long id, String contentType, Blob content, LocalDateTime postedAt, CommentAttachment commentAttachment, StoryTask storyTask, Story story) {
        this.id = id;
        this.contentType = contentType;
        this.content = content;
        this.postedAt = postedAt;
        this.commentAttachment = commentAttachment;
        this.storyTask = storyTask;
        this.story = story;
    }

    public Attachment() {
    }

    public long getId() {
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

    public CommentAttachment getCommentAttachment() {
        return this.commentAttachment;
    }

    public StoryTask getStoryTask() {
        return this.storyTask;
    }

    public Story getStory() {
        return this.story;
    }

    public void setId(long id) {
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

    public void setCommentAttachment(CommentAttachment commentAttachment) {
        this.commentAttachment = commentAttachment;
    }

    public void setStoryTask(StoryTask storyTask) {
        this.storyTask = storyTask;
    }

    public void setStory(Story story) {
        this.story = story;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Attachment)) return false;
        final Attachment other = (Attachment) o;
        if (!other.canEqual(this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$contentType = this.getContentType();
        final Object other$contentType = other.getContentType();
        if (!Objects.equals(this$contentType, other$contentType))
            return false;
        final Object this$content = this.getContent();
        final Object other$content = other.getContent();
        if (!Objects.equals(this$content, other$content)) return false;
        final Object this$postedAt = this.getPostedAt();
        final Object other$postedAt = other.getPostedAt();
        if (!Objects.equals(this$postedAt, other$postedAt)) return false;
        final Object this$commentAttachment = this.getCommentAttachment();
        final Object other$commentAttachment = other.getCommentAttachment();
        if (!Objects.equals(this$commentAttachment, other$commentAttachment))
            return false;
        final Object this$storyTask = this.getStoryTask();
        final Object other$storyTask = other.getStoryTask();
        if (!Objects.equals(this$storyTask, other$storyTask)) return false;
        final Object this$story = this.getStory();
        final Object other$story = other.getStory();
        return Objects.equals(this$story, other$story);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Attachment;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final Object $contentType = this.getContentType();
        result = result * PRIME + ($contentType == null ? 43 : $contentType.hashCode());
        final Object $content = this.getContent();
        result = result * PRIME + ($content == null ? 43 : $content.hashCode());
        final Object $postedAt = this.getPostedAt();
        result = result * PRIME + ($postedAt == null ? 43 : $postedAt.hashCode());
        final Object $commentAttachment = this.getCommentAttachment();
        result = result * PRIME + ($commentAttachment == null ? 43 : $commentAttachment.hashCode());
        final Object $storyTask = this.getStoryTask();
        result = result * PRIME + ($storyTask == null ? 43 : $storyTask.hashCode());
        final Object $story = this.getStory();
        result = result * PRIME + ($story == null ? 43 : $story.hashCode());
        return result;
    }

    public String toString() {
        return "Attachment(id=" + this.getId() + ", contentType=" + this.getContentType() + ", content=" + this.getContent() + ", postedAt=" + this.getPostedAt() + ", commentAttachment=" + this.getCommentAttachment() + ", storyTask=" + this.getStoryTask() + ", story=" + this.getStory() + ")";
    }
}