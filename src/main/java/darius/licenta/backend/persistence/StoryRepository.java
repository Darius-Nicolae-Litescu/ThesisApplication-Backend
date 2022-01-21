package darius.licenta.backend.persistence;

import darius.licenta.backend.domain.Story;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoryRepository extends JpaRepository<Story, Long> {

    Page<Story> findByPriority_Id(long id, Pageable pageable);

    Page<Story> findByCategory_Id(long id, Pageable pageable);

    Page<Story> findByDescriptionLike(String description, Pageable pageable);

    Page<Story> findBySoftwareApplication_Id(long id, Pageable pageable);



}