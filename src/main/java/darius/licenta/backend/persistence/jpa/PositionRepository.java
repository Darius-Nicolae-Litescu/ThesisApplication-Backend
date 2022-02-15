package darius.licenta.backend.persistence.jpa;

import darius.licenta.backend.domain.sql.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PositionRepository extends JpaRepository<Position, Long> {

    Optional<Position> findByName(String name);

    Optional<Position> findByEmployee_User_Username(String username);

    long deleteByName(String positionName);

    @Override
    List<Position> findAll();

}
