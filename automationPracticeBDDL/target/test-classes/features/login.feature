Feature: Login
# some text regarding you featere file
# And new feature validation
 
 # Steps key words
 #Given, When,And, But, Then

Scenario: Validate user login
 Given User navigates to home page
 When User user clicks on sign in link
 And User inputs  email and password
 And User clicks sign in button
 Then User is on account page

