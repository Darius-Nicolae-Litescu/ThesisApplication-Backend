package darius.licenta.backend.dto.normal.priority;

import java.io.Serializable;
import java.util.Objects;

public class InsertPriorityDto implements Serializable {
    private final String title;
    private final String description;
    private final int level;

    public InsertPriorityDto(String title, String description, int level) {
        this.title = title;
        this.description = description;
        this.level = level;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InsertPriorityDto that = (InsertPriorityDto) o;

        if (level != that.level) return false;
        if (!Objects.equals(title, that.title)) return false;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + level;
        return result;
    }

    @Override
    public String toString() {
        return "InsertPriorityDto{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", level=" + level +
                '}';
    }
}
