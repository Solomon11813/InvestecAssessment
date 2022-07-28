CONTENTS OF THIS FILE
---------------------

* Introduction
* Requirements
* Configuration
* Troubleshooting
* Maintainers

INTRODUCTION
------------

The Investec Automation framework follows the BDD concept of creating automation scripts, Java, restAssured and Selenium are 
incorporated to facilitate the functionality between the feature files (Test cases) and the UI or API interaction. Other
capabilities of this framework is reporting, ExtentReport has been utilized as part of the framework reporting tool. For 
more details or clarity on the above-mentioned tools please see the below links for referral:  

* BDD:
  https://cucumber.io/
* Selenium:
  https://www.selenium.dev/documentation/
* RestAssured:
  https://rest-assured.io/
* ExtentReport: https://www.extentreports.com/

REQUIREMENTS
------------

This project requires the following core tools:
* JAVA JDK 16
* JAVA JRE 1.8.0 (At least)
* IntelliJ IDE (Preferably the latest one)
* Have at least read and write access to the repository
* Cucumber plugin installed on IntelliJ

CONFIGURATION
-------------

To configure this project, the following has to be implemented:
* Use 'git clone {projectURL}' to clone the project on your local machine
* Once the project has been cloned, configure the project JAVA JDK to 16 and also change the language level to at least 14
* Change target bytecodeversion under settings/compile to 14
* Once the above changes are in place, run mvn clean and install to download all the required dependencies
* Once mvn clean and install is done, you are set to run the project

TROUBLESHOOTING
---------------

In most cases, the first attempt you might fail to get the project up and running. If it happens that MAVEN is struggling
to download some dependencies, try updating your remote and local mvn repositories. Any other queries you may face, please
reach out to the maintainer(s)

MAINTAINERS
-----------

Current maintainers of this Automation framework:
* Solomon Mathebula (First option)
* Investec QE Leads (Alternatives)