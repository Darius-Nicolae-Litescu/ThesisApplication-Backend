package darius.licenta.backend.mapper.normal.employee;

import darius.licenta.backend.domain.sql.Employee;
import darius.licenta.backend.dto.normal.employee.EmployeeDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface EmployeeMapper {
    Employee employeeDtoToEmployee(EmployeeDto employeeDto);

    EmployeeDto employeeToEmployeeDto(Employee employee);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEmployeeFromEmployeeDto(EmployeeDto employeeDto, @MappingTarget Employee employee);
}
