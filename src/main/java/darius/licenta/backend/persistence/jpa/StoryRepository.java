package darius.licenta.backend.persistence.jpa;

import darius.licenta.backend.domain.sql.Story;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface StoryRepository extends JpaRepository<Story, Long>, JpaSpecificationExecutor<Story> {

    Page<Story> findByPriority_Id(long id, Pageable pageable);

    Page<Story> findByCategories_Id(long id, Pageable pageable);

    Page<Story> findByDescriptionLike(String description, Pageable pageable);

    Page<Story> findBySoftwareApplication_Id(long id, Pageable pageable);



}