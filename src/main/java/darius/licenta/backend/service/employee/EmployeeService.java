package darius.licenta.backend.service.employee;

import darius.licenta.backend.dto.normal.employee.insert.InsertEmployeeDto;
import darius.licenta.backend.dto.normal.employee.response.EmployeeDto;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.payload.response.PaginatedResponse;

public interface EmployeeService {

    ApiResponse<EmployeeDto> insert(InsertEmployeeDto insertEmployeeDto);

    ApiResponse<EmployeeDto> update(EmployeeDto employeeDto);

    ApiResponse<EmployeeDto> delete(Long id);

    ApiResponse<PaginatedResponse<EmployeeDto>> getAllEmployees(int page, int size);

    ApiResponse<EmployeeDto> getEmployeeById(Long id);
}