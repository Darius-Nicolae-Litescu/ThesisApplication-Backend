package darius.licenta.backend.domain.elasticsearch;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Document(indexName = "comment")
public class ElasticSearchCommentDto implements Serializable {
    private final Long id;
    private final String content;
    private final String postedByUsername;
    private final String postedByEmail;
    private final LocalDateTime postedAt;

    public ElasticSearchCommentDto(Long id, String content, String postedByUsername, String postedByEmail, LocalDateTime postedAt) {
        this.id = id;
        this.content = content;
        this.postedByUsername = postedByUsername;
        this.postedByEmail = postedByEmail;
        this.postedAt = postedAt;
    }


    public Long getId() {
        return this.id;
    }

    public String getContent() {
        return this.content;
    }

    public String getPostedByUsername() {
        return this.postedByUsername;
    }

    public String getPostedByEmail() {
        return this.postedByEmail;
    }

    public LocalDateTime getPostedAt() {
        return this.postedAt;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ElasticSearchCommentDto)) return false;
        final ElasticSearchCommentDto other = (ElasticSearchCommentDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (!Objects.equals(this$id, other$id)) return false;
        final Object this$content = this.getContent();
        final Object other$content = other.getContent();
        if (!Objects.equals(this$content, other$content)) return false;
        final Object this$postedByUsername = this.getPostedByUsername();
        final Object other$postedByUsername = other.getPostedByUsername();
        if (!Objects.equals(this$postedByUsername, other$postedByUsername))
            return false;
        final Object this$postedByEmail = this.getPostedByEmail();
        final Object other$postedByEmail = other.getPostedByEmail();
        if (!Objects.equals(this$postedByEmail, other$postedByEmail))
            return false;
        final Object this$postedAt = this.getPostedAt();
        final Object other$postedAt = other.getPostedAt();
        if (!Objects.equals(this$postedAt, other$postedAt)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ElasticSearchCommentDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $content = this.getContent();
        result = result * PRIME + ($content == null ? 43 : $content.hashCode());
        final Object $postedByUsername = this.getPostedByUsername();
        result = result * PRIME + ($postedByUsername == null ? 43 : $postedByUsername.hashCode());
        final Object $postedByEmail = this.getPostedByEmail();
        result = result * PRIME + ($postedByEmail == null ? 43 : $postedByEmail.hashCode());
        final Object $postedAt = this.getPostedAt();
        result = result * PRIME + ($postedAt == null ? 43 : $postedAt.hashCode());
        return result;
    }

    public String toString() {
        return "ElasticSearchCommentDto(id=" + this.getId() + ", content=" + this.getContent() + ", postedByUsername=" + this.getPostedByUsername() + ", postedByEmail=" + this.getPostedByEmail() + ", postedAt=" + this.getPostedAt() + ")";
    }
}
