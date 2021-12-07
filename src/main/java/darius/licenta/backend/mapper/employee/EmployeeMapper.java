package darius.licenta.backend.mapper.employee;

import darius.licenta.backend.domain.Employee;
import darius.licenta.backend.dto.employee.EmployeeDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface EmployeeMapper {
    Employee employeeDtoToEmployee(EmployeeDto employeeDto);

    EmployeeDto employeeToEmployeeDto(Employee employee);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEmployeeFromEmployeeDto(EmployeeDto employeeDto, @MappingTarget Employee employee);
}
