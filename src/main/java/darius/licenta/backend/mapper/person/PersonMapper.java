package darius.licenta.backend.mapper.person;

import darius.licenta.backend.domain.Person;
import darius.licenta.backend.dto.person.EmployeeDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PersonMapper {
    Person personDtoToPerson(EmployeeDto employeeDto);

    EmployeeDto personToPersonDto(Person person);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePersonFromPersonDto(EmployeeDto employeeDto, @MappingTarget Person person);
}
