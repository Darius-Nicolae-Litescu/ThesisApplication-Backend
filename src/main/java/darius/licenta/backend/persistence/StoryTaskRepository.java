package darius.licenta.backend.persistence;

import darius.licenta.backend.domain.StoryTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryTaskRepository extends JpaRepository<StoryTask, Long> {
}