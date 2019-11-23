Feature: Login

  # some text regarding you featere file
  # And new feature validation
  # Steps key words
  #Given, When,And, But, Then
  Background: User login
    Given User navigates to home page
    When User user clicks on sign in link

  @login @smoketest
  Scenario: User Login Validation
    And User inputs  email and password
    And User clicks sign in button
    Then User is on account page

  Scenario: User login validation with invalid credential
    And User inputs "invalid" email  and "invalid" password
    And User clicks sign in button
    Then User should see error message "There is 1 error"

  @negative @multipleExamples
  Scenario Outline: User login validation with invalid credential
    And User inputs "<email>" email  and "<password>" password
    And User clicks sign in button
    Then User should see error message "<error message>"

    Examples: credentionals
      | email                 | password | error message                           |
      | abc213@mailinator.com | invalid  | There is 1 error Authentication failed. |
      | invalid@gmail.com     | abc1234  | There is 1 error Authentication failed. |
      | invalid               | invalid  | There is 1 error Invalid email address. |

  @negative @wip
  Scenario: User login validation with invalid credential
    Then User inputs  email, password, clicks sign in button and validate errore message
    
      | email                 | password | error message                           |
      | abc213@mailinator.com | invalid  | There is 1 error Authentication failed. |
      | invalid@gmail.com     | abc1234  | There is 1 error Authentication failed. |
      | invalid               | invalid  | There is 1 error Invalid email address. |
