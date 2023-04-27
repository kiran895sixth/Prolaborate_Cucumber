#Author: kirankumar
Feature: This is for Add Users in Repository

  Background:
    Given User login as admin
    And User credentials getting for testdata
      | UserFirstName | UserLastName |
      | test          | user         |


  @LicenseType_in_repository_user_list
  Scenario: checking LicenseType in repository user list page
  TC01 check if after created user ,License Type of user shown properly
  TC02 check if based License upload,the License Type options shown

    Given User open repository
    When User click on burger menu
#    And User click "Users" under repository configuration
#    And User click on "Add User"
#    And User enter the valid user credentials 1
#    And User click on "Save"
#    Then License type should be shown 1 "Regular" "TC01 check if after created user ,License Type of user shown properly"
#    And User click on burger menu
    And User click "Licenses" under license configuration
    And User click on "Remove Activation Key"
    And User click on "Delete"
    And User Uploaded read and regular license
#    And User click on "Activate License"
#    And User click on burger menu
#    And User click "Repositories" under portal settings
#    And User open repository
#    And User click on burger menu
#    And User click "Users" under repository configuration
#    And User Open user edit page 1
    Then The license type option shown "TC02 check if based License upload,the License Type options shown"