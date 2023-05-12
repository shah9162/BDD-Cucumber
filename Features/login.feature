Feature: Login
  As a registered user
  I want to log in with my user id and password
  So that I can access my account

  Scenario: Valid login
    Given I am on the login page
    When I enter my user id "3056shahnawaz@gmail.com" and password "Abc@12345"
    And I click on the login button
    Then I should be redirected to my account dashboard

  Scenario: Invalid login
    Given I am on the login page
    When I enter my user id "3056shahnawaz@gmail.com" and password "Abc@123"
    And I click on the login button
    Then I should see an error message "Invalid Password"
