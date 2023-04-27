#Author: kirankumar
Feature: This is for UserGroup in Repository

  Background:
    Given User login as admin (reportName "Add Default Group")
    When User click prolaborate logo
    And User credentials getting for testdata
      | UserFirstName | UserLastName |
      | test          | user         |


  @Add_Default_Group
  Scenario: Default Group added when the repository is created
    Given Copy a repository
    When User open copied repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User click on "Save"
    And User click on burger menu
    And User click "User and License Management" under portal settings
    And Make added user as admin
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open copied repository
    And User click on burger menu
    And User click "User Groups" under repository configuration
    Then New repository user group list shown "Default" group  (row 12) "TC01 Check if the Default group is added when the repository is Added"
    Then "Default" group is visible in the Access Permissions User Group list (row 13) "TC02 Check if the Default Group is vsible in the Access Permissions User Group list"
    And User click on burger menu
    And User click "User Group" under repository configuration
    And User click on "Default" (indexValue is 2)
    Then Admin user added to the "Default" Group by default (row 14) "TC03 Check if the Admin user is added to the default group"
    Then Featuer set is by default selected in the "Default" Group (row 15) "TC04 Check if the feature sets are unchecked in the Default Group"
    Then Feature set is disabled in the "Default" group (row 16) "TC05 Check if the feature sets are disabled in the default group"
    Then User not able to remove the admin user from the "Default" Group (row 17) "TC06 Check if we are not allowed to remove the admin user from the default group"