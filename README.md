# 🚀 OrangeHRM Selenium Automation Framework

**Author:** [Kshitij Ganare](https://github.com/KshitijGanare)  
**Project Status:** 23 Test Cases Automated | Integrated with Jenkins CI/CD

---

## 🎯 Overview

This is an enterprise-level Web Automation Framework designed for the **OrangeHRM** application. It leverages the **Page Object Model (POM)** and a robust **CI/CD Pipeline** to ensure continuous quality monitoring.

Key achievements:
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

The framework follows a strict Page Object Model:

```text
Selenium_Framework_OrangeHRM
├── src
│   ├── main/java
│   │   ├── base            # WebDriverManager & BaseTest
│   │   ├── pages           # Page Objects
│   │   └── util            # Excel & Property Readers
│   └── test/java
│       ├── listeners       # AllureListener for screenshots
│       └── tests           # Test Suites
└── pom.xml                 # Maven dependencies


📊 CI/CD Integration (Jenkins)
The project utilizes a 5-stage Jenkins Pipeline:

Tool Install - Configures environment (JDK/Maven).

Checkout - Pulls latest code from GitHub.

Build & Test - Executes mvn clean test.

Generate Report - Compiles Allure Results.

Notifications - Sends SMTP email reports.

✨ Best Practices
✅ Listener Pattern: AllureListener catches failures automatically.

✅ Byte Array Screenshots: Efficient memory management for reports.

✅ ThreadLocal Driver: Ensures thread-safety for parallel execution.