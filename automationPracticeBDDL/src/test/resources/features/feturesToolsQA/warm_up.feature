Feature: HTML form submission
User HTML form submission #notes about the feature

Scenario: As User I should be able to submit HTML form
Given User navigates tp TOOLS QA home page
When User click HTML form link
And User enters "Liliia" first name
And User enters "Kulish" last name
And User enters "USA" country
And User enters "Hello" subject
And User clicks submit button
Then User should see successful page

Scenario Outline: As User I should be able to submit HTML form
Given User navigates tp TOOLS QA home page
When User click HTML form link
And User enters "<first name>" first name
And User enters "<last name>" last name
And User enters "<country>" country
And User enters "<subject>" subject
And User clicks submit button
Then User should see successful page

Examples: users
|first name |last name|country|subject|
|Ninel      |Proskuryakova    |Ukraine|Hello  |
|Selcuk     |Once     |Turkey |Ola    |
|Emma       |Haug     |Usa    |Privet |


@sampleTable
Scenario: As an user I should be able to print all values from sample table
Given User navigates to""
When User is able to view Sample table
Then User should be able to print values to console