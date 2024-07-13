@SmokeTest
Feature: Create or delete User
  Scenario: Validate add or delete user
    Given automationPractice website is opened
    When Enter "Admin" as userName
    And  Enter "admin123" as password
    And  Click on the login button
    Then User should redirected to home page
    And User click on Admin tab
    When User Get Numbers Of Records
    When Add New User
    And User Get Numbers Of Records Increase By One
    And User Search With User
    And User Verify Search Result
    And User Delete User
    Then User Log out


