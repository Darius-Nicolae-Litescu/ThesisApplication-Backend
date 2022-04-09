package darius.licenta.backend.controller;

import darius.licenta.backend.domain.sql.UserRole;
import darius.licenta.backend.dto.normal.person.PersonDto;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.payload.response.PaginatedResponse;
import darius.licenta.backend.service.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
@CrossOrigin(origins = "http://localhost:3000")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @PostMapping("/")
    @Secured(UserRole.Rank.ADMIN)
    public ApiResponse<PersonDto> addPerson(@RequestBody PersonDto personDto) {
        return personService.insert(personDto);
    }

    @PutMapping("/")
    @Secured(UserRole.Rank.ADMIN)
    public ApiResponse<PersonDto> updatePerson(@RequestBody PersonDto personDto) {
        return personService.updatePerson(personDto);
    }

    @GetMapping("/{id}")
    @Secured({UserRole.Rank.ADMIN})
    public ApiResponse<PersonDto> getPersonById(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

    @DeleteMapping("/{id}")
    @Secured(UserRole.Rank.ADMIN)
    public ApiResponse<PersonDto> deletePersonById(@PathVariable Long id) {
        return personService.deleteById(id);
    }

    @GetMapping("/pageable")
    @Secured({UserRole.Rank.ADMIN})
    public ApiResponse<PaginatedResponse<PersonDto>> getPersons(@RequestParam int page,
                                                                @RequestParam int size) {
        return personService.getAllPersons(page, size);
    }
}
