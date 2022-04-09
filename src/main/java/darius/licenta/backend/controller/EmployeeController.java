package darius.licenta.backend.controller;

import darius.licenta.backend.domain.sql.UserRole;
import darius.licenta.backend.dto.normal.employee.insert.InsertEmployeeDto;
import darius.licenta.backend.dto.normal.employee.response.EmployeeDto;
import darius.licenta.backend.dto.normal.employee.update.UpdateEmployeeDto;
import darius.licenta.backend.dto.normal.story.response.table.TableEmployeeDto;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.payload.response.PaginatedResponse;
import darius.licenta.backend.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping("/")
    @Secured(UserRole.Rank.ADMIN)
    public ApiResponse<EmployeeDto> addEmployee(@RequestBody InsertEmployeeDto insertEmployeeDto) {
        return employeeService.insert(insertEmployeeDto);
    }

    @PutMapping
    @Secured(UserRole.Rank.ADMIN)
    public ApiResponse<UpdateEmployeeDto> updateEmployee(@RequestBody UpdateEmployeeDto employeeDto) {
        return employeeService.updateEmployee(employeeDto);
    }

    @GetMapping("/basic/{id}")
    @Secured({UserRole.Rank.ADMIN})
    public ApiResponse<UpdateEmployeeDto> getEmployeeByIdBasicDetails(@PathVariable Long id) {
        return employeeService.getEmployeeBasicDetailsById(id);
    }

    @GetMapping("/{id}")
    @Secured({UserRole.Rank.ADMIN})
    public ApiResponse<EmployeeDto> getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    @Secured(UserRole.Rank.ADMIN)
    public ApiResponse<EmployeeDto> deleteEmployee(@PathVariable Long id) {
        return employeeService.deleteById(id);
    }

    @GetMapping("/pageable")
    @Secured({UserRole.Rank.ADMIN})
    public ApiResponse<PaginatedResponse<TableEmployeeDto>> getEmployees(@RequestParam int page,
                                                                         @RequestParam int size) {
        return employeeService.getAllEmployees(page, size);
    }
}
