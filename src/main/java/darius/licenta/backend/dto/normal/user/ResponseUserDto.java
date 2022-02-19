package darius.licenta.backend.dto.normal.user;

import java.io.Serializable;
import java.util.Objects;

public class ResponseUserDto implements Serializable {
    private Long id;
    private String username;
    private String email;
    private String bioDescription;

    public ResponseUserDto(Long id, String username, String email, String bioDescription) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.bioDescription = bioDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBioDescription() {
        return bioDescription;
    }

    public void setBioDescription(String bioDescription) {
        this.bioDescription = bioDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResponseUserDto that = (ResponseUserDto) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(username, that.username)) return false;
        if (!Objects.equals(email, that.email)) return false;
        return Objects.equals(bioDescription, that.bioDescription);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (bioDescription != null ? bioDescription.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ResponseUserDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", bioDescription='" + bioDescription + '\'' +
                '}';
    }
}
