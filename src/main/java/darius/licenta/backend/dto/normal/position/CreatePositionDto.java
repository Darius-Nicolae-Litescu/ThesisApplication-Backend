package darius.licenta.backend.dto.normal.position;

import java.io.Serializable;
import java.util.Objects;

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

    public void setName(String name) {
        this.name = name;
    }

    public String getSeniorityLevel() {
        return this.seniorityLevel;
    }

    public void setSeniorityLevel(String seniorityLevel) {
        this.seniorityLevel = seniorityLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreatePositionDto that = (CreatePositionDto) o;

        if (!Objects.equals(name, that.name)) return false;
        return Objects.equals(seniorityLevel, that.seniorityLevel);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (seniorityLevel != null ? seniorityLevel.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CreatePositionDto{" +
                "name='" + name + '\'' +
                ", seniorityLevel='" + seniorityLevel + '\'' +
                '}';
    }
}
