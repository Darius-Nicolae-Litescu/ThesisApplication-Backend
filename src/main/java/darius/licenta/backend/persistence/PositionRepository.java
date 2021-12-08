package darius.licenta.backend.persistence;

import darius.licenta.backend.domain.Position;
import darius.licenta.backend.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PositionRepository extends JpaRepository<Position, Long> {
    List<Position> findByUserId(long id);
    long deleteByPositionName(String positionName);
    @Override
    List<Position> findAll();

}