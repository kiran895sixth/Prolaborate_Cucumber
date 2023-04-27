#Author: kirankumar
@Add_Remove_Users_in_Group
Feature: This is for UserGroup in Repository

  Background:
    Given User login as admin
    When User click prolaborate logo
    And User credentials getting for testdata
      | UserFirstName | UserLastName |
      | test          | user         |

  @tag1
  Scenario: TC01 Check if we are able to add user in the user group and TC03 Check if we are able to remove the user from the user group

    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User click on "Save"
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test1"
    And User add the users in group (registeredUser 1)
    And User click on "Save"
    Then Validate the user is able to  add user in the user group (groupName "Test1") (registeredUser 1) (row 22) "TC01 Check if we are able to add user in the user group"
    And Remove the user from the group (registeredUser 1)
    And User click on "Save"
    Then Validate the user is able to  remove user in the user group (groupName "Test1") (registeredUser 1) (row 24) "TC03 Check if we are able to remove the user from the user group"

  @tag2
  Scenario: TC05 Check if the user is removed from the group, then the feature set assigned is not visible to the user

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
    And User assigned feature to user group (feature "Dashboards")
    And User click on "Save"
    And Logout the user
    And Login the added user (registeredUser 2)
    And User open repository
    And User click on burger menu
    Then Validate assigned feature should be shown (feature "Dashboards")
    And Logout the user
    And User login as admin
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User open "Test2" group
    And Remove the user from the group (registeredUser 2)
    And User click on "Save"
    And Logout the user
    And Login the added user (registeredUser 2)
    And User click on burger menu
    Then Validate assigned feature should not be shown (feature "Dashboards") (row 26) "TC05 Check if the user is removed from the group, then the feature set assigned is not visible to the user"

  @tag3
  Scenario: TC06 Check if the Access Permission applied to the user group is revoked for the removed user

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
    And Remove the user from the group (registeredUser 3)
    And User click on "Save"
    And Logout the user
    And Login the added user (registeredUser 3)
    And User click on burger menu
    Then Validate assigned repository browser should not be shown  (row 27) "TC06 Check if the Access Permission applied to the user group is revoked for the removed user"
    And Logout the user
    And User login as admin

  @tag4
  Scenario: TC07 Check if the default dashboaard assigned to the user group is not visible to the removed user

    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the user credentials (userNo 4)
    And User click on "Save"
    And User click on burger menu
    And User click "Dashboards" under repository configuration
    And User create dashboard "testDashboard4"
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test4"
    And User select default dashboard "testDashboard4"
    And User add the users in group (registeredUser 4)
    And User click on "Save"
    And Logout the user
    Then Default dashboard set to the user group is visible to the Dashboard of Registered user (registeredUser 4) (dashboard "testDashboard4") (row 38) "Validate the dashboard shown"
    And Logout the user
    And User login as admin
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User open "Test4" group
    And Remove the user from the group (registeredUser 4)
    And User click on "Save"
    And Logout the user
    And Login the added user (registeredUser 4)
    Then Validate assigned default dashboard should not be shown (dashboard "testDashboard4") (row 28) "TC07 Check if the default dashboaard assigned to the user group is not visible to the removed user"
    And Logout the user
    And User login as admin


  @tag5
  Scenario: TC09 Check if we are able to add the AD user in the user

    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And Add the AD user (user "AD119737")
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test5"
    And User add the users in group ("AD1002")
    And User click on "Save"
    Then Validate the user is able to add user in the user group (groupName "Test5") ("AD1002") (row 30) "TC09 Check if we are able to add the AD user in the user"
    And Remove the user from the group ("AD1002")
    And User click on "Save"
    Then Validate the user is able to remove user in the user group (groupName "Test5") ("AD1002")


  @tag6
  Scenario: TC10 Check if we are able to add the AD group in the user Group

    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And Add the AD group
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test6"
    And User add the users in group ("shgroup")
    And User click on "Save"
    Then Validate the user is able to add user in the user group (groupName "Test6") ("shgroup") (row 31) "TC10 Check if we are able to add the AD group in the user Group"
    And Remove the user from the group ("shgroup")
    And User click on "Save"
    Then Validate the user is able to remove user in the user group (groupName "Test6") ("shgroup")


  @tag7
  Scenario: TC11 Check if we are able to add the SAML user is the User Group

    When Logout the user
    And User login with sso
    And Logout the user
    And User login as admin
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test7"
    And User add the users in group ("kiran kumar")
    And User click on "Save"
    Then Validate the user is able to add user in the user group (groupName "Test7") ("kiran kumar") (row 32) "TC11 Check if we are able to add the SAML user is the User Group"
    And Remove the user from the group ("kiran kumar")
    And User click on "Save"
    Then Validate the user is able to remove user in the user group (groupName "Test7") ("kiran kumar")


  @tag8
  Scenario: TC12 Check if the invited user is visible in the User Group

    When User open repository
    And User click repository package
    And User invite user via email "inviteuser1@mail.com"
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test8"
    And User add the users in group ("inviteuser1@mail.com")
    And User click on "Save"
    Then Validate the user is able to add user in the user group (groupName "Test8") ("inviteuser1@mail.com") (row 33) "TC12 Check if the invited user is visible in the User Group"
    And Remove the user from the group ("inviteuser1@mail.com")
    And User click on "Save"
    Then Validate the user is able to remove user in the user group (groupName "Test8") ("inviteuser1@mail.com")
