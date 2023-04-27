#Author: kirankumar
  @Add_Portal_User

Feature: This is for Users in UserManagement

  Background:

    Given User login as admin
    And User credentials getting for testdata
      | UserFirstName | UserLastName |
      | test          | user         |

  @tag1
  Scenario: TC01 Add system user and check whether the user is added properly or not
    When User open repository
    And User click on burger menu
    And User click "User and License Management" under portal settings
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User click on "Save"
    Then Validate the user is added properly in portal (User 1) (row 1) "TC01 Add system user and check whether the user is added properly or not"

  @tag2
  Scenario: TC02 Add System User by assigning the particular repository and check whether the repository is assigned properly or not
    When User open repository
    And User click on burger menu
    And User click "User and License Management" under portal settings
    And User click on "Add User"
    And User enter the user credentials (userNo 2)
    And User select repository membership "demoprofile"
    And User click on "Save"
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    Then Validate the user is added properly in repository (User 2) (row 2) "TC02 Add System User by assigning the particular repository and check whether the repository is assigned properly or not"


  @tag3
  Scenario: TC11 Add System User by enable Admin option and check whether the user has admin privilege or not
    When User open repository
    And User click on burger menu
    And User click "User and License Management" under portal settings
    And User click on "Add User"
    And User enter the user credentials (userNo 3)
    And User select repository membership "demoprofile"
    And User click Make user as a admin
    And User click on "Save"
    And Logout the user
    And Login the added user (registeredUser 3)
    And User click on burger menu
    Then Validate user has get "Admin access" (User 3) (row 11) "TC11 Add System User by enable Admin option and check whether the user has admin privilege or not"
    | Admin access                                | Non admin access      |
    | Access Control Profiles                     | Notification Settings |
    | Active Directory Single Sign On             | Repositories          |
    | Integrated Applications - Access Management | |
    | Manage Application Restrictions             | |
    | Embeddable Link Defaults                    | |
    | General Settings                            | |
    | Sign Up Settings                            | |
    | Health Checks                               | |
    | Mailer Configuration                        | |
    | Integrated Applications                     | |
    | Notification Settings                       | |
    | Repositories                                | |
    | Review Defaults                             | |
    | SAML Single Sign On                         | |
    | Theme Settings                              | |
    | User and License Management                 | |
    | Licenses                                    | |
    | Login History                               | |
    And Logout the user
    And User login as admin

  @tag4
  Scenario: TC12 Add System User by disable "Admin" option and check whether the user has admin privilege or not
    When User open repository
    And User click on burger menu
    And User click "User and License Management" under portal settings
    And User click on "Add User"
    And User enter the user credentials (userNo 4)
    And User select repository membership "demoprofile"
    And User click on "Save"
    And Logout the user
    And Login the added user (registeredUser 4)
    And User click on burger menu
    Then Validate user has get "Non admin access" (User 4) (row 12) "TC12 Add System User by disable Admin option and check whether the user has admin privilege or not"
      | Admin access                                | Non admin access      |
      | Access Control Profiles                     | Notification Settings |
      | Active Directory Single Sign On             | Repositories          |
      | Integrated Applications - Access Management | |
      | Manage Application Restrictions             | |
      | Embeddable Link Defaults                    | |
      | General Settings                            | |
      | Sign Up Settings                            | |
      | Health Checks                               | |
      | Mailer Configuration                        | |
      | Integrated Applications                     | |
      | Notification Settings                       | |
      | Repositories                                | |
      | Review Defaults                             | |
      | SAML Single Sign On                         | |
      | Theme Settings                              | |
      | User and License Management                 | |
      | Licenses                                    | |
      | Login History                               | |
    And Logout the user
    And User login as admin

  @tag5
  Scenario: TC13 Add system user as a Active user and check whether the added user is in active state or not
    When User open repository
    And User click on burger menu
    And User click "User and License Management" under portal settings
    And User click on "Add User"
    And User enter the user credentials (userNo 5)
    And User select repository membership "demoprofile"
    And User click on "Save"
    Then Validate the user status (userStatus "Active") (userNo 5) (row 13) "TC13 Add system user as a Active user and check whether the added user is in active state or not"
    And Logout the user
    Then Validate the active user can able to login (userNo 5) (row 15) "TC15 Check whether the Active user can able to login or not"
    And User login as admin

  @tag6
  Scenario: TC14 Add system user as a "Inactive" user and check whether the added user is in Inactive state or not
    When User open repository
    And User click on burger menu
    And User click "User and License Management" under portal settings
    And User click on "Add User"
    And User enter the user credentials (userNo 6)
    And User select repository membership "demoprofile"
    And Make user as inactive
    And User click on "Save"
    Then Validate the user status (userStatus "Inactive") (userNo 6) (row 14) "TC14 Add system user as a Inactive user and check whether the added user is in Inactive state or not"
    And Logout the user
    Then Validate the inactive user can able to login (userNo 6) (row 16) "TC16 Check whether the In active user can able to login or not"
    And User login as admin

  @tag7
  Scenario: Check whether added user get repository and group access based on repository membership choosed
    When User open repository
    And User click on burger menu
    And User click "Access Control Profile" under portal settings
    And User click on "demoprofile" (indexValue is 1)
    And Note the selected repository and group access
    And User click on burger menu
    And User click "User and License Management" under portal settings
    And User click on "Add User"
    And User enter the user credentials (userNo 7)
    And User select repository membership "demoprofile"
    And User click on "Save"
    And Logout the user
    And Login the added user (registeredUser 7)
    Then Validate the repository access is based on access control profile  (row 17) "TC17 Check whether added user get repository  access based on repository membership choosed"
    Then Validate the group access is based on access control profile  (row 18) "TC18 Check whether added user get  group access based on repository membership choosed"
    And Logout the user
    And User login as admin

  @tag8
  Scenario: TC19  Add Aduser in portal level and check whether the user is added properly or not and TC20 Check whether success message is shown properly when adding users
    When User open repository
    And User click on burger menu
    And User click "User and License Management" under portal settings
    And User click on "Add User"
    And User click on "Add Active Directory User"
    And Select the active directory domain
    And User click on "Users" under browser
    And Select the user by search in advanced search ("AD119737")
    And User click on "Add Users"
    Then User should see pb alert "Active Directory user added successfully!" message (row 20) "TC20 Check whether success message is shown properly when adding users"
    And User click on burger menu
    And User click "User and License Management" under portal settings
    Then Added ADuser should be in user-management user list (user "AD119737") (row 19) "TC19  Add Aduser in portal level and check whether the user is added properly or not"



  @tag9
  Scenario: TC21 Check whether user can able to assign access profile while adding
    When User open repository
    And User click on burger menu
    And User click "User and License Management" under portal settings
    And User click on "Add User"
    And User click on "Add Active Directory User"
    And Select the active directory domain
    And User click on "Users" under browser
    And Select the user by search in advanced search ("AD119737")
    And Select the access profile "demoprofile"
    And User click on "Add Users"
    And User click on burger menu
    And User click "User and License Management" under portal settings
    And User click on edit in repository membership column respective user in portal users list (user "AD119737")
    Then Validate the repository and group selected based on the access profile choosed (repository "Test Repository") (group "Default") (row 21) "TC21 Check whether user can able to assign access profile while adding"