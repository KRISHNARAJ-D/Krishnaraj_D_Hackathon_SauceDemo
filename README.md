# SauceDemo Automation Framework

## Overview

This project is an automated UI testing framework developed for the SauceDemo e-commerce application using Selenium WebDriver, Java, TestNG, Maven, and the Page Object Model (POM) with Page Factory.

The framework is designed to be modular, maintainable, and scalable by separating test logic, page objects, utilities, and configuration files. Test execution is managed using TestNG, while Allure Reports provide detailed execution results with screenshots captured automatically on test failures.

Application URL:
https://www.saucedemo.com/

---

## Technology Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- Page Factory
- Allure Report
- Git
- GitHub

---

## Framework Design

The framework follows the Page Object Model (POM) design pattern.

```
src
└── test
    ├── java
    │   ├── base
    │   ├── listeners
    │   ├── pages
    │   ├── tests
    │   └── utils
    │
    └── resources
        └── config.properties

pom.xml
testng.xml
```

### Package Description

| Package | Description |
|----------|-------------|
| base | Browser initialization, WebDriver configuration and common setup |
| listeners | TestNG listener implementation for reporting and screenshot capture |
| pages | Page Object classes containing web element locators and reusable methods |
| tests | TestNG test classes implementing business scenarios |
| utils | Common utility classes such as screenshot handling |
| resources | Configuration files including application URL, browser, and credentials |

---

## Features

- Page Object Model (POM)
- Page Factory implementation
- TestNG test execution
- Maven dependency management
- Configurable execution through properties file
- Allure reporting
- Screenshot capture on test failure
- Reusable page methods
- Clean project structure
- Modular framework design

---

## Test Scenarios

### SD_UI_001 – End-to-End Purchase

- Login with valid credentials
- Add product to cart
- Proceed to checkout
- Complete purchase
- Verify successful order confirmation

---

### SD_UI_002 – Cart Update Validation

- Login to application
- Add multiple products
- Remove a product
- Continue shopping
- Add another product
- Proceed to checkout
- Complete purchase successfully

---

### SD_UI_003 – Checkout Validation

- Login to application
- Add product to cart
- Proceed to checkout
- Validate mandatory field
- Verify validation message
- Complete checkout after entering valid details

---

## Reporting

The framework uses Allure Report for execution reporting.

The report includes:

- Test execution summary
- Pass and fail status
- Execution time
- Severity
- Test description
- Step-level execution details
- Screenshot attachment on test failure

---

## Configuration

Framework configuration is managed using the `config.properties` file.

Example:

```properties
url=https://www.saucedemo.com/
browser=chrome
username=standard_user
password=secret_sauce
```

---

## Test Execution

Execute the complete test suite:

```bash
mvn clean test
```

---

## Generate Allure Report

```bash
allure serve target/allure-results
```

---

## Project Highlights

- Modular automation framework
- Reusable Page Object classes
- Centralized browser configuration
- TestNG Listener implementation
- Automatic screenshot capture on failures
- Structured reporting using Allure
- Easy maintenance and scalability

---

## Future Enhancements

- Data Driven Testing using Apache POI
- Cross Browser Execution
- Parallel Execution using ThreadLocal WebDriver
- Jenkins CI/CD Integration
- Docker Support
- Cucumber BDD Integration

---

## Author

Krishnaraj D
GitHub:
https://github.com/KRISHNARAJ-D
