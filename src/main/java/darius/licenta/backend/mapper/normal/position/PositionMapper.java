package darius.licenta.backend.mapper.normal.position;

import darius.licenta.backend.domain.sql.Position;
import darius.licenta.backend.dto.normal.position.CreatePositionDto;
import darius.licenta.backend.dto.normal.position.PositionDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PositionMapper {
    Position positionDtoToPosition(PositionDto positionDto);

    PositionDto positionToPositionDto(Position position);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePositionFromPositionDto(PositionDto positionDto, @MappingTarget Position position);

    Position createPositionDtoToPosition(CreatePositionDto createPositionDto);

    CreatePositionDto positionToCreatePositionDto(Position position);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePositionFromCreatePositionDto(CreatePositionDto createPositionDto, @MappingTarget Position position);
}
