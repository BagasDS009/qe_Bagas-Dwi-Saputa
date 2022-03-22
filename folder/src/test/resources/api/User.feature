Feature: AS an admin, i want to see list of user so that i can create new user

  Scenario: Get admin i have be able to get detail user
    Given I set get api endpoint
    When I send get http request
    Then I receive valid http response code 200
    And I receive valid data for detail user

  Scenario: Post admin i have be able to create new user
    Given I set post api endpoint
    When I send post http request
    Then I receive valid http response code 201
    And I receive valid data for new user