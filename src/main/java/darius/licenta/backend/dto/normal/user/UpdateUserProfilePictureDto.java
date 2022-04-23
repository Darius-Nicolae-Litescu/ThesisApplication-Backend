package darius.licenta.backend.dto.normal.user;

import darius.licenta.backend.domain.sql.Picture;

import java.io.Serializable;
import java.util.Objects;

public class UpdateUserProfilePictureDto implements Serializable {
    private String username;
    private Picture profilePicture;

    public UpdateUserProfilePictureDto() {
    }

    public UpdateUserProfilePictureDto(String username, Picture profilePicture) {
        this.username = username;
        this.profilePicture = profilePicture;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Picture getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(Picture profilePicture) {
        this.profilePicture = profilePicture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UpdateUserProfilePictureDto that = (UpdateUserProfilePictureDto) o;

        if (!Objects.equals(username, that.username)) return false;
        return Objects.equals(profilePicture, that.profilePicture);
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (profilePicture != null ? profilePicture.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UpdateUserProfilePictureDto{" +
                "username='" + username + '\'' +
                ", profilePicture=" + profilePicture +
                '}';
    }
}
