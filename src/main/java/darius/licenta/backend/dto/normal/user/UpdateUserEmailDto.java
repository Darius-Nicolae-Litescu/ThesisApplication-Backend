package darius.licenta.backend.dto.normal.user;

import java.io.Serializable;
import java.util.Objects;

public class UpdateUserEmailDto implements Serializable {
    private String username;
    private String email;

    public UpdateUserEmailDto(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public UpdateUserEmailDto() {
    }

    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UpdateUserEmailDto that = (UpdateUserEmailDto) o;

        if (!Objects.equals(username, that.username)) return false;
        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UpdateUserEmailDto{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
