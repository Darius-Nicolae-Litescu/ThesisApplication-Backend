package darius.licenta.backend.domain.sql;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Objects;

@Entity
@Table(name = Priority.TABLE_NAME)
public class Priority {
    public static final String TABLE_NAME = "priority";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = 256)
    private String title;

    @Column(name = "description", nullable = false, length = 256)
    private String description;

    @Column(name = "level", nullable = false, length = 256)
    private int level;

    @Column(name = "priority_icon", nullable = true)
    @Lob
    private Blob priorityIcon;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="story_id", nullable=true, insertable=false, updatable=false)
    private Story story;

    public Priority() {
    }

    public Priority(Long id, String title, String description, int level) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.level = level;
    }

    public Priority(Long id, String title, String description, int level, Blob priorityIcon) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.level = level;
        this.priorityIcon = priorityIcon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Blob getPriorityIcon() {
        return priorityIcon;
    }

    public void setPriorityIcon(Blob priorityIcon) {
        this.priorityIcon = priorityIcon;
    }

    public Story getStory() {
        return story;
    }

    public void setStory(Story story) {
        this.story = story;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Priority priority = (Priority) o;

        if (level != priority.level) return false;
        if (!Objects.equals(id, priority.id)) return false;
        if (!Objects.equals(title, priority.title)) return false;
        return Objects.equals(description, priority.description);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + level;
        return result;
    }

    @Override
    public String toString() {
        return "Priority{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", level=" + level +
                '}';
    }
}
