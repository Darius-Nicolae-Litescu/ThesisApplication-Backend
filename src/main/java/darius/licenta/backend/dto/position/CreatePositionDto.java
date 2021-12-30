package darius.licenta.backend.dto.position;

import java.io.Serializable;

public class CreatePositionDto implements Serializable {
    private String name;
    private String seniorityLevel;

    public CreatePositionDto(String name, String seniorityLevel) {
        this.name = name;
        this.seniorityLevel = seniorityLevel;
    }

    public CreatePositionDto() {
    }

    public String getName() {
        return this.name;
    }

    public String getSeniorityLevel() {
        return this.seniorityLevel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSeniorityLevel(String seniorityLevel) {
        this.seniorityLevel = seniorityLevel;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CreatePositionDto)) return false;
        final CreatePositionDto other = (CreatePositionDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$seniorityLevel = this.getSeniorityLevel();
        final Object other$seniorityLevel = other.getSeniorityLevel();
        if (this$seniorityLevel == null ? other$seniorityLevel != null : !this$seniorityLevel.equals(other$seniorityLevel))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CreatePositionDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $seniorityLevel = this.getSeniorityLevel();
        result = result * PRIME + ($seniorityLevel == null ? 43 : $seniorityLevel.hashCode());
        return result;
    }

    public String toString() {
        return "CreatePositionDto(name=" + this.getName() + ", seniorityLevel=" + this.getSeniorityLevel() + ")";
    }
}
