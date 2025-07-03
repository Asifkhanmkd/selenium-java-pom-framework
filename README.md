 Selenium Java POM TestNG Framework

 Overview

This is a scalable, modular, and multi-threaded Selenium Test Automation Framework designed for real-world testing needs. It follows best practices like the Page Object Model (POM), centralized WebDriver management with ThreadLocal, and real-time reporting with ExtentReports.



Tech Stack

| Tool                | Purpose                         |
|---------------------|----------------------------------|
| Java 17+            | Programming Language             |
| Maven               | Build and Dependency Management  |
| TestNG              | Test Execution Framework         |
| Selenium WebDriver  | Browser Automation               |
| WebDriverManager    | Driver Binary Management         |
| ExtentReports       | Test Reporting                   |
| Apache POI          | Excel Reading (Data-Driven)      |           



Project Structure


selenium-java-pom-framework/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.qa/
│   │   │       ├── base/
│   │   │       │   ├── BaseTest.java
│   │   │       │   └── DriverFactory.java
│   │   │       ├── listeners/
│   │   │       │   └── TestListener.java
│   │   │       ├── pages/
│   │   │       │   ├── LoginPage.java
│   │   │       │   ├── AdminPage.java
│   │   │       │   └── PIMPage.java
│   │   │       ├── utils/
│   │   │       │   ├── ConfigReader.java
│   │   │       │   ├── Constants.java
│   │   │       │   ├── ElementUtil.java
│   │   │       │   ├── WaitUtils.java
│   │   │       │   ├── ExcelReader.java
│   │   │       │   └── ScreenshotUtils.java
│   │   └── resources/
│   │       └── config.properties
│   └── test/
│       └── java/
│           └── com.qa.tests/
│               ├── LoginTest.java
│               ├── AdminPageTest.java
│               └── e2e/
│                   └── PIMPageTest.java
├── test-output/         # TestNG default reports (gitignored)
├── Reports/             # ExtentReport output (gitignored)
├── screenshots/         # Captures on failure
├── pom.xml
├── testng.xml
└── .gitignore

Key Features

- Page Object Model (POM) for maintainability

- ThreadLocal WebDriver via DriverFactory for thread-safe parallel execution

- Externalized config using config.properties

- Screenshot on failure via TestListener

- ExtentReports integration with dynamic test names

- Excel-driven data via ExcelReader

- Group/tag execution support with TestNG groups (planned)

- RetryAnalyzer for automatic re-attempt of failed tests

- Multi-threaded support with @DataProvider(parallel = true)

Configuration
- src/main/resources/config

Example:
browser=chrome
env=qa
If no values are passed via command line or testng.xml parameters, these defaults will be used.

Environment Management
 -Denv=qa
 -Denv=staging
 -Denv=prod
 
ConfigReader dynamically loads:
 -/src/main/resources/config/config-{env}.properties
Example 
 - config/
  ├── config-qa.properties
  ├── config-staging.properties
  └── config-prod.properties

Browser Selection
 - You can choose the browser at runtime:
     -Dbrowser=chrome
     -Dbrowser=firefox
     -Dbrowser=edge
DriverFactory handles:
- Chrome
- Firefox
- Edge
- Automatically managed via WebDriverManager
- Fallback to config.properties if not specified

Retry Analyzer
- This framework includes automatic retry logic:
- Configured globally via RetryAnalyzer
- Retries failed tests up to n times
- Improves stability for flaky UI test


How to Run:
Prerequisites
JDK 17+
Maven installed
Chrome browser

From Terminal:
- mvn clean test

Specify environment and browser:
- mvn clean test -Denv=qa -Dbrowser=chrome
- mvn clean test -Denv=staging -Dbrowser=firefox

From Eclipse/IDE:-
Right-click testng.xml → Run As → TestNG Suite
 - Uses defaults from config.properties
 - No need for -D properties unless you configure them in Eclipse Run Configurations

Notes on Parallel Execution
 - testng.xml supports:
    - <suite parallel="class" thread-count="5">
     - ThreadLocal WebDriver ensures thread safety
     - Thread count can be tuned per environment
   
Screenshot on Failure:-
- All failures automatically captured via TestListener
- Saved in /screenshots with test method name and timestamp

Reporting:-
- Rich HTML reports under /Reports folder
- Includes pass/fail logs, screenshots, timestamps

Author
Muhammad Asif
Role: Software QA Engineer
