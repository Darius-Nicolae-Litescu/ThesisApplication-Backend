package darius.licenta.backend.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = Employee.TABLE_NAME)
public class Employee {
    public static final String TABLE_NAME = "employee";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Employee)) return false;
        final Employee other = (Employee) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$person = this.getPerson();
        final Object other$person = other.getPerson();
        if (!Objects.equals(this$person, other$person)) return false;
        final Object this$position = this.getPosition();
        final Object other$position = other.getPosition();
        if (!Objects.equals(this$position, other$position)) return false;
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        return Objects.equals(this$user, other$user);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Employee;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final Object $person = this.getPerson();
        result = result * PRIME + ($person == null ? 43 : $person.hashCode());
        final Object $position = this.getPosition();
        result = result * PRIME + ($position == null ? 43 : $position.hashCode());
        final Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        return result;
    }

    public String toString() {
        return "Employee(id=" + this.getId() + ", person=" + this.getPerson() + ", position=" + this.getPosition() + ", user=" + this.getUser() + ")";
    }
}
