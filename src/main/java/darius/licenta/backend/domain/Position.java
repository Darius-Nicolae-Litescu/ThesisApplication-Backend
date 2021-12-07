package darius.licenta.backend.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = Position.TABLE_NAME)
public class Position {
    public static final String TABLE_NAME = "position";

    @Id
    @GeneratedValue()
    private long id;

    @Column(name = "name", nullable = false, length = 256)
    private String name;

    @Column(name = "seniority_level", nullable = false, length = 256)
    private String seniorityLevel;

    @OneToOne(mappedBy = "position")
    private Employee employee;

    public Position(long id, String name, String seniorityLevel, Employee employee) {
        this.id = id;
        this.name = name;
        this.seniorityLevel = seniorityLevel;
        this.employee = employee;
    }

    public Position() {
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getSeniorityLevel() {
        return this.seniorityLevel;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSeniorityLevel(String seniorityLevel) {
        this.seniorityLevel = seniorityLevel;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Position)) return false;
        final Position other = (Position) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (!Objects.equals(this$name, other$name)) return false;
        final Object this$seniorityLevel = this.getSeniorityLevel();
        final Object other$seniorityLevel = other.getSeniorityLevel();
        if (!Objects.equals(this$seniorityLevel, other$seniorityLevel))
            return false;
        final Object this$employee = this.getEmployee();
        final Object other$employee = other.getEmployee();
        if (!Objects.equals(this$employee, other$employee)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Position;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $seniorityLevel = this.getSeniorityLevel();
        result = result * PRIME + ($seniorityLevel == null ? 43 : $seniorityLevel.hashCode());
        final Object $employee = this.getEmployee();
        result = result * PRIME + ($employee == null ? 43 : $employee.hashCode());
        return result;
    }

    public String toString() {
        return "Position(id=" + this.getId() + ", name=" + this.getName() + ", seniorityLevel=" + this.getSeniorityLevel() + ", employee=" + this.getEmployee() + ")";
    }
}
