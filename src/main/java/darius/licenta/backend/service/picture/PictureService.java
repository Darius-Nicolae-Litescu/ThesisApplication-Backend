package darius.licenta.backend.service.picture;

import darius.licenta.backend.domain.sql.Picture;
import darius.licenta.backend.payload.response.ApiResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PictureService {
    ApiResponse<Boolean> uploadProfilePicture(MultipartFile multipartFile, String uploadedByUsername) throws IOException;
    Picture getProfilePicture(String username);
    Picture getProfilePicture(Long id);
    ApiResponse<Boolean> deleteProfilePicture(String username);

}
