package darius.licenta.backend.mapper.person;

import darius.licenta.backend.domain.Person;
import darius.licenta.backend.domain.Position;
import darius.licenta.backend.dto.person.PersonDto;
import darius.licenta.backend.dto.position.UpdatePositionDto;
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
