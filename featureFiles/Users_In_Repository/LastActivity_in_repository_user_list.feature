#Author: kirankumar
Feature: This is for Add Users in Repository

  Background:
    Given User login as admin
    And User credentials getting for testdata
      | UserFirstName | UserLastName |
      | test          | user         |
@LastActivity_in_repository_user_list
Scenario: checking LastActivity in repository user list page
TC01 check if user after login and logut only,the login date and time shown under Last Active On column.
TC02 check if Last Active On column shown the last activity of all type of users.

Given User open repository
When User click on burger menu
And User click "Users" under repository configuration
And User click on "Add User"
And User enter the valid user credentials 1
And User click on "Save"
And Logout the user
And Login the added user 1
And Note the login time
And Logout the user
And User login as admin
And User open repository
And User click on burger menu
And User click "Users" under repository configuration
Then Validate the lastactivity column is shown login date and time