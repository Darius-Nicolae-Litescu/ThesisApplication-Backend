package darius.licenta.backend.dto.normal.person;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class PersonDto implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    public PersonDto(Long id, String firstName, String lastName, Date birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public PersonDto(String firstName, String lastName, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public PersonDto() {
    }

    public Long getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonDto personDto = (PersonDto) o;

        if (!Objects.equals(id, personDto.id)) return false;
        if (!Objects.equals(firstName, personDto.firstName)) return false;
        if (!Objects.equals(lastName, personDto.lastName)) return false;
        return Objects.equals(birthDate, personDto.birthDate);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
