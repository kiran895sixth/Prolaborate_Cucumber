#Author: kirankumar
@Configure_Defaultdashboard_to_Group
Feature: This is for UserGroup in Repository

  Background:
    Given User login as admin
    When User click prolaborate logo
    And User credentials getting for testdata
      | UserFirstName | UserLastName |
      | test          | user         |

  @tag1
  Scenario: TC01 Check if the default dashboard set to the user group is visible to the Dashboard of Registered user and TC06 Check if the default dashboard set to the user group is properly visible in default dashboard field

    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the user credentials (userNo 4)
    And User click on "Save"
    And User click on burger menu
    And User click "Dashboards" under repository configuration
    And User create dashboard "testDashboard1"
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test1"
    And User select default dashboard "testDashboard1"
    And User add the users in group (registeredUser 4)
    And User click on "Save"
    Then Default dashboard set to the user group is properly visible in default dashboard field (groupName "Test1") (dashboard "testDashboard1") (row 43) "TC06 Check if the default dashboard set to the user group is properly visible in default dashboard field"
    And Logout the user
    And Login the added user (registeredUser 4)
    Then Default dashboard set to the user group is visible to the Dashboard of Registered user (registeredUser 4) (dashboard "testDashboard1") (row 38) "TC01 Check if the default dashboard set to the user group is visible to the Dashboard of Registered user"
    And Logout the user
    And User login as admin


  @tag2
  Scenario: TC02 Check if the default dashboard set to the user group is visible to the Dashboard of AD group
    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And Add the AD group (group "kiran_Automation")
    And User click on burger menu
    And User click "Dashboards" under repository configuration
    And User create dashboard "testDashboard2"
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test2"
    And User select default dashboard "testDashboard2"
    And User add the users in group (ADgroup "kiran_Automation")
    And User click on "Save"
    And Logout the user
    Then Default dashboard set to the user group is visible to the Dashboard of ADgroup (ADgroupuser "kiran") (dashboard "testDashboard2") (row 39) "TC02 Check if the default dashboard set to the user group is visible to the Dashboard of AD group"

  @tag3
  Scenario: TC03 Check if the default dashboard set to the user group is visible to the Dashboard of AD group user
    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And Add the AD group
    And Logout the user
    And User login ADgroupUserOrADuser (ADgroupUserOrADuser "NI2")
    And Logout the user
    And User login as admin
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    And User click "Dashboards" under repository configuration
    And User create dashboard "testDashboard3"
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test3"
    And User select default dashboard "testDashboard3"
    And User add the users in group (ADgroupUser "NI2")
    And User click on "Save"
    And Logout the user
    Then Default dashboard set to the user group is visible to the Dashboard of ADgroupuser (ADgroupUser "NI2") (dashboard "testDashboard3") (row 40) "TC03 Check if the default dashboard set to the user group is visible to the Dashboard of AD group user"

  @tag4
  Scenario: TC04 Check if the default dashboard set to the user group is visible to the Dashboard of AD user

    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And Add the AD user
    And User click on burger menu
    And User click "Dashboards" under repository configuration
    And User create dashboard "testDashboard4"
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test4"
    And User select default dashboard "testDashboard4"
    And User add the users in group (ADuser "AD1002")
    And User click on "Save"
    And Logout the user
    Then Default dashboard set to the user group is visible to the Dashboard of ADuser (ADuser "AD1002") (dashboard "testDashboard4") (row 41) "TC04 Check if the default dashboard set to the user group is visible to the Dashboard of AD user"

  @tag5
  Scenario: TC05 Check if the default dashboard set to the user group is visible to the Dashboard of SAML user

    When Logout the user
    And User login with sso
    And Logout the user
    And User login as admin
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    And User click "Dashboards" under repository configuration
    And User create dashboard "testDashboard5"
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test5"
    And User select default dashboard "testDashboard5"
    And User add the users in group (SAMLuser "kiran kumar")
    And User click on "Save"
    And Logout the user
    And User login with sso
    Then Default dashboard set to the user group is visible to the Dashboard of SAMLuser (SAMLuser "kiran kumar") (dashboard "testDashboard5") (row 42) "TC05 Check if the default dashboard set to the user group is visible to the Dashboard of SAML user"