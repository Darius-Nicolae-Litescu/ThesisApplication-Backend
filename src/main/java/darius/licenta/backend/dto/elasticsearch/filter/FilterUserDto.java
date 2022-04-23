package darius.licenta.backend.dto.elasticsearch.filter;

import java.util.Objects;

public class FilterUserDto {
    private final String username;
    private final String email;

    public FilterUserDto(String username, String email) {
        this.username = username;
        this.email = email;
    }


    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilterUserDto that = (FilterUserDto) o;

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
        return "FilterUserDto{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
