package darius.licenta.backend.dto.normal.user;

import java.io.Serializable;
import java.util.Objects;

public class UpdateUserPasswordDto implements Serializable {
    private String username;
    private String password;

    public UpdateUserPasswordDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UpdateUserPasswordDto() {
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UpdateUserPasswordDto that = (UpdateUserPasswordDto) o;

        if (!Objects.equals(username, that.username)) return false;
        return Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
