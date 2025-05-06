#Author: Asif Mufti
#@UserRegistration
Feature: User Registration

  Background: User clicks sign up & login
    Given User is on the homepage
    When User click on Sign Up & Login from header

  @tag1
  Scenario: User try to complete registration step  by step
    Given User is on the login page
    When User enters Name <"Rahul M">
    And User enters email
    And User clicks on Sign Up button
    And User should be redirected to next page of registration
    And able to see other fields to be required to complete sign up
    And User selects radio button Mr.
    And User enters password <"Test@123">
    And User selcts DOB
    And Tick marked on newsletter
    And tick marked on offers subscrption
    And User enter first name <"Ron">
    And User enters last name <"Jr.">
    And User enters Company <"Al Nassr">
    And User enters address <"add1, Club1">
    And User enters address2 <"add2, Club2">
    And Country is selected as India
    And User enters State <"WB">
    And User enters city <"Calcutta">
    And User enters zipcode <"700001">
    And User enters mobile <"7000000001">
    And User clicked on Create Account button
    And User should be redirected to Account Created page
    And Able to see the confirmation page with texts
    And User clicked on Continue button
    Then User should be redirected to dashboard
    And Able to see Log Out in header menu
    And Able to see Delete Acount in header menu
    But Login/Sign Up is not there
