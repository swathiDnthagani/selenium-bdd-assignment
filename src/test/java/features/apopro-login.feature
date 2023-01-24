#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template



@login
Feature: Apopro login feature
  I want to validate login functionality of Apopro

  @login @success
  Scenario: As a user, I want to validate Apopro successful login
    Given I open Apopro website
    And I accept all cookies
    When I click on login CTA
    And I login with valid credentials
    Then I should see successful login

  @login @failure @invalid
  Scenario Outline: As a user, I want to validate Apopro unsuccessful login
    Given I open Apopro website
    And I accept all cookies
    When I click on login CTA
    And login with username as "<username>" and password as "<password>"
    Then I should see the "<errorMessage>"

    Examples: 
      | username              | password        | errorMessage                                                                                                                                                              |
      | validuser@email.com   | invalidpassword | tilsendt en ny adgangskode eller til at oprette en profil. |
      | invaliduser@email.com | validpassword   | tilsendt en ny adgangskode eller til at oprette en profil. |


  @login @failure
  Scenario: As a user, I want to validate Field level error messagess for login with empty username and password
    Given I open Apopro website
    And I accept all cookies
    When I click on login CTA
    And login with username as "" and password as ""
    Then I should see field specific error messages