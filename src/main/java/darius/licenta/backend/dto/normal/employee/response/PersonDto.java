package darius.licenta.backend.dto.normal.employee.response;

import java.io.Serializable;

public class PersonDto implements Serializable {
    private String firstName;
    private String lastName;

    public PersonDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public PersonDto() {
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PersonDto)) return false;
        final PersonDto other = (PersonDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$firstName = this.getFirstName();
        final Object other$firstName = other.getFirstName();
        if (this$firstName == null ? other$firstName != null : !this$firstName.equals(other$firstName)) return false;
        final Object this$lastName = this.getLastName();
        final Object other$lastName = other.getLastName();
        if (this$lastName == null ? other$lastName != null : !this$lastName.equals(other$lastName)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PersonDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $firstName = this.getFirstName();
        result = result * PRIME + ($firstName == null ? 43 : $firstName.hashCode());
        final Object $lastName = this.getLastName();
        result = result * PRIME + ($lastName == null ? 43 : $lastName.hashCode());
        return result;
    }

    public String toString() {
        return "PersonDto(firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ")";
    }
}
