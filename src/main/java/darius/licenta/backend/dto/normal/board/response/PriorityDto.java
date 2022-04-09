package darius.licenta.backend.dto.normal.board.response;

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

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PriorityDto)) return false;
        final PriorityDto other = (PriorityDto) o;
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
        if (this.getLevel() != other.getLevel()) return false;
        final Object this$priorityIcon = this.getPriorityIcon();
        final Object other$priorityIcon = other.getPriorityIcon();
        if (!Objects.equals(this$priorityIcon, other$priorityIcon))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PriorityDto;
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
        result = result * PRIME + this.getLevel();
        final Object $priorityIcon = this.getPriorityIcon();
        result = result * PRIME + ($priorityIcon == null ? 43 : $priorityIcon.hashCode());
        return result;
    }

    public String toString() {
        return "PriorityDto(id=" + this.getId() + ", title=" + this.getTitle() + ", description=" + this.getDescription() + ", level=" + this.getLevel() + ", priorityIcon=" + this.getPriorityIcon() + ")";
    }
}
