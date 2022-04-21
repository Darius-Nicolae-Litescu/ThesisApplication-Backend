package darius.licenta.backend.dto.normal.softwareapplication;

import java.io.Serializable;
import java.util.Objects;

public class SoftwareApplicationDto implements Serializable {
    private long id;
    private String name;
    private String description;

    public SoftwareApplicationDto(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public SoftwareApplicationDto() {
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

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SoftwareApplicationDto that = (SoftwareApplicationDto) o;

        if (id != that.id) return false;
        if (!Objects.equals(name, that.name)) return false;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SoftwareApplicationDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
