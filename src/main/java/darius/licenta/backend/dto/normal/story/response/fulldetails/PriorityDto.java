package darius.licenta.backend.dto.normal.story.response.fulldetails;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Objects;

public class PriorityDto implements Serializable {
    private final Long id;
    private final String title;
    private final String description;
    private final int level;
    private final Blob priorityIcon;

    public PriorityDto(Long id, String title, String description, int level, Blob priorityIcon) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.level = level;
        this.priorityIcon = priorityIcon;
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

    public int getLevel() {
        return this.level;
    }

    public Blob getPriorityIcon() {
        return this.priorityIcon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PriorityDto that = (PriorityDto) o;

        if (level != that.level) return false;
        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(title, that.title)) return false;
        if (!Objects.equals(description, that.description)) return false;
        return Objects.equals(priorityIcon, that.priorityIcon);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + level;
        result = 31 * result + (priorityIcon != null ? priorityIcon.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PriorityDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", level=" + level +
                ", priorityIcon=" + priorityIcon +
                '}';
    }
}
