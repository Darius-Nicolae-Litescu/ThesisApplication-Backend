package darius.licenta.backend.persistence.jpa;

import darius.licenta.backend.domain.sql.Attachment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment, Long> {

    Page<Attachment> findByUploadedBy_Username(String username, Pageable pageable);

}