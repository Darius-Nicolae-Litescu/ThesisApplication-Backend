package darius.licenta.backend.persistence;

import darius.licenta.backend.domain.StoryComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryCommentRepository extends JpaRepository<StoryComment, Long> {
}