# Advanced SDET Automation Framework

Enterprise-level Hybrid Automation Framework using Selenium WebDriver, Java, TestNG, RestAssured, Maven, and CI/CD integrations.

---

# Tech Stack

- Java 17
- Selenium WebDriver
- TestNG
- Maven
- RestAssured
- WebDriverManager
- Extent Reports
- Log4j2
- Jenkins
- GitHub Actions
- Docker

---

# Framework Features

## UI Automation
- Selenium WebDriver
- Page Object Model (POM)
- Cross Browser Support
- Dynamic Wait Utilities
- Parallel Execution
- Retry Mechanism
- ThreadLocal Driver Management

## API Automation
- RestAssured Integration
- GET API Validation
- Response Validation
- Status Code Assertions

## CI/CD Integration
- Jenkins Pipeline
- GitHub Actions Workflow
- Maven Build Execution

## Reporting & Logging
- Extent Reports
- Log4j2 Logging
- Screenshot Capture on Failure

---

# Project Structure

```plaintext
src/main/java
 ├── base
 ├── pages
 ├── utilities

src/test/java
 ├── tests
 ├── api

.github/workflows
Jenkinsfile
docker-compose.yml