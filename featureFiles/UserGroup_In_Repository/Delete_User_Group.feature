#Author: kirankumar
@Delete_User_Group
Feature: This is for UserGroup in Repository

  Background:
    Given User login as admin
    When User click prolaborate logo
    And User credentials getting for testdata
      | UserFirstName | UserLastName |
      | test          | user         |


  @tag1
  Scenario: Checking delete confirmation popup

    When User open repository
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test1"
    And User click on "Save"
    And User click on delete in more-options (groupName "Test1")
    Then Validate the administrator group not deletable (row 79) "TC10 Check if we are not allowed to delete the Administrator group"
    Then Validate the default group not deletable (row 78) "TC09 Check if we are not allowed to delete the default group"
    Then Validate the confirmation popup is displayed (row 70) "TC01 Check if the delete confirmation popup comes when we Click on Delete Group icon of the group"
    Then Validate the confirmation popup message (row 71) "TC02 Check if the Proper warning message is shown in the delete confirmation popup"
    And User clicked delete in the delete confirmation popup
    Then Validate the PB alert message (row 73) "TC04 Check if the successfully deleted message is shown in the Pb-alert"
    Then Validate the group is deleted when we Click on Delete (groupName "Test1") (row 72) "TC03 Check if the groups is deleted when we Click on Delete button in confirmation popup"

  @tag2
  Scenario: Checking deleted groups access permissions

    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the user credentials (userNo 2)
    And User click on "Save"
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test2"
    And User add the users in group (registeredUser 2)
    And User click on "Save"
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User select redio button of "Customized Access"
    And User select repository browser
    And User add access user or usergroup to the repository browser "Test2"
    And User click on "Add" (indexValue is 2)
    And Logout the user
    And Login the added user (registeredUser 2)
    And User open repository
    Then Validate assigned repository browaer should be shown
    And Logout the user
    And User login as admin
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on delete in more-options (groupName "Test2")
    And User clicked delete in the delete confirmation popup
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User select redio button of "Customized Access"
    And User select repository browser
    Then Validate deleted group is not shown in access permission page (groupName "Test2") (row 76) "TC07 Check if the Access applied on that group should not be visible in the Access Permmissions (ACL ON)"
    Then Validate deleted group is not shown in access permission page user list dropdown (groupName "Test2") (row 75) "TC06 Check if the deleted group is not shown in the Access Permissions User Groups list"
    And Logout the user
    And Login the added user (registeredUser 2)
    And User click on burger menu
    Then Validate assigned repository browser should not be shown  (row 74) "TC05 Check if the access applied to the group is removed for the users in that group"
    And Logout the user
    And User login as admin


  @tag3
  Scenario: checking deleted groups features set

    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the user credentials (userNo 3)
    And User click on "Save"
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test3"
    And User assigned all features to the user group
    And User add the users in group (registeredUser 3)
    And User click on "Save"
    And Logout the user
    And Login the added user (registeredUser 3)
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    Then Assigned all feature should be shown in menu in user account (row 77) "All features should be shown in menu in user account"
    And Logout the user
    And User login as admin
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on delete in more-options (groupName "Test3")
    And User clicked delete in the delete confirmation popup
    And Logout the user
    And Login the added user (registeredUser 3)
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    Then Feature should be shown in menu in user account (row 77) "TC08 Check if the feature set selected in the User Group is removed for the users, once the group is deleted"
