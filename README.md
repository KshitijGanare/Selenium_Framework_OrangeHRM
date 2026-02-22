# 🚀 OrangeHRM Selenium Automation Framework

**Author:** [Kshitij Ganare](https://github.com/KshitijGanare)  
**Project Status:** 23 Test Cases Automated | Integrated with Jenkins CI/CD

---

## 🎯 Overview

This is an enterprise-level Web Automation Framework designed for the **OrangeHRM** application. It leverages the **Page Object Model (POM)** and a robust **CI/CD Pipeline** to ensure continuous quality monitoring.

**Key achievements:**
* **Scalable Execution:** Successfully handling 23 complex test scenarios.
* **Automated Feedback:** Interactive Allure reports with integrated failure screenshots.
* **DevOps Ready:** Fully automated logic within a 5-stage Jenkins pipeline.

---

## 🛠️ Tech Stack

| Technology | Version | Description |
|-----------|---------|-------------|
| **Java** | 17 | Core programming language |
| **Selenium** | 4.40.0 | Browser automation engine |
| **TestNG** | 7.12.0 | Test execution framework |
| **Maven** | 3.6+ | Build tool |
| **Allure** | 2.32.0 | Advanced reporting |
| **Jenkins** | 2.x | CI/CD automation server |

---

## 📁 Project Structure

The framework follows a modular Page Object Model:

```text
Selenium_Framework_OrangeHRM
├── src
│   ├── main/java
│   │   ├── base            # WebDriverManager & BaseTest
│   │   ├── config          # Global configurations
│   │   ├── pages           # Page Objects
│   │   └── util            # Helpers & Utilities
│   └── test/java
│       ├── listeners       # TestNG Listeners
│       └── tests           # Test Suites
├── allure-results          # Raw execution data
├── testng.xml              # Test configuration
└── pom.xml                 # Maven dependencies

```

📊 CI/CD Integration (Jenkins)

The project utilizes a 5-stage Jenkins Pipeline to automate the testing lifecycle:

Tool Install - Configures the environment (JDK/Maven).

Checkout - Pulls the latest code from GitHub.

Build & Test - Executes mvn clean test.

Generate Report - Compiles Allure Results into a visual dashboard.

Notifications - Sends automated SMTP email reports upon completion.




✨ Best Practices

✅ Listener Pattern: AllureListener catches failures and skips automatically.

✅ Byte Array Screenshots: Uses memory-efficient byte[] for attaching UI evidence to reports.

✅ ThreadLocal Driver: Ensures thread-safety for parallel test execution.

✅ Clean Builds: Automatic cleanup of old results via Maven Clean plugin.
