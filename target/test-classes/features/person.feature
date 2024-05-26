Feature: Person Registration

  Scenario: Register a person
    Given the user provides valid person details
    When the user sends a POST request to "/person"
    Then the response status code of person registration should be 200
    And the response body should contain the created person ID 1

  Scenario: Get an existing person
    Given an existing person with ID 1
    When the user sends a GET request to "/person"
    Then the response status code of getting an person should be 200
    And the response body should contain the person details
