package darius.licenta.backend.dto.normal.story.request.update;

import java.io.Serializable;
import java.util.Objects;

public class ChangeStoryTitleAndDescription implements Serializable {
    private final Long id;
    private final String title;
    private final String description;

    public ChangeStoryTitleAndDescription(Long id, String title, String description) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChangeStoryTitleAndDescription that = (ChangeStoryTitleAndDescription) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(title, that.title)) return false;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ChangeStoryTitleAndDescription{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
