Feature: As a user I want to have ability to login to email

 @smoke
  Scenario: Login should be successfull
   When the user opens Email page
    When the user inputs Email and Password
    Then login is successfull

