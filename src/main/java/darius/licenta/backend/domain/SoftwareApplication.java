package darius.licenta.backend.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = SoftwareApplication.TABLE_NAME)
public class SoftwareApplication {
    public static final String TABLE_NAME = "software_application";

    @Id
    @GeneratedValue()
    private long id;

    @Column(name = "name", nullable = false, length = 256)
    private String name;

    @Column(name = "description", nullable = false, length = 512)
    private String description;

    @OneToMany(mappedBy="softwareApplication", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Story> stories;

    public SoftwareApplication(long id, String name, String description, Set<Story> stories) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.stories = stories;
    }

    public SoftwareApplication() {
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public Set<Story> getStories() {
        return this.stories;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStories(Set<Story> stories) {
        this.stories = stories;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof SoftwareApplication)) return false;
        final SoftwareApplication other = (SoftwareApplication) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        final Object this$stories = this.getStories();
        final Object other$stories = other.getStories();
        if (this$stories == null ? other$stories != null : !this$stories.equals(other$stories)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof SoftwareApplication;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $stories = this.getStories();
        result = result * PRIME + ($stories == null ? 43 : $stories.hashCode());
        return result;
    }

    public String toString() {
        return "SoftwareApplication(id=" + this.getId() + ", name=" + this.getName() + ", description=" + this.getDescription() + ", stories=" + this.getStories() + ")";
    }
}

