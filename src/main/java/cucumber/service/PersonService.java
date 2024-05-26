package cucumber.service;

import org.springframework.stereotype.Service;
import cucumber.model.Person;
import cucumber.repository.PersonRepository;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Long savePerson(Person person) {
        return personRepository.save(person).getId();
    }

    public Person getPerson(Long id) {
        return personRepository.findById(id).orElse(null);
    }
}
