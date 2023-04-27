#Author: kirankumar
@Update_Added_User_Details
Feature: This is for Users in UserManagement

  Background:
    Given User login as admin
    And User credentials getting for testdata
      | UserFirstName | UserLastName |
      | test          | user         |

  @tag1
  Scenario: TC01 TC02 Update First name of user and check whether it is updated properly
    When User click on burger menu
    And User click "User and License Management" under portal settings
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User click on "Save"
    And User click edit on actions respective (user 1)
    Then Validate the respective edit user page is displayed (row 57) "TC01 Check on clicking the edit button in action column, the user should be redirected to the edit page"
    And User update the "First Name" ("test1")
    And User click on "Save"
    Then Validate firstname is updated in user list and user profile (user 1)
    And Logout the user
    And Login the added user (registeredUser 1)
    And Open my profile
    Then Validate firstname is updated in user profile ("test1") (row 58) "TC02 Update First name of user and check whether it is updated properly"


  @tag2
  Scenario: TC03 Update Last name of user and check whether it is updated properly
    When User click on burger menu
    And User click "User and License Management" under portal settings
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User click on "Save"
    And User click edit on actions respective (user 1)
    And User update the "Last Name" ("test1")
    And User click on "Save"
    Then Validate lastname is updated in user list and user profile (user 1)
    And Logout the user
    And Login the added user (registeredUser 1)
    And Open my profile
    Then Validate lastname is updated in user profile ("test1") (row 59) "TC03 Update Last name of user and check whether it is updated properly"
    And Logout the user
    And User login as admin

  @tag3
  Scenario: TC04 TC05 Update mail of user and check whether it is updated properly
    When User click on burger menu
    And User click "User and License Management" under portal settings
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User click on "Save"
    And User click edit on actions respective (user 1)
    And User update the "Email" ("testuser2@mail.com")
    And User click on "Save"
    Then Validate email is updated in user list (user 1) (update "testuser2@mail.com") (row 60) "TC04 Update mail of user and check whether it is updated properly"
    And Logout the user
    Then Validate the user can able to login (user 2) (row 61) "TC05 Check whether the user can able to login with updated mail"
    And User login as admin

  @tag4
  Scenario: TC06 Update status of user and check whether it is updated properly
    When User click on burger menu
    And User click "User and License Management" under portal settings
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User click on "Save"
    And User click edit on actions respective (user 1)
    And User update user status to "Inactive"
    And User click on "Save"
    Then Validate status is updated in user list (user 1) (status "Inactive") (row 62) "TC06 Update status of user and check whether it is updated properly"

  @tag5
  Scenario: TC07 Check if the user can edit the non-editable fields
    When User click on burger menu
    And User click "User and License Management" under portal settings
    And User click on "Add User"
    And Add the AD user (user "AD119737")
    And User click on burger menu
    And User click "User and License Management" under portal settings
    And User click edit on actions respective (user "AD119737")
    Then Validate the ADuser non-editable fields properly disabled "First Name" "Last Name" "Email" (row 63) "TC07 Check if the user can edit the non-editable fields"

  @tag6
  Scenario: TC08 Update role of user and check whether it is updated properly
    When User click on burger menu
    And User click "User and License Management" under portal settings
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User click on "Save"
    And User click edit on actions respective (user 1)
    And User update user role to "admin"
    And User click on "Save"
    Then Validate role is updated in user list (user 1) (role "Prolaborate Admin") (row 64) "TC08 Update role of user and check whether it is updated properly"

  @tag7
  Scenario: TC08 Update temporary password of user and check whether it is updated properly
    When User click on burger menu
    And User click "User and License Management" under portal settings
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User click on "Save"
    And User update the set temporary password of (user 1) (tempPassword "Welcome@321")
    Then Validate the PB alert message for successful set password
    And Logout the user
    Then Validate the user can able to login by temporary password (user 1) (tempPassword "Welcome@321") (row 65) "TC08 Update temporary password of user and check whether it is updated properly"
    And User login as admin