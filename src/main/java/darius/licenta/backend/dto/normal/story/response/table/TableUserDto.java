package darius.licenta.backend.dto.normal.story.response.table;

import java.io.Serializable;
import java.util.Objects;

public class TableUserDto implements Serializable {
    private final Long id;
    private final String username;
    private final String bioDescription;
    private final String email;

    public TableUserDto(Long id, String username, String bioDescription, String email) {
        this.id = id;
        this.username = username;
        this.bioDescription = bioDescription;
        this.email = email;
    }


    public Long getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getBioDescription() {
        return this.bioDescription;
    }

    public String getEmail() {
        return this.email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TableUserDto that = (TableUserDto) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(username, that.username)) return false;
        if (!Objects.equals(bioDescription, that.bioDescription))
            return false;
        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (bioDescription != null ? bioDescription.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TableUserDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", bioDescription='" + bioDescription + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
