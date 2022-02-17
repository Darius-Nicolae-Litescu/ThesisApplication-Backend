package darius.licenta.backend.dto.normal.employee.response;

import java.io.Serializable;

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

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof EmployeeDto)) return false;
        final EmployeeDto other = (EmployeeDto) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$person = this.getPerson();
        final Object other$person = other.getPerson();
        if (this$person == null ? other$person != null : !this$person.equals(other$person)) return false;
        final Object this$position = this.getPosition();
        final Object other$position = other.getPosition();
        if (this$position == null ? other$position != null : !this$position.equals(other$position)) return false;
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof EmployeeDto;
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
        return "EmployeeDto(id=" + this.getId() + ", person=" + this.getPerson() + ", position=" + this.getPosition() + ", user=" + this.getUser() + ")";
    }
}
