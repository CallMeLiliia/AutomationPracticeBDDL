$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src\\test\\resources\\features\\login.feature");
formatter.feature({
  "name": "Login",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "User login validation with invalid credential",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@negative"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User navigates to home page",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginSteps.userNavigatesToHomePage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User user clicks on sign in link",
  "keyword": "When "
});
formatter.match({
  "location": "HomeSteps.user_user_clicks_on_sign_in_link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User inputs \"\" and \"\"",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User clicks sign in button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.user_clicks_sign_in_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User should see error message",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.after({
  "status": "passed"
});
});