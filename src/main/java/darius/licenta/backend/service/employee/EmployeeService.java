package darius.licenta.backend.service.employee;

import darius.licenta.backend.dto.normal.employee.insert.InsertEmployeeDto;
import darius.licenta.backend.dto.normal.employee.response.EmployeeDto;
import darius.licenta.backend.dto.normal.employee.update.UpdateEmployeeDto;
import darius.licenta.backend.dto.normal.story.response.table.TableEmployeeDto;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.payload.response.PaginatedResponse;

public interface EmployeeService {

    ApiResponse<EmployeeDto> insert(InsertEmployeeDto insertEmployeeDto);

    ApiResponse<UpdateEmployeeDto> updateEmployee(UpdateEmployeeDto employeeDto);

    ApiResponse<EmployeeDto> deleteById(Long id);

    ApiResponse<EmployeeDto> getEmployeeById(Long id);

    ApiResponse<UpdateEmployeeDto> getEmployeeBasicDetailsById(Long id);

    ApiResponse<PaginatedResponse<TableEmployeeDto>> getAllEmployees(int page, int size);
}