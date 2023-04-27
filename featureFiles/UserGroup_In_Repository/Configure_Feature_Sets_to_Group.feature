#Author: kirankumar
@Configure_Feature_Sets_to_Group
Feature: This is for UserGroup in Repository

  Background:
    Given User login as admin
    When User click prolaborate logo
    And User credentials getting for testdata
      | UserFirstName | UserLastName |
      | test          | user         |


  @tag1
  Scenario: TC01 Check if the Feature set is enabled in the user group

    When User open repository
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test1"
    And User click on "Save"
    And User open "Test1" group
    Then Features set should be enabled (row 52) "TC01 Check if the Feature set is enabled in the user group"


  @tag2
  Scenario: TC02 Check if the Integration feature is checked, the register user will have this menu in Repository Configuration

    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User click on "Save"
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test1"
    And User assigned feature to user group (feature "Integrations")
    And User add the users in group (registeredUser 1)
    And User click on "Save"
    And Logout the user
    And Login the added user (registeredUser 1)
    And User open repository
    And User click on burger menu
    Then Assigned feature should be shown in menu in user account (feature "Integrated Application Projects") (row 53) "TC02 Check if the Integration feature is checked, the register user will have this menu in Repository Configuration"
    And Logout the user
    And User login as admin

  @tag3
  Scenario: TC03 Check if the Dashboard feature is checked, the register user will have this menu in Repository Configuration

    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the user credentials (userNo 3)
    And User click on "Save"
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test3"
    And User assigned feature to user group (feature "Dashboards")
    And User add the users in group (registeredUser 3)
    And User click on "Save"
    And Logout the user
    And Login the added user (registeredUser 3)
    And User open repository
    And User click on burger menu
    Then Assigned feature should be shown in menu in user account (feature "Dashboards") (row 54) "TC03 Check if the Dashboard feature is checked, the register user will have this menu in Repository Configuration"
    And Logout the user
    And User login as admin

  @tag4
  Scenario: TC04 Check if the Review feature is checked, the register user will have the Create Review option in the manage Reviews

    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the user credentials (userNo 4)
    And User click on "Save"
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test4"
    And User assigned feature to user group (feature "Reviews")
    And User add the users in group (registeredUser 4)
    And User click on "Save"
    And Logout the user
    And Login the added user (registeredUser 4)
    And User open repository
    And User click on burger menu
    Then Assigned feature should be shown in menu in user account (feature "Reviews") (row 55) "TC04 Check if the Review feature is checked, the register user will have the Create Review option in the manage Reviews"
    And Logout the user
    And User login as admin


  @tag5
  Scenario: TC05 Check if the Sections and Access Permissions  feature is checked, the register user will have these menu in Repository Configuration

    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the user credentials (userNo 5)
    And User click on "Save"
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test5"
    And User assigned feature to user group (feature "Sections and Access Permissions")
    And User add the users in group (registeredUser 5)
    And User click on "Save"
    And Logout the user
    And Login the added user (registeredUser 5)
    And User open repository
    And User click on burger menu
    Then Assigned feature should be shown in menu in user account (feature "Sections" "Access Permissions") (row 56) "TC05 Check if the Sections and Access Permissions  feature is checked, the register user will have these menu in Repository Configuration"
    And Logout the user
    And User login as admin

  @tag6
  Scenario: TC06 Check if the Modelling Language feature is checked, the register user will have this menu in Repository Configuration

    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the user credentials (userNo 6)
    And User click on "Save"
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test6"
    And User assigned feature to user group (feature "Modeling Languages")
    And User add the users in group (registeredUser 6)
    And User click on "Save"
    And Logout the user
    And Login the added user (registeredUser 6)
    And User open repository
    And User click on burger menu
    Then Assigned feature should be shown in menu in user account (feature "Modeling Languages") (row 57) "TC06 Check if the Modelling Language feature is checked, the register user will have this menu in Repository Configuration"
    And Logout the user
    And User login as admin

  @tag7
  Scenario: TC07 Check if the User and User Group feature is checked, the register user will have these menu in Repository Configuration

    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the user credentials (userNo 7)
    And User click on "Save"
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test7"
    And User assigned feature to user group (feature "Users and User Groups")
    And User add the users in group (registeredUser 7)
    And User click on "Save"
    And Logout the user
    And Login the added user (registeredUser 7)
    And User open repository
    And User click on burger menu
    Then Assigned feature should be shown in menu in user account (feature "Users" "User Groups") (row 58) "TC07 Check if the User and User Group feature is checked, the register user will have these menu in Repository Configuration"
    And Logout the user
    And User login as admin

  @tag8
  Scenario: TC08 Check if all the features are selected, the user will see all these menus in their Repository Configuration menu

    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the user credentials (userNo 8)
    And User click on "Save"
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test8"
    And User assigned all features to the user group
    And User add the users in group (registeredUser 8)
    And User click on "Save"
    And Logout the user
    And Login the added user (registeredUser 8)
    And User open repository
    And User click on burger menu
    Then Assigned all feature should be shown in menu in user account (row 59) "TC08 Check if all the features are selected, the user will see all these menus in ther  Repository Configuration menu"
    And Logout the user
    And User login as admin
    And User open repository
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User open "Test8" group
    And Remove all features from the group
    And User click on "Save"
    And Logout the user
    And Login the added user (registeredUser 8)
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    Then Features should not be shown in menu in user account (row 62) "TC11 Check if the features are unchecked, the respective menu should also not visible to the user"


  @tag9
  Scenario: TC09 Check if the features selected in the user group is visible to the AD user of that group

    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And Add the AD user
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test9"
    And User assigned all features to the user group
    And User add the users in group ("AD1002")
    And User click on "Save"
    And Logout the user
    And Login the added aduser
    And User open repository
    And User click on burger menu
    Then Assigned all feature should be shown in menu in user account (row 60) "TC09 Check if the features selected in the user group is visible to the AD user of that group"
    And Logout the user
    And User login as admin


  @tag10
  Scenario: TC10 Check if the features selected in the user group is visible to the SAML user of that group

    When Logout the user
    And User login with sso
    And Logout the user
    And User login as admin
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test10"
    And User assigned all features to the user group
    And User add the users in group ("kiran kumar")
    And User click on "Save"
    And Logout the user
    And User login with sso
    And User open repository
    And User click on burger menu
    Then Assigned all feature should be shown in menu in user account (row 61) "TC10 Check if the features selected in the user group is visible to the SAML user of that group"
    And Logout the user
    And User login as admin


  @tag11
  Scenario: TC12 Check if the Repository Settings feature is checked, the register user will have this menu in Repository Configuration

    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the user credentials (userNo 9)
    And User click on "Save"
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test9"
    And User assigned feature to user group (feature "Repository Settings")
    And User add the users in group (registeredUser 9)
    And User click on "Save"
    And Logout the user
    And Login the added user (registeredUser 9)
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    Then Assigned feature should be shown in menu in user account (feature "Repository Settings") (row 109) "TC12 Check if the Repository Settings feature is checked, the register user will have this menu in Repository Configuration"
    And Logout the user
    And User login as admin

  @tag12
  Scenario: TC13 Check if the Integration feature is checked, the register user will have this menu in Repository Configuration ADuser

    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And Add the AD user
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test1"
    And User assigned feature to user group (feature "Integrations")
    And User add the users in group ("AD1002")
    And User click on "Save"
    And Logout the user
    And User login ADgroupUserOrADuser (ADgroupUserOrADuser "AD1002")
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    Then Assigned feature should be shown in menu in user account (feature "Integrated Application Projects") (row 110) "TC13 Check if the Integration feature is checked, the register user will have this menu in Repository Configuration ADuser"
    And Logout the user
    And User login as admin

  @tag13
  Scenario: TC14 Check if the Dashboard feature is checked, the register user will have this menu in Repository Configuration ADuser

    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And Add the AD user
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test3"
    And User assigned feature to user group (feature "Dashboards")
    And User add the users in group ("AD1002")
    And User click on "Save"
    And Logout the user
    And User login ADgroupUserOrADuser (ADgroupUserOrADuser "AD1002")
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    Then Assigned feature should be shown in menu in user account (feature "Dashboards") (row 111) "TC14 Check if the Dashboard feature is checked, the register user will have this menu in Repository Configuration ADuser"
    And Logout the user
    And User login as admin

  @tag14
  Scenario: TC04 Check if the Review feature is checked, the register user will have the Create Review option in the manage Reviews ADuser

    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And Add the AD user
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test4"
    And User assigned feature to user group (feature "Reviews")
    And User add the users in group ("AD1002")
    And User click on "Save"
    And Logout the user
    And User login ADgroupUserOrADuser (ADgroupUserOrADuser "AD1002")
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    Then Assigned feature should be shown in menu in user account (feature "Reviews") (row 112) "TC15 Check if the Review feature is checked, the register user will have the Create Review option in the manage Reviews Aduser"
    And Logout the user
    And User login as admin


  @tag15
  Scenario: TC05 Check if the Sections and Access Permissions  feature is checked, the register user will have these menu in Repository Configuration ADuser

    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And Add the AD user
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test5"
    And User assigned feature to user group (feature "Sections and Access Permissions")
    And User add the users in group ("AD1002")
    And User click on "Save"
    And Logout the user
    And User login ADgroupUserOrADuser (ADgroupUserOrADuser "AD1002")
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    Then Assigned feature should be shown in menu in user account (feature "Sections" "Access Permissions") (row 113) "TC16 Check if the Sections and Access Permissions  feature is checked, the register user will have these menu in Repository Configuration Aduser"
    And Logout the user
    And User login as admin

  @tag16
  Scenario: TC06 Check if the Modelling Language feature is checked, the register user will have this menu in Repository Configuration ADuser

    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And Add the AD user
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test6"
    And User assigned feature to user group (feature "Modeling Languages")
    And User add the users in group ("AD1002")
    And User click on "Save"
    And Logout the user
    And User login ADgroupUserOrADuser (ADgroupUserOrADuser "AD1002")
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    Then Assigned feature should be shown in menu in user account (feature "Modeling Languages") (row 114) "TC17 Check if the Modelling Language feature is checked, the register user will have this menu in Repository Configuration ADuser"
    And Logout the user
    And User login as admin

  @tag17
  Scenario: TC07 Check if the User and User Group feature is checked, the register user will have these menu in Repository Configuration ADuser

    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And Add the AD user
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test7"
    And User assigned feature to user group (feature "Users and User Groups")
    And User add the users in group ("AD1002")
    And User click on "Save"
    And Logout the user
    And User login ADgroupUserOrADuser (ADgroupUserOrADuser "AD1002")
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    Then Assigned feature should be shown in menu in user account (feature "Users" "User Groups") (row 115) "TC18 Check if the User and User Group feature is checked, the register user will have these menu in Repository Configuration Aduser"
    And Logout the user
    And User login as admin

  @tag18
  Scenario: TC19 Check if the Repository Settings feature is checked, the register user will have this menu in Repository Configuration Aduser

    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And Add the AD user
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test9"
    And User assigned feature to user group (feature "Repository Settings")
    And User add the users in group ("AD1002")
    And User click on "Save"
    And Logout the user
    And User login ADgroupUserOrADuser (ADgroupUserOrADuser "AD1002")
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    Then Assigned feature should be shown in menu in user account (feature "Repository Settings") (row 116) "TC19 Check if the Repository Settings feature is checked, the register user will have this menu in Repository Configuration Aduser"
    And Logout the user
    And User login as admin

  @tag19
  Scenario:  TC20 Check if the Integration feature is checked, the register user will have this menu in Repository Configuration SAMLuser

    When Logout the user
    And User login with sso
    And Logout the user
    And User login as admin
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test10"
    And User assigned feature to user group (feature "Integrations")
    And User add the users in group ("kiran kumar")
    And User click on "Save"
    And Logout the user
    And User login with sso
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    Then Assigned feature should be shown in menu in user account (feature "Integrated Application Projects") (row 117) "TC20 Check if the Integration feature is checked, the register user will have this menu in Repository Configuration SAMLuser"
    And Logout the user
    And User login as admin


  @tag20
  Scenario: TC21 Check if the Dashboard feature is checked, the register user will have this menu in Repository Configuration SAMLuser

    When User open repository
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test3"
    And User assigned feature to user group (feature "Dashboards")
    And User add the users in group ("kiran kumar")
    And User click on "Save"
    And Logout the user
    And User login with sso
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    Then Assigned feature should be shown in menu in user account (feature "Dashboards") (row 118) "TC21 Check if the Dashboard feature is checked, the register user will have this menu in Repository Configuration SAMLuser"
    And Logout the user
    And User login as admin

  @tag21
  Scenario: TC22 Check if the Review feature is checked, the register user will have the Create Review option in the manage Reviews SAMLuser

    When User open repository
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test4"
    And User assigned feature to user group (feature "Reviews")
    And User add the users in group ("kiran kumar")
    And User click on "Save"
    And Logout the user
    And User login with sso
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    Then Assigned feature should be shown in menu in user account (feature "Reviews") (row 119) "TC22 Check if the Review feature is checked, the register user will have the Create Review option in the manage Reviews SAMLuser"
    And Logout the user
    And User login as admin


  @tag22
  Scenario: TC23 Check if the Sections and Access Permissions  feature is checked, the register user will have these menu in Repository Configuration SAMLuser

    When User open repository
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test5"
    And User assigned feature to user group (feature "Sections and Access Permissions")
    And User add the users in group ("kiran kumar")
    And User click on "Save"
    And Logout the user
    And User login with sso
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    Then Assigned feature should be shown in menu in user account (feature "Sections" "Access Permissions") (row 120) "TC23 Check if the Sections and Access Permissions  feature is checked, the register user will have these menu in Repository Configuration SAMLuser"
    And Logout the user
    And User login as admin

  @tag23
  Scenario: TC24 Check if the Modelling Language feature is checked, the register user will have this menu in Repository Configuration SAMLuser

    When User open repository
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test6"
    And User assigned feature to user group (feature "Modeling Languages")
    And User add the users in group ("kiran kumar")
    And User click on "Save"
    And Logout the user
    And User login with sso
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    Then Assigned feature should be shown in menu in user account (feature "Modeling Languages") (row 121) "TC24 Check if the Modelling Language feature is checked, the register user will have this menu in Repository Configuration SAMLuser"
    And Logout the user
    And User login as admin

  @tag24
  Scenario: TC25 Check if the User and User Group feature is checked, the register user will have these menu in Repository Configuration SAMLuser

    When User open repository
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test7"
    And User assigned feature to user group (feature "Users and User Groups")
    And User add the users in group ("kiran kumar")
    And User click on "Save"
    And Logout the user
    And User login with sso
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    Then Assigned feature should be shown in menu in user account (feature "Users" "User Groups") (row 122) "TC25 Check if the User and User Group feature is checked, the register user will have these menu in Repository Configuration SAMLuser"
    And Logout the user
    And User login as admin

  @tag25
  Scenario: TC26 Check if the Repository Settings feature is checked, the register user will have this menu in Repository Configuration SAMLuser

    When User open repository
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test9"
    And User assigned feature to user group (feature "Repository Settings")
    And User add the users in group ("kiran kumar")
    And User click on "Save"
    And Logout the user
    And User login with sso
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    Then Assigned feature should be shown in menu in user account (feature "Repository Settings") (row 123) "TC26 Check if the Repository Settings feature is checked, the register user will have this menu in Repository Configuration SAMLuser"
    And Logout the user
    And User login as admin