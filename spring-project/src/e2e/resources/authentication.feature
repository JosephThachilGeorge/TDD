Feature: Login Service Project

Scenario: User Login and Logout
  Given The User is on SignUp Page
	When Enters email "email10111@gmail" , password "password" ,usernumber "usernumber" and username "user" 
	Then The User is on Login Page
  Then The message "Data is Saved" must be shown
  
 Scenario: User Login with invalid password
	Given The User is on SignUp Page
	When Enters email "email1011@gmail" , password "password" ,usernumber "usernumber" and username "user" 
	Then The User is on Login Page
	When The User load his email "email1011@gmail" and password "passwordNotCorrect"
	Then The message "Invalid email or password" must be shown	
		
Scenario: User Signup with email already in use
	Given The User is on SignUp Page
	When Enters email "email1011@gmail" , password "password" ,usernumber "usernumber" and username "user"  
	Given The User is on SignUp Page
	When Enters email "email1011@gmail" , password "anotherpassword" ,usernumber "anotherusernumber" and username "anotheruser" 
	Then The message "This email is already registered!" must be shown
	
Scenario: User Signup with User already in use
	Given The User is on SignUp Page
	When Enters email "email1011@gmail" , password "password" ,usernumber "usernumber" and username "user"  
	Given The User is on SignUp Page
	When Enters email "email1011@gmail" , password "anotherpassword" ,usernumber "anotherusernumber" and username "user" 
	Then The message "This user is already registered!" must be shown
	
Scenario: User Signup with Usernumber already in use
	Given The User is on SignUp Page
	When Enters email "email1011@gmail" , password "password" ,usernumber "usernumber" and username "user"  
	Given The User is on SignUp Page
	When Enters email "email10111@gmail" , password "anotherCorrect" ,usernumber "usernumber" and username "anotheruser" 
 	Then The User is on Login Page
  Then The message "Data is Saved" must be shown
	
	
