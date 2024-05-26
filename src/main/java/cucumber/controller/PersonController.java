package cucumber.controller;

import cucumber.model.Person;
import cucumber.service.PersonService;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/person")
    public Long createPerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable Long id) {
        return personService.getPerson(id);
    }

}
