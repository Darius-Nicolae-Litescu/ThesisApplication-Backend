package darius.licenta.backend.domain.elasticsearch;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Document(indexName = "storytask")
public class ElasticSearchStoryTaskDto implements Serializable {
    private final Long id;
    private final String title;
    private final String description;
    private final Integer storyPoints;
    private final String createdByUsername;
    private final LocalDateTime createdAt;
    private final String assignedToUsername;
    private final String status;
    private final LocalDateTime finishedAt;
    private final Date modificationDate;

    public ElasticSearchStoryTaskDto(Long id, String title, String description, Integer storyPoints, String createdByUsername, LocalDateTime createdAt, String assignedToUsername, String status, LocalDateTime finishedAt, Date modificationDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.storyPoints = storyPoints;
        this.createdByUsername = createdByUsername;
        this.createdAt = createdAt;
        this.assignedToUsername = assignedToUsername;
        this.status = status;
        this.finishedAt = finishedAt;
        this.modificationDate = modificationDate;
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

    public Integer getStoryPoints() {
        return this.storyPoints;
    }

    public String getCreatedByUsername() {
        return this.createdByUsername;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public String getAssignedToUsername() {
        return this.assignedToUsername;
    }

    public String getStatus() {
        return this.status;
    }

    public LocalDateTime getFinishedAt() {
        return this.finishedAt;
    }

    public Date getModificationDate() {
        return this.modificationDate;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ElasticSearchStoryTaskDto)) return false;
        final ElasticSearchStoryTaskDto other = (ElasticSearchStoryTaskDto) o;
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
        if (this.getStoryPoints() != other.getStoryPoints()) return false;
        final Object this$createdByUsername = this.getCreatedByUsername();
        final Object other$createdByUsername = other.getCreatedByUsername();
        if (!Objects.equals(this$createdByUsername, other$createdByUsername))
            return false;
        final Object this$createdAt = this.getCreatedAt();
        final Object other$createdAt = other.getCreatedAt();
        if (!Objects.equals(this$createdAt, other$createdAt)) return false;
        final Object this$assignedToUsername = this.getAssignedToUsername();
        final Object other$assignedToUsername = other.getAssignedToUsername();
        if (!Objects.equals(this$assignedToUsername, other$assignedToUsername))
            return false;
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        if (!Objects.equals(this$status, other$status)) return false;
        final Object this$finishedAt = this.getFinishedAt();
        final Object other$finishedAt = other.getFinishedAt();
        if (!Objects.equals(this$finishedAt, other$finishedAt))
            return false;
        final Object this$modificationDate = this.getModificationDate();
        final Object other$modificationDate = other.getModificationDate();
        if (!Objects.equals(this$modificationDate, other$modificationDate))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ElasticSearchStoryTaskDto;
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
        result = result * PRIME + this.getStoryPoints();
        final Object $createdByUsername = this.getCreatedByUsername();
        result = result * PRIME + ($createdByUsername == null ? 43 : $createdByUsername.hashCode());
        final Object $createdAt = this.getCreatedAt();
        result = result * PRIME + ($createdAt == null ? 43 : $createdAt.hashCode());
        final Object $assignedToUsername = this.getAssignedToUsername();
        result = result * PRIME + ($assignedToUsername == null ? 43 : $assignedToUsername.hashCode());
        final Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        final Object $finishedAt = this.getFinishedAt();
        result = result * PRIME + ($finishedAt == null ? 43 : $finishedAt.hashCode());
        final Object $modificationDate = this.getModificationDate();
        result = result * PRIME + ($modificationDate == null ? 43 : $modificationDate.hashCode());
        return result;
    }

    public String toString() {
        return "ElasticSearchStoryTaskDto(id=" + this.getId() + ", title=" + this.getTitle() + ", description=" + this.getDescription() + ", storyPoints=" + this.getStoryPoints() + ", createdByUsername=" + this.getCreatedByUsername() + ", createdAt=" + this.getCreatedAt() + ", assignedToUsername=" + this.getAssignedToUsername() + ", status=" + this.getStatus() + ", finishedAt=" + this.getFinishedAt() + ", modificationDate=" + this.getModificationDate() + ")";
    }
}
