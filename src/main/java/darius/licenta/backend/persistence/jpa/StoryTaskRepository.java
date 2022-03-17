package darius.licenta.backend.persistence.jpa;

import darius.licenta.backend.domain.sql.StoryTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface StoryTaskRepository extends JpaRepository<StoryTask, Long>, JpaSpecificationExecutor<StoryTask> {

    List<StoryTask> findByStory_Id(long id);

    List<StoryTask> findByCreatedBy_Username(String username);

    List<StoryTask> findByAssignedTo_Username(String username);
}