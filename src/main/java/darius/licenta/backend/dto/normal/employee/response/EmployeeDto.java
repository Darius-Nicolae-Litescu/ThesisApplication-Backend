package darius.licenta.backend.dto.normal.employee.response;

import java.io.Serializable;
import java.util.Objects;

public class EmployeeDto implements Serializable {
    private Long id;
    private PersonDto person;
    private PositionDto position;
    private UserDto user;

    public EmployeeDto(Long id, PersonDto person, PositionDto position, UserDto user) {
        this.id = id;
        this.person = person;
        this.position = position;
        this.user = user;
    }

    public EmployeeDto(PersonDto person, PositionDto position) {
        this.person = person;
        this.position = position;
    }

    public EmployeeDto() {
    }

    public Long getId() {
        return this.id;
    }

    public PersonDto getPerson() {
        return this.person;
    }

    public PositionDto getPosition() {
        return this.position;
    }

    public UserDto getUser() {
        return this.user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPerson(PersonDto person) {
        this.person = person;
    }

    public void setPosition(PositionDto position) {
        this.position = position;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeDto that = (EmployeeDto) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(person, that.person)) return false;
        if (!Objects.equals(position, that.position)) return false;
        return Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (person != null ? person.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "id=" + id +
                ", person=" + person +
                ", position=" + position +
                ", user=" + user +
                '}';
    }
}
