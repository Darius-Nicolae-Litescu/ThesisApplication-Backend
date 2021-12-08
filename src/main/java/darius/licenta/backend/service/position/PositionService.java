package darius.licenta.backend.service.position;

import darius.licenta.backend.domain.Position;
import darius.licenta.backend.domain.Role;

import java.util.List;

public interface PositionService {
    void saveOrUpdatePosition(Position position);
    boolean deletePosition(String positionName);
    List<Position> findPositionByUserId(long userId);
    List<Position> findAllPositions();
}
