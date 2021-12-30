package darius.licenta.backend.dto.story;

import java.io.Serializable;
import java.sql.Blob;

public class PriorityDto implements Serializable {
    private long id;
    private String title;
    private String description;
    private int level;
    private Blob priorityIcon;

    public PriorityDto(long id, String title, String description, int level, Blob priorityIcon) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.level = level;
        this.priorityIcon = priorityIcon;
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

    public Blob getPriorityIcon() {
        return this.priorityIcon;
    }

    public void setId(long id) {
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

    public void setPriorityIcon(Blob priorityIcon) {
        this.priorityIcon = priorityIcon;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PriorityDto)) return false;
        final PriorityDto other = (PriorityDto) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        if (this.getLevel() != other.getLevel()) return false;
        final Object this$priorityIcon = this.getPriorityIcon();
        final Object other$priorityIcon = other.getPriorityIcon();
        if (this$priorityIcon == null ? other$priorityIcon != null : !this$priorityIcon.equals(other$priorityIcon))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PriorityDto;
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
        result = result * PRIME + this.getLevel();
        final Object $priorityIcon = this.getPriorityIcon();
        result = result * PRIME + ($priorityIcon == null ? 43 : $priorityIcon.hashCode());
        return result;
    }

    public String toString() {
        return "PriorityDto(id=" + this.getId() + ", title=" + this.getTitle() + ", description=" + this.getDescription() + ", level=" + this.getLevel() + ", priorityIcon=" + this.getPriorityIcon() + ")";
    }
}
