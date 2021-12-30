package darius.licenta.backend.service.person;

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
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonMapper personMapper;

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonMapper personMapper, PersonRepository personRepository) {
        this.personMapper = personMapper;
        this.personRepository = personRepository;
    }

    @Override
    public ApiResponse<PersonDto> insert(PersonDto personDto) {
        Person person = personMapper.personDtoToPerson(personDto);

        personRepository.save(person);

        PersonDto responsePersonDto = personMapper.personToPersonDto(person);
        return new ApiResponse<>(responsePersonDto, HttpStatus.OK);
    }

    @Override
    public ApiResponse<PersonDto> update(PersonDto personDto) {
        Optional<Person> person = personRepository.findById(personDto.getId());
        if (person.isPresent()) {
            person.get().setFirstName(personDto.getFirstName());
            person.get().setLastName(personDto.getLastName());
            person.get().setBirthDate(personDto.getBirthDate());
            personRepository.save(person.get());
            PersonDto personDtoResponse = personMapper.personToPersonDto(person.get());
            return new ApiResponse<>(personDtoResponse, HttpStatus.OK);
        }
        return new ApiResponse<>(null, HttpStatus.NOT_FOUND);
    }

    @Override
    public ApiResponse<PersonDto> delete(Long id) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            personRepository.delete(person.get());
            PersonDto responsePersonDto = personMapper.personToPersonDto(person.get());
            return new ApiResponse<>(responsePersonDto, HttpStatus.ACCEPTED);
        } else {
            return new ApiResponse<>("Could not find person with id " + id, null, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ApiResponse<PaginatedResponse<PersonDto>> getAllPersons(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Person> allPersons = personRepository.findAll(pageable);
        if (allPersons.getNumberOfElements() == 0) {
            return new ApiResponse<>(new PaginatedResponse<>(allPersons.getNumber(), allPersons.getSize(), allPersons.getNumberOfElements(),
                    new ArrayList<>(), allPersons.getTotalElements(), allPersons.getTotalPages()), HttpStatus.NOT_FOUND);
        }
        List<PersonDto> allEmployeeDto = new ArrayList<>();
        allPersons.getContent().forEach(person -> allEmployeeDto.add(personMapper.personToPersonDto(person)));
        return new ApiResponse<>(new PaginatedResponse<>(allPersons.getNumber(), allPersons.getSize(), allPersons.getNumberOfElements(),
                allEmployeeDto, allPersons.getTotalElements(), allPersons.getTotalPages()), HttpStatus.OK);
    }

    @Override
    public ApiResponse<PersonDto> getPersonById(Long id) {
        Person person = personRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        PersonDto personDto = personMapper.personToPersonDto(person);
        return new ApiResponse<>(personDto, HttpStatus.OK);
    }

}
