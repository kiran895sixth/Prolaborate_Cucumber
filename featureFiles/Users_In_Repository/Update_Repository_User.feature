#Author: kirankumar
@Update_Repository_User
Feature: This is for Add Users in Repository

  Background:
    Given User login as admin
    And User credentials getting for testdata
      | UserFirstName | UserLastName |
      | test          | user         |


  @tag1
  Scenario: TC01 Check if we are able to edit and save the First name of the registered user
    Given User open repository "TC01 Check if we are able to edit and save the First name of the registered user"
    When User click on burger menu
    And User click users under repository configuration
    And User click add user
    And User enter the user credentials (userNo 1)
    And User click save
    And User update the first name and save
    Then Seccess message sholud be shown 80


  @tag2
  Scenario: TC02 Check if we are able to edit and save the last name of the registered user
    Given User open repository "TC02 Check if we are able to edit and save the last name of the registered user"
    When User click on burger menu
    And User click users under repository configuration
    And User click add user
    And User enter the user credentials (userNo 1)
    And User click save
    And User update the last name and save
    Then Seccess message sholud be shown 81


  @tag3
  Scenario: TC03 Check if the updated Registered users First name is visible in the List of Repository Users
    Given User open repository "TC03 Check if the updated Registered users First name is visible in the List of Repository Users"
    When User click on burger menu
    And User click users under repository configuration
    And User click add user
    And User enter the user credentials (userNo 1)
    And User click save
    And User update the first name and save
    Then Updated first name should be visible in users list


  @tag4
  Scenario: TC04 Check if the updated Registered users Last Name should be visible in the List of Repository users
    Given User open repository "TC04 Check if the updated Registered users Last Name should be visible in the List of Repository users"
    When User click on burger menu
    And User click users under repository configuration
    And User click add user
    And User enter the user credentials (userNo 1)
    And User click save
    And User update the last name and save
    Then Updated last name should be visible in users list


  @tag7
  Scenario: TC07 Check if the Updated First Name is visible in the users Profile
    Given User open repository "TC07 Check if the Updated First Name is visible in the users Profile"
    When User click on burger menu
    And User click users under repository configuration
    And User click add user
    And User enter the user credentials (userNo 1)
    And User click save
    And User update the first name and save
    And Logout the user
    And Login the added user
    Then Updated first name should be visible in users profile
    And Logout the user
    And User login as admin


  @tag8
  Scenario: TC08 Check if the updated last Name is visible in the users Profile
    Given User open repository "TC08 Check if the updated last Name is visible in the users Profile"
    When User click on burger menu
    And User click users under repository configuration
    And User click add user
    And User enter the user credentials (userNo 1)
    And User click save
    And User update the last name and save
    And Logout the user
    And Login the added user
    Then Updated last name should be visible in users profile
    And Logout the user
    And User login as admin


  @tag9
  Scenario: TC09 Check if we are able to edit and save the email address of a registered user
    Given User open repository "TC09 Check if we are able to edit and save the email address of a registered user"
    When User click on burger menu
    And User click users under repository configuration
    And User click add user
    And User enter the user credentials (userNo 1)
    And User click save
    And User update the email and save
    Then Seccess message sholud be shown 88
  after email change

  @tag10
  Scenario: TC10 Check if the updated email address of Registered user is visible in the List Of Repository user
    Given User open repository "TC10 Check if the updated email address of Registered user is visible in the List Of Repository user"
    When User click on burger menu
    And User click users under repository configuration
    And User click add user
    And User enter the user credentials (userNo 1)
    And User click save
    And User update the email and save
    Then Updated email should be visible in users list
  after email change

  @tag11
  Scenario: TC11 Check if the Registered user is able to login with the updated email address
    Given User open repository "TC11 Check if the Registered user is able to login with the updated email address"
    When User click on burger menu
    And User click users under repository configuration
    And User click add user
    And User enter the user credentials (userNo 1)
    And User click save
    And User update the email and save
    And Logout the user
    Then User should be loginable
    And Logout the user
    And User login as admin


  @tag12
  Scenario: TC12 Check if the updated email address of Registered user is visible in the users Profile
    Given User open repository "TC12 Check if the updated email address of Registered user is visible in the users Profile"
    When User click on burger menu
    And User click users under repository configuration
    And User click add user
    And User enter the user credentials (userNo 1)
    And User click save
    And User update the email and save
    And Logout the user
    And Login the updated email user
    Then Updated email should be visible in users profile
    And Logout the user
    And User login as admin


  @tag13
  Scenario: TC13 TC14 Check if we are able to update and save the Default Dashboard of the Registered user and verify its visible in the users dashboard
    Given User open repository "TC13 Check if we are able to update and save the Default Dashboard of the Registered user /n TC14 Check if the updated default dashboard is visible in the users Dashboard"
    When User click on burger menu
    And User click users under repository configuration
    And User click add user
    And User enter the user credentials (userNo 1)
    And User click save
    And User click on burger menu
    And User click dashboards under repository configuration
    And User create dashboard "testDashboard"
    And User click on burger menu
    And User click users under repository configuration
    And User update the default dashboard of the user and save
    Then Seccess message sholud be shown 92
    And Logout the user
    And Login the added user
    And User open repository
    Then Updated dashboard should be shown for user 93
    And Logout the user
    And User login as admin
    And User click on burger menu
    And User click the repositories
    And User open repository
    And Delete the dashboard


  @tag15
  Scenario: TC15 Check if we are not allowed to edit the Name and Email for AD users
    Given User open repository "TC15 Check if we are not allowed to edit the Name and Email for AD users"
    When User click on burger menu
    And User click users under repository configuration
    And User click add user
    And Add the AD user
    And User click on burger menu
    And User click users under repository configuration
    And User click edit on actions respective ADuser
    Then User should not able to edit the name and email 94
    And Delete the ADuser

  @tag16
  Scenario: TC16 Check if we are not allowed to edit the Name and Email for the SAML users
    Given User open repository "TC16 Check if we are not allowed to edit the Name and Email for the SAML users"
    And Logout the user
    When User login with sso
    And Logout the user
    And User login as admin
    And User click on burger menu
    And User click the repositories
    And User open repository
    And User click on burger menu
    And User click users under repository configuration
    And User click edit on actions respective sso user
    Then User should not able to edit the name and email 95
    And Delete the sso user

  @tag17
  Scenario: TC17 Check if the Default Dashboard updated for the AD user is visible in their account Dashboards page
    Given User open repository "TC17 Check if the Default Dashboard updated for the AD user is visible in their account Dashboards page"
    When User click on burger menu
    And User click users under repository configuration
    And User click add user
    And Add the AD user
    And User click on burger menu
    And User click dashboards under repository configuration
    And User create dashboard "testDashboard"
    And User click on burger menu
    And User click users under repository configuration
    And User click edit on actions respective ADuser
    And User update the default dashboard of the ADuser and save
    And Logout the user
    And Login the added aduser
    #And User open repository
    Then Updated dashboard should be shown for user 96
    And Logout the user
    And User login as admin
    And User click on burger menu
    And User click the repositories
    And User open repository
    And Delete the dashboard
    And Delete the ADuser

  @tag18
  Scenario: TC18 Check if the Default Dashboard updated for the SAML user is visible in their account
    Given User open repository "TC18 Check if the Default Dashboard updated for the SAML user is visible in their account"
    And Logout the user
    When User login with sso
    And Logout the user
    And User login as admin
    And User click on burger menu
    And User click dashboards under repository configuration
    And User create dashboard "testDashboard"
    And User click on burger menu
    And User click the repositories
    And User open repository
    And User click on burger menu
    And User click users under repository configuration
    And User click edit on actions respective sso user
    And User update the default dashboard of the sso user and save
    And Logout the user
    And User login with sso
    Then Updated dashboard should be shown for user 97
    And Logout the user
    And User login as admin
    And User click on burger menu
    And User click the repositories
    And User open repository
    And Delete the dashboard
    And Delete the sso user

  @tag32
  Scenario: TC32 Check if we are able to add  the User Groups Membership from the edit Repository membership window.
    Given User open repository "TC32 Check if we are able to add  the User Groups Membership from the edit Repository membership window."
    When User click on burger menu
    And User click users under repository configuration
    And User click add user
    And User enter the user credentials without default group
    And User click save
    And User add the user group membership in repository membership edit page of the user and save
    And Logout the user
    And Login the added user
    And User open repository
    Then User should get all repository configuration features under the burger menu
    And Logout the user
    And User login as admin


  @tag33
  Scenario: TC33 Check if we are able to remove  the User Groups Membership from the edit Repository membership window
    Given User open repository "TC33 Check if we are able to remove  the User Groups Membership from the edit Repository membership window"
    When User click on burger menu
    And User click users under repository configuration
    And User click add user
    And User enter the valid user credentials
    And User click save
    And User remove the user group membership in repository membership edit page of the user and save
    And Logout the user
    And Login the added user
    And User open repository
    Then User should get reviews features under the burger menu
    And Logout the user
    And User login as admin