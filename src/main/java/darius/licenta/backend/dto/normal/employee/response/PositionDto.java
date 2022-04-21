package darius.licenta.backend.dto.normal.employee.response;

import java.io.Serializable;
import java.util.Objects;

public class PositionDto implements Serializable {
    private String name;
    private String seniorityLevel;

    public PositionDto(String name, String seniorityLevel) {
        this.name = name;
        this.seniorityLevel = seniorityLevel;
    }

    public PositionDto() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PositionDto that = (PositionDto) o;

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
        return "PositionDto{" +
                "name='" + name + '\'' +
                ", seniorityLevel='" + seniorityLevel + '\'' +
                '}';
    }
}
