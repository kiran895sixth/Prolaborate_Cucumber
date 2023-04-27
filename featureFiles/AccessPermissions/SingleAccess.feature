#Author: kirankumar
Feature: This is for Access Permission

  Background:
    Given User login as admin
    When User click prolaborate logo
    And User credentials getting for testdata
      | UserFirstName | UserLastName |
      | test          | user         |

  @tag1
  Scenario: Validating single access
    When User open repository
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    Then Validate user can able to choose single access (row 1) "TC01 Check whether user can able to choose single access redio button"
    Then Validate PB alert message for successful switched (row 2) "TC02 Check whether PB alert message is shown when successfully switched single access"
    Then Validate single access help icon mouseover text (message "Single access for everyone in the repository") (row 3) "TC03 Verifying the single access help icon mouse over text is shown properly"
    Then Validate select field shown all access by default (row 4) "TC04 Check the selected field is shown all access by default(read,write,collaborate)"
    Then Validate apply button show properly (row 5) "TC05 Check whether apply button is shown properly"
    And User click on "Apply"
    Then Validate PB alert message for successful applied (row 6) "TC06 Check whether PB alert message is shown when click apply button"
    And User click on burger menu
    And User click "Sections" under repository configuration
    And Note the artifacts under the sections
    And User click on home button
    Then Validate all artifacts shown in repository browser based on sections (row 7) "TC07 Apply single access and check whether it is showing all the artifacts in repository browser or not"


  @tag2
  Scenario: Validating single access
    When User open repository
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Single" access
    And User click on burger menu
    And User click "Sections" under repository configuration
    And Note the artifacts under the sections
    And User click on burger menu
    And User click "Reviews" under repository configuration
    And User navigate to create Review -Select Reciew Items tab
    Then Validate the repository browser in review shows based on sections (row 8) "TC08 Check if the repository browser in review shows all the artifacts based on sections or not."
    And User click on burger menu
    And User click "Dashboards" under repository configuration
    And User click on "Discard"
    And User click on "Create Dashboard"
    And User click on "Create New"
    And User add "Charts" Widget
    And Close choose report from list window
    And User choose "Pie" chart type
    Then Validate the browser in charts source selection tab shows based on sections (row 9) "TC09 Check if the repository browser in charts shows all the artifacts based on sections or not"


  @tag3
  Scenario: TC10 Check if the repository browser in reports shows all the artifacts based on sections or not
    When User open repository
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Single" access
    And User click on burger menu
    And User click "Sections" under repository configuration
    And Note the artifacts under the sections
    And User click on burger menu
    And User click "Dashboards" under repository configuration
    And User click on "Create Dashboard"
    And User click on "Create New"
    And User add "Reports" Widget
    And Close choose report from list window
    Then Validate the browser in reports source selection tab shows based on sections (row 10) "TC10 Check if the repository browser in reports shows all the artifacts based on sections or not"

  @tag4
  Scenario: TC11 Check if the repository browser in hyper link widget shows all the artifacts based on sections or not
    When User open repository
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Single" access
    And User click on burger menu
    And User click "Sections" under repository configuration
    And Note the artifacts under the sections
    And User click on burger menu
    And User click "Dashboards" under repository configuration
    And User click on "Create Dashboard"
    And User click on "Create New"
    And User add "Hyperlinks" Widget
    Then Validate the browser in hyperlinks select an item window shows based on sections (row 11) "TC11 Check if the repository browser in hyper link widget shows all the artifacts based on sections or not"

  @tag5
  Scenario: TC12 Check if the repository browser in Diagram widget shows all the artifacts based on sections or not
    When User open repository
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Single" access
    And User click on burger menu
    And User click "Sections" under repository configuration
    And Note the artifacts under the sections
    And User click on burger menu
    And User click "Dashboards" under repository configuration
    And User click on "Create Dashboard"
    And User click on "Create New"
    And User add "Diagrams" Widget
    Then Validate the browser in Diagrams select an diagram window shows based on sections (row 12) "TC12 Check if the repository browser in Diagram widget shows all the artifacts based on sections or not"



  @tag6
  Scenario: TC13 Check whether the super admin can able to do all the operation properly
    When User open repository
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Single" access
    And User click on home button
    Then Validate user can able to do all operations (row 13) "TC13 Check whether the super admin can able to do all the operation properly"

  @tag7
  Scenario: TC14 Check if the admin user shows all the artifacts based on sections or not
    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User click on "Save"
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Single" access
    And User click on burger menu
    And User click "Sections" under repository configuration
    And Note the artifacts under the sections
    And User click on burger menu
    And User click "User and License Management" under portal settings
    And User open (user 1)
    And User click Make user as a admin
    And User click on "Save"
    And Logout the user
    And Login the added user (registeredUser 1)
    And User open repository
    Then Validate admin user get all artifacts based on sections (row 14) "TC14 Check if the admin user shows all the artifacts based on sections or not"
    Then Validate user can able to do all operations (row 20) "TC20 Check whether the super admin can able to do all the operation properly"
    And Logout the user
    And User login as admin

  @tag8
  Scenario: TC15 Check if the registered user shows all the artifacts based on sections or not
    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User click on "Save"
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Single" access
    And User click on burger menu
    And User click "Sections" under repository configuration
    And Note the artifacts under the sections
    And Logout the user
    And Login the added user (registeredUser 1)
    And User open repository
    Then Validate registered user get all artifacts based on sections (row 15) "TC15 Check if the registered user shows all the artifacts based on sections or not"
    Then Validate user can able to do all operations (row 21) "TC21 Check whether the registered user can able to do all the operation properly"
    And Logout the user
    And User login as admin

  @tag9
  Scenario: TC16 Check if the AD user shows all the artifacts based on sections or not
    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User click on "Add Active Directory User"
    And Select the active directory user (uesr "Andi")
    And User click on "Add Users"
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Single" access
    And User click on burger menu
    And User click "Sections" under repository configuration
    And Note the artifacts under the sections
    And Logout the user
    And User login ADgroupUserOrADuser (ADgroupUserOrADuser "Andi")
    And User open repository
    Then Validate registered user get all artifacts based on sections (row 16) "TC16 Check if the AD user shows all the artifacts based on sections or not"
    Then Validate user can able to do all operations (row 22) "TC22 Check whether the AD user can able to do all the operation properly"
    And Logout the user
    And User login as admin

  @tag10
  Scenario: TC17 Check if the AD group user shows all the artifacts based on sections or not
    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Active Directory Groups"
    And User click on "Add Group"
    And Select the group by search in advanced search ("kiran_Automation")
    And User click on "Add Groups"
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Single" access
    And User click on burger menu
    And User click "Sections" under repository configuration
    And Note the artifacts under the sections
    And Logout the user
    And User login ADgroupUserOrADuser (ADgroupUserOrADuser "kiran")
    And User open repository
    Then Validate registered user get all artifacts based on sections (row 17) "TC17 Check if the AD group user shows all the artifacts based on sections or not"
    Then Validate user can able to do all operations (row 23) "TC23 Check whether the AD group user can able to do all the operation properly"
    And Logout the user
    And User login as admin


  @tag11
  Scenario: TC19 Check if the invite user shows all the artifacts based on sections or not
    When User open repository
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Single" access
    And User click on burger menu
    And User click "Sections" under repository configuration
    And Note the artifacts under the sections
    And User click on home button
    And select repository browser package and invite user via email
    And User join the prolaborate via invite link
    And User click login as user in profile
    Then Validate invite user get all artifacts based on sections (row 19) "TC19 Check if the invite user shows all the artifacts based on sections or not"
    Then Validate user can able to do all operations (row 25) "TC25 Check whether the invite user can able to do all the operation properly"


  @tag12
  Scenario: Validating the read and wirte operations only can be performed admin user
    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User click on "Save"
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Single" access
    And User give permission Read and Write
    And User click on "Apply"
    And User click on burger menu
    And User click "User and License Management" under portal settings
    And User open (user 1)
    And User click Make user as a admin
    And User click on "Save"
    And Logout the user
    And Login the added user (registeredUser 1)
    And User open repository
    Then Validate user can able to do read and write operations (row 27 and 26) "TC27 TC26 Apply Read and Write access and check whether the admin user can do read and write operation alone or not"
    And Logout the user
    And User login as admin


  @tag13
  Scenario: Validating the read and wirte operations only can be performed for registered users
    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User click on "Save"
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Single" access
    And User give permission Read and Write
    And User click on "Apply"
    And Logout the user
    And Login the added user (registeredUser 1)
    And User open repository
    Then Validate user can able to do read and write operations (row 29 and 28) "TC29 TC28 Apply Read and Write access and check whether the registered user can do read and write operation alone or not"
    And Logout the user
    And User login as admin

  @tag14
  Scenario: Validating the read and wirte operations only can be performed for AD users
    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User click on "Add Active Directory User"
    And Select the active directory user (uesr "Andi")
    And User click on "Add Users"
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Single" access
    And User give permission Read and Write
    And User click on "Apply"
    And Logout the user
    And User login ADgroupUserOrADuser (ADgroupUserOrADuser "Andi")
    And User open repository
    Then Validate user can able to do read and write operations (row 31 and 30) "TC31 TC30 Apply Read and Write access and check whether the AD user can do read and write operation alone or not"
    And Logout the user
    And User login as admin


  @tag15
  Scenario: Validating the read and wirte operations only can be performed for AD group users
    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Active Directory Groups"
    And User click on "Add Group"
    And Select the group by search in advanced search ("kiran_Automation")
    And User click on "Add Groups"
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Single" access
    And User give permission Read and Write
    And User click on "Apply"
    And Logout the user
    And User login ADgroupUserOrADuser (ADgroupUserOrADuser "kiran")
    And User open repository
    Then Validate user can able to do read and write operations (row 33 and 32) "TC33 TC32 Apply Read and Write access and check whether the AD group user can do read and write operation alone or not"
    And Logout the user
    And User login as admin


  @tag16
  Scenario: Validating the read and wirte operations only can be performed for invite users
    When User open repository
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Customized" access
    And User choose "Single" access
    And User click on home button
    And select repository browser package and invite user via email
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Single" access
    And User give permission Read and Write
    And User click on "Apply"
    And User join the prolaborate via invite link
    And User click login as user in profile
    Then Validate user can able to do read and write operations (row 37 and 36) "TC37 TC36 Apply Read and Write access and check whether the invite user can do read and write operation alone or not"


  @tag17
  Scenario: Validating the read and collaborate operations only can be performed admin user
    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User click on "Save"
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Single" access
    And User give permission Read and Collaborate
    And User click on "Apply"
    And User click on burger menu
    And User click "User and License Management" under portal settings
    And User open (user 1)
    And User click Make user as a admin
    And User click on "Save"
    And Logout the user
    And Login the added user (registeredUser 1)
    And User open repository
    Then Validate user can able to do read and collaborate operations (row 38 and 39) "TC38 TC39 Apply Read and collaborate access and check whether the admin user can do read and collaborate operation alone or not"
    And Logout the user
    And User login as admin

  @tag18
  Scenario: Validating the read and collaborate operations only can be performed for registered users
    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User click on "Save"
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Single" access
    And User give permission Read and Collaborate
    And User click on "Apply"
    And Logout the user
    And Login the added user (registeredUser 1)
    And User open repository
    Then Validate user can able to do read and collaborate operations (row 40 and 41) "TC40 TC41 Apply Read and collaborate access and check whether the registered user can do read and collaborate operation alone or not"
    And Logout the user
    And User login as admin

  @tag19
  Scenario: Validating the read and collaborate operations only can be performed for AD users
    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User click on "Add Active Directory User"
    And Select the active directory user (uesr "Andi")
    And User click on "Add Users"
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Single" access
    And User give permission Read and Collaborate
    And User click on "Apply"
    And Logout the user
    And User login ADgroupUserOrADuser (ADgroupUserOrADuser "Andi")
    And User open repository
    Then Validate user can able to do read and collaborate operations (row 42 and 43) "TC42 TC43 Apply Read and collaborate access and check whether the AD user can do read and collaborate operation alone or not"
    And Logout the user
    And User login as admin

  @tag20
  Scenario: Validating the read and collaborate operations only can be performed for AD group users
    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Active Directory Groups"
    And User click on "Add Group"
    And Select the group by search in advanced search ("kiran_Automation")
    And User click on "Add Groups"
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Single" access
    And User give permission Read and Collaborate
    And User click on "Apply"
    And Logout the user
    And User login ADgroupUserOrADuser (ADgroupUserOrADuser "kiran")
    And User open repository
    Then Validate user can able to do read and collaborate operations (row 44 and 45) "TC44 TC45 Apply Read and collaborate access and check whether the AD group user can do read and collaborate operation alone or not"
    And Logout the user
    And User login as admin

  @tag21
  Scenario: Validating the read and collaborate operations only can be performed for invite users
    When User open repository
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Customized" access
    And User choose "Single" access
    And User click on home button
    And select repository browser package and invite user via email
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Single" access
    And User give permission Read and Collaborate
    And User click on "Apply"
    And User join the prolaborate via invite link
    And User click login as user in profile
    Then Validate user can able to do read and collaborate operations (row 48 and 49) "TC48 TC49 Apply Read and collaborate access and check whether the invite user can do read and collaborate operation alone or not"


  @tag22
  Scenario: Validating the read operations only can be performed admin user
    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User click on "Save"
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Single" access
    And User give permission Read
    And User click on "Apply"
    And User click on burger menu
    And User click "User and License Management" under portal settings
    And User open (user 1)
    And User click Make user as a admin
    And User click on "Save"
    And Logout the user
    And Login the added user (registeredUser 1)
    And User open repository
    Then Validate user can able to do read operations (row 50 and 51) "TC50 TC51 Apply Read access and check whether the admin user can do read alone or not"
    And Logout the user
    And User login as admin

  @tag23
  Scenario: Validating the read operations only can be performed for registered users
    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the user credentials (userNo 1)
    And User click on "Save"
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Single" access
    And User give permission Read
    And User click on "Apply"
    And Logout the user
    And Login the added user (registeredUser 1)
    And User open repository
    Then Validate user can able to do read operations (row 52 and 53) "TC52 TC53 Apply Read access and check whether the registered user can do read operation alone or not"
    And Logout the user
    And User login as admin

  @tag24
  Scenario: Validating the read operations only can be performed for AD users
    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User click on "Add Active Directory User"
    And Select the active directory user (uesr "Andi")
    And User click on "Add Users"
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Single" access
    And User give permission Read
    And User click on "Apply"
    And Logout the user
    And User login ADgroupUserOrADuser (ADgroupUserOrADuser "Andi")
    And User open repository
    Then Validate user can able to do read operations (row 54 and 55) "TC54 TC55 Apply Read access and check whether the AD user can do read operation alone or not"
    And Logout the user
    And User login as admin

  @tag25
  Scenario: Validating the read operations only can be performed for AD group users
    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Active Directory Groups"
    And User click on "Add Group"
    And Select the group by search in advanced search ("kiran_Automation")
    And User click on "Add Groups"
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Single" access
    And User give permission Read
    And User click on "Apply"
    And Logout the user
    And User login ADgroupUserOrADuser (ADgroupUserOrADuser "kiran")
    And User open repository
    Then Validate user can able to do read operations (row 56 and 57) "TC56 TC57 Apply Read access and check whether the AD group user can do read operation alone or not"
    And Logout the user
    And User login as admin

  @tag26
  Scenario: Validating the read operations only can be performed for invite users
    When User open repository
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Customized" access
    And User choose "Single" access
    And User click on home button
    And select repository browser package and invite user via email
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Single" access
    And User give permission Read
    And User click on "Apply"
    And User join the prolaborate via invite link
    And User click login as user in profile
    Then Validate user can able to do read operations (row 60 and 61) "TC60 TC61 Apply Read access and check whether the invite user can do read operation alone or not"

  @tag27
  Scenario: Verify that the read access check box is selected by default and disabled condition
    When User open repository
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Single" access
    Then Validate user can able to uncheck the read checkbox (row 62) "TC62 Verify that the read access check box is selected by default and disabled condition"

  @tag28
  Scenario: TC18 Check if the identity user shows all the artifacts based on sections or not
    When User open repository
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Single" access
    And User click on burger menu
    And User click "Sections" under repository configuration
    And Note the artifacts under the sections
    And User click on burger menu
    And Logout the user
    And User login with sso
    And User open repository
    Then Validate admin user get all artifacts based on sections (row 18) "TC14 Check if the identity user shows all the artifacts based on sections or not"
    Then Validate user can able to do all operations (row 24) "TC24 Check whether the identity can able to do all the operation properly"
    And Logout the user
    And User login as admin


  @tag29
  Scenario: TC35 TC34 Apply Read and Write access and check whether the identity user can do read and write operation alone or not
    When User open repository
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Single" access
    And User give permission Read and Write
    And User click on "Apply"
    And User click on burger menu
    And User click "Sections" under repository configuration
    And Note the artifacts under the sections
    And User click on burger menu
    And Logout the user
    And User login with sso
    And User open repository
    Then Validate user can able to do read and write operations (row 35 and 34) "TC35 TC34 Apply Read and Write access and check whether the identity user can do read and write operation alone or not"
    And Logout the user
    And User login as admin

  @tag30
  Scenario: TC46 TC47 Apply Read and collaborate access and check whether the identity user can do read and collaborate operation alone or not
    When User open repository
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Single" access
    And User give permission Read and Collaborate
    And User click on "Apply"
    And User click on burger menu
    And User click "Sections" under repository configuration
    And Note the artifacts under the sections
    And User click on burger menu
    And Logout the user
    And User login with sso
    And User open repository
    Then Validate user can able to do read and collaborate operations (row 46 and 47) "TC46 TC47 Apply Read and collaborate access and check whether the identity user can do read and collaborate operation alone or not"
    And Logout the user
    And User login as admin


  @tag31
  Scenario: TC58 TC59 Apply Read access and check whether the identity user can do read operation alone or not
    When User open repository
    And User click on burger menu
    And User click "Access Permissions" under repository configuration
    And User choose "Single" access
    And User give permission Read
    And User click on "Apply"
    And User click on burger menu
    And User click "Sections" under repository configuration
    And Note the artifacts under the sections
    And User click on burger menu
    And Logout the user
    And User login with sso
    And User open repository
    Then Validate user can able to do read operations (row 58 and 59) "TC58 TC59 Apply Read access and check whether the identity user can do read operation alone or not"
    And Logout the user
    And User login as admin

