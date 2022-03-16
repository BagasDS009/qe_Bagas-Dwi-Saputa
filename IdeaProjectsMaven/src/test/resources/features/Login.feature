Feature: Login
  As a user
  I want to se my home page
  So that I can update my profile

  Scenario: As user i have able to success login
    Given I as on the login page
    When I enter my username and password correctly
    And I click login button
    Then I am on the home page