#Author: Vikrant Patil
#Keywords Summary : Feature file for all user related scenarios

@Smoke
Feature: User
  As a user I want to verify user related scenarios

  @tag1
  Scenario: As a user I want to verify registartion
    Given user opens the app
    When user accepts the terms and condition
    Then user is navigated to signup page
    When user fill the registartion details with $<vendorId> $<city>
    And user click on register button
    Then user is on home page
    Examples: 
    | vendorId | city |
    | 3        | pune |
  
  #@tag1
  #Scenario: As a user I want to verify login
    #Given user opens the app
    #When user accepts the terms and condition
    #Then user is navigated to signup page
    #When user click on already have account
    #And user enters mobile number
    #And user clicks on signin button
    #Then user is logged in
    #Examples: 
    #| vendorId |
    #| 3     |
