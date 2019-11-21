Feature: Contact us

@contactUs @smoketest
Scenario: User should able to contact

Given User clicks on Contact Us link
When User populates Contact Us form
And User Clicks on Send button
Then User should vie success message


