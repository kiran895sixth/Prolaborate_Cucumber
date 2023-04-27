#Author: kirankumar
@List_Repository_Users
Feature: This is for Add Users in Repository

  Background:
    Given User login as admin
    And User credentials getting for testdata
      | UserFirstName | UserLastName |
      | test          | user         |


  @tag1
  Scenario: TC01 TC02 Check if the added users name and email is Properly showing in the list
    Given User open repository "TC01 TC02 Check if the added users name and email is Properly showing in the list"
    When User click on burger menu
    And User click users under repository configuration
    And User click add user
    And User enter the user credentials without default dashboard
    And User click save
    Then User name and email should be shown in list


  @tag3
  Scenario: TC03 Check if the Type shows Registered User when the system user is non admin
    Given User open repository "TC03 Check if the Type shows Registered User when the system user is non admin"
    When User click on burger menu
    And User click users under repository configuration
    And User click add user
    And User enter the valid admin user credentials
    And User click save
    Then User type should be shown registered user
    And Delete the admin user

  @tag4
  Scenario: TC04 Check if the Type shows Prolaborate Admin for the user with admin role
    Given User open repository "TC04 Check if the Type shows Prolaborate Admin for the user with admin role"
    When User click on burger menu
    And User click users under repository configuration
    And User click add user
    And User enter the valid admin user credentials
    And User click save
    And Make user as admin
    And User click prolaborate logo
    And User open repository
    And User click on burger menu
    And User click users under repository configuration
    Then User type should be shown prolaborate admin
    And Delete the admin user

  @tag5
  Scenario: TC05 Check if the Type shows Active Directory User for the AD user
    Given User open repository "TC05 Check if the Type shows Active Directory User for the AD user"
    When User click on burger menu
    And User click users under repository configuration
    And User click add user
    And Add the AD user
    And User click on burger menu
    And User click users under repository configuration
    Then ADuser type should be shown active directory user
    And Delete the ADuser

  @tag6
  Scenario: TC06 Check if the Type shows Active Directory Group User when the AD group user is added
    Given User open repository "TC06 Check if the Type shows Active Directory Group User when the AD group user is added"
    When User click on burger menu
    And User click users under repository configuration
    And User click add user
    And Add the AD group
    And Logout the user
    And Login ADgroup user
    #And Logout the user
    And User login as admin
    And User click prolaborate logo
    And User open repository
    And User click on burger menu
    And User click users under repository configuration
    Then ADgroupuser type should be shown active directory group user
    And Delete the ADgroupuser

  @tag8
  Scenario: TC08 Check if the Status is showing as Active for the active users
    Given User open repository "TC08 Check if the Status is showing as Active for the active users"
    When User click on burger menu
    And User click users under repository configuration
    And User click add user
    And User enter the valid admin user credentials
    And User click save
    Then User status should be shown active
    And Delete the admin user

  @tag7
  Scenario: TC07 Check if the Type shows Identity User if the SSO user is added
    Given User open repository "TC07 Check if the Type shows Identity User if the SSO user is added"
    And Logout the user
    When User login with sso
    And Logout the user
    And User login as admin
    And User click prolaborate logo
    And User open repository
    And User click on burger menu
    And User click users under repository configuration
    Then Sso type should be shown Identity Provider User
    And Delete the sso user

  @tag9
  Scenario: TC09 Check if the Status is showing as Inactive for the inactive users
    Given User open repository "TC09 Check if the Status is showing as Inactive for the inactive users"
    When User click on burger menu
    And User click users under repository configuration
    And User click add user
    And User enter the valid admin user credentials
    And Make user as inactive
    And User click save
    Then User status should be shown inactive
    And Delete the admin user