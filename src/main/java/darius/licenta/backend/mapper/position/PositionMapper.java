package darius.licenta.backend.mapper.position;

import darius.licenta.backend.domain.Position;
import darius.licenta.backend.dto.position.PositionDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PositionMapper {
    Position positionDtoToPosition(PositionDto positionDto);

    PositionDto positionToPositionDto(Position position);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePositionFromPositionDto(PositionDto positionDto, @MappingTarget Position position);
}
