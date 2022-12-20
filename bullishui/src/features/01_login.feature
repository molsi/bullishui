#Author: molsi.varghese@gmail.com
#Didn't want to expose the real username and real password in this file, so used several methods
#to send usernames and passwords.
Feature: Login page of Application
 
Scenario: Positive test case of Login
Given Open Chrome and launch the application
When Enter the right username and right password
Then Login works 

Scenario Outline:: Negative test case of Login (invalid username)
Given Open Chrome and launch the application
When Enter the username "momsmith" and right password
Then Login doesn't work because of invalid username 

Scenario Outline:: Negative test case of Login (blank username)
Given Open Chrome and launch the application
When Enter the username "" and right password
Then Login doesn't work because of invalid username

Scenario Outline:: Negative test case of Login (invalid password)
Given Open Chrome and launch the application
When Enter the right username and password "abc"
Then Login doesn't work because of invalid password 

Scenario Outline:: Negative test case of Login (blank password)
Given Open Chrome and launch the application
When Enter the right username and password ""
Then Login doesn't work because of invalid password 

Scenario Outline:: Negative test case of Login (invalid username and invalid password)
Given Open Chrome and launch the application
When Enter the username "abc" and password "xyz"
Then Login doesn't work because of invalid username 

Scenario Outline:: Negative test case of Login (blank username and blank password)
Given Open Chrome and launch the application
When Enter the username "" and password ""
Then Login doesn't work because of invalid username 