package darius.licenta.backend.service.position;

import darius.licenta.backend.domain.sql.Position;
import darius.licenta.backend.dto.normal.position.CreatePositionDto;
import darius.licenta.backend.dto.normal.position.PositionDto;
import darius.licenta.backend.dto.normal.position.UpdatePositionDto;
import darius.licenta.backend.mapper.normal.position.PositionMapper;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.persistence.jpa.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;

    private final PositionMapper positionMapper;

    @Autowired
    public PositionServiceImpl(PositionRepository positionRepository, PositionMapper positionMapper) {
        this.positionRepository = positionRepository;
        this.positionMapper = positionMapper;
    }

    @Override
    public ApiResponse<PositionDto> insert(CreatePositionDto createPositionDto) {
        Position position = positionMapper.createPositionDtoToPosition(createPositionDto);

        positionRepository.save(position);

        PositionDto responsePositionDto = positionMapper.positionToPositionDto(position);
        return new ApiResponse<>(responsePositionDto, HttpStatus.OK);
    }

    @Override
    public ApiResponse<PositionDto> getPositionById(Long id) {
        Optional<Position> position = positionRepository.findById(id);

        if (position.isPresent()) {
            PositionDto positionDto = positionMapper.positionToPositionDto(position.get());
            return new ApiResponse<>(positionDto, HttpStatus.OK);
        }
        return new ApiResponse<>(null, HttpStatus.NOT_FOUND);
    }

    @Override
    public ApiResponse<PositionDto> updatePosition(Long id, UpdatePositionDto updatePositionDto) {
        Optional<Position> position = positionRepository.findById(id);

        if (position.isPresent()) {
            position.get().setName(updatePositionDto.getName());
            position.get().setSeniorityLevel(updatePositionDto.getSeniorityLevel());
            positionRepository.save(position.get());
            PositionDto positionDto = positionMapper.positionToPositionDto(position.get());
            return new ApiResponse<>(positionDto, HttpStatus.OK);
        }
        return new ApiResponse<>(null, HttpStatus.NOT_FOUND);
    }

    @Override
    public ApiResponse<PositionDto> updatePositionSeniorityLevel(UpdatePositionDto updatePositionDto) {
        Optional<Position> position = positionRepository.findByName(updatePositionDto.getName());

        if (position.isPresent()) {
            position.get().setSeniorityLevel(updatePositionDto.getSeniorityLevel());
            positionRepository.save(position.get());
            PositionDto positionDtoResponse = positionMapper.positionToPositionDto(position.get());
            return new ApiResponse<>(positionDtoResponse, HttpStatus.OK);
        }
        return new ApiResponse<>(null, HttpStatus.NOT_FOUND);
    }

    @Override
    public ApiResponse<PositionDto> deleteById(Long positionId) {
        Optional<Position> position = positionRepository.findById(positionId);

        if (position.isPresent()) {
            positionRepository.delete(position.get());
            PositionDto positionDto = positionMapper.positionToPositionDto(position.get());
            return new ApiResponse<>(positionDto, HttpStatus.OK);
        }
        return new ApiResponse<>(null, HttpStatus.NOT_FOUND);
    }

    @Override
    public ApiResponse<PositionDto> findPositionByUserId(String username) {

        Optional<Position> position = positionRepository.findByEmployee_User_Username(username);
        if (position.isPresent()) {
            PositionDto positionDto = positionMapper.positionToPositionDto(position.get());
            return new ApiResponse<>(positionDto, HttpStatus.OK);
        }
        return new ApiResponse<>(null, HttpStatus.NOT_FOUND);
    }

    @Override
    public ApiResponse<List<PositionDto>> findAllPositions() {
        List<Position> positions = positionRepository.findAll();

        if (Objects.isNull(positions)) {
            return new ApiResponse<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
        }
        List<PositionDto> positionDtos = new ArrayList<>();

        positions.forEach(position -> positionDtos.add(positionMapper.positionToPositionDto(position)));
        return new ApiResponse<>(positionDtos, HttpStatus.OK);
    }

    @Override
    public ApiResponse<PositionDto> deletePositionByName(String positionName) {
        Optional<Position> position = positionRepository.findByName(positionName);
        if (position.isPresent()) {
            positionRepository.delete(position.get());
            PositionDto positionDto = positionMapper.positionToPositionDto(position.get());
            return new ApiResponse<>(positionDto, HttpStatus.ACCEPTED);
        } else {
            return new ApiResponse<>("Position name not found ... ", null, HttpStatus.NOT_FOUND);
        }
    }

}