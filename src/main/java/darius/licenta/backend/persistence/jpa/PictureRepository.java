package darius.licenta.backend.persistence.jpa;

import darius.licenta.backend.domain.sql.Employee;
import darius.licenta.backend.domain.sql.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PictureRepository extends JpaRepository<Picture, Long> {
    Picture findByUploadedBy_Username(String username);

    Picture findByUploadedBy_Id(Long id);

}