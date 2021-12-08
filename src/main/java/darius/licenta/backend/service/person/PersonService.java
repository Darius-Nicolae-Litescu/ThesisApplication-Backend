package darius.licenta.backend.service.person;

import darius.licenta.backend.domain.Person;
import darius.licenta.backend.dto.person.PersonDto;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.payload.response.PaginatedResponse;

public interface PersonService {
    PaginatedResponse<PersonDto> getAllPersons(int page, int size);

    ApiResponse<PersonDto> getPersonById(Long id);

    void insertPerson(Person person);
}