Feature: Airline Service Project

Scenario: User Login and Logout
  Given The User is on SignUp Page
	When Enters email "email10@gmail" , password "password" and username "user" 
	Then The User is on Login Page
	When The User load his email "email10@gmail" and password "password"
	Then The user with email "email10@gmail" is logged
	When The user logout
	Then The User is on Login Page
	
Scenario: User Login with invalid password
	Given The User is on SignUp Page
	When Enters email "email10@gmail" , password "password" and username "user" 
	Then The User is on Login Page
	When The User load his email "email10@gmail" and password "passwordNotCorrect"
	Then The message "Invalid email or password" must be shown	
		
Scenario: User Signup with email already in use
	Given The User is on SignUp Page
	When  Enters email "email10@gmail" , password "password" and username "user" 
	Given The User is on SignUp Page
	When Enters email "email10@gmail" , password "anotherpassword" and username "anotheruser" 
	Then The message "This email is already registered!" must be shown
	
