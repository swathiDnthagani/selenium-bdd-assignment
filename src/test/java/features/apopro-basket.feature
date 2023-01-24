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

@basket
Feature: Add an item to Apopro basket and empty the basket

    This feature performs below operaions on Apopro website
    accepts the cookies
    add an item to basket
    verify added item in basket
    empty the basket

    @basket
    Scenario: As a user, I want to add an item to basket and empty the basket
    Given I open Apopro website
    And I accept all cookies
    When I browse an item "NAN EXPERTPRO HA 1"
    Then list of items should be displayed
    When I click on first item
    Then I should navigate to item info page
    When I click on Add to your basket
    Then product should be added to basket
    When I click on go to cart
    Then I should navigate to your shopping cart page
    When I remove items from basket
    Then basket should be empty