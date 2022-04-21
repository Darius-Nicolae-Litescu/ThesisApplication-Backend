package darius.licenta.backend.dto.normal.story.response.fulldetails;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class SoftwareApplicationDto implements Serializable {
    private final Long id;
    private final String name;
    private final String description;
    private final Date modificationDate;

    public SoftwareApplicationDto(Long id, String name, String description, Date modificationDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.modificationDate = modificationDate;
    }


    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public Date getModificationDate() {
        return this.modificationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SoftwareApplicationDto that = (SoftwareApplicationDto) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(description, that.description)) return false;
        return Objects.equals(modificationDate, that.modificationDate);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (modificationDate != null ? modificationDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SoftwareApplicationDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", modificationDate=" + modificationDate +
                '}';
    }
}
