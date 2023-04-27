#Author: kirankumar
@Repository_membership_in_portal_user_list
Feature: This is for Users in UserManagement

  Background:
    Given User login as admin
    And User credentials getting for testdata
      | UserFirstName | UserLastName |
      | test          | user         |

  @tag1
  Scenario: Validating  Repository Membership column in user and license management
    When User click on burger menu
    And User click "Repositories" under portal settings
    And Copy a repository
    And Get the repository list
    And User open repository
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And Get the group list
    And User click on burger menu
    And User click "User and License Management" under portal settings
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User click on "Save"
    Then Repository membership column should be shown in portal user list (row 78) "TC01 Check if  Repositary Membership column is available in user and license management"
    Then Edit option should be shown in under the repository membership column in portal user list (user 1) (row 79) "TC02 check if edit option is shown in  Repository Membership"
    And User click on edit in repository membership column respective user 1
    Then Validate respective model window is shown (user 1) (row 80) "TC03 Check if edit option is redirect to respective model window"
    Then Validate all repository names are shown in repository membership window (row 81) "TC04 Check Repository membership model window shows repository list"
    Then Validate user group membership field is disabled state until the repository choose (row 82) "TC05 Check user group membership field is disabled state until the repository choose"
    And User select repository "Test Repository"
    Then Validate the user group list is shown in user group membership dropdown after choosed repository "Test Repository" (row 83) "TC06 Check user group list is shown in user group membership dropdown after choosed repository"
    Then Validate the save and cancel button is shown in repository membership model window (row 84) "TC07 Check Save and cancel button is shown in repository membership model window"


  @tag2
  Scenario: Validating  Repository Membership column in user and license management
    When User open repository
    And User click on burger menu
    And User click "User and License Management" under portal settings
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User click on "Save"
    And User click on edit in repository membership column respective user 1
    And User select repository "Test Repository"
    And User click on "Cancel"
    And User click on edit in repository membership column respective user 1
    Then Validate the choosed repository is aborted properly (repository "Test Repository") (row 85) "TC08 Check user select the repository membership and click on cancel button its properly aborted or not"
    And User click close button
    Then Validate the repository membership window is disappeared when click close button (row 86) "TC09 Check whether the repository membership window is disappeared when click close button"
    And User click on edit in repository membership column respective user 1
    And User click on Repository header
    Then Validate all repository is selected (row 87) "TC10 Check user click the repository name header its selected all repository in list"

  @tag3
  Scenario: Validating  Repository Membership column in user and license management
    When User open repository
    And User click on burger menu
    And User click "User and License Management" under portal settings
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User click on "Save"
    And User click on edit in repository membership column respective user 1
    And User select repository "Test Repository"
    And User select user group membership (repository "Test Repository") "Default"
    And User click on "Save"
    Then Validate the PB alert message for successful repository membership assigned (row 88) "TC11 Check PB alert message is shown when save the repository membership"
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User open "Default" group
    Then Validate the user is added to the assigned group
    And User click on burger menu
    And User click "Users" under repository configuration
    Then Validate the user is added to the assigned repository (userNo 1) (row 89) "TC12 Check whether user is added in choosed repository user list and choosed group"
    And Logout the user
    And Login the added user (registeredUser 1)
    Then Validate assigned repository is shown in user account (row 90) "TC13 Check assigned repository is shown in user account"
    And User click on burger menu
    Then Validate user getting repository configuration access besed on group select (row 91) "TC14 Check whether user getting repository configuration access besed on group select"
    And Logout the user
    And User login as admin



