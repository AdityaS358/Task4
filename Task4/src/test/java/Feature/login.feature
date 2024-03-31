Feature: User Login Action

 Scenario: User login with valid credentials
    
Given User is on Home Page
When User enters username and password from Excel
Then User clicks on login button
Then User should be logged in