package darius.licenta.backend.dto.storytask;

import java.io.Serializable;

public class ResponseStoryTaskDto implements Serializable {
    private final Long id;
    private final String title;
    private final String description;
    private final int storyPoints;
    private final String status;

    public ResponseStoryTaskDto(Long id, String title, String description, int storyPoints, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.storyPoints = storyPoints;
        this.status = status;
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

    public int getStoryPoints() {
        return this.storyPoints;
    }

    public String getStatus() {
        return this.status;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ResponseStoryTaskDto)) return false;
        final ResponseStoryTaskDto other = (ResponseStoryTaskDto) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        if (this.getStoryPoints() != other.getStoryPoints()) return false;
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ResponseStoryTaskDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        result = result * PRIME + this.getStoryPoints();
        final Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        return result;
    }

    public String toString() {
        return "ResponseStoryTaskDto(id=" + this.getId() + ", title=" + this.getTitle() + ", description=" + this.getDescription() + ", storyPoints=" + this.getStoryPoints() + ", status=" + this.getStatus() + ")";
    }
}
