package darius.licenta.backend.domain.elasticsearch;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Objects;

@Document(indexName = "softwareapplication")
public class ElasticSearchSoftwareApplicationDto implements Serializable {
    private final Long id;
    private final String name;
    private final String description;

    public ElasticSearchSoftwareApplicationDto(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ElasticSearchSoftwareApplicationDto))
            return false;
        final ElasticSearchSoftwareApplicationDto other = (ElasticSearchSoftwareApplicationDto) o;
        if (!other.canEqual(this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (!Objects.equals(this$id, other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (!Objects.equals(this$name, other$name)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        return Objects.equals(this$description, other$description);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ElasticSearchSoftwareApplicationDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        return result;
    }

    public String toString() {
        return "ElasticSearchSoftwareApplicationDto(id=" + this.getId() + ", name=" + this.getName() + ", description=" + this.getDescription() + ")";
    }
}
