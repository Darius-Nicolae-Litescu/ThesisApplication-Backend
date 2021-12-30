package darius.licenta.backend.service.employee;

import darius.licenta.backend.domain.Employee;
import darius.licenta.backend.dto.employee.EmployeeDto;
import darius.licenta.backend.dto.person.PersonDto;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.payload.response.PaginatedResponse;

public interface EmployeeService {
    ApiResponse<PaginatedResponse<EmployeeDto>> getAllEmployees(int page, int size);

    ApiResponse<EmployeeDto> getEmployeeById(Long id);

    ApiResponse<EmployeeDto> insert(EmployeeDto employeeDto);

    ApiResponse<EmployeeDto> update(EmployeeDto employeeDto);

    ApiResponse<EmployeeDto> delete(Long id);
}