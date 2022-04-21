package darius.licenta.backend.dto.normal.priority;

import java.io.Serializable;
import java.util.Objects;

public class PriorityDto implements Serializable {
    private long id;
    private String title;
    private String description;
    private int level;

    public PriorityDto(Long id, String title, String description, int level) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.level = level;
    }

    public PriorityDto() {
    }

    public long getId() {
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PriorityDto that = (PriorityDto) o;

        if (id != that.id) return false;
        if (level != that.level) return false;
        if (!Objects.equals(title, that.title)) return false;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + level;
        return result;
    }

    @Override
    public String toString() {
        return "PriorityDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", level=" + level +
                '}';
    }
}
