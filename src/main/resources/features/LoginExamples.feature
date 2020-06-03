Feature: As a user I want to have ability to login with different credentials
@first
Scenario Outline: Login should be success with examples
When the user opens Email page
When the user inputs different parameters <email> and <password>
Then login is success

Examples:
| email | password |
| aliaksandr.yarkiy@mail.ru | obuchenie2015 |