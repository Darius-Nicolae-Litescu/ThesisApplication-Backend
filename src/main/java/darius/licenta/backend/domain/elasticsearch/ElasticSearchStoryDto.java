package darius.licenta.backend.domain.elasticsearch;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Objects;

@Document(indexName = "story")
public class ElasticSearchStoryDto implements Serializable {
    private final Long id;
    private final String title;
    private final String description;

    public ElasticSearchStoryDto(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ElasticSearchStoryDto)) return false;
        final ElasticSearchStoryDto other = (ElasticSearchStoryDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (!Objects.equals(this$id, other$id)) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (!Objects.equals(this$title, other$title)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (!Objects.equals(this$description, other$description))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ElasticSearchStoryDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        return result;
    }

    public String toString() {
        return "ElasticSearchStoryDto(id=" + this.getId() + ", title=" + this.getTitle() + ", description=" + this.getDescription() + ")";
    }
}
