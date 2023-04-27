#Author: kirankumar
@Get_Portal_User_Details
Feature: This is for Users in UserManagement

  Background:
    Given User login as admin
    And User credentials getting for testdata
      | UserFirstName | UserLastName |
      | test          | user         |

  @tag1
  Scenario: Validating the add user details in edit user page
    When User open repository
    And User click on burger menu
    And User click "User and License Management" under portal settings
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User click Make user as a admin
    And User click on "Save"
    And User open (user 1)
    Then Validate the user details in edit user page (user 1) (row 34) "TC01 Click on View Details and check if the user details are displaying properly"

  @tag2
  Scenario: Validating the add ADuser details in edit user page
    When User open repository
    And User click on burger menu
    And User click "User and License Management" under portal settings
    And User click on "Add User"
    And User click on "Add Active Directory User"
    And Select the active directory domain
    And User click on "Users" under browser
    And Select the user by search in advanced search ("AD119737")
    And User click on "Add Users"
    And User click on burger menu
    And User click "User and License Management" under portal settings
    And User open (user "AD119737")
    Then Validate the user details in edit user page (user "AD119737") (row 35) "TC02 Click on View Details and check if the ADuser details are displaying properly."

  @tag3
  Scenario: Validating the add SAMLuser details in edit user page
    When Logout the user
    And User login with sso
    And Logout the user
    And User login as admin
    And User click on burger menu
    And User click "User and License Management" under portal settings
    And User open (user "kiran kumar")
    Then Validate the SMALuser details in edit user page (user "kiran kumar") (row 36) "TC03 Click on View Details and check if the SAMLuser details are displaying properly."