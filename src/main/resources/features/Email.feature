Feature: As a user I want to have ability to send email from draft

  Background:
    When the user opens Email page
    When the user inputs Email and Password

  @smoke
  Scenario: Login should be success
    Then login is success

  @smoke
  Scenario: Draft should be saved
    When the user opens Compose Email
    When the user opens Email page after composing
    When the user opens Drafts page
    Then draft is saved

  @smoke
  Scenario: Body should be correct
    When the user opens Compose Email
    When the user opens Email page after composing
    When the user opens Drafts page
    When the user opens Draft Email page
    Then body is correct

  @smoke
  Scenario: To should be correct
    When the user opens Compose Email
    When the user opens Email page after composing
    When the user opens Drafts page
    When the user opens Draft Email page
    Then To is correct

  @smoke
  Scenario: Subject should be correct
    When the user opens Compose Email
    When the user opens Email page after composing
    When the user opens Drafts page
    When the user opens Draft Email page
    Then subject is correct

  @smoke
  Scenario: Draft should be sent
    When the user opens Compose Email
    When the user opens Email page after composing
    When the user opens Drafts page
    When the user opens Draft Email page
    When the user sends Draft
    When the user closes Advertising page
    Then draft is sent

  @smoke
  Scenario: Email should be sent
    When the user opens Compose Email
    When the user opens Email page after composing
    When the user opens Drafts page
    When the user opens Draft Email page
    When the user sends Draft
    When the user closes Advertising page
    When the user opens Send Email page Advertising page
    Then email is sent


