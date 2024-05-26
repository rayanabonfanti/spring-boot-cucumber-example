package cucumber.steps;

import cucumber.model.Person;
import cucumber.repository.PersonRepository;
import cucumber.utils.FeatureUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonManagement {

    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private PersonRepository personRepository;
    private ResponseEntity<Person> response;
    private Person mockPerson;

    @Given("an existing person with ID {long}")
    public void anExistingPersonWithID(long id) {
        this.mockPerson = FeatureUtils.getMockPerson();
        this.personRepository.save(this.mockPerson);
    }

    @When("the user sends a GET request to {string}")
    public void theUserSendsAGetRequestTo(String path) {
        String url = String.format("%s/%s/%d", FeatureUtils.URL, path, mockPerson.getId());
        response = this.restTemplate.getForEntity(url, Person.class);
    }

    @Then("the response status code of getting an person should be {int}")
    public void theResponseStatusCodeOfGettingAPersonShouldBe(int statusCode) {
        assertEquals(HttpStatusCode.valueOf(statusCode), response.getStatusCode());
    }

    @And("the response body should contain the person details")
    public void theResponseBodyShouldContainThePersonDetails() {
        Person resPerson = response.getBody();
        assert resPerson != null;
        assertEquals(mockPerson.getId(), resPerson.getId());
        assertEquals(mockPerson.getUsername(), resPerson.getUsername());
        assertEquals(mockPerson.getPassword(), resPerson.getPassword());
        assertEquals(mockPerson.getFullName(), resPerson.getFullName());
    }
}
