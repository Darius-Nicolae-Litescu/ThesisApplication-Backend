package darius.licenta.backend.dto.softwareapplication;

import java.io.Serializable;

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

    public String getDescription() {
        return this.description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof InsertSoftwareApplicationDto)) return false;
        final InsertSoftwareApplicationDto other = (InsertSoftwareApplicationDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof InsertSoftwareApplicationDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        return result;
    }

    public String toString() {
        return "InsertSoftwareApplicationDto(name=" + this.getName() + ", description=" + this.getDescription() + ")";
    }
}
