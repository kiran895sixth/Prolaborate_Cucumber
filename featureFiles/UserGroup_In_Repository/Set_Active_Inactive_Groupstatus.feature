#Author: kirankumar
@Set_Active_Inactive_Groupstatus
Feature: This is for UserGroup in Repository

  Background:
    Given User login as admin
    When User click prolaborate logo
    And User credentials getting for testdata
      | UserFirstName | UserLastName |
      | test          | user         |


  @tag1
  Scenario: TC01 Check  if we are able to craete the group as Inactive

    When User open repository
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test1"
    And User click on status toggle
    And User click on "Save"
    Then Validate status of the group is shown properly (status "Inactive") (groupname "Test1") (row 97) "TC01 Check  if we are able to craete the group as Inactive"

  @tag2
  Scenario: TC02 Check if the Group is made inactive, the menus based on the selected features should not be visible to the registered users

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
    And User assigned all features to the user group
    And User add the users in group (registeredUser 2)
    And User click on "Save"
    And Logout the user
    And Login the added user (registeredUser 2)
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    Then Assigned all feature should be shown in menu in user account (row 98) "Features should be shown in menu in user account"
    And Logout the user
    And User login as admin
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User open "Test2" group
    And User click on status toggle
    And User click on "Save"
    And Logout the user
    And Login the added user (registeredUser 2)
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    Then Features should not be shown in menu in user account (row 98) "TC02 Check if the Group is made inactive, the menus based on the selected features should not be visible to the registered users"
    And Logout the user
    And User login as admin


  @tag3
  Scenario: TC03 Check if the group is inactive, then access permissions applied on that group is not applied to the Registered user

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
    And User add the users in group (registeredUser 3)
    And User click on "Save"
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User select redio button of "Customized Access"
    And User select repository browser
    And User add access user or usergroup to the repository browser "Test3"
    And User click on "Add" (indexValue is 2)
    And Logout the user
    And Login the added user (registeredUser 3)
    And User open repository
    Then Validate assigned repository browaer should be shown
    And Logout the user
    And User login as admin
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User open "Test3" group
    And User click on status toggle
    And User click on "Save"
    And Logout the user
    And Login the added user (registeredUser 3)
    Then Validate assigned repository browser should not be shown  (row 99) "TC03 Check if the group is inactive, then access permissions applied on that group is not applied to the Registered user"
    And Logout the user
    And User login as admin

  @tag4
  Scenario: TC04 Check if the group is made inactive, then the selected feature's menu is not visible to the user of AD Group in that user group

    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And Add the AD group
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test4"
    And User assigned all features to the user group
    And User click on status toggle
    And User add the users in group (ADgroup "shgroup")
    And User click on "Save"
    And Logout the user
    And User login ADgroupUserOrADuser (ADgroupUserOrADuser "sh11")
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    Then Features should not be shown in menu in user account (row 100) "TC04 Check if the group is made inactive, then the selected feature's menu is not visible to the user of AD Group in that user group"
    And Logout the user
    And User login as admin


  @tag5
  Scenario: Checking Inactive Group access permissions and feature set permissions for AD user

    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And Add the AD user
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test5"
    And User add the users in group (ADuser "AD1002")
    And User assigned all features to the user group
    And User click on "Save"
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User select redio button of "Customized Access"
    And User select repository browser
    And User add access user or usergroup to the repository browser "Test5"
    And User click on "Add" (indexValue is 2)
    And Logout the user
    And User login ADgroupUserOrADuser (ADgroupUserOrADuser "AD1002")
    And User open repository
    Then Validate assigned repository browaer should be shown
    And User click on burger menu
    Then Assigned all feature should be shown in menu in user account (row 101) "Features should be shown in menu in user account"
    And Logout the user
    And User login as admin
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User open "Test5" group
    And User click on status toggle
    And User click on "Save"
    And Logout the user
    And User login ADgroupUserOrADuser (ADgroupUserOrADuser "AD1002")
    Then Validate assigned repository browser should not be shown  (row 104) "TC08 Check if the group is inactive, then access permissions applied on that group is not applied to the AD user"
    And User click on burger menu
    Then Features should not be shown in menu in user account (row 101) "TC05 Check if the Group is made inactive, the menus based on the selected features should not be visible to the AD users"
    And Logout the user
    And User login as admin


  @tag6
  Scenario: Checking Inactive Group access permissions and feature set permissions for SAML user

    When Logout the user
    And User login with sso
    And Logout the user
    And User login as admin
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test6"
    And User add the users in group (SAMLuser "kiran kumar")
    And User assigned all features to the user group
    And User click on "Save"
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User select redio button of "Customized Access"
    And User select repository browser
    And User add access user or usergroup to the repository browser "Test6"
    And User click on "Add" (indexValue is 2)
    And Logout the user
    And User login with sso
    And User open repository
    Then Validate assigned repository browaer should be shown
    And User click on burger menu
    Then Assigned all feature should be shown in menu in user account (row 102) "Features should be shown in menu in user account"
    And Logout the user
    And User login as admin
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User open "Test6" group
    And User click on status toggle
    And User click on "Save"
    And Logout the user
    And User login with sso
    Then Validate assigned repository browser should not be shown  (row 103) "TC08 Check if the group is inactive, then access permissions applied on that group is not applied to the AD user"
    And User click on burger menu
    Then Features should not be shown in menu in user account (row 102) "TC05 Check if the Group is made inactive, the menus based on the selected features should not be visible to the AD users"
    And Logout the user
    And User login as admin
