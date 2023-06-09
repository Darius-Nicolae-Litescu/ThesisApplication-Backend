package darius.licenta.backend.testingdata;

import darius.licenta.backend.service.employee.EmployeeService;
import darius.licenta.backend.service.person.PersonService;
import darius.licenta.backend.service.position.PositionService;
import darius.licenta.backend.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TestingData implements ApplicationRunner {

    private final PersonService personService;

    private final UserService userService;


    private final PositionService positionService;

    private final EmployeeService employeeService;

    @Autowired
    public TestingData(PersonService personService, UserService userService, PositionService positionService, EmployeeService employeeService) {
        this.personService = personService;
        this.userService = userService;
        this.positionService = positionService;
        this.employeeService = employeeService;
    }

    public void run(ApplicationArguments args) {
        InsertPositions.InsertPositions(positionService);
        InsertPerson.InsertPersons(personService);
        InsertEmployees.InsertEmployess(employeeService);

    }

    void insertPersonData() {

    }
}