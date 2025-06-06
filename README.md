Selenium POM TestNG Framework

Project Overview

This is a structured Selenium Test Automation Framework using:

Selenium WebDriver:  For browser automation
TestNG:              For test orchestration
Page Object Model:   For maintainable test code
Maven:               As the build tool

Other utilities integrated:

Screenshot capture on test failure
Config.properties file to externalize configuration and test data
ElementUtil for clean interaction logic



Tech Stack

Language: Java 17+
Build Tool: Maven
Framework: TestNG
Browser Driver Management: WebDriverManager
Design Pattern: Page Object Model (POM)
IDE Used: Eclipse


 Project Structure


selenium-pom-testng/
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.qa
│   │   │       ├── base
│   │   │       │   └── BaseTest.java
│   │   │       ├── listeners
│   │   │       │   └── TestListener.java
│   │   │       ├── pages
│   │   │       │   ├── LoginPage.java
│   │   │       │   └── DashboardPage.java
│   │   │       └── utils
│   │   │           ├── ConfigReader.java
│   │   │           ├── ElementUtil.java
│   │   │           ├── ExcelUtil.java
│   │   │           └── ScreenshotUtils.java
│   │   └── resources
│   │       └── config.properties
│   └── test
│       └── java
│           └── com.qa.tests
│               └── LoginTest.java
├── screenshots/
│   └── (Saved screenshots on failure)
├── testng.xml
├── pom.xml
└── .gitignore



 How to Run

1. Prerequisites
   JDK 17+
   Maven installed
   Chrome browser

2. Run from Terminal

--bash--
mvn clean test


3. Run from Eclipse

Right click on testng.xml > Run As > TestNG Suite


 Features

POM-based clean structure
config.properties for credentials and URLs
Common utilities: click, sendKeys, wait, Element Assertions
Screenshot on failure (via TestNG Listener)
Separate tests for valid and invalid login

---

Screenshot on Failure

Captured in screenshots folder using listener class TestListener.



TestNG Groups (Upcoming)

Will be added to allow tagging of tests like smoke, regression etc.



Author

Muhammad Asif
Role: Software QA 



Next Steps

* [x] Complete Level 1 (DONE)
* [ ] Start Level 2: PageFactory + Data-Driven
