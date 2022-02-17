package darius.licenta.backend.mapper.normal.person;

import darius.licenta.backend.domain.sql.Person;
import darius.licenta.backend.domain.sql.Position;
import darius.licenta.backend.dto.normal.person.PersonDto;
import darius.licenta.backend.dto.normal.position.UpdatePositionDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PersonMapper {
    Person personDtoToPerson(PersonDto personDto);

    PersonDto personToPersonDto(Person person);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePersonFromPersonDto(PersonDto employeeDto, @MappingTarget Person person);

    Position updatePositionDtoToPosition(UpdatePositionDto updatePositionDto);

    UpdatePositionDto positionToUpdatePositionDto(Position position);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePositionFromUpdatePositionDto(UpdatePositionDto updatePositionDto, @MappingTarget Position position);
}
