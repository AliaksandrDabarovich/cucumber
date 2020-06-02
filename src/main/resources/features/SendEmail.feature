Feature: As a user I want to send email

  @smoke
  Scenario: Email should be sent
    When the user opens Email page
    When the user inputs Email and Password
    When the user opens Compose Email
    When the user opens Email page after composing
    When the user opens Drafts page
    When the user opens Draft Email page
    When the user sends Draft
    When the user opens Draft after sending Draft
    When the user opens closes Advertising page
    When the user opens Send Email page Advertising page
    Then email is sent