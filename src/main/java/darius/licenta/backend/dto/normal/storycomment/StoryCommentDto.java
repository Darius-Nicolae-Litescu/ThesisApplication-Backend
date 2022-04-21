package darius.licenta.backend.dto.normal.storycomment;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class StoryCommentDto implements Serializable {
    private Long id;
    private String content;
    private LocalDateTime postedAt;

    public StoryCommentDto(Long id, String content, LocalDateTime postedAt) {
        this.id = id;
        this.content = content;
        this.postedAt = postedAt;
    }

    public StoryCommentDto() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getPostedAt() {
        return this.postedAt;
    }

    public void setPostedAt(LocalDateTime postedAt) {
        this.postedAt = postedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StoryCommentDto that = (StoryCommentDto) o;

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
        return "StoryCommentDto{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", postedAt=" + postedAt +
                '}';
    }
}
