package darius.licenta.backend.persistence.jpa;

import darius.licenta.backend.domain.sql.Priority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PriorityRepository extends JpaRepository<Priority, Long> {
    List<Priority> findByTitle(String title);

    List<Priority> findByDescription(String description);

    List<Priority> findByLevel(int level);
}