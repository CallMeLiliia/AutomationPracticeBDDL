$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src\\test\\resources\\features\\login.feature");
formatter.feature({
  "name": "Login",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "User login",
  "description": "",
  "keyword": "Background"
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
formatter.afterstep({
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
formatter.afterstep({
  "status": "passed"
});
formatter.scenario({
  "name": "User login validation with invalid credential",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@negative"
    },
    {
      "name": "@wip"
    }
  ]
});
formatter.step({
  "name": "User inputs  email, password, clicks sign in button and validate errore message",
  "rows": [
    {
      "cells": [
        "email",
        "password",
        "error message"
      ]
    },
    {
      "cells": [
        "abc213@mailinator.com",
        "invalid",
        "There is 1 error Authentication failed."
      ]
    },
    {
      "cells": [
        "invalid@gmail.com",
        "abc1234",
        "There is 1 error Authentication failed."
      ]
    },
    {
      "cells": [
        "invalid",
        "invalid",
        "There is 1 error Invalid email address."
      ]
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.user_inputs_email_password_clicks_sign_in_button_and_validate_errore_message(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});