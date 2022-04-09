package darius.licenta.backend.service.employee;

import darius.licenta.backend.domain.sql.Employee;
import darius.licenta.backend.domain.sql.Person;
import darius.licenta.backend.domain.sql.Position;
import darius.licenta.backend.domain.sql.User;
import darius.licenta.backend.dto.normal.employee.insert.InsertEmployeeDto;
import darius.licenta.backend.dto.normal.employee.response.EmployeeDto;
import darius.licenta.backend.dto.normal.employee.update.UpdateEmployeeDto;
import darius.licenta.backend.dto.normal.story.response.table.TableEmployeeDto;
import darius.licenta.backend.mapper.normal.employee.EmployeeMapper;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.payload.response.PaginatedResponse;
import darius.licenta.backend.persistence.jpa.EmployeeRepository;
import darius.licenta.backend.persistence.jpa.PersonRepository;
import darius.licenta.backend.persistence.jpa.PositionRepository;
import darius.licenta.backend.persistence.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeMapper employeeMapper;

    private final EmployeeRepository employeeRepository;
    private final PersonRepository personRepository;
    private final PositionRepository positionRepository;
    private final UserRepository userRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeMapper employeeMapper, EmployeeRepository employeeRepository, PersonRepository personRepository, PositionRepository positionRepository, UserRepository userRepository) {
        this.employeeMapper = employeeMapper;
        this.employeeRepository = employeeRepository;
        this.personRepository = personRepository;
        this.positionRepository = positionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ApiResponse<PaginatedResponse<TableEmployeeDto>> getAllEmployees(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Employee> allEmployees = employeeRepository.findAll(pageable);
        if (allEmployees.getNumberOfElements() == 0) {
            return new ApiResponse<>(new PaginatedResponse<>(allEmployees.getNumber(), allEmployees.getSize(), allEmployees.getNumberOfElements(),
                    new ArrayList<>(), allEmployees.getTotalElements(), allEmployees.getTotalPages()), HttpStatus.NOT_FOUND);
        }
        List<TableEmployeeDto> allEmployeeDto = new ArrayList<>();
        allEmployees.getContent().forEach(employee -> allEmployeeDto.add(employeeMapper.employeeToTableEmployeeDto(employee)));
        return new ApiResponse<>(new PaginatedResponse<>(allEmployees.getNumber(), allEmployees.getSize(), allEmployees.getNumberOfElements(),
                allEmployeeDto, allEmployees.getTotalElements(), allEmployees.getTotalPages()), HttpStatus.OK);
    }

    @Transactional
    @Override
    public ApiResponse<EmployeeDto> insert(InsertEmployeeDto insertEmployeeDto) {
        Person person = personRepository.getById(insertEmployeeDto.getPersonId());
        Position position = positionRepository.getById(insertEmployeeDto.getPositionId());
        User user = userRepository.getById(insertEmployeeDto.getUserId());
        Employee employee = new Employee(person,position,user);

        employeeRepository.save(employee);
        user.setEmployee(employee);
        userRepository.save(user);
        EmployeeDto responseEmployeeDto = employeeMapper.employeeToEmployeeDto(employee);

        return new ApiResponse<>(responseEmployeeDto, HttpStatus.OK);
    }

    @Override
    public ApiResponse<UpdateEmployeeDto> updateEmployee(UpdateEmployeeDto employeeDto) {
        Employee employee = employeeRepository.getById(employeeDto.getId());

        employee.setPerson(personRepository.getById(employeeDto.getPersonId()));
        employee.setPosition(positionRepository.getById(employeeDto.getPositionId()));
        employee.setUser(userRepository.getById(employeeDto.getUserId()));
        employeeRepository.save(employee);

        return new ApiResponse<>(employeeMapper.employeeToUpdateEmployeeDto(employee), HttpStatus.OK);
    }

    @Override
    public ApiResponse<EmployeeDto> deleteById(Long id) {
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

    @Override
    public ApiResponse<UpdateEmployeeDto> getEmployeeBasicDetailsById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        UpdateEmployeeDto employeeDto = employeeMapper.employeeToUpdateEmployeeDto(employee);
        return new ApiResponse<>(employeeDto, HttpStatus.OK);
    }
}
