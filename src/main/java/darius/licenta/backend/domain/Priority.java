package darius.licenta.backend.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = Priority.TABLE_NAME)
public class Priority {
    public static final String TABLE_NAME = "priority";

    @Id
    @GeneratedValue()
    private long id;

    @Column(name = "title", nullable = false, length = 256)
    private String title;

    @Column(name = "description", nullable = false, length = 256)
    private String description;

    @Column(name = "level", nullable = false, length = 256)
    private int level;

    @OneToOne(mappedBy = "priorityIcon")
    private Attachment priorityIcon;

    @OneToOne(mappedBy = "priority")
    private Story story;

    public Priority(long id, String title, String description, int level, Attachment priorityIcon, Story story) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.level = level;
        this.priorityIcon = priorityIcon;
        this.story = story;
    }

    public Priority() {
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

    public Attachment getPriorityIcon() {
        return this.priorityIcon;
    }

    public Story getStory() {
        return this.story;
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

    public void setPriorityIcon(Attachment priorityIcon) {
        this.priorityIcon = priorityIcon;
    }

    public void setStory(Story story) {
        this.story = story;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Priority)) return false;
        final Priority other = (Priority) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
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
        final Object this$story = this.getStory();
        final Object other$story = other.getStory();
        if (!Objects.equals(this$story, other$story)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Priority;
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
        final Object $story = this.getStory();
        result = result * PRIME + ($story == null ? 43 : $story.hashCode());
        return result;
    }

    public String toString() {
        return "Priority(id=" + this.getId() + ", title=" + this.getTitle() + ", description=" + this.getDescription() + ", level=" + this.getLevel() + ", priorityIcon=" + this.getPriorityIcon() + ", story=" + this.getStory() + ")";
    }
}
