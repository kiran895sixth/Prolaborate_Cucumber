#Author: kirankumar
Feature: This is for UserGroup in Repository

  Background:
    Given User login as admin (reportName "Add Administrator Group")
    When User click prolaborate logo
    And User credentials getting for testdata
      | UserFirstName | UserLastName |
      | test          | user         |

  @Add_Administrator_Group
  Scenario: Administrator Group added when the repository is created
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
    Then New repository user group list shown "Administrators" group  (row 2) "TC01 Check if the Administrator Group added when the repository is created"
    Then "Administrators" group is visible in the Access Permissions User Group list (row 3) "TC02 Check if the Administrator group is visible in the Access Permissions (ACL ON) Userr Group list"
    And User click on burger menu
    And User click "User Group" under repository configuration
    And User click on "Administrators"
    Then Admin user added to the "Administrators" Group by default (row 4) "TC03 Check if the Admin user added to the Administrator Group by default"
    Then Featuer set is by default selected in the "Administrators" Group (row 5) "TC04 Check if the Featuer set is by default selected in the Admin Group"
    Then Feature set is disabled in the "Administrators" group (row 6) "TC05 Check if the Feature set is disabled in the Administrator group"
    Then User not able to remove the admin user from the "Administrators" Group (row 7) "TC06 Check if we are not able to remove the admin user from the Administrator Group"

  
