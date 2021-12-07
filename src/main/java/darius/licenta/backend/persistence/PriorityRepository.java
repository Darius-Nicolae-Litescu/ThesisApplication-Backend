package darius.licenta.backend.persistence;

import darius.licenta.backend.domain.Priority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriorityRepository extends JpaRepository<Priority, Long> {
}