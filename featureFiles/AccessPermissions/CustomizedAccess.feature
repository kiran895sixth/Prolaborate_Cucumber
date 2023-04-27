#Author: kirankumar
Feature: This is for Access Permission

  Background:
    Given User login as admin
    When User click prolaborate logo
    And User credentials getting for testdata
      | UserFirstName | UserLastName |
      | test          | user         |

  @tag1
  Scenario: Validating Customized access
    When User open repository
    And User click on burger menu
    And User click "Sections" under repository configuration
    And Note the artifacts under the sections
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    Then Validate user can able to choose customized access (row 81) "TC01 Check whether user can able to choose customized access redio button"
    Then Validate PB alert message for successful switched (row 82) "TC02 Check whether PB alert message is shown when successfully switched customized access"
    Then Validate customized access help icon mouseover text (message "Customized access for users based on their roles or groups") (row 83) "TC03 Verifying the cusomized access help icon mouse over text is shown properly"
    Then Validate all artifacts shown in repository browser based on sections (row 84) "TC04 Check if the repository browser shows the artifact based on access or not"
    Then Validate the user or group tap is disabled state untill user choose repository browser (row 85) "TC05 Verify the user or group tap is disabled state untill user choose repository browser"
    Then Validate the read and collaborate access is selected by default in customized access permission (row 86) "TC06 Verify the read and collaborate access is selected by default in customized access permission"
    Then Validate the apply recursively toggle button is on by default (row 87) "TC07 Verify the apply recursively toggle button is on by default"
    Then Validate add button is shown properly (row 88) "TC08 Check whether add button is shown properly"

  @tag2
  Scenario: Validating Customized access
    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User click on "Save"
    And User click on burger menu
    And User click "Sections" under repository configuration
    And Note the artifacts under the sections
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User selecte the repository browser
    And selecte the user in user and usergroup dropdown (user 1)
    And User click on "Add" (indexValue is 2)
    Then Validate user is add in user or group list when click add button (user 1) (row 89) "TC09 Check whether user is add in user or group list when click add button"

  @tag3
  Scenario: Validating Customized access
    When User open repository
    And User click on burger menu
    And User click "Sections" under repository configuration
    And Note the artifacts under the sections
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User remove super admin access from the customized access
    And User selecte the repository browser (child package 1)
    And selecte the user in user and usergroup dropdown (user "Super Admin")
    And User click on "Add" (indexValue is 2)
    And User click on burger menu
    And User click "Reviews" under repository configuration
    And User navigate to create Review -Select Reciew Items tab
    Then Validate the repository browser in review shows based on access (row 90) "TC10 Check if the repository browser in review shows all the artifacts based on sections or not"


  @tag4
  Scenario: Validating Customized access
    When User open repository
    And User click on burger menu
    And User click "Sections" under repository configuration
    And Note the artifacts under the sections
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User remove super admin access from the customized access
    And User selecte the repository browser (child package 1)
    And selecte the user in user and usergroup dropdown (user "Super Admin")
    And User click on "Add" (indexValue is 2)
    And User click on burger menu
    And User click "Dashboards" under repository configuration
    And User click on "Create Dashboard"
    And User click on "Create New"
    And User add "Charts" Widget
    And Close choose report from list window
    And User choose "Pie" chart type
    Then Validate the browser in charts source selection tab shows based on sections (row 91) "TC11 Check if the repository browser in charts shows all the artifacts based on sections or not"
    And User click on "Cancel" (indexValue is 2)
    And User add "Reports" Widget
    And Close choose report from list window
    Then Validate the browser in reports source selection tab shows based on sections (row 92) "TC12 Check if the repository browser in reports shows all the artifacts based on sections or not"
    And User click on "Cancel" (indexValue is 2)
    And User add "Hyperlinks" Widget
    Then Validate the browser in hyperlinks select an item window shows based on sections (row 93) "TC13 Check if the repository browser in hyper link widget shows all the artifacts based on sections or not"
    And User click on "Cancel" (indexValue is 2)
    And User add "Diagrams" Widget
    Then Validate the browser in Diagrams select an diagram window shows based on sections (row 94) "TC14 Check if the repository browser in Diagram widget shows all the artifacts based on sections or not"


  @tag5
  Scenario: TC15 Check if the admin user shows the artifacts based on access permission or not
    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User click on "Save"
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Customized" access
    And User selecte the repository browser (child package 1)
    And selecte the user in user and usergroup dropdown (user 1)
    And User click on "Add" (indexValue is 2)
    And User click on burger menu
    And User click "User and License Management" under portal settings
    And User open (user 1)
    And User click Make user as a admin
    And User click on "Save"
    And Logout the user
    And Login the added user (registeredUser 1)
    And User open repository
    Then the user shows the artifacts based on access (row 95) "TC15 Check if the admin user shows the artifacts based on access or not"
    And Logout the user
    And User login as admin


  @tag6
  Scenario: TC16 Check if the Registered user shows the artifacts based on access permission or not
    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User click on "Save"
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Customized" access
    And User selecte the repository browser (child package 1)
    And selecte the user in user and usergroup dropdown (user 1)
    And User click on "Add" (indexValue is 2)
    And Logout the user
    And Login the added user (registeredUser 1)
    And User open repository
    Then the user shows the artifacts based on access (row 96) "TC16 Check if the Registered user shows the artifacts based on access or not"
    And Logout the user
    And User login as admin

  @tag7
  Scenario: TC17 Check if the AD user shows shows the artifacts based on access permission or not
    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User click on "Add Active Directory User"
    And Select the active directory user (uesr "Andi")
    And User click on "Add Users"
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Customized" access
    And User selecte the repository browser (child package 1)
    And selecte the user in user and usergroup dropdown (user "Andi")
    And User click on "Add" (indexValue is 2)
    And Logout the user
    And User login ADgroupUserOrADuser (ADgroupUserOrADuser "Andi")
    And User open repository
    Then the user shows the artifacts based on access (row 97) "TC17 Check if the AD user shows the artifacts based on access or not"
    And Logout the user
    And User login as admin

  @tag8
  Scenario: TC18 Check if the AD group user shows the artifacts based on access or not
    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Active Directory Groups"
    And User click on "Add Group"
    And Select the group by search in advanced search ("kiran_Automation")
    And User click on "Add Groups"
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Customized" access
    And User selecte the repository browser (child package 1)
    And selecte the user in user and usergroup dropdown (user "kiran_Automation")
    And User click on "Add" (indexValue is 2)
    And Logout the user
    And User login ADgroupUserOrADuser (ADgroupUserOrADuser "kiran")
    And User open repository
    Then the user shows the artifacts based on access (row 98) "TC18 Check if the AD group user shows the artifacts based on access or not"
    And Logout the user
    And User login as admin


  @tag9
  Scenario: TC19 Check if the group user shows the artifacts based on access or not
    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User click on "Save"
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test2"
    And User add the users in group (registeredUser 1)
    And User assigned feature to user group (feature "Dashboards")
    And User click on "Save"
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Customized" access
    And User selecte the repository browser (child package 1)
    And selecte the user in user and usergroup dropdown (user "Test2")
    And User click on "Add" (indexValue is 2)
    And Logout the user
    And Login the added user (registeredUser 1)
    And User open repository
    Then the user shows the artifacts based on access (row 99) "TC19 Check if the group user shows the artifacts based on access or not"
    And Logout the user
    And User login as admin


  @tag10
  Scenario: TC20 Check if the identity user shows the artifacts based on access or not
    When Logout the user
    And User login with sso
    And Logout the user
    And User login as admin
    And User open repository
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Customized" access
    And User selecte the repository browser (child package 1)
    And selecte the user in user and usergroup dropdown (user "kiran kumar")
    And User click on "Add" (indexValue is 2)
    And Logout the user
    And User login with sso
    And User open repository
    Then the user shows the artifacts based on access (row 100) "TC20 Check if the identity user shows the artifacts based on access or not"
    And Logout the user
    And User login as admin

  @tag11
  Scenario: TC21 Check if the invite user shows the artifacts based on access or not
    When User open repository
    And select repository browser package and invite user via email
    And User join the prolaborate via invite link
    And User click login as user in profile
    And Logout the user
    And User login as admin
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Customized" access
    And User selecte the repository browser
    And select the inviteuser in user and usergroup dropdown
    And User click on "Add" (indexValue is 2)
    And Logout the user
    And Login invite user
    Then the user shows the artifacts based on access (row 101) "TC21 Check if the invite user shows the artifacts based on access or not"
    And Logout the user
    And User login as admin

  @tag12
  Scenario: TC22 Check if the admin user can do Read, write and collaborate operation on accessed artifacts or not
    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User click on "Save"
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Customized" access
    And User selecte the repository browser (child package 1)
    And selecte the user in user and usergroup dropdown (user 1)
    And User choose read write collaborate access
    And User click on "Add" (indexValue is 2)
    And User click on burger menu
    And User click "User and License Management" under portal settings
    And User open (user 1)
    And User click Make user as a admin
    And User click on "Save"
    And Logout the user
    And Login the added user (registeredUser 1)
    And User open repository
    Then Validate user can able to do all operations by customized access (row 102) "TC22 Check if the admin user can do Read, write and collaborate operation on accessed artifacts"
    And Logout the user
    And User login as admin

  @tag13
  Scenario: TC23 Check if the registered user can do Read, write and collaborate operation on accessed artifacts or not
    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User click on "Save"
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Customized" access
    And User selecte the repository browser (child package 1)
    And selecte the user in user and usergroup dropdown (user 1)
    And User choose read write collaborate access
    And User click on "Add" (indexValue is 2)
    And Logout the user
    And Login the added user (registeredUser 1)
    And User open repository
    Then Validate user can able to do all operations by customized access (row 103) "TC23 Check if the registered user can do Read, write and collaborate operation on accessed artifacts"
    And Logout the user
    And User login as admin


  @tag14
  Scenario: TC24 Check if the AD user can do Read, write and collaborate operation on accessed artifacts or not
    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User click on "Add Active Directory User"
    And Select the active directory user (uesr "Andi")
    And User click on "Add Users"
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Customized" access
    And User selecte the repository browser (child package 1)
    And selecte the user in user and usergroup dropdown (user "Andi")
    And User choose read write collaborate access
    And User click on "Add" (indexValue is 2)
    And Logout the user
    And User login ADgroupUserOrADuser (ADgroupUserOrADuser "Andi")
    And User open repository
    Then Validate user can able to do all operations by customized access (row 104) "TC24 Check if the AD user can do Read, write and collaborate operation on accessed artifacts"
    And Logout the user
    And User login as admin


  @tag15
  Scenario: TC25 Check if the AD Group user can do Read, write and collaborate operation on accessed artifacts or not
    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Active Directory Groups"
    And User click on "Add Group"
    And Select the group by search in advanced search ("kiran_Automation")
    And User click on "Add Groups"
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Customized" access
    And User selecte the repository browser (child package 1)
    And selecte the user in user and usergroup dropdown (user "kiran_Automation")
    And User choose read write collaborate access
    And User click on "Add" (indexValue is 2)
    And Logout the user
    And User login ADgroupUserOrADuser (ADgroupUserOrADuser "kiran")
    And User open repository
    Then Validate user can able to do all operations by customized access (row 105) "TC25 Check if the AD Group user can do Read, write and collaborate operation on accessed artifacts"
    And Logout the user
    And User login as admin


  @tag16
  Scenario: TC26 Check if the Group user can do Read, write and collaborate operation on accessed artifacts or not
    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User click on "Save"
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test2"
    And User add the users in group (registeredUser 1)
    And User assigned feature to user group (feature "Dashboards")
    And User click on "Save"
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Customized" access
    And User selecte the repository browser (child package 1)
    And selecte the user in user and usergroup dropdown (user "Test2")
    And User choose read write collaborate access
    And User click on "Add" (indexValue is 2)
    And Logout the user
    And Login the added user (registeredUser 1)
    And User open repository
    Then Validate user can able to do all operations by customized access (row 106) "TC26 Check if the group user can do Read, write and collaborate operation on accessed artifacts"
    And Logout the user
    And User login as admin


  @tag17
  Scenario: TC27 Check if the identity user can do Read, write and collaborate operation on accessed artifacts or not
    When Logout the user
    And User login with sso
    And Logout the user
    And User login as admin
    And User open repository
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Customized" access
    And User selecte the repository browser (child package 1)
    And selecte the user in user and usergroup dropdown (user "kiran kumar")
    And User choose read write collaborate access
    And User click on "Add" (indexValue is 2)
    And Logout the user
    And User login with sso
    And User open repository
    Then Validate user can able to do all operations by customized access (row 107) "TC27 Check if the identity user can do Read, write and collaborate operation on accessed artifacts"
    And Logout the user
    And User login as admin

  @tag18
  Scenario: TC28 Check if the invited user can do Read, write and collaborate operation on accessed artifacts or not
    When User open repository
    And select repository browser package and invite user via email
    And User join the prolaborate via invite link
    And User click login as user in profile
    And Logout the user
    And User login as admin
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Customized" access
    And User selecte the repository browser
    And select the inviteuser in user and usergroup dropdown
    And User choose read write collaborate access
    And User click on "Add" (indexValue is 2)
    And Logout the user
    And Login invite user
    Then Validate invite user can able to do all operations by customized access (row 108) "TC28 Check if the invite user can do Read, write and collaborate operation on accessed artifacts"
    And Logout the user
    And User login as admin

  @tag19
  Scenario: TC29 TC30 Check if admin user my Diagrams shown properly based on accessed artifacts
    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User click on "Save"
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Customized" access
    And User selecte the repository browser (child package 1)
    And selecte the user in user and usergroup dropdown (user 1)
    And User choose read write collaborate access
    And User click on "Add" (indexValue is 2)
    And User click on burger menu
    And User click "User and License Management" under portal settings
    And User open (user 1)
    And User click Make user as a admin
    And User click on "Save"
    And Logout the user
    And Login the added user (registeredUser 1)
    And User open repository
    And User click on "Diagrams" from header tab
    Then Validate my Diagrams shown properly (row 109 110) "TC29 TC30 Check if admin user my Diagrams shown properly based on accessed artifacts"
    And Logout the user
    And User login as admin

  @tag20
  Scenario: TC31 TC32 Check if registered user my Diagrams shown properly based on accessed artifacts
    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User click on "Save"
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Customized" access
    And User selecte the repository browser (child package 1)
    And selecte the user in user and usergroup dropdown (user 1)
    And User choose read write collaborate access
    And User click on "Add" (indexValue is 2)
    And Logout the user
    And Login the added user (registeredUser 1)
    And User open repository
    And User click on "Diagrams" from header tab
    Then Validate my Diagrams shown properly (row 111 112) "TC31 TC32 Check if registered user my Diagrams shown properly based on accessed artifacts"
    And Logout the user
    And User login as admin


  @tag21
  Scenario: TC33 TC34 Check if AD user my Diagrams shown properly based on accessed artifacts
    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User click on "Add Active Directory User"
    And Select the active directory user (uesr "Andi")
    And User click on "Add Users"
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Customized" access
    And User selecte the repository browser (child package 1)
    And selecte the user in user and usergroup dropdown (user "Andi")
    And User choose read write collaborate access
    And User click on "Add" (indexValue is 2)
    And Logout the user
    And User login ADgroupUserOrADuser (ADgroupUserOrADuser "Andi")
    And User open repository
    And User click on "Diagrams" from header tab
    Then Validate my Diagrams shown properly (row 113 114) "TC33 TC34 Check if AD user my Diagrams shown properly based on accessed artifacts"
    And Logout the user
    And User login as admin

  @tag22
  Scenario: TC35 TC36 Check if AD group user my Diagrams shown properly based on accessed artifacts
    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Active Directory Groups"
    And User click on "Add Group"
    And Select the group by search in advanced search ("kiran_Automation")
    And User click on "Add Groups"
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Customized" access
    And User selecte the repository browser (child package 1)
    And selecte the user in user and usergroup dropdown (user "kiran_Automation")
    And User choose read write collaborate access
    And User click on "Add" (indexValue is 2)
    And Logout the user
    And User login ADgroupUserOrADuser (ADgroupUserOrADuser "kiran")
    And User open repository
    And User click on "Diagrams" from header tab
    Then Validate my Diagrams shown properly (row 115 116) "TC35 TC36 Check if AD group user my Diagrams shown properly based on accessed artifacts"
    And Logout the user
    And User login as admin


  @tag23
  Scenario: TC37 TC38 Check if identity user my Diagrams shown properly based on accessed artifacts
    When Logout the user
    And User login with sso
    And Logout the user
    And User login as admin
    And User open repository
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Customized" access
    And User selecte the repository browser (child package 1)
    And selecte the user in user and usergroup dropdown (user "kiran kumar")
    And User choose read write collaborate access
    And User click on "Add" (indexValue is 2)
    And Logout the user
    And User login with sso
    And User open repository
    And User click on "Diagrams" from header tab
    Then Validate my Diagrams shown properly (row 117 118) "TC37 TC38 Check if identity user my Diagrams shown properly based on accessed artifacts"
    And Logout the user
    And User login as admin

  @tag24
  Scenario: TC39 TC40 Check if group user my Diagrams shown properly based on accessed artifacts
    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User click on "Save"
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test2"
    And User add the users in group (registeredUser 1)
    And User assigned feature to user group (feature "Dashboards")
    And User click on "Save"
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Customized" access
    And User selecte the repository browser (child package 1)
    And selecte the user in user and usergroup dropdown (user "Test2")
    And User choose read write collaborate access
    And User click on "Add" (indexValue is 2)
    And Logout the user
    And Login the added user (registeredUser 1)
    And User open repository
    And User click on "Diagrams" from header tab
    Then Validate my Diagrams shown properly (row 119 120) "TC39 TC40 Check if group user my Diagrams shown properly based on accessed artifacts"
    And Logout the user
    And User login as admin


  @tag25
  Scenario: TC41 TC42 Check if invite user my Diagrams shown properly based on accessed artifacts
    When User open repository
    And select repository browser package and invite user via email (parent package)
    And User join the prolaborate via invite link
    And User click login as user in profile
    And Logout the user
    And User login as admin
    And User open repository
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Customized" access
    And User selecte the repository browser (child package 1)
    And select the inviteuser in user and usergroup dropdown
    And User choose read write collaborate access
    And User click on "Add" (indexValue is 2)
    And Logout the user
    And Login invite user
    And User click on "Diagrams" from header tab
    Then Validate my Diagrams shown properly (row 121 122) "TC41 TC42 Check if invite user my Diagrams shown properly based on accessed artifacts"
    And Logout the user
    And User login as admin


  @tag26
  Scenario: TC43 TC44 Check if the admin user can do Read and collaborate operation on accessed artifacts or not
    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User click on "Save"
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Customized" access
    And User selecte the repository browser (child package 1)
    And selecte the user in user and usergroup dropdown (user 1)
    And User click on "Add" (indexValue is 2)
    And User click on burger menu
    And User click "User and License Management" under portal settings
    And User open (user 1)
    And User click Make user as a admin
    And User click on "Save"
    And Logout the user
    And Login the added user (registeredUser 1)
    And User open repository
    Then Validate user can able to do read and collaborate operations based on customized access (row 123 and 124) "TC43 TC44 Apply Read and collaborate access and check whether the admin user can do read and collaborate operation alone or not"
    And Logout the user
    And User login as admin

  @tag27
  Scenario: TC45 TC46 Check if the registered user can do Read and collaborate operation on accessed artifacts or not
    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User click on "Save"
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Customized" access
    And User selecte the repository browser (child package 1)
    And selecte the user in user and usergroup dropdown (user 1)
    And User click on "Add" (indexValue is 2)
    And Logout the user
    And Login the added user (registeredUser 1)
    And User open repository
    Then Validate user can able to do read and collaborate operations based on customized access (row 125 and 126) "TC45 TC46 Apply Read and collaborate access and check whether the registered user can do read and collaborate operation alone or not"
    And Logout the user
    And User login as admin


  @tag28
  Scenario: TC47 TC48 Check if the AD user can do Read and collaborate operation on accessed artifacts or not
    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User click on "Add Active Directory User"
    And Select the active directory user (uesr "Andi")
    And User click on "Add Users"
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Customized" access
    And User selecte the repository browser (child package 1)
    And selecte the user in user and usergroup dropdown (user "Andi")
    And User click on "Add" (indexValue is 2)
    And Logout the user
    And User login ADgroupUserOrADuser (ADgroupUserOrADuser "Andi")
    And User open repository
    Then Validate user can able to do read and collaborate operations based on customized access (row 127 and 128) "TC47 TC48 Apply Read and collaborate access and check whether the AD user can do read and collaborate operation alone or not"
    And Logout the user
    And User login as admin


  @tag29
  Scenario: TC49 TC50 Check if the AD group user can do Read and collaborate operation on accessed artifacts or not
    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Active Directory Groups"
    And User click on "Add Group"
    And Select the group by search in advanced search ("kiran_Automation")
    And User click on "Add Groups"
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Customized" access
    And User selecte the repository browser (child package 1)
    And selecte the user in user and usergroup dropdown (user "kiran_Automation")
    And User click on "Add" (indexValue is 2)
    And Logout the user
    And User login ADgroupUserOrADuser (ADgroupUserOrADuser "kiran")
    And User open repository
    Then Validate user can able to do read and collaborate operations based on customized access (row 129 and 130) "TC49 TC50 Apply Read and collaborate access and check whether the AD group user can do read and collaborate operation alone or not"
    And Logout the user
    And User login as admin


  @tag16
  Scenario: TC26 Check if the Group user can do Read, write and collaborate operation on accessed artifacts or not
    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User click on "Save"
    And User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "Test2"
    And User add the users in group (registeredUser 1)
    And User assigned feature to user group (feature "Dashboards")
    And User click on "Save"
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Customized" access
    And User selecte the repository browser (child package 1)
    And selecte the user in user and usergroup dropdown (user "Test2")
    And User choose read write collaborate access
    And User click on "Add" (indexValue is 2)
    And Logout the user
    And Login the added user (registeredUser 1)
    And User open repository
    Then Validate user can able to do all operations by customized access (row 106) "TC26 Check if the group user can do Read, write and collaborate operation on accessed artifacts"
    And Logout the user
    And User login as admin


  @tag17
  Scenario: TC27 Check if the identity user can do Read, write and collaborate operation on accessed artifacts or not
    When Logout the user
    And User login with sso
    And Logout the user
    And User login as admin
    And User open repository
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Customized" access
    And User selecte the repository browser (child package 1)
    And selecte the user in user and usergroup dropdown (user "kiran kumar")
    And User choose read write collaborate access
    And User click on "Add" (indexValue is 2)
    And Logout the user
    And User login with sso
    And User open repository
    Then Validate user can able to do all operations by customized access (row 107) "TC27 Check if the identity user can do Read, write and collaborate operation on accessed artifacts"
    And Logout the user
    And User login as admin

  @tag18
  Scenario: TC28 Check if the invited user can do Read, write and collaborate operation on accessed artifacts or not
    When User open repository
    And select repository browser package and invite user via email
    And User join the prolaborate via invite link
    And User click login as user in profile
    And Logout the user
    And User login as admin
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Customized" access
    And User selecte the repository browser
    And select the inviteuser in user and usergroup dropdown
    And User choose read write collaborate access
    And User click on "Add" (indexValue is 2)
    And Logout the user
    And Login invite user
    Then Validate invite user can able to do all operations by customized access (row 108) "TC28 Check if the invite user can do Read, write and collaborate operation on accessed artifacts"
    And Logout the user
    And User login as admin





