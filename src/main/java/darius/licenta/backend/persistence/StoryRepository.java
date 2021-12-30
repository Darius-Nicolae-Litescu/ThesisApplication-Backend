package darius.licenta.backend.persistence;

import darius.licenta.backend.domain.Story;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoryRepository extends JpaRepository<Story, Long> {

    List<Story> findByPriority_Id(long id);

    List<Story> findByCategory_Id(long id);

    List<Story> findByDescriptionLike(String description);

    List<Story> findBySoftwareApplication_Id(long id);

}