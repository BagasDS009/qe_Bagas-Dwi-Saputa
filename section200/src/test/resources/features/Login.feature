Feature: AS an user i want to see home page so that i can find books

   Scenario: As user, I have be able to success login
     Given I am on the login page
     When I input username
     And I input valid password
     And I click login button
     Then I am on the page home