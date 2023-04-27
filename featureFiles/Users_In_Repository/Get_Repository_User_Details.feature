#Author: kirankumar
@Get_Repository_User_Details
Feature: This is for Add Users in Repository

  Background:
    Given User login as admin
    And User credentials getting for testdata
      | UserFirstName | UserLastName |
      | test          | user         |

  @tag1
  Scenario: TC01 Check if the dashboard choosed while adding the user is visible under Default Dashboard label dashboard
    Given User open repository "TC01 Check if the dashboard choosed while adding the user is visible under Default Dashboard label dashboard"
    When User click on burger menu
    And User click dashboards under repository configuration
    And User create dashboard "testDashboard"
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the valid user credentials with demodashboard
    And User click save
    And User open edit user page
    Then Choosed dashboard should be show under default dashboard
    And Delete the dashboard


  @tag2
  Scenario: TC02 Check if the Prolaborate Start here dashboard is shown under Default Dashboard label when the user added without any deault dashboard
    Given User open repository "TC02 Check if the Prolaborate Start here dashboard is shown under Default Dashboard label when the user added without any deault dashboard"
    When User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the user credentials without default dashboard
    And User click save
    And User open edit user page
    Then Default dashboard should be show under default dashboard


  @tag5
  Scenario: TC05 Check if the Time Zone is by default showing as (UTC) Coordinate Universal Time
    Given User open repository "TC05 Check if the Time Zone is by default showing as (UTC) Coordinate Universal Time"
    When User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the user credentials without default dashboard
    And User click save
    And User open edit user page
    Then Default time zone should be shown under the time zone


  @tag6
  Scenario: TC06 TC07 TC08 Check if the Email ID , First Name and Last Name of the user is Properly visible
    Given User open repository "TC06 TC07 TC08 Check if the Email ID , First Name and Last Name of the user is Properly visible"
    When User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the user credentials without default dashboard
    And User click save
    And User open edit user page
    Then Email ID , First Name and Last Name of the user should be visible