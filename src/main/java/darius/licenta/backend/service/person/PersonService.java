package darius.licenta.backend.service.person;

import darius.licenta.backend.dto.normal.person.PersonDto;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.payload.response.PaginatedResponse;

public interface PersonService {
    ApiResponse<PaginatedResponse<PersonDto>> getAllPersons(int page, int size);

    ApiResponse<PersonDto> insert(PersonDto personDto);

    ApiResponse<PersonDto> updatePerson(PersonDto personDto);

    ApiResponse<PersonDto> getPersonById(Long id);

    ApiResponse<PersonDto> deleteById(Long id);
}