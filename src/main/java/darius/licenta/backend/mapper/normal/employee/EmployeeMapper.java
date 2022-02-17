package darius.licenta.backend.mapper.normal.employee;

import darius.licenta.backend.domain.sql.Employee;
import darius.licenta.backend.dto.normal.employee.insert.InsertEmployeeDto;
import darius.licenta.backend.dto.normal.employee.response.EmployeeDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface EmployeeMapper {
    Employee employeeDtoToEmployee(EmployeeDto employeeDto);

    EmployeeDto employeeToEmployeeDto(Employee employee);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEmployeeFromEmployeeDto(EmployeeDto employeeDto, @MappingTarget Employee employee);

    @Mapping(source = "personId", target = "person.id")
    @Mapping(source = "positionId", target = "position.id")
    @Mapping(source = "userId", target = "user.id")
    Employee insertEmployeeDtoToEmployee(InsertEmployeeDto insertEmployeeDto);

    @InheritInverseConfiguration(name = "insertEmployeeDtoToEmployee")
    InsertEmployeeDto employeeToInsertEmployeeDto(Employee employee);

    @InheritConfiguration(name = "insertEmployeeDtoToEmployee")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEmployeeFromInsertEmployeeDto(InsertEmployeeDto insertEmployeeDto, @MappingTarget Employee employee);
}
