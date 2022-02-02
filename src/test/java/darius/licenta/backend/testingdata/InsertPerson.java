package darius.licenta.backend.testingdata;
import darius.licenta.backend.domain.Employee;
import darius.licenta.backend.domain.Person;
import darius.licenta.backend.domain.Position;
import darius.licenta.backend.service.employee.EmployeeService;
import darius.licenta.backend.service.person.PersonService;

import java.util.Date;

public class InsertPerson {
    public static void InsertPersons(PersonService personService)
    {
       personService.insert(Persons.person1);
       personService.insert(Persons.person2);
       personService.insert(Persons.person3);
       personService.insert(Persons.person4);
       personService.insert(Persons.person5);

    }
}
