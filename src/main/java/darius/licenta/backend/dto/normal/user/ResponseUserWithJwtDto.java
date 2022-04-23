package darius.licenta.backend.dto.normal.user;

import darius.licenta.backend.domain.sql.UserRole;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class ResponseUserWithJwtDto implements Serializable {
    private final Long id;
    private final String username;
    private final String email;
    private final String jwtToken;
    private final String bioDescription;
    private final List<UserRole> roles;
    private final String firstName;
    private final String lastName;
    private final String positionName;
    private final String positionSeniority;

    public ResponseUserWithJwtDto(ResponseUserDto responseUserDto, String jwtToken, List<UserRole> roles, String firstName, String lastName, String positionName, String positionSeniority) {
        this.id = responseUserDto.getId();
        this.username = responseUserDto.getUsername();
        this.email = responseUserDto.getEmail();
        this.bioDescription = responseUserDto.getBioDescription();
        this.jwtToken = jwtToken;
        this.roles = roles;
        this.firstName = firstName;
        this.lastName = lastName;
        this.positionName = positionName;
        this.positionSeniority = positionSeniority;
    }

    public ResponseUserWithJwtDto(ResponseUserDto responseUserDto, String jwtToken, List<UserRole> roles) {
        this.id = responseUserDto.getId();
        this.username = responseUserDto.getUsername();
        this.email = responseUserDto.getEmail();
        this.bioDescription = responseUserDto.getBioDescription();
        this.jwtToken = jwtToken;
        this.roles = roles;
        this.firstName = null;
        this.lastName = null;
        this.positionName = null;
        this.positionSeniority = null;
    }

    public String getBioDescription() {
        return bioDescription;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPositionName() {
        return positionName;
    }

    public String getPositionSeniority() {
        return positionSeniority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResponseUserWithJwtDto that = (ResponseUserWithJwtDto) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(username, that.username)) return false;
        if (!Objects.equals(email, that.email)) return false;
        if (!Objects.equals(jwtToken, that.jwtToken)) return false;
        if (!Objects.equals(roles, that.roles)) return false;
        if (!Objects.equals(firstName, that.firstName)) return false;
        if (!Objects.equals(lastName, that.lastName)) return false;
        if (!Objects.equals(bioDescription, that.bioDescription)) return false;
        if (!Objects.equals(positionName, that.positionName)) return false;
        return Objects.equals(positionSeniority, that.positionSeniority);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (jwtToken != null ? jwtToken.hashCode() : 0);
        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (bioDescription != null ? bioDescription.hashCode() : 0);
        result = 31 * result + (positionName != null ? positionName.hashCode() : 0);
        result = 31 * result + (positionSeniority != null ? positionSeniority.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ResponseUserWithJwtDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", jwtToken='" + jwtToken + '\'' +
                ", roles=" + roles +
                ", bioDescription=" + bioDescription +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", positionName='" + positionName + '\'' +
                ", positionSeniority='" + positionSeniority + '\'' +
                '}';
    }
}
