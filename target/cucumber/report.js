$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/login.feature");
formatter.feature({
  "name": "Login to gmail",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@login"
    }
  ]
});
formatter.scenario({
  "name": "As a user I login to tours",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@login"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on \"http://newtours.demoaut.com/\"",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginStepDefs.iAmOn(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I provide username as \"sandy\" and password as \"sandy\"",
  "keyword": "When "
});
formatter.match({
  "location": "LoginStepDefs.iProvideUsernameAsAndPasswordAs(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should be able to login to tours",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDefs.iShouldBeAbleToLoginToTours()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I close the browser",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepDefs.iCloseTheBrowser()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});