#Author: kirankumar
@Delete_Repository_User
Feature: This is for Add Users in Repository

  Background:
    Given User login as admin
    And User credentials getting for testdata
      | UserFirstName | UserLastName |
      | test          | user         |


  @tag1
  Scenario: TC01 Check if the Delete user confirmation popup comes when we click on Delete from Actions menu
    Given User open repository "TC01 Check if the Delete user confirmation popup comes when we click on Delete from Actions menu"
    When User click on burger menu
    And User click users under repository configuration
    And User click add user
    And User enter the user credentials (userNo 1)
    And User click save
    And User delete the added user from repository
    Then User should see confirmation popup


  @tag2
  Scenario: TC02 Check if the user is Deleted from the List of Repository Users
    Given User open repository "TC02 Check if the user is Deleted from the List of Repository Users"
    When User click on burger menu
    And User click users under repository configuration
    And User click add user
    And User enter the user credentials (userNo 1)
    And User click save
    And User delete the added user from repository user list
    Then Deleted user should be removed from list


  @tag3
  Scenario: TC03 Check if the user is removed from the Access Permissions users list
    Given User open repository "TC03 Check if the user is removed from the Access Permissions users list"
    When User click on burger menu
    And User click users under repository configuration
    And User click add user
    And User enter the user credentials (userNo 1)
    And User click save
    And User delete the added user from repository user list
    And User click on burger menu
    And User click access permissions under repository configuration
    Then User should not see added user in access permissions users dropdown list "Example Model"


  @tag4
  Scenario: TC04 Check if the removed users  access permissions are removed
    Given User open repository "TC04 Check if the removed users  access permissions are removed"
    When User click on burger menu
    And User click users under repository configuration
    And User click add user
    And User enter the user credentials (userNo 1)
    And User click save
    And User click on burger menu
    And User click access permissions under repository configuration
    And User set access permission for added user "Example Model"
    And User click on burger menu
    And User click users under repository configuration
    And User delete the added user from repository user list
    Then Access permission is removed for deleted user "Example Model"


  @tag5
  Scenario: TC05 Check if the user is removed from the User Group
    Given User open repository "TC05 Check if the user is removed from the User Group"
    When User click on burger menu
    And User click users under repository configuration
    And User click add user
    And User enter the user credentials (userNo 1)
    And User click save
    And User click on burger menu
    And User click user groups under repository configuration
    And User click create user group
    And Add the added user in group
    And User click on burger menu
    And User click users under repository configuration
    And User delete the added user from repository user list
    Then Added user should be removed from group

  @tag6
  Scenario: TC06 Check if the user is removed from the existing Review
    Given User open repository "TC06 Check if the user is removed from the existing Review"
    When User click on burger menu
    And User click users under repository configuration
    And User click add user
    And User enter the user credentials (userNo 1)
    And User click save
    And User create one review with added user
    And User click on burger menu
    And User click users under repository configuration
    And User delete the added user from repository user list
    Then Added user should be removed from the existing Review
    And Delete the review


  @tag7
  Scenario: TC07 Check if the user removed from a repository wont have access to that repository
    Given User open repository "TC07 Check if the user removed from a repository wont have access to that repository"
    When User click on burger menu
    And User click users under repository configuration
    And User click add user
    And User enter the user credentials (userNo 1)
    And User click save
    And Logout the user
    And Login the added user (registeredUser 1)
    Then Repository should be shown
    And Logout the user
    And User login as admin
    And User click prolaborate logo
    And User open repository
    And User click on burger menu
    And User click users under repository configuration
    And User delete the added user from repository user list
    And Logout the user
    And Login the added user after removed from repository
    Then Repository should not shown for removed user
    And Logout the user
    And User login as admin


  @tag8
  Scenario: TC08 Check if the user removed from the Repository is still visible in the List of Prolaborate Users
    Given User open repository "TC08 Check if the user removed from the Repository is still visible in the List of Prolaborate Users"
    When User click on burger menu
    And User click users under repository configuration
    And User click add user
    And User enter the user credentials (userNo 1)
    And User click save
    And User delete the added user from repository user list
    And User navigate to protal user list
    Then User should be available in list


  @tag9
  Scenario: TC09 Check if we are able to delete a user from Repository by selcting the check box
    Given User open repository "TC09 Check if we are able to delete a user from Repository by selcting the check box"
    When User click on burger menu
    And User click users under repository configuration
    And User click add user
    And User enter the user credentials (userNo 1)
    And User click save
    And User delete the added user from repository user list by check box
    Then User should not available in repository user list


  @tag10
  Scenario: TC10 Check if we are abe to delete multiple users from the repository
    Given User open repository "TC10 Check if we are abe to delete multiple users from the repository"
    When User click on burger menu
    And User click users under repository configuration
    And User click add user
    And User enter the user credentials (userNo 1)
    And User click save
    And User click add user
    And User enter the valid user2 credentials
    And User click save
    And User delete the multiple user from repository user list by check box
    Then Users should not available in repository user list


  @tag11
  Scenario: TC11 Check if a admin user can delete another admin user in the repository
    Given User open repository "TC11 Check if a admin user can delete another admin user in the repository"
    When User click on burger menu
    And User click users under repository configuration
    And User click add user
    And User enter the valid admin user credentials
    And User click save
    And User click add user
    And User enter the valid admin user2 credentials
    And User click save
    And Make users as admin
    Then Admin user should able to delete admin user from repository
    And Delete the admin user
    And Delete the admin user2