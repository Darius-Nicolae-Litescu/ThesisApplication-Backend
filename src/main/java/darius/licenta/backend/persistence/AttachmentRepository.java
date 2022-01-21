package darius.licenta.backend.persistence;

import darius.licenta.backend.domain.Attachment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttachmentRepository extends JpaRepository<Attachment, Long> {

    Page<Attachment> findByUploadedBy_Username(String username, Pageable pageable);

}