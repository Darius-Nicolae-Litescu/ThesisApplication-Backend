package darius.licenta.backend.service.employee;

import darius.licenta.backend.domain.Employee;
import darius.licenta.backend.dto.employee.EmployeeDto;
import darius.licenta.backend.mapper.employee.EmployeeMapper;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.payload.response.PaginatedResponse;
import darius.licenta.backend.persistence.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeMapper employeeMapper;

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeMapper employeeMapper, EmployeeRepository employeeRepository) {
        this.employeeMapper = employeeMapper;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public PaginatedResponse<EmployeeDto> getAllEmployees(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC);
        Page<Employee> allEmployees = employeeRepository.findAll(pageable);
        if (allEmployees.getNumberOfElements() == 0) {
            return new PaginatedResponse<>(allEmployees.getNumber(), allEmployees.getSize(), allEmployees.getNumberOfElements(),
                    new ArrayList<>(), allEmployees.getTotalElements(), allEmployees.getTotalPages());
        }
        List<EmployeeDto> allEmployeeDto = new ArrayList<>();
        allEmployees.getContent().forEach(employee -> allEmployeeDto.add(employeeMapper.employeeToEmployeeDto(employee)));
        return new PaginatedResponse<>(allEmployees.getNumber(), allEmployees.getSize(), allEmployees.getNumberOfElements(),
                allEmployeeDto, allEmployees.getTotalElements(), allEmployees.getTotalPages());
    }

    @Override
    public ApiResponse<EmployeeDto> getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        EmployeeDto employeeDto = employeeMapper.employeeToEmployeeDto(employee);
        return new ApiResponse<>(employeeDto, HttpStatus.OK);
    }

    @Override
    public void insertEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
