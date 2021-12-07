package darius.licenta.backend.persistence;

import darius.licenta.backend.domain.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {
}