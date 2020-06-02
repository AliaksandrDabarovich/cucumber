Feature: As a user I want to have ability to login to email


  Scenario: Login should be success
   When the user opens Email page
    When the user inputs Email and Password
    Then login is success

