#Author: kirankumar
@List_User_Group
Feature: This is for UserGroup in Repository

  Background:
    Given User login as admin
    When User click prolaborate logo
    And User credentials getting for testdata
      | UserFirstName | UserLastName |
      | test          | user         |


  @tag1
  Scenario: Check if the added user groups are listed in the Manage User Groups

    When User open repository
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test1"
    And User click on "Save"
    Then Validate added groups are listed in the usergroup page (groupname "Test1") (row 86) "TC01 Check if the added user groups are listed in the Manage User Groups"
    Then Validate group name is shown properly in the usergroup page (groupname "Test1") (row 87) "TC02 Check if the Group name is properly visible in the Manage User Groups List"
    Then Validate status of the group is shown properly (status "Active") (groupname "Test1") (row 88) "TC03 Check if the Status is showning as Active for Active Groups"

  @tag2
  Scenario: Check if the added user groups are listed in the Manage User Groups

    When User open repository
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test2"
    And User click on status toggle
    And User click on "Save"
    Then Validate status of the group is shown properly (status "Inactive") (groupname "Test2") (row 89) "TC04 Check if the status is showing as inactive for inactive Groups"