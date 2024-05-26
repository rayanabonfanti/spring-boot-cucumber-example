package cucumber.steps;

import cucumber.model.Person;
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

public class PersonRegistration {

    @Autowired
    private TestRestTemplate restTemplate;
    private ResponseEntity<Long> response;
    private Person mockedPerson;

    @Given("the user provides valid person details")
    public void theUserProvidesValidPersonDetails() {
        mockedPerson = FeatureUtils.getMockPerson();
    }

    @When("the user sends a POST request to {string}")
    public void theUserSendsAPostRequestTo(String path) {
        response = this.restTemplate.postForEntity(FeatureUtils.URL + path, mockedPerson, Long.class);
    }

    @Then("the response status code of person registration should be {int}")
    public void theResponseStatusCodeOfPersonRegistrationShouldBe(int statusCode) {
        assertEquals(HttpStatusCode.valueOf(statusCode), response.getStatusCode());
    }

    @And("the response body should contain the created person ID {long}")
    public void theResponseBodyShouldContainTheCreatedPersonID(long id) {
        assertEquals(id, response.getBody());
    }
}
