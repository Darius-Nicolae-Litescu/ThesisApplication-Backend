package darius.licenta.backend.domain.sql;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = Comment.TABLE_NAME)
public class Comment {
    public static final String TABLE_NAME = "comment";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content", nullable = false, length = 512)
    private String content;

    @Column(name = "posted_at", nullable = false)
    private LocalDateTime postedAt;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date modificationDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Story story;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private StoryTask storyTask;

    @OneToMany(mappedBy= "comment", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Attachment> storyAttachments;

    public Comment(Long id, String content, LocalDateTime postedAt, Story story, StoryTask storyTask, Set<Attachment> storyAttachments) {
        this.id = id;
        this.content = content;
        this.postedAt = postedAt;
        this.story = story;
        this.storyTask = storyTask;
        this.storyAttachments = storyAttachments;
    }

    public Comment(Long id, String content, LocalDateTime postedAt, StoryTask storyTask) {
        this.id = id;
        this.content = content;
        this.postedAt = postedAt;
        this.storyTask = storyTask;
    }

    public Comment() {
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public Story getStory() {
        return story;
    }

    public Set<Attachment> getStoryAttachments() {
        return storyAttachments;
    }

    public Long getId() {
        return this.id;
    }

    public String getContent() {
        return this.content;
    }

    public LocalDateTime getPostedAt() {
        return this.postedAt;
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

    public void setStoryTask(StoryTask storyTask) {
        this.storyTask = storyTask;
    }

    public void setStory(Story story) {
        this.story = story;
    }

    public void setStoryAttachments(Set<Attachment> storyAttachments) {
        this.storyAttachments = storyAttachments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment that = (Comment) o;

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