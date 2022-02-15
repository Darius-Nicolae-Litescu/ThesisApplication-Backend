package darius.licenta.backend.service.employee;

import darius.licenta.backend.domain.sql.Employee;
import darius.licenta.backend.dto.normal.employee.EmployeeDto;
import darius.licenta.backend.mapper.normal.employee.EmployeeMapper;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.payload.response.PaginatedResponse;
import darius.licenta.backend.persistence.jpa.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public ApiResponse<PaginatedResponse<EmployeeDto>> getAllEmployees(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Employee> allEmployees = employeeRepository.findAll(pageable);
        if (allEmployees.getNumberOfElements() == 0) {
            return new ApiResponse<>(new PaginatedResponse<>(allEmployees.getNumber(), allEmployees.getSize(), allEmployees.getNumberOfElements(),
                    new ArrayList<>(), allEmployees.getTotalElements(), allEmployees.getTotalPages()), HttpStatus.NOT_FOUND);
        }
        List<EmployeeDto> allEmployeeDto = new ArrayList<>();
        allEmployees.getContent().forEach(employee -> allEmployeeDto.add(employeeMapper.employeeToEmployeeDto(employee)));
        return new ApiResponse<>(new PaginatedResponse<>(allEmployees.getNumber(), allEmployees.getSize(), allEmployees.getNumberOfElements(),
                allEmployeeDto, allEmployees.getTotalElements(), allEmployees.getTotalPages()), HttpStatus.OK);
    }

    @Override
    public ApiResponse<EmployeeDto> insert(EmployeeDto employeeDto) {
        Employee employee = employeeMapper.employeeDtoToEmployee(employeeDto);

        employeeRepository.save(employee);

        EmployeeDto responseEmployeeDto = employeeMapper.employeeToEmployeeDto(employee);
        return new ApiResponse<>(responseEmployeeDto, HttpStatus.OK);
    }

    @Override
    public ApiResponse<EmployeeDto> update(EmployeeDto employeeDto) {
        return null;
    }

    @Override
    public ApiResponse<EmployeeDto> delete(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            employeeRepository.delete(employee.get());
            EmployeeDto responseEmployeeDto = employeeMapper.employeeToEmployeeDto(employee.get());
            return new ApiResponse<>(responseEmployeeDto, HttpStatus.ACCEPTED);
        } else {
            return new ApiResponse<>("Could not find employee with id " + id, null, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ApiResponse<EmployeeDto> getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        EmployeeDto employeeDto = employeeMapper.employeeToEmployeeDto(employee);
        return new ApiResponse<>(employeeDto, HttpStatus.OK);
    }
}
