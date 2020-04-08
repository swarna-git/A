Feature: Login into application
Scenario Outline: positive test validating login
Given Initialize the Chrome browser
And Navigate to "http://qaclickacademy.com"
And Click on login link in home page
When user enters <username> and <password> and logs in
Then verify if the user is successfully logged in
And Close the browser
Examples:
|username |password|
|swarnam98@gmail.com|swarna*56|


