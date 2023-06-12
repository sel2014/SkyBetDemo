Project Summary:
I have been given this task to complete as part of my application process.
I took the following steps to complete.

I converted the task to a User Story first of all. This will help me to create my features
files for my steps and easy to understand for non-technical team members.

1- I am using Java Selenium Cucumber framework and junit for my assertions.
2- I created my POM.XML file and added my dependencies and plugins that I needed
   such as webdrivermanager, cucumber-junit, javafaker.
3- I created configuration.properties file to keep important test data like browser type,
   URL. It helps me  to prevent hardcoding
4- I implemented Page Object Model (POM). POM ensures all my locator are centralised and
   I have easy access to them.
5- I have Singleten Design Pattern in my framework. SDP allows to have only one instance 
   of my driver in my entire project.
6- I created my BrowserUtils class to keep my commonly use method. This enables me to write
   clean code and prevent reparative coding.
7- Next I have my Hooks class.Hooks class allows me to execute certain actions after each 
   scenario. Maximizing window or taking screenshot if scenario is failing
   Driver.closeDriver() is also important method in hooks class which closses the current
   browser session.
8- ConfigurationReader class enables me to read from configuration.properties
9- Finally I have features folder where I have my features for each scenarios. I run these
   features to get my code snippets and copy paste these failing codes to write my actual
   in my step definitions.
10- Last but not the least is CukesRunner class. This class allows me to control the flow
    of my project. I can run my tests, add my tags such as @smoke or @regression, paths to
    my features files and step definitions.

  I tried to explain briefly about my framework. I am happy to explain further if given the
  opportunity.
