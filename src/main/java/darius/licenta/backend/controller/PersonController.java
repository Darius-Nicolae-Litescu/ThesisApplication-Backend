package darius.licenta.backend.controller;

import darius.licenta.backend.domain.sql.UserRole;
import darius.licenta.backend.dto.normal.person.PersonDto;
import darius.licenta.backend.dto.normal.position.CreatePositionDto;
import darius.licenta.backend.dto.normal.position.PositionDto;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.payload.response.PaginatedResponse;
import darius.licenta.backend.service.person.PersonService;
import darius.licenta.backend.service.position.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/pageable")
    @Secured({UserRole.Rank.ADMIN})
    public ApiResponse<PaginatedResponse<PersonDto>> getPersons(@RequestParam int page,
                                                                @RequestParam int size) {
        return personService.getAllPersons(page, size);
    }
}
