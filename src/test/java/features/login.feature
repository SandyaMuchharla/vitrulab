@login
Feature: Login to gmail

  Scenario: As a user I login to tours
    Given I am on "http://newtours.demoaut.com/"
    When I provide username as "sandy" and password as "sandy"
    Then I should be able to login to tours
    And I close the browser
