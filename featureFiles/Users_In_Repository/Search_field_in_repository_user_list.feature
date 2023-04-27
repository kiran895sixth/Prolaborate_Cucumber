#Author: kirankumar
Feature: This is for Add Users in Repository

  Background:
    Given User login as admin
    And User credentials getting for testdata
      | UserFirstName | UserLastName |
      | test          | user         |

  @Search_field_in_repository_user_list
  Scenario: check search option in repository user list page
  TC01 check if in users module  user search options is available,
  TC02 check if user can enter all kind of special charactor in search text successful,
  TC03 check if based on value enter in search options only shown in datatable,
  TC04 check if user enter details is not in datatable,then shows message in datatable as No Users were found to match your search

    Given User open repository
    When User click on burger menu
    And User click "Users" under repository configuration
    Then Search field should be available in repository users list page "TC01 check if in users module  user search options is available"
    And User click on "Add User"
    And User enter the valid user credentials 1
    And User click on "Save"
    And Search the added user name in search field
    Then List will be shown based on search "TC03 check if based on value enter in search options ,only shown in datatable"
    And User click on "Add User"
    And User enter the valid user credentials "@" "$"
    And User click on "Save"
    And Search the added user name with special charactor in search field "@" "$"
    Then List will be shown based on search with special charactor "@" "$" "TC02 check if user can enter all kind of  special charactor in search text successful"
    And Search the detail that is not in list
    Then Error Message shown 144 "No Users were found to match your search" "TC04 check if user enter details is not in datatable,then shows message in datatable as No Users were found to match your search"