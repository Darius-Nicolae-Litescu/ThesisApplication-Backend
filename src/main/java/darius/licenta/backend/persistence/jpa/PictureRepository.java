package darius.licenta.backend.persistence.jpa;

import darius.licenta.backend.domain.sql.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, Long> {
    Picture findByUploadedBy_Username(String username);

    Picture findByUploadedBy_Id(Long id);

}