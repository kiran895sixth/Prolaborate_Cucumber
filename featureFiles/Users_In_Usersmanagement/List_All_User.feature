#Author: kirankumar
@List_All_User
Feature: This is for Users in UserManagement

  Background:
    Given User login as admin
    And User credentials getting for testdata
      | UserFirstName | UserLastName |
      | test          | user         |

  @tag1
  Scenario: TC01 Check if the added registered user listed properly with email,username,type,license type,status
    When User click on burger menu
    And User click "User and License Management" under portal settings
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User click on "Save"
    Then Validate the registereduser details in user list page (user 1) (row 48) "TC01 Check if the added registered user listed properly with email,username,type,license type,status"

  @tag2
  Scenario: TC02 Check if the added admin user listed properly with email,username,type,license type,status
    When User click on burger menu
    And User click "User and License Management" under portal settings
    And User click on "Add User"
    And User enter the user credentials (userNo 2)
    And User click Make user as a admin
    And User click on "Save"
    Then Validate the adminuser details in user list page (user 2) (row 49) "TC02 Check if the added admin user listed properly with email,username,type,license type,status"


  @tag3
  Scenario: TC03 Check if the added ADuser listed properly with email,username,type,license type,status
    When User click on burger menu
    And User click "User and License Management" under portal settings
    And User click on "Add User"
    And Add the AD user (user "AD119737")
    And User click on burger menu
    And User click "User and License Management" under portal settings
    Then Validate the ADuser details in user list page (user "AD119737") (row 50) "TC03 Check if the added ADuser listed properly with email,username,type,license type,status"

  @tag4
  Scenario: TC04 Check if the added ADgroupuser listed properly with email,username,type,license type,status
    When User click on burger menu
    And User click "User and License Management" under portal settings
    And User click on "Add User"
    And Add the AD group (group "kiran_Automation")
    And Logout the user
    And User login ADgroupUserOrADuser (ADgroupUserOrADuser "kiran")
    And Logout the user
    And User login as admin
    And User click on burger menu
    And User click "User and License Management" under portal settings
    Then Validate the ADgroupuser details in user list page (user "kiran") (row 51) "TC04 Check if the added ADgroupuser listed properly with email,username,type,license type,status"


  @tag5
  Scenario: TC05 Check if the added SAMLuser listed properly with email,username,type,license type,status
    When Logout the user
    And User login with sso
    And Logout the user
    And User login as admin
    And User click on burger menu
    And User click "User and License Management" under portal settings
    Then Validate the SAMLuser details in user list page (user "kiran kumar") (row 52) "TC05 Check if the added SAMLuser listed properly with email,username,type,license type,status"

