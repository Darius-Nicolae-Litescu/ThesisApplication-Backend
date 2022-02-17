package darius.licenta.backend.dto.normal.user;

import java.io.Serializable;

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

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UpdateUserEmailDto)) return false;
        final UpdateUserEmailDto other = (UpdateUserEmailDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$username = this.getUsername();
        final Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UpdateUserEmailDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $username = this.getUsername();
        result = result * PRIME + ($username == null ? 43 : $username.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        return result;
    }

    public String toString() {
        return "UpdateUserEmailDto(username=" + this.getUsername() + ", email=" + this.getEmail() + ")";
    }
}
