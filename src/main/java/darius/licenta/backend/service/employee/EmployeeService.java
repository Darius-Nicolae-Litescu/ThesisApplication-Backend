package darius.licenta.backend.service.employee;

import darius.licenta.backend.domain.Employee;
import darius.licenta.backend.dto.employee.EmployeeDto;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.payload.response.PaginatedResponse;

public interface EmployeeService {
    PaginatedResponse<EmployeeDto> getAllEmployees(int page, int size);
    ApiResponse<EmployeeDto> getEmployeeById(Long id);
    void insertEmployee(Employee employee);
}