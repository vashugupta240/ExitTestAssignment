#Flipkart Testing
###PROJECT OVERVIEW
This project is for test automation of flipkart, covering UI test, functional testing. Created with lessons learned during training  provide all commonly required components and concepts.

>This project is done by using selenium.

##Concepts Included
>* Page Object Model
* Common web page interaction methods
* Dependency
* plugins
* jekins by using github
* making jar
* logger
* extent report
* reading test data from excel file

##Tools
>* Maven
* Selenium Webdriver
* eclipse


##Requirements
order to utilise this project you need to have the following installed locally:
>* Chrome and Chromedriver
* firefix and firefoxdriver
* internet exploler and driver
* Java 
* Maven
* TestNG
* excel file


##Usage
The project is broken into separate modules for testing. Each of these modules can be utilised independently of the others using maven profiles.

To run modules, navigate to test-automation directory and run:

``` commands
mvn clean
 ```
Then
 
 ``` commands
 mvn install
 ```
 ``` commands
 mvn test
 ```


##About the pages
This Project contains many Files-
>* Base Test
* Login page
* Login test
* extra page
* extra test
* Product search Page
* Product search Test
* Screeenshots as a jar
* config.properties
* excel file 
* excel data provider
* travel page
* travel test
* logout page
* logout test

##Use of the all the pages
#####Base Test
This page contain the initialization part to invoke the browser during the run time.
All grouping ,before method, after method, before suite are declare here.

#####Login Test
This pages runs the test case for all valid login conditions and invalid login conditions.

#####Login Page
This page contain the target of all the fields to pass the event by sendkeys, click for the login condition.

#####Product search Page
This page contain the target of all the tags to pass the event by sendkeys, click for the login condition.

#####Product search Test
This page contain 3 test case i.e 
* search a product
* buy a product
* hover over a electronic tab


#####Screeenshots
In this section it will capture the screenshot for all the failing test scenarios.

#####Travel page
getting the tags for the travel page like date destination

#####Travel test
This page contain 2 test case i.e 
* One way trip
* two way trip

#####Logout test
In this page checking the logout functionality

######Address test
This page contain 2 test case i.e 
* adding address
* deleting address

######Extra Test
This page contain 7 test case i.e 
* topOffer
* superCoin
* contact
* securityAndPrivacy
* storyclick
* signupByHover
* flipkartFacebook

######Excel data provider
getting the data from the excel sheet

##Reporting
 
Reports for each module are written into their respective /target directories after a successful run.

For all failing test case and passing test case scenarios a report will be generated with proper screenshot.