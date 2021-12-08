package darius.licenta.backend.service.person;

import darius.licenta.backend.domain.Employee;
import darius.licenta.backend.domain.Person;
import darius.licenta.backend.dto.person.EmployeeDto;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.payload.response.PaginatedResponse;

public interface PersonService {
    PaginatedResponse<EmployeeDto> getAllPersons(int page, int size);

    ApiResponse<EmployeeDto> getPersonById(Long id);

    void insertPerson(Person person);
}