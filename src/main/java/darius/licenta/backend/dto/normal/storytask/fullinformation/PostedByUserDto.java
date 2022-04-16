package darius.licenta.backend.dto.normal.storytask.fullinformation;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Objects;

public class PostedByUserDto implements Serializable {
    private final String username;

    public PostedByUserDto(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostedByUserDto that = (PostedByUserDto) o;

        return Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return username != null ? username.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "PostedByUserDto{" +
                "username='" + username + '\'' +
                '}';
    }
}
