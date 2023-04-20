#Feature: Login into the Application
#
#Scenario: Check user login is successfull with valid credentials
#Given User is on the login page
#When User enters username and password
#And Clicks on Login button
#Then User is navigated to the home page
#
Feature: Login into the application

  Scenario Outline: Check Login with Valid Credentials
   # Given User open the browser
    Given  User is on Login Page
    When User enter the  <username> and <password>
    And User can click login button
    Then Verify that homePage is populated
    And Logout the application

    Examples: 
      | username | password |
      | Test1    |    12345 |
      | Test2    |    12345 |
      | Test3    |    12345 |
      | Test4    |    12345 |
      | Test5    |    12345 |
      
      
      
   Scenario Outline: Check Login with Wrong Credentials
    Given  User is on Login Page
    When User enter the  <username> and <password>
    And User can click login button
    Then Verify that erorr message should show

    Examples: 
      | username | password |
      | Test1    |    123 |
      | Test2    |    123 |
      | Test3    |    123 |
      | Test4    |    12 |
      | Test5    |    12 |
      
      
      
      
      

  