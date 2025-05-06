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
Feature: User Login

  Background: User clicks sign up & login
    Given User is on the homepage
    When User click on Sign Up & Login from header

  @Positive
  Scenario: Successful login with valid credentials
    Given User is on the login page
    When User enters valid credentials email
    And User enters valid credentials password <"Test@123">
    And User clicks on Login button
    Then User should be redirected to the homepage

  @Negative
  Scenario: Failure login if entered invalid password
    Given User is on the login page
    When User enters invalid Password
    Then User should not be redirected to the homepage
    And Error message should be dispalyed
    And A failure toast message will be appeared

  @Negative
  Scenario: Failure login if entered invalid email
    Given User is on the login page
    When User enters invalid Email
    Then User should not be redirected to the homepage
    And Error message should be dispalyed

  @Negative
  Scenario: Try to login with blank credential
    Given User is on the login page
    When User not entered any credentials
    Then User should not be redirected to the homepage
    And Error message should be displayed on Email field in a Tool tip

  @Negative
  Scenario: Try to login with blank credential
    Given User is on the login page
    When User not entered password credentials
    And User enters valid email
    Then User should not be redirected to the homepage
    And Error message should be displayed on Password field in a Tool tip

  @Negative
  Scenario: Try to login with a email that is in wrong format
    Given User is on the login page
    When User entered email "<email123>"
    Then User should not be redirected to the homepage
    And Error message should be displayed on Email field in a Tool tip
