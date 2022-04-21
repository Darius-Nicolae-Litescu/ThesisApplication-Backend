package darius.licenta.backend.domain.sql;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = SoftwareApplication.TABLE_NAME)
public class SoftwareApplication {
    public static final String TABLE_NAME = "software_application";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 256)
    private String name;

    @Column(name = "description", nullable = false, length = 512)
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date modificationDate;

    @OneToMany(mappedBy = "softwareApplication", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Story> stories;

    public SoftwareApplication(Long id, String name, String description, Set<Story> stories) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.stories = stories;
    }

    public SoftwareApplication() {
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Story> getStories() {
        return this.stories;
    }

    public void setStories(Set<Story> stories) {
        this.stories = stories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SoftwareApplication that = (SoftwareApplication) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(name, that.name)) return false;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SoftwareApplication{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

