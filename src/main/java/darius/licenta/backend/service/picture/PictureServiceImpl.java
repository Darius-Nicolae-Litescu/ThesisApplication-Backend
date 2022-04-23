package darius.licenta.backend.service.picture;

import darius.licenta.backend.domain.sql.Picture;
import darius.licenta.backend.domain.sql.User;
import darius.licenta.backend.mapper.normal.user.UserMapper;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.persistence.jpa.PictureRepository;
import darius.licenta.backend.persistence.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
public class PictureServiceImpl implements PictureService {
    private final PictureRepository pictureRepository;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository, UserRepository userRepository, UserMapper userMapper) {
        this.pictureRepository = pictureRepository;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Transactional
    public ApiResponse<Boolean> uploadProfilePicture(MultipartFile multipartFile, String uploadedByUsername) throws IOException {
        String name = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        String contentType = multipartFile.getContentType();
        byte[] content = multipartFile.getBytes();
        long size = multipartFile.getSize();

        if (!checkIfContentTypeIsImage(contentType)) {
            return new ApiResponse<>("The file is not an image", false, HttpStatus.BAD_REQUEST);
        }
        if (!checkIfSizeIsLowerThan4MB(size)) {
            return new ApiResponse<>("The image is too big", false, HttpStatus.BAD_REQUEST);
        }
        Optional<User> user = userRepository.findByUsername(uploadedByUsername);
        if (!user.isPresent()) {
            return new ApiResponse<>("The user does not exist", false, HttpStatus.BAD_REQUEST);
        }
        Picture picture = pictureRepository.findByUploadedBy_Username(uploadedByUsername);
        if (picture == null) {
            picture = new Picture(name, contentType, content, user.get());
        } else {
            picture.setName(name);
            picture.setContentType(contentType);
            picture.setContent(content);
            picture.setUploadedBy(user.get());
            picture.setPostedAt(LocalDateTime.now());
        }
        pictureRepository.save(picture);
        user.get().setProfilePicture(picture);
        userRepository.save(user.get());
        return new ApiResponse<>("The image was uploaded successfully", true, HttpStatus.OK);
    }

    public Picture getProfilePicture(String username) {
        return pictureRepository.findByUploadedBy_Username(username);
    }

    public Picture getProfilePicture(Long id) {
        return pictureRepository.findByUploadedBy_Id(id);
    }

    public ApiResponse<Boolean> deleteProfilePicture(String username) {
        Picture picture = pictureRepository.findByUploadedBy_Username(username);
        if (picture == null) {
            return new ApiResponse<>("The picture does not exist", false, HttpStatus.BAD_REQUEST);
        } else {
            pictureRepository.delete(picture);
        }
        return new ApiResponse<>("The image was deleted successfully", true, HttpStatus.OK);
    }

    private boolean checkIfContentTypeIsImage(String contentType) {
        if (contentType == null) {
            return false;
        }
        return contentType.contains("image/");
    }

    private boolean checkIfSizeIsLowerThan4MB(long size) {
        return size < 4 * 1024 * 1024;
    }
}
