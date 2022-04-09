package darius.licenta.backend.dto.normal.story.response.fulldetails;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Objects;

public class CreatedByUserDto implements Serializable {
    private final Long id;
    private final String username;
    private final Blob profilePicture;

    public CreatedByUserDto(Long id, String username, Blob profilePicture) {
        this.id = id;
        this.username = username;
        this.profilePicture = profilePicture;
    }

    public Long getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public Blob getProfilePicture() {
        return this.profilePicture;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CreatedByUserDto)) return false;
        final CreatedByUserDto other = (CreatedByUserDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (!Objects.equals(this$id, other$id)) return false;
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
        return other instanceof CreatedByUserDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $username = this.getUsername();
        result = result * PRIME + ($username == null ? 43 : $username.hashCode());
        final Object $profilePicture = this.getProfilePicture();
        result = result * PRIME + ($profilePicture == null ? 43 : $profilePicture.hashCode());
        return result;
    }

    public String toString() {
        return "CreatedByUserDto(id=" + this.getId() + ", username=" + this.getUsername() + ", profilePicture=" + this.getProfilePicture() + ")";
    }
}
