package darius.licenta.backend.persistence;

import darius.licenta.backend.domain.CommentAttachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentAttachmentRepository extends JpaRepository<CommentAttachment, Long> {
}