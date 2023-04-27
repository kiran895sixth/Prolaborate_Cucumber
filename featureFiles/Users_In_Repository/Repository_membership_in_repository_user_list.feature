#Author: kirankumar
Feature: This is for Add Users in Repository

  Background:
    Given User login as admin
    And User credentials getting for testdata
      | UserFirstName | UserLastName |
      | test          | user         |
  @Repository_membership_in_repository_user_list
  Scenario: checking Repository Membership in repository user list page
  TC01 check if  Repository Membership column is available in user datatable,
  TC02 check if edit option is shown in  Repository Membership,
  TC03 check if user click on Edit options,its shows the number of repository and group that user has access,
  TC04 check if user remove or change the access for the user manually

    Given User open repository
    When User click on burger menu
    And User click "Users" under repository configuration
    Then Repository membership column should be shown "TC01 check if  Repository Membership column is available in user datatable"
    And Edit option should be shown in under the repository membership column "TC02 check if edit option is shown in  Repository Membership"
    And User click on "Add User"
    And User enter the valid user credentials 1
    And User click on "Save"
    And User click on edit in repository membership column respective user 1
    Then repository membership window shows repositories and group "TC03 check if user click on Edit options,its shows the number of repository and group that user has access"
    And Remove and change the user group access
    And User click on "Save"
    Then User should see pb alert "Repository Membership saved successfully!" message 168 "TC04 check if user remove or change the access for the user manually"