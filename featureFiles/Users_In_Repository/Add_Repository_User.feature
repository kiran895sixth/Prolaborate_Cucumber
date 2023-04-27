#Author: kirankumar
@Add_Repository_User
Feature: This is for Add Users in Repository

  Background:
    Given User login as admin
    And User credentials getting for testdata
      | UserFirstName | UserLastName |
      | test          | user         |

   @tag1
   Scenario: TC01 Check if the user is added successfully when we enter the valid user credential
     Given User open repository
     When User click on burger menu
     And User click "Users" under repository configuration
     And User click on "Add User"
     And User enter the user credentials (userNo 1)
     And User choose "Administrators" usergroup
     And User choose "Prolaborate - Start Here" dashboard
     And User click on "Save"
     Then User should be added successfully 2 "TC01 Check if the user is added successfully when we enter the valid user credential"


   @tag2
  Scenario: TC02 Check if the user is successfully added if there is no default group is selected
    Given User open repository
    When User click on burger menu
     And User click "Users" under repository configuration
     And User click on "Add User"
     And User enter the user credentials (userNo 1)
     And User choose "Administrators" usergroup
     And User choose "Prolaborate - Start Here" dashboard
     And User click on "Save"
    And User enter the user credentials without default group 2
    And User click on "Save"
    Then User should be added successfully 3 "TC02 Check if the user is successfully added if there is no default group is selected"


   @tag3
  Scenario: TC03 Check if the user is added when there is no default dashboard is choosed,
  TC05 Check if the user is not allowed added with the existing Active users email ID,
  TC06 Check if the warning message is shown when email entered is similar to that of user in another repoistory

    Given User open repository "TC03 Check if the user is added when there is no default dashboard is choosed &TC05 Check if the user is not allowed added with the existing Active users email ID&TC06 Check if the warning message is shown when email entered is similar to that of user in another repoistory"
    When User click on burger menu
     And User click "Users" under repository configuration
     And User click on "Add User"
    And User enter the user credentials without default dashboard 3
    And User click on "Save"
    Then User should be added successfully 4 "TC03 Check if the user is added when there is no default dashboard is choosed"
    And User click on "Add User"
    And User add another user with existing user mail 3
    Then User should see warning message "Unable to save the changes as the Email already exists! Please try a different email" "TC06 Check if the warning message is shown when email entered is similar to that of user in another repoistory"
    And User should not able to save "User Added to the Repository Successfully" "TC05 Check if the user is not allowed added with the existing Active users email ID"


   @tag7
  Scenario: TC07 Check if the user is successfully added from the existing user in Prolaborate warning message
    Given User open repository "TC07 Check if the user is successfully added from the existing user in Prolaborate warning message"
    When User click on burger menu
    And User click users and license management under portal sttings
    And User click on "Add User"
    And User enter the user credentials (userNo 7)
    And User click on "Save"
    And User click prolaborate header
    And User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the existing user mail TCno 7
    Then User should see warning message and import option TCno 7


   @tag8
  Scenario: TC08 Check if the new user is added with the emaill ID of Invited Collaborator
    Given User open repository "TC08 Check if the new user is added with the emaill ID of Invited Collaborator"
    When User click repository package "Example Model"
    And User invite user via email "testuser20@mailinator.com"
    When User add the invite user via invite link "Example Model"
      | InviteMail | FirstName | LastName | Password    |
      | testuser20 | test      | user1110 | Welcome123@ |
    Then Invite user should be added in repository user list and portal user list "testuser20"


   @tag9
  Scenario: TC09 Check if the added user is visible in the Access permissions menu users list
    Given User open repository "TC09 Check if the added user is visible in the Access permissions menu users list"
    When User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the user credentials without default dashboard 9
    And User click on "Save"
    And User click on burger menu
    And User click access permissions under repository configuration
    Then User should be see added user in access permissions users dropdown list "Example Model"


   @tag10
  Scenario: TC10 Check if the Default Group dropdown shows the list of User Groups in the Repository
    Given User open repository "TC10 Check if the Default Group dropdown shows the list of User Groups in the Repository"
    When User click on burger menu
    And User click user groups under repository configuration
    And User click create user group
    And User create user group
    And Get user groups names
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    Then User should be see all user groups in dropdown

   @tag11
  Scenario: TC11 Check if the Default Dashboard dropdwon shows all the Dashboards from the Repository
    Given User open repository "TC11 Check if the Default Dashboard dropdwon shows all the Dashboards from the Repository"
    When User click on burger menu
    And User click dashboards under repository configuration
    And User create dashboard "testDashboard"
    And Get dashboard names list
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    Then User should be see all dashboards in dashboard list dropdown


   @tag12
  Scenario: TC12 Check if the add user cannot be done by leaving the mandatory fields empty
    Given User open repository "TC12 Check if the add user cannot be done by leaving the mandatory fields empty"
    When User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User select user group and dashboard only
    And User click on "Save"
    Then User should not able to save

   @tag13
  Scenario: TC13 Check if the user cannot be added when the email is sepecified without domain
    Given User open repository "TC13 Check if the user cannot be added when the email is sepecified without domain"
    When User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the email without specifieddomain
    And User click on "Save"
    Then User should not able to save user


   @tag14
  Scenario: TC14 Check if the inactive Dashboards in the repository are not shown in default dashboard dropdown
    Given User open repository "TC14 Check if the inactive Dashboards in the repository are not shown in default dashboard dropdown"
    When User click on burger menu
    And User click dashboards under repository configuration
    And User create inactive dashboard
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    Then User should not see inactive dashboard in dropdown


   @tag15
  Scenario: TC15 Check if the inactive user group is listed in the Default Group dropdown
    Given User open repository "TC15 Check if the inactive user group is listed in the Default Group dropdown"
    When User click on burger menu
    And User click user groups under repository configuration
    And User click create user group
    And User create inactive user group
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    Then User should not see inactive user group

   @tag16
  Scenario: TC16 Check if the added user is visible in the create Review -Add Contributors tab
    Given User open repository "TC16 Check if the added user is visible in the create Review -Add Contributors tab"
    When User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
     And User enter the user credentials (userNo 1)
    And User click on "Save"
    And User navigate to create Review -Add Contributors tab
    Then User should be see added user in Add Contributors tab


   @tag17
  Scenario: TC17 Invite user to a repository and check whether the invited user list listed in Invited collaborators list
    Given User open repository "TC17 Invite user to a repository and check whether the invited user list listed in Invited collaborators list"
    When User click repository package "Example Model"
    And User invite user via email "test@mail.com"
    Then Invite user should be added in repository user invited collaborators list "test@mail.com"
    And Delete the invite user from invites collaborators list "test@mail.com"