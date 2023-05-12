Feature: User SignUp
  As a new user
  I want to sign up for a new account
  So that I can access the platform

  Scenario: SignUp without click privacy button
    Given I am on the SignUp page
    When I enter my name as "John Doe"
    And I enter my email as "asdf61@yopmail.com"
    And I enter my MobileNumber as "9998887776"
    And I enter my password as "Abc@1234"
    And I click on the SignUp button
    Then I should see an Error message "Check T&C"