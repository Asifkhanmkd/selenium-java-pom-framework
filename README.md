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
│   │   │       │   
│   │   └── resources/
│   │       └── config.properties
│   └── test/
│       └── java/
│           └── com.qa.tests/
│               ├── LoginTest.java
│               ├── AdminPageTest.java
│               └── e2e/
│                   └── PIMPageTest.java
├── test-output/           # TestNG default reports (gitignored)
├── Reports/               # ExtentReport output (gitignored)
├── screenshots/           # Captures on failure (auto-named)
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

- Multi-threaded support with @DataProvider(parallel = true)

How to Run:
Prerequisites
JDK 17+
Maven installed
Chrome browser

From Terminal:
mvn clean test

From Eclipse/IDE:-
Right-click testng.xml → Run As → TestNG Suite

Screenshot on Failure:-

All failures automatically captured via TestListener
Saved in /screenshots with test method name and timestamp

Reporting:-
Rich HTML reports under /Reports folder
Includes pass/fail logs, screenshots, timestamps

Author
Muhammad Asif
Role: Software QA Engineer
