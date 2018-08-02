# UI Test Automation

 This repository contains UI Automated tests for Weather Forecast website


# Installation

#### Dependencies : Maven, Selenium, JUnit


# Usage

User can run the tests either from Command Line or using InelliJ

To Run tests using Maven --
run from Project Root Directory

  #### in Windows 10:  mvn clean test -Dbrowser="Chrome"  -Dos="WIN10"
  
  #### in OSX  : mvn clean test -Dbrowser="Chrome" -Dos="OSX"

# Test Observations

1. Summary information not correct in few cases 
         eg: Glasgow rainfall summary is incorrect on Wed 21
   Same for temperature etc in few instances.

2. No requirement for air pressure info , however its displayed in website 
        eg:Glasgow Tue 20, has 1015mb  

# TO-DO Improvements

  a. Configure Test Frameworks to run for multiple browsers using Grid  eg: Firefox, Safari etc
  
  b. Improve Logging using standard logging libraries
  
  c. Improve Reporting mechanism using extent Reports or Allure Reports
  
  d. Add Automated a11y Test suite
  
  e. Add Automated Visual Test Suite covering Critical test Scenarios
  
  f. Add Automated Security tests using Selenium + ZAP 
  
  g. Add Automated layout testing using Galen (Assuming UX Specs are defined)
  
 
