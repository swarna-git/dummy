Feature: Sign into the application
this feature is used to check the sign in component of code ranch web application
#this is a comment

Background: 
Given chrome browser is initialized
And User Navigates to the URL
And Clicks on Sign in link



@validTest
Scenario Outline:  Sign into the appplication using valid crendentials
When user enters valid <username> and valid <password>
Then Verify the user is successfully logged in 
And Close the browser

Examples: 
|username|password|
|swarnam98@gmail.com |swarna*76  |


@invalidTest
Scenario: Sign into the application using invalid crendentials
When user enters invalid username and invalid password
Then Verify if the appropriate error message is displayed
And Close the browser 




