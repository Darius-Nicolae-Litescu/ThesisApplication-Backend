package darius.licenta.backend.dto.normal.user;

import java.io.Serializable;
import java.sql.Blob;

public class UpdateUserProfilePictureDto implements Serializable {
    private String username;
    private Blob profilePicture;

    public UpdateUserProfilePictureDto(String username, Blob profilePicture) {
        this.username = username;
        this.profilePicture = profilePicture;
    }

    public UpdateUserProfilePictureDto() {
    }

    public String getUsername() {
        return this.username;
    }

    public Blob getProfilePicture() {
        return this.profilePicture;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setProfilePicture(Blob profilePicture) {
        this.profilePicture = profilePicture;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UpdateUserProfilePictureDto)) return false;
        final UpdateUserProfilePictureDto other = (UpdateUserProfilePictureDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$username = this.getUsername();
        final Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) return false;
        final Object this$profilePicture = this.getProfilePicture();
        final Object other$profilePicture = other.getProfilePicture();
        if (this$profilePicture == null ? other$profilePicture != null : !this$profilePicture.equals(other$profilePicture))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UpdateUserProfilePictureDto;
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
        return "UpdateUserProfilePictureDto(username=" + this.getUsername() + ", profilePicture=" + this.getProfilePicture() + ")";
    }
}
