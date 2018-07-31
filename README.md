# UI Test Automation

 This repository contains UI Automated tests for Weather Forecast website


# Installation

#### Dependencies : Maven, Selenium, JUnit


# Usage

User can run the tests either from Command Line or using InelliJ

To Run tests using Maven --
run from Project Root Directory
   mvn clean test -Dbrowser="Chrome"  -Dos="WIN10"

# Test Observations

1. Summary information not correct in few cases, eg: Glasgow rainfall summary is incorrect on Wed 21

2. Missing requirement for air pressure info displayed in website eg:Glasgow Tue 20, has 1015mb  

# TO-DO Improvements

  a. Configure Test Frameworks to run for multiple browsers using Grid
  
  b. Add Automated a11y Test suite
  
  c. Add Automated Visual Test Suite covering Critical test Scenarios
  
  d. Add Automated Security tests using Selenium + ZAP 
  
  e. Add Automated layout testing (Assuming UX Specs are defined)
  
 
