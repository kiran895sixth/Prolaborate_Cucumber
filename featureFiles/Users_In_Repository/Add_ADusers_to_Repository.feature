#Author: kirankumar
@Add_ADusers_to_Repository
Feature: This is for Add Users in Repository

  Background:
    Given User login as admin
    And User credentials getting for testdata
      | UserFirstName | UserLastName |
      | test          | user         |


  @tag1
  Scenario: TC01 Check if the AD user is added to the repository
  TC02 Check if the added AD user is visible in the List of Repository users
  TC03 Check if added AD user is visible in the User Management

    Given User open repository
    When User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User click on "Add Active Directory User"
    And Select the active directory domain
    And User click on "Users" under browser
    And Select the user by search in advanced search ("AD1002")
    And User click on "Add Users"
    Then User should see pb alert "Active Directory user added successfully!" message 123 "TC01 Check if the AD user is added to the repository"
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click discard
    Then Added ADuser should be in repository user list 124 "TC02 Check if the added AD user is visible in the List of Repository users"
    And User click on burger menu
    And User click "User and License Management" under portal settings
    Then Added ADuser should be in portal user list 125 "TC03 Check if added AD user is visible in the User Management"

  @tag2
  Scenario: TC04 Check if the default group is assigned to the AD user While adding
    Given User open repository
    When User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User click on "Add Active Directory User"
    And Select the active directory domain
    And User click on "Users" under browser
    And Select the user by search in advanced search ("AD1002")
    And Select the user group membership "Administrators"
    And User click on "Add Users"
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click discard
    And User click on "Administrators"
    Then Added ADuser should be added in the group 126 "TC04 Check if the default group is assigned to the AD user While adding"

  @tag3
  Scenario: Active Directory Groups list in the Repository
  TC05 Check if the AD Group is added to the repository
  TC06 Check if added AD Group is visible in the Active Directory Groups list in the Repository
  TC07 Check if added AD Group is visible in the Active Directory Groups list in the User Management

    Given User open repository
    When User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Active Directory Groups"
    And User click on "Add Group"
    And Select the active directory domain
    And User click on "Users" under browser
    And Select the group by search in advanced search ("shgroup")
    And User click on "Add Groups"
    Then User should see pb alert "Active Directory group added successfully!" message 127 "TC05 Check if the AD Group is added to the repository"
    And User click on "Active Directory Groups" in bread crumbs
    Then Added ADgroup should be added in the repository active directory groups list 128 "TC06 Check if added AD Group is visible in the Active Directory Groups list in the Repository"
    And User click on burger menu
    And User click "User and License Management" under portal settings
    And User click on "Active Directory Groups"
    Then Added ADgroup should be added in the portal active directory groups list 129 "TC07 Check if added AD Group is visible in the Active Directory Groups list in the User Management"

  @tag4
  Scenario: Active Directory Group user is added to the repository
  TC08 Check if the Active Directory Group user is added to the repository
  TC09 Check if the Active Directory Group user is added to the User Management

    Given User open repository
    When User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Active Directory Groups"
    And User click on "Add Group"
    And Select the active directory domain
    And User click on "Users" under browser
    And Select the group by search in advanced search ("shgroup")
    And User click on "Add Groups"
    And Logout the user
    And User login ADgroupUserOrADuser (ADgroupUserOrADuser "ADU10")
    And Logout the user
    And User login as admin
    And User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    Then ADgroup user should be in repository user list "TC08 Check if the Active Directory Group user is added to the repository"
    And User click on burger menu
    And User click "User and License Management" under portal settings
    Then ADgroup user should be in portal user list "TC09 Check if the Active Directory Group user is added to the User Management"

  @tag5
  Scenario: TC10 Check if the AD Group is assigned default user group while adding
    Given User open repository
    When User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Active Directory Groups"
    And User click on "Add Group"
    And Select the active directory domain
    And User click on "Users" under browser
    And Select the group by search in advanced search ("shgroup")
    And Select the user group membership "Administrators"
    And User click on "Add Groups"
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Administrators"
    Then Added ADgroup should be added in the group 132 "TC10 Check if the AD Group is assigned default user group while adding"