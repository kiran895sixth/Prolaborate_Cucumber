#Author: kirankumar
@Sorting_in_Usergroup
Feature: This is for UserGroup in Repository

  Background:
    Given User login as admin
    And User credentials getting for testdata
      | UserFirstName | UserLastName |
      | test          | user         |

  @tag1
  Scenario: Checking sort order in the user group page

    When User open repository
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "ZTest"
    And User click on "Save"
    Then Validate sort option should be shown in usergroup header (row 126) "TC01 Check if group name column shown with sorting option"
    Then Validate sort option should be shown in status header (row 129) "TC04 Check if status column shown with sorting option"
    And User click on usergroup header
    Then Validate list should be in ascending order (row 127) (elementIndex 1) "TC02 Check whether Sorting Option displays as per ascending order when clicked"
    And User click on usergroup header
    Then Validate list should be in descending order (row 128) (elementIndex 1) "TC03 Check whether Sorting Option displays as per descending order when clicked"
    And User click on status header
    Then Validate list should be in ascending order (row 130) (elementIndex 2) "TC05 Check whether Sorting Option displays as per ascending order when clicked"
    And User click on status header
    Then Validate list should be in descending order (row 131) (elementIndex 2) "TC06 Check whether Sorting Option displays as per descending order when clicked"

