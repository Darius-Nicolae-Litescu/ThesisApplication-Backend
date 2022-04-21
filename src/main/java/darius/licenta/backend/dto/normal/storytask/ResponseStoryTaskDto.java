package darius.licenta.backend.dto.normal.storytask;

import java.io.Serializable;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResponseStoryTaskDto that = (ResponseStoryTaskDto) o;

        if (storyPoints != that.storyPoints) return false;
        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(title, that.title)) return false;
        if (!Objects.equals(description, that.description)) return false;
        return Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + storyPoints;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ResponseStoryTaskDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", storyPoints=" + storyPoints +
                ", status='" + status + '\'' +
                '}';
    }
}
