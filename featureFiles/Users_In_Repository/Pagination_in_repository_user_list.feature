#Author: kirankumar
Feature: This is for Add Users in Repository

  Background:
    Given User login as admin
    And User credentials getting for testdata
      | UserFirstName | UserLastName |
      | test          | user         |

  @Pagination_in_repository_user_list
  Scenario: checking Pagination in repository user list page
  TC01 check if pagination options is shown properly
  TC02 check if pagination number of user in a table limit is upto 10 by default
  TC03 check if user can change the number of user value in pagination dropdown
  TC04 check if user limit reached to 10,then balance users move to next page and shown as two page
  TC05 check if user select value 10 to 20 ,then number of user shown upto 20 if available
  TC06 check if user increase select value upto 100 maximum and 10 decrease value  to 10 minimum
  TC07 check if user switch from one page to another page you want ,by simply click on next or page number you shown

    Given User open repository
    When User click on burger menu
    And User click "Users" under repository configuration
    Then Pagination option should be shown (rowNo 147) "TC01 check if pagination options is shown properly"
    And The pagination should be by default "10" "TC02 check if pagination number of user in a table limit is upto 10 by default"
    Then Validate the user can able to change pagination value (rowNo 149) "TC03 check if user can change the number of user value in pagination dropdown"
    And Adding multiple number of users in repository for checking pagination option (i = 100)
    Then Validate the user limit is reached 10 then balance user is shown in next page (rowNo 150) "TC04 check if user limit reached to 10,then balance users move to next page and shown as two page"
    Then Validate if user select paginiation option 20,user list shown based on pagination TCno row 151 "TC05 check if user select value 10 to 20 ,then number of user shown upto 20 if available"
    Then Validate if user select paginiation option 100,user list shown based on pagination TCno row 152 "TC06 check if user increase select value upto 100 maximum and 10 decrease value  to 10 minimum"
    Then Validate the page switching button "TC07 check if user switch from one page to another page you want ,by simply click on next or page number you shown"