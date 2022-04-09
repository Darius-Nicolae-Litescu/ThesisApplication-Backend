package darius.licenta.backend.dto.normal.storytask.fullinformation;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Objects;

public class PostedByUserDto implements Serializable {
    private final String username;
    private final Blob profilePicture;

    public PostedByUserDto(String username, Blob profilePicture) {
        this.username = username;
        this.profilePicture = profilePicture;
    }

    public String getUsername() {
        return this.username;
    }

    public Blob getProfilePicture() {
        return this.profilePicture;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PostedByUserDto)) return false;
        final PostedByUserDto other = (PostedByUserDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$username = this.getUsername();
        final Object other$username = other.getUsername();
        if (!Objects.equals(this$username, other$username)) return false;
        final Object this$profilePicture = this.getProfilePicture();
        final Object other$profilePicture = other.getProfilePicture();
        if (!Objects.equals(this$profilePicture, other$profilePicture))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PostedByUserDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $username = this.getUsername();
        result = result * PRIME + ($username == null ? 43 : $username.hashCode());
        final Object $profilePicture = this.getProfilePicture();
        result = result * PRIME + ($profilePicture == null ? 43 : $profilePicture.hashCode());
        return result;
    }

    public String toString() {
        return "PostedByUserDto(username=" + this.getUsername() + ", profilePicture=" + this.getProfilePicture() + ")";
    }
}
