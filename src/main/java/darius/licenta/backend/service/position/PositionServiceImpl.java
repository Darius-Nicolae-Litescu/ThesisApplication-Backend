package darius.licenta.backend.service.position;

import darius.licenta.backend.domain.Position;
import darius.licenta.backend.domain.Role;
import darius.licenta.backend.persistence.PositionRepository;
import darius.licenta.backend.persistence.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
class PositionServiceImpl implements PositionService {

    private PositionRepository positionRepository;

    @Autowired
    public PositionServiceImpl(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Transactional
    @Override
    public void saveOrUpdatePosition(Position position) {
        positionRepository.save(position);
    }

    @Override
    public boolean deletePosition(String positionName) {
        return positionRepository.deleteByPositionName(positionName) > 0;
    }

    @Override
    public List<Position> findPositionByUserId(long userId) {
        List<Position> positions = positionRepository.findByUserId(userId);
        if (Objects.isNull(positions)) {
            return new ArrayList<>();
        }
        return positions;
    }

    @Override
    public List<Position> findAllPositions() {
        return positionRepository.findAll();
    }
}