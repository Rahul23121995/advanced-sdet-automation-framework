# Advanced SDET Automation Framework

Enterprise-level Hybrid Automation Framework using Selenium WebDriver, Java, TestNG, RestAssured, Maven, Jenkins, and GitHub Actions for UI and API testing.

[![CI/CD Pipeline](https://github.com/Rahul23121995/advanced-sdet-automation-framework/actions/workflows/test-execution.yml/badge.svg)](https://github.com/Rahul23121995/advanced-sdet-automation-framework/actions)

---

## 📋 Table of Contents

- [Tech Stack](#tech-stack)
- [Features](#features)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Installation & Setup](#installation--setup)
- [Running Tests](#running-tests)
- [CI/CD Integration](#cicd-integration)
- [Docker Setup](#docker-setup)
- [Examples](#examples)
- [Contributing](#contributing)
- [License](#license)

---

## 🔧 Tech Stack

| Component | Version | Purpose |
|-----------|---------|---------|
| **Java** | 17 | Core programming language |
| **Selenium WebDriver** | 4.18.1 | UI test automation |
| **TestNG** | 7.9.0 | Test framework |
| **RestAssured** | 5.4.0 | API test automation |
| **Maven** | 3.9+ | Build & dependency management |
| **Log4j2** | 2.22.1 | Logging framework |
| **Extent Reports** | 5.1.1 | Test reporting |
| **JaCoCo** | 0.8.10 | Code coverage analysis |
| **Jenkins** | 2.404+ | CI/CD pipeline |
| **GitHub Actions** | - | Cloud CI/CD |
| **Docker** | 24+ | Containerization |
| **WebDriverManager** | 5.7.0 | Driver management |

---

## ✨ Features

### UI Automation
- ✅ Selenium WebDriver 4 with modern async API
- ✅ Page Object Model (POM) design pattern
- ✅ Cross-browser support (Chrome, Firefox, Edge)
- ✅ Parallel test execution
- ✅ Dynamic wait utilities (Explicit, Implicit)
- ✅ Retry mechanism for flaky tests
- ✅ ThreadLocal driver management
- ✅ Screenshot capture on test failure
- ✅ Headless browser support

### API Automation
- ✅ RestAssured for RESTful API testing
- ✅ Request/Response validation
- ✅ Status code & schema assertions
- ✅ JSON response parsing
- ✅ Header & authentication testing
- ✅ Performance metrics collection

### Reporting & Logging
- ✅ Extent Reports for detailed HTML reports
- ✅ Log4j2 structured logging with file rotation
- ✅ Console & file logging
- ✅ Error log segregation
- ✅ Test execution dashboard
- ✅ Code coverage reports (JaCoCo)

### CI/CD Integration
- ✅ GitHub Actions workflow
- ✅ Jenkins pipeline with parameterized builds
- ✅ Docker containerized execution
- ✅ Selenium Grid for distributed testing
- ✅ Artifact archival
- ✅ Email notifications

---

## 📁 Project Structure

```
advanced-sdet-automation-framework/
├── src/
│   ├── main/
│   │   ├── java/com/sdet/
│   │   │   ├── base/
│   │   │   │   ├── BaseTest.java          # Base UI test class
│   │   │   │   └── DriverManager.java     # WebDriver management
│   │   │   ├── pages/                      # Page Object Model classes
│   │   │   │   └── HomePage.java
│   │   │   └── utilities/                  # Helper classes
│   │   │       ├── WaitUtilities.java
│   │   │       └── LoggerUtilities.java
│   │   └── resources/
│   │       └── log4j2.xml                  # Logging configuration
│   │
│   └── test/
│       ├── java/com/sdet/
│       │   ├── tests/                      # UI test cases
│       │   │   └── SampleUITest.java
│       │   └── api/                        # API test cases
│       │       ├── BaseAPITest.java        # Base API test class
│       │       └── SampleAPITest.java
│       │
│       └── resources/
│           └── testdata/                   # Test data files
│
├── .github/
│   └── workflows/
│       └── test-execution.yml              # GitHub Actions workflow
│
├── pom.xml                                 # Maven configuration
├── testng.xml                              # TestNG configuration
├── Jenkinsfile                             # Jenkins pipeline
├── docker-compose.yml                      # Selenium Grid setup
├── Dockerfile                              # Container image definition
├── CONTRIBUTING.md                         # Contribution guidelines
├── LICENSE                                 # Apache 2.0 License
└── README.md                               # This file
```

---

## 📦 Prerequisites

- **Java 17+** - [Download](https://www.oracle.com/java/technologies/downloads/)
- **Maven 3.9+** - [Download](https://maven.apache.org/download.cgi)
- **Git** - [Download](https://git-scm.com/download)
- **Docker** (optional, for containerized execution) - [Download](https://www.docker.com/products/docker-desktop)
- **Jenkins** (optional, for CI/CD) - [Download](https://www.jenkins.io/download/)

### Verify Installation

```bash
java -version
mvn -version
git --version
docker --version  # if using Docker
```

---

## 🚀 Installation & Setup

### 1. Clone Repository

```bash
git clone https://github.com/Rahul23121995/advanced-sdet-automation-framework.git
cd advanced-sdet-automation-framework
```

### 2. Install Dependencies

```bash
mvn clean install
```

### 3. Update Configuration

- Edit `testng.xml` to add your test classes
- Update `src/main/resources/log4j2.xml` for logging preferences
- Create `src/test/resources/config.properties` for environment variables

### 4. Verify Setup

```bash
mvn compile
```

---

## 🧪 Running Tests

### Run All Tests

```bash
mvn clean test
```

### Run Specific Test Suite

```bash
mvn clean test -Dsuites=testng.xml
```

### Run Tests in Parallel

```bash
mvn clean test -DthreadCount=4
```

### Run with Different Browser

```bash
mvn clean test -Dbrowser=firefox
```

Supported browsers: `chrome`, `firefox`, `edge`, `headless-chrome`

### Run with Remote WebDriver (Grid)

```bash
mvn clean test -Dremote=true -Dgrid.url=http://localhost:4444
```

### Generate Code Coverage Report

```bash
mvn clean test jacoco:report
# Report available at: target/site/jacoco/index.html
```

---

## 📊 CI/CD Integration

### GitHub Actions

Workflow file: `.github/workflows/test-execution.yml`

Features:
- Automatic test execution on push/PR
- Parallel test execution (UI & API)
- Code coverage analysis
- Test artifact uploads
- Execution summary in PR comments

**Trigger conditions:**
- Push to `main` or `develop` branches
- Pull requests
- Manual workflow dispatch

### Jenkins Pipeline

File: `Jenkinsfile`

Features:
- Parameterized builds (environment, thread count)
- Multi-stage pipeline (Build → Test → Report)
- Distributed test execution
- HTML test reports
- Email notifications on failure

**Setup:**
1. Create new Pipeline job in Jenkins
2. Link to this GitHub repository
3. Set webhook for automatic builds

---

## 🐳 Docker Setup

### Standalone Execution

```bash
docker build -t sdet-framework:latest .
docker run -v $(pwd)/reports:/app/reports sdet-framework:latest
```

### Distributed Execution with Selenium Grid

```bash
# Start Selenium Hub and nodes
docker-compose up -d

# Run tests against grid
mvn clean test -Dremote=true -Dgrid.url=http://localhost:4444

# View Selenium Grid UI
# http://localhost:4444

# Shutdown
docker-compose down
```

### Docker Compose Services

- **selenium-hub** - Selenium Grid Hub (port 4444)
- **chrome** - Chrome browser node
- **firefox** - Firefox browser node
- **edge** - Edge browser node

---

## 💡 Examples

### UI Test Example

```java
package com.sdet.tests;

import com.sdet.base.BaseTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import static org.assertj.core.api.Assertions.*;

public class LoginTest extends BaseTest {

    @Test(description = "Verify successful login")
    public void testSuccessfulLogin() {
        // Navigate to application
        driver.get("https://example.com");
        
        // Find and interact with elements
        driver.findElement(By.id("username")).sendKeys("testuser");
        driver.findElement(By.id("password")).sendKeys("password123");
        driver.findElement(By.id("login-btn")).click();
        
        // Assert
        String pageTitle = driver.getTitle();
        assertThat(pageTitle).contains("Dashboard");
    }
}
```

### API Test Example

```java
package com.sdet.tests.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class UserAPITest extends BaseAPITest {

    @Test(description = "Verify GET user endpoint")
    public void testGetUser() {
        Response response = RestAssured
            .given()
                .baseUri("https://api.example.com")
                .basePath("/users")
                .queryParam("id", "123")
            .when()
                .get()
            .then()
                .extract()
                .response();
        
        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(response.jsonPath().getString("name")).isNotEmpty();
    }
}
```

---

## 📝 Contributing

We welcome contributions! Please see [CONTRIBUTING.md](CONTRIBUTING.md) for guidelines.

### Quick Start for Contributors

1. Fork the repository
2. Create a feature branch: `git checkout -b feature/your-feature`
3. Commit changes: `git commit -am 'Add feature'`
4. Push to branch: `git push origin feature/your-feature`
5. Create Pull Request

---

## 🔗 Resources

- [Selenium Documentation](https://www.selenium.dev/documentation/)
- [TestNG Documentation](https://testng.org/)
- [RestAssured Guide](https://rest-assured.io/)
- [Maven Documentation](https://maven.apache.org/guides/)
- [Jenkins Documentation](https://www.jenkins.io/doc/)
- [Docker Documentation](https://docs.docker.com/)

---

## 📄 License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details.

---

## 👨‍💻 Author

**Rahul** - [@Rahul23121995](https://github.com/Rahul23121995)

---

## 🤝 Support

For issues, questions, or suggestions:
- Open an [GitHub Issue](https://github.com/Rahul23121995/advanced-sdet-automation-framework/issues)
- Create a [Discussion](https://github.com/Rahul23121995/advanced-sdet-automation-framework/discussions)
- Contact: rahul.sdet@example.com

---

**Last Updated:** May 09, 2026