package darius.licenta.backend.dto.normal.softwareapplication;

import java.io.Serializable;
import java.util.Objects;

public class InsertSoftwareApplicationDto implements Serializable {
    private String name;
    private String description;

    public InsertSoftwareApplicationDto(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public InsertSoftwareApplicationDto() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InsertSoftwareApplicationDto that = (InsertSoftwareApplicationDto) o;

        if (!Objects.equals(name, that.name)) return false;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "InsertSoftwareApplicationDto{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
