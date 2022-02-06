package darius.licenta.backend.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = Employee.TABLE_NAME)
public class Employee {
    public static final String TABLE_NAME = "employee";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "person_id")
    private Person person;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "position_id")
    private Position position;

    @OneToOne(mappedBy = "employee")
    private User user;

    public Employee(Long id, Person person, Position position, User user) {
        this.id = id;
        this.person = person;
        this.position = position;
        this.user = user;
    }

    public Employee(Person person, Position position) {
        this.person = person;
        this.position = position;
    }

    public Employee() {
    }

    public long getId() {
        return this.id;
    }

    public Person getPerson() {
        return this.person;
    }

    public Position getPosition() {
        return this.position;
    }

    public User getUser() {
        return this.user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                '}';
    }
}
