#Author: kirankumar
@Edit_Usergroup_Page_in_Usergroup
Feature: This is for UserGroup in Repository

  Background:
    Given User login as admin
    And User credentials getting for testdata
      | UserFirstName | UserLastName |
      | test          | user         |


  @tag1
  Scenario: Validating Select All and Deselect All option

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
    And User click on "Save"
    And User click on Edit in actions (groupName "Test1")
    Then Validate the Select All and Deselect All option is displayed (row 134) "TC01 Check whether select-all and deselect-all options displayed"
    Then Validate the Select All and Deselect All option is working properly (row 135) "TC02 Check whether selectall and deselectall options working properly"
    Then Validate administrative access help icon mouse over text (message "Users of this group will have administrative access to selected Features") (row 144) "TC11 Verifying the administrative access help icon mouse over text is shown properly"
    Then Validate maximize icon is displayed (row 145) "TC12 Check whether maximize icon is displayed"
    Then Validate maximize option working properly (row 146) "TC13 Check whether maximize option working properly"
    Then Validate minimize icon is displayed in maximized view (row 147) "TC14 Check whether minimize icon is displayed in maximized view"
    Then Validate the Select All and Deselect All option is working properly (row 148) "TC15 Check whether selectall and deselectall options working properly in maximized view"
    Then Validate users tap is minimized when click minimize icon (row 149) "TC16 Check whether users tap is minimized when click minimize icon"
    Then Validate usergroups help learn more link is displayed (row 137) "TC04 Check whether usergroups help learn more link is displayed"
    Then Validate learn more link is redircted respective page (row 138) "TC05 Check whether learn more link is redircted respective page"

  @tag2
  Scenario: Validating license type

    When User open repository
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test1"
    And User click on "Save"
    And User click on "Create User Group"
    And User enter a groupname "Test2"
    And User choose "ReadOnly" license type
    And User click on "Save"
    And User click on Edit in actions (groupName "Test1")
    Then Validate license type shown correctly (groups "Test1" "Test2") (row 136) "TC03 Check whether license type shown correctly"

  @tag3
  Scenario: Validate default dashboard and feature set

    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User click on "Save"
    And User click on burger menu
    And User click "Dashboards" under repository configuration
    And User create dashboard "testDashboard1"
    And User create dashboard "testDashboard2"
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test1"
    And User select default dashboard "testDashboard1"
    And User assigned feature to user group (feature "Dashboards")
    And User add the users in group (registeredUser 1)
    And User click on "Save"
    And Logout the user
    And Login the added user (registeredUser 1)
    And User open repository
    Then Default dashboard set to the user group is visible to the Dashboard of Registered user (registeredUser 1) (dashboard "testDashboard1") (row 143) "Dashboard should be visible"
    And User click on burger menu
    Then Assigned feature should be shown in menu in user account (feature "Dashboards") (row 143) "Feature should be shown in menu in user account"
    And Logout the user
    And User login as admin
    And User open repository
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on Edit in actions (groupName "Test1")
    And User select default dashboard "testDashboard2"
    And User assigned feature to user group (feature "Dashboards")
    And User assigned feature to user group (feature "Repository Settings")
    And User click on "Save"
    And User click on Edit in actions (groupName "Test1")
    Then Validate updated dashboard is shown in default dashboard field (dashboard "testDashboard2") (row 140) "TC07 Check whether updated dashboard shown in default dashboard field"
    Then Validate updated feature set is selected properly (feature selected "Repository Settings") (feature unselected "Dashboards") (row 142) "TC09 Check whether user can able to update the feature set"
    And Logout the user
    And Login the added user (registeredUser 1)
    And User open repository
    Then Default dashboard set to the user group is visible to the Dashboard of Registered user (registeredUser 1) (dashboard "testDashboard2") (row 141) "TC08 Check whether updated dashboard is shown in usergroup member account "
    And User click on burger menu
    Then Assigned feature should be shown in menu in user account (feature "Repository Settings") (row 143) "TC10 Check whether updated  feature set is shown in usergroup member account"
    And Logout the user
    And User login as admin