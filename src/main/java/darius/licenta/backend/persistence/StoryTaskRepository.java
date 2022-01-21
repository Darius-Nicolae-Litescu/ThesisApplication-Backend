package darius.licenta.backend.persistence;

import darius.licenta.backend.domain.StoryTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoryTaskRepository extends JpaRepository<StoryTask, Long> {

    List<StoryTask> findByStory_Id(long id);

    List<StoryTask> findByCreatedBy_Username(String username);

    List<StoryTask> findByAssignedTo_Username(String username);
}