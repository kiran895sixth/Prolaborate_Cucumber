#Author: kirankumar
@Delete_Portal_User

Feature: This is for Users in UserManagement

  Background:
    Given User login as admin
    And User credentials getting for testdata
      | UserFirstName | UserLastName |
      | test          | user         |

  @tag1
  Scenario: TC01 Delete the user from portal user management and check whether it is fully deleted from the Prolaborate application are not
    When User open repository
    And User click on burger menu
    And User click "User and License Management" under portal settings
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User click on "Save"
    And Delete the user from the portal (user 1)
    Then Validate user is deleted from the Prolaborate application are not (user 1) (row 26) "TC01 Delete the user from portal user management and check whether it is fully deleted from the Prolaborate application are not"

  @tag2
  Scenario: TC02 Delete the user from the portal user management and check if the confirmation model window occurs or not
    When User open repository
    And User click on burger menu
    And User click "User and License Management" under portal settings
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User click on "Save"
    And User click on delete in more-options (user 1)
    Then Validate the configuration model window is displayed (row 27) "TC02 Delete the user from the portal user management and check if the confirmation model window occurs or not"

  @tag3
  Scenario: TC03 Check if the user is removed from the Access Permissions users list
    When User open repository
    And User click on burger menu
    And User click "User and License Management" under portal settings
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User select repository membership "demoprofile"
    And User click on "Save"
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User select redio button of "Customized Access"
    And User select repository browser
    Then Added user should be shown in dropdown (user 1)
    And User click on burger menu
    And User click "User and License Management" under portal settings
    And Delete the user from the portal (user 1)
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User select redio button of "Customized Access"
    And User select repository browser
    Then Validate the user is removed from the dropdown (user 1) (row 70) "TC03 Check if the user is removed from the Access Permissions users list"

  @tag4
  Scenario: TC04 Check if the user is removed from the User Group
    When User open repository
    And User click on burger menu
    And User click "User and License Management" under portal settings
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User select repository membership "demoprofile"
    And User click on "Save"
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test3"
    And User add the users in group (registeredUser 1)
    And User click on "Save"
    And User click on burger menu
    And User click "User and License Management" under portal settings
    And Delete the user from the portal (user 1)
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User open "Test3" group
    Then Validate the user is not shown in user group users list (user 1) (row 71) "TC04 Check if the user is removed from the User Group"


  @tag5
  Scenario: TC05 Check if the user is removed from the existing Review
    When User open repository
    And User click on burger menu
    And User click "User and License Management" under portal settings
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User select repository membership "demoprofile"
    And User click on "Save"
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    And User click "Reviews" under repository configuration
    And User create one review with added user (user 1) (review "Test")
    And User click on burger menu
    And User click "User and License Management" under portal settings
    And Delete the user from the portal (user 1)
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    And User click "Reviews" under repository configuration
    And User open "Test" review
    Then Validate the user is removed frome the review (user 1) (row 72) "TC05 Check if the user is removed from the existing Review"


  @tag6
  Scenario: TC06 Check if we are abe to delete multiple users from the portal
    When User open repository
    And User click on burger menu
    And User click "User and License Management" under portal settings
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User click on "Save"
    And User click on "Add User"
    And User enter the user credentials (userNo 2)
    And User click on "Save"
    And Delete the multiple user from the portal (user 1) (user 2)
    Then Validate user is deleted from the Prolaborate application are not (user 1) (user 2) (row 73) "TC06 Check if we are abe to delete multiple users from the portal"

  @tag7
  Scenario: TC07 Check if a admin user can delete another admin user in the portal
    When User open repository
    And User click on burger menu
    And User click "User and License Management" under portal settings
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User click Make user as a admin
    And User click on "Save"
    And User click on "Add User"
    And User enter the user credentials (userNo 2)
    And User click Make user as a admin
    And User click on "Save"
    And Logout the user
    And Login the added user (registeredUser 1)
    And User click on burger menu
    And User click "User and License Management" under portal settings
    Then Validate user can able to delete the another admin user (user 2) (row 74) "TC07 Check if a admin user can delete another admin user in the portal"
    And Logout the user
    And User login as admin