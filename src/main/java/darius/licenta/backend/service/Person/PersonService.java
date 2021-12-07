package darius.licenta.backend.service.Person;

import darius.licenta.backend.domain.Person;
import darius.licenta.backend.domain.Role;
import darius.licenta.backend.dto.person.PersonDto;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.payload.response.PaginatedResponse;

import java.util.List;

public interface PersonService {
    PaginatedResponse<PersonDto> getAllPersons(int page, int size);
    ApiResponse<PersonDto> getPersonById(Long id);
}