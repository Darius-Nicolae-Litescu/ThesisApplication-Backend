package darius.licenta.backend.dto.normal.user;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class AddUserProfilePicture implements Serializable {
    private MultipartFile profilePicture;

    public AddUserProfilePicture() {

    }

    public AddUserProfilePicture(MultipartFile profilePicture) {
        this.profilePicture = profilePicture;
    }

    public MultipartFile getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(MultipartFile profilePicture) {
        this.profilePicture = profilePicture;
    }


}
