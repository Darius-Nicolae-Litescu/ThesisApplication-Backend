package darius.licenta.backend.persistence;

import darius.licenta.backend.domain.Story;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<Story, Long> {
}