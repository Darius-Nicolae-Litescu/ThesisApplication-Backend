package darius.licenta.backend.dto.normal.story.response.fulldetails;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Objects;

public class CreatedByUserDto implements Serializable {
    private final Long id;
    private final String username;

    public CreatedByUserDto(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public Long getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreatedByUserDto that = (CreatedByUserDto) o;

        if (!Objects.equals(id, that.id)) return false;
        return Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CreatedByUserDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
