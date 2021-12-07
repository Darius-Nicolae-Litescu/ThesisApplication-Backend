package darius.licenta.backend.service.Person;

import darius.licenta.backend.domain.Person;
import darius.licenta.backend.dto.person.PersonDto;
import darius.licenta.backend.mapper.person.PersonMapper;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.payload.response.PaginatedResponse;
import darius.licenta.backend.persistence.PersonRepository;
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
public class PersonServiceImpl implements PersonService {

    private final String BIRTH_DATE = "birth_date";

    private final PersonMapper personMapper;

    PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonMapper personMapper, PersonRepository personRepository) {
        this.personMapper = personMapper;
        this.personRepository = personRepository;
    }

    @Override
    public PaginatedResponse<PersonDto> getAllPersons(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, BIRTH_DATE);
        Page<Person> allPersons = personRepository.findAll(pageable);
        if (allPersons.getNumberOfElements() == 0) {
            return new PaginatedResponse<>(allPersons.getNumber(), allPersons.getSize(), allPersons.getNumberOfElements(),
                    new ArrayList<>(), allPersons.getTotalElements(), allPersons.getTotalPages());
        }
        List<PersonDto> allPersonDto = new ArrayList<>();
        allPersons.getContent().forEach(person -> allPersonDto.add(personMapper.personToPersonDto(person)));
        return new PaginatedResponse<>(allPersons.getNumber(), allPersons.getSize(), allPersons.getNumberOfElements(),
                allPersonDto, allPersons.getTotalElements(), allPersons.getTotalPages());
    }

    @Override
    public ApiResponse<PersonDto> getPersonById(Long id) {
        Person person = personRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        PersonDto personDto = personMapper.personToPersonDto(person);
        return new ApiResponse<>(personDto, HttpStatus.OK);
    }
}