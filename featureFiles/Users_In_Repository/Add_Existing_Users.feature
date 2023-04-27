#Author: kirankumar
@Add_Existing_Users
Feature: This is for Add Users in Repository

  Background:
    Given User login as admin
    And User credentials getting for testdata
      | UserFirstName | UserLastName |
      | test          | user         |

  @tag1
  Scenario: To Check whether all Repository have Add Existing User option
  TC01 Check whether Add Existing User option is available for Repository
  TC02 Check whether Add Existing User Tab is Displayed when clicked on Add Existing User
  TC03 Check whether Search option is available

    Given User open repository
    When User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    Then Add Existing User Tab option should be available near Add User Tab "TC01 Check whether Add Existing User option is available for Repository"
    And User click on "Add Existing Users"
    Then Add Existing Users page should be shown "TC02 Check whether Add Existing User Tab is Displayed when clicked on Add Existing User"
    Then Search option should be shown "TC03 Check whether Search option is available"

  @tag2
  Scenario: Validating search option
  TC04 Check whether Search shows results based on User Name
  TC05 Check whether Search shows results based on Email
  TC06 Check whether Search shows results based on Type of User
  TC07 Check whether it shows results based on search content contains
  TC11 Check whether User Name List is available
  TC12 Check whether User Name should not redirect profile page when clicked on username from list
  TC21 Check whether Search Option based on User Name  Below  User Name Column should display results as per search
  TC27 Check whether Search Option based on Email  Below  Email Column should display results as per search
  TC36 Check whether Search Option based on Type of User  Below  Type of User Column should display results as per search

    Given User open repository
    When User click on burger menu
    And User click "User and License Management" under portal settings
    And User click on "Add User"
    And User enter the user credentials (userNo 4)
    And User click on "Save"
    And User click on "Add User"
    And User enter the user credentials (userNo 5)
    And User click Make user as a admin
    And User click on "Save"
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User click on "Add Existing Users"
    Then Validating search results shown properly based on username (userNo 4) "TC04 Check whether Search shows results based on User Name"
    Then Validating search results shown properly based on mail  (userNo 5) "TC05 Check whether Search shows results based on Email"
    Then Validating search results shown properly based on type "TC06 Check whether Search shows results based on Type of User"
    Then Validating search results shown based on search content contains "TC07 Check whether it shows results based on search content contains"
    Then Validate username is not clickable "TC12 Check whether User Name should not redirect profile page when clicked on username from list"
    Then Validate column search results is shown properly based on search (column 2) (seachContent 4) (row 194) "TC21 Check whether Search Option based on User Name  Below  User Name Column should display results as per search"
    Then Validate column search results is shown properly based on search (column 3) (seachContent 5) (row 200) "TC27 Check whether Search Option based on Email  Below  Email Column should display results as per search"
    Then Validate type column search results is shown properly based on search (seachContent "Prolaborate Admin") "TC27 Check whether Search Option based on Email  Below  Email Column should display results as per search"

  @tag3
  Scenario: checking Pagination in add existing user list page
  TC08 check if pagination options is shown properly
  TC09 check if user can change the number of user value in pagination dropdown
  TC10 Check whether it shown list based on choosed pagination value
  TC75 Check whether Next/previous  Page Option is Available
  TC76 Check whether Next/previous Page directs respective page when clicked
  TC77 Check whether First Page/Final Page Option is Available
  TC78 Check whether First Page/Final Page directs respective page when clicked

    Given User open repository
    When User click on burger menu
    And User click "User and License Management" under portal settings
    And Adding multiple number of users in portal for checking pagination option (i = 30)
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User click on "Add Existing Users"
    Then Pagination option should be shown (rowNo 181) "TC08 check if pagination options is shown properly"
    Then Validate the user can able to change pagination value (rowNo 182) "TC09 check if user can change the number of user value in pagination dropdown"
    Then Validate the user limit is reached 20 then balance user is shown in next page (rowNo 183) "TC10 Check whether it shown list based on choosed pagination value"
    Then Validate Next and previous should be shown "TC75 Check whether Next/previous  Page Option is Available"
    Then Validate next and previous button redirect to respective page "TC76 Check whether Next/previous Page directs respective page when clicked"
    Then Validate FirstPage FinalPage Option is shown "TC77 Check whether First Page/Final Page Option is Available"
    Then Validate FirstPage FinalPage directs respective page when clicked "TC78 Check whether First Page/Final Page directs respective page when clicked"

  @tag4
  Scenario: checking Sorting in add existing user list page

  TC18 Check whether Sorting Option is available near User Name Column
  TC19 Check whether Sorting Option displays as per ascending order when clicked
  TC20 Check whether Sorting Option displays as per descending order when clicked
  TC24 Check whether Sorting Option is available near Email Column
  TC25 Check whether Sorting Option displays as per ascending order when clicked
  TC26 Check whether Sorting Option displays as per descending order when clicked
  TC33 Check whether Sorting Option is available near Type of User Column
  TC34 Check whether Sorting Option displays as per ascending order when clicked
  TC35 Check whether Sorting Option displays as per ascending order when clicked

    Given User open repository
    When User click on burger menu
    And User click "User and License Management" under portal settings
    And Adding multiple number of users in portal for checking sort option (i = 3)
      | A | B | C | D |
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User click on "Add Existing Users"
    Then Validate sort option should be shown in username header "TC18 Check whether Sorting Option is available near User Name Column"
    And User click on username header
    Then Validate list should be in ascending order (rowNo 192) (elementIndex 2) "TC19 Check whether Sorting Option displays as per ascending order when clicked"
      | A | B | C | D |
    And User click on username header
    Then Validate list should be in descending order (rowNo 193) (elementIndex 2) "TC20 Check whether Sorting Option displays as per descending order when clicked"
      | D | C | B | A |
    Then Validate sort option should be shown in mail header "TC24 Check whether Sorting Option is available near Email Column"
    And User click on email header
    Then Validate list should be in ascending order (rowNo 198) (elementIndex 3) "TC25 Check whether Sorting Option displays as per ascending order when clicked"
      | A | B | C | D |
    And User click on email header
    Then Validate list should be in descending order (rowNo 199) (elementIndex 3) "TC26 Check whether Sorting Option displays as per descending order when clicked"
      | D | C | B | A |
    Then Validate sort option should be shown in type header "TC33 Check whether Sorting Option is available near Type of User Column"
    And User click on type header
    Then Validate list should be in ascending order (rowNo 207) (elementIndex 4) "TC34 Check whether Sorting Option displays as per ascending order when clicked"
      | A | B | C | D |
    And User click on type header
    Then Validate list should be in descending order (rowNo 208) (elementIndex 4) "TC35 Check whether Sorting Option displays as per ascending order when clicked"
      | D | C | B | A |

  @tag5
  Scenario: checking another repository users shown in add existing user list page
  TC13 Check whether User Name List displays all Registered Regular users from all Repository
  TC14 Check whether User Name List displays all Registered Read Only users from all Repository
  TC15 Check whether User Name List displays all  SAML users from all Repository
  TC16 Check whether User Name List displays all  AD/AD Group users from all Repository
  TC17 Check whether User Name List displays all AD Groups  from all Repository
  TC29 Check whether Registered User type is listed properly
  TC30 Check whether Identity User type is listed properly
  TC31 Check whether AD/AD Group User type is listed properly
  TC32 Check whether AD Group type is listed properly

    When Copy a repository
    And User click on burger menu
    And User click "Licenses" under license configuration
    And User click on "Remove Activation Key"
    And User click on "Delete"
    And User Uploaded read and regular license
    And User click on "Activate License"
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the user credentials (userNo 4)
    And User click on "Save"
    And User click on "Add User"
    And User enter the user credentials (userNo 5)
    And User choose "ReadOnly" license type
    And User click on "Save"
    And User click on "Add User"
    And Add the AD user (user "Andi")
    And User click on "Add User"
    And Add the AD group (group "shgroup")
    And Logout the user
    And User login with sso
    And Logout the user
    And User login as admin
    And User open copied repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User click on "Add Existing Users"
    Then Validate other repository users should be shown (row 186) (userNo 4) "TC13 Check whether User Name List displays all Registered Regular users from all Repository"
    Then Validate other repository users should be shown (row 187) (userNo 5) "TC14 Check whether User Name List displays all Registered Read Only users from all Repository"
    Then Validate other repository (user "kiran kumar") should be shown (row 188) "TC15 Check whether User Name List displays all  SAML users from all Repository"
    Then Validate other repository (user "Andi") should be shown (row 189) "TC16 Check whether User Name List displays all  AD/AD Group users from all Repository"
    Then Validate other repository (user "shgroup") should be shown (row 190) "TC17 Check whether User Name List displays all AD Groups  from all Repository"

  @tag6
  Scenario: checking checkbox in add existing user list page
  TC44 Check whether  select all CheckBox is available in add existing user list page
  TC45 Check whether individual CheckBox is available for users in the list
  TC46 Check whether  all check box are selcted when select all CheckBox is selected
  TC47 Check whether  all check box are unselcted when select all CheckBox is unselected
  TC48 Check whether users are selected when check box is selected
  TC49 Check whether users are unselected when check box is unselected
  TC50 Check whether No of selected user option is available
  TC51 Check whether No of selected users are displayed properly when selected

    Given User open repository
    When User click on burger menu
    And User click "User and License Management" under portal settings
    And Adding multiple number of users in portal for checking pagination option (i = 2)
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User click on "Add Existing Users"
    Then Validate select all chackbox should be shown (row 217) "TC44 Check whether  select all CheckBox is available in add existing user list page"
    Then Validate individual checkbox should be shown for users (row 218) "TC45 Check whether individual CheckBox is available for users in the list"
    Then Validate all users should be selected when select all check box selected (row 219) "TC46 Check whether  all check box are selcted when select all CheckBox is selected"
    Then Validate all users should be unselected when select all check box unselected (row 220) "TC47 Check whether  all check box are unselcted when select all CheckBox is unselected"
    Then Validate user should be able to select individual user (row 221) "TC48 Check whether users are selected when check box is selected"
    Then Validate user should be able to unselect individual user (row 222) "TC49 Check whether users are unselected when check box is unselected"
    Then Validate selected user count option should be shown (row 223) "TC50 Check whether No of selected user option is available"
    Then Validate selected user count should be properly shown (row 224) "TC51 Check whether No of selected users are displayed properly when selected"

  @tag7
  Scenario: checking user group membership in add existing user list page

  TC55 Check whether User Group Membership Dropdown box is available
  TC56 Check  Default & Admin Group is listed in Dropdown box
  TC57 Check Regular Licensed Group is listed in Dropdown box
  TC59 Check ReadOnly Licensed Group is listed in Dropdown box
  TC62 Check Only Active Groups are  listed in Dropdown box

    Given User open repository
    When User click on burger menu
    And User click "User Groups" under repository configuration
    And User click on "Create User Group"
    And User enter a groupname "TestReadOnly"
    And User choose "ReadOnly" license type
    And User click on "Save"
    And User click on "Create User Group"
    And User enter a groupname "TestRegular"
    And User click on "Save"
    And User click on "Create User Group"
    And User enter a groupname "TestInactive"
    And User click on "Status" option
    And User click on "Save"
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User click on "Add Existing Users"
    Then Validate user group membership dropdown should be shown "TC55 Check whether User Group Membership Dropdown box is available"
    Then Validate "Default" and "Administrators" group should be shown in user group membership dropdown "TC56 Check  Default & Admin Group is listed in Dropdown box"
    Then Validate "TestRegular" group should be shown in user group membership dropdown (row 230) "TC57 Check Regular Licensed Group is listed in Dropdown box"
    Then Validate "TestReadOnly" group should be shown in user group membership dropdown (row 232) "TC59 Check ReadOnly Licensed Group is listed in Dropdown box"
    Then Validate "TestInactive" group should not be shown in user group membership dropdown "TC62 Check Only Active Groups are  listed in Dropdown box"

  @tag8
  Scenario: Adding user to Repository from Add Existing Users Page
  TC63 Check whether Add User button is available
  TC64 Check whether Registerd Regular user is added when Add User button is clicked
  TC65 Check whether Registerd Read Only  User is added when Add User button is clicked
  TC66 Check whether SAML  User is added when Add User button is clicked
  TC67 Check whether AD/AD Group  User is added when Add User button is clicked
  TC68 Check whether AD Group is added when Add User button is clicked

    Given Copy a repository
    When User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User enter the user credentials (userNo 4)
    And User click on "Save"
    And User click on "Add User"
    And User enter the user credentials (userNo 5)
    And User choose "ReadOnly" license type
    And User click on "Save"
    And User click on "Add User"
    And Add the AD user (user "Andi")
    And User click on "Add User"
    And Add the AD group (group "shgroup")
    And Logout the user
    And User login with sso
    And Logout the user
    And User login as admin
    And User open copied repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User click on "Add Existing Users"
    Then Validate add users button shoud be shown "TC63 Check whether Add User button is available"
    Then Validate user can able to add "RegularUser" to repository (user "") (userNo 4) (row 237) "TC64 Check whether Registerd Regular user is added when Add User button is clicked"
    And User click on "Add User"
    And User click on "Add Existing Users"
    Then Validate user can able to add "ReadOnlyUser" to repository (user "") (userNo 5) (row 238) "TC65 Check whether Registerd Read Only  User is added when Add User button is clicked"
    And User click on "Add User"
    And User click on "Add Existing Users"
    Then Validate user can able to add "SMALUser" to repository (user "kiran kumar") (userNo 4) (row 239) "TC66 Check whether SAML  User is added when Add User button is clicked"
    And User click on "Add User"
    And User click on "Add Existing Users"
    Then Validate user can able to add "ADuser" to repository (user "Andi") (userNo 4) (row 240) "TC67 Check whether AD/AD Group  User is added when Add User button is clicked"
    And User click on "Add User"
    And User click on "Add Existing Users"
    Then Validate user can able to add "ADGroup" to repository (user "shgroup") (userNo 4) (row 241) "TC68 Check whether AD Group is added when Add User button is clicked"

  @tag9
  Scenario: checking user group membership in add existing user list page

  TC69 Check whether Regular users are added in Repository &  selected Regular  group
  TC70 Check whether it shows proper PB Alert when  Read Only users are added in Regular group
  TC71 Check whether  Regular users are added in ReadOnly group
  TC72 Check whether  multiple Regular users are added in one Regular group
  TC73 Check whether single  Regular user can be added in multiple  Regular group
  TC74 Check whether single  Regular user can be added in multiple  ReadOnly  group

    Given User open repository
    When User click on burger menu
    And User click "User Groups" under repository configuration
    And Adding multiple number of user group for checking user group membership option (i = 4)
    And User click on burger menu
    And User click "User and License Management" under portal settings
    And Adding multiple number of users in portal for checking user group membership option (i = 12)
    And User click on burger menu
    And User click "Repositories" under portal settings
    And User open repository
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User click on "Add Existing Users"
    Then Validate Regular users are added in Repository and selected Regular group (userType "TestRegular1") (userGroup "TestRegular1") "TC69 Check whether Regular users are added in Repository &  selected Regular  group"
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User click on "Add Existing Users"
    Then Validate proper PB Alert when Read Only users are added in Regular group (userType "TestReadOnly0") (userGroup "TestRegular1") "TC70 Check whether it shows proper PB Alert when  Read Only users are added in Regular group"
    Then Validate Regular users are added in ReadOnly group (userType "TestRegular3") (userGroup "TestReadOnly1") "TC71 Check whether  Regular users are added in ReadOnly group"
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User click on "Add Existing Users"
    Then Validate multiple Regular users are added in one Regular group (userType "TestRegular5" "TestRegular7") (userGroup "TestRegular1") "TC72 Check whether  multiple Regular users are added in one Regular group"
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User click on "Add Existing Users"
    Then Validate single  Regular user can be added in multiple  Regular group (userType "TestRegular9") (userGroup "TestRegular1" "TestRegular3") "TC73 Check whether single  Regular user can be added in multiple  Regular group"
    And User click on burger menu
    And User click "Users" under repository configuration
    And User click on "Add User"
    And User click on "Add Existing Users"
    Then Validate single  Regular user can be added in multiple  ReadOnly group (userType "TestRegular11") (userGroup "TestReadOnly0" "TestReadOnly2") "TC74 Check whether single  Regular user can be added in multiple  ReadOnly  group"