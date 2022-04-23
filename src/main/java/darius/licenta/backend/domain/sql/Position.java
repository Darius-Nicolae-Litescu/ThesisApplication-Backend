package darius.licenta.backend.domain.sql;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = Position.TABLE_NAME)
public class Position {
    public static final String TABLE_NAME = "position";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 256)
    private String name;

    @Column(name = "seniority_level", nullable = false, length = 256)
    private String seniorityLevel;

    @OneToOne(mappedBy = "position")
    private Employee employee;

    public Position(Long id, String name, String seniorityLevel, Employee employee) {
        this.id = id;
        this.name = name;
        this.seniorityLevel = seniorityLevel;
        this.employee = employee;
    }

    public Position(String name, String seniorityLevel) {
        this.name = name;
        this.seniorityLevel = seniorityLevel;
    }

    public Position() {
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

    public String getSeniorityLevel() {
        return this.seniorityLevel;
    }

    public void setSeniorityLevel(String seniorityLevel) {
        this.seniorityLevel = seniorityLevel;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (!Objects.equals(id, position.id)) return false;
        if (!Objects.equals(name, position.name)) return false;
        return Objects.equals(seniorityLevel, position.seniorityLevel);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (seniorityLevel != null ? seniorityLevel.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", seniorityLevel='" + seniorityLevel + '\'' +
                '}';
    }
}
