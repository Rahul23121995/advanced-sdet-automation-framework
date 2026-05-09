# Contributing to Advanced SDET Automation Framework

Thank you for your interest in contributing! This document provides guidelines and instructions for contributing to this project.

## 📋 Table of Contents

- [Code of Conduct](#code-of-conduct)
- [Getting Started](#getting-started)
- [Development Setup](#development-setup)
- [Making Changes](#making-changes)
- [Commit Guidelines](#commit-guidelines)
- [Testing Guidelines](#testing-guidelines)
- [Pull Request Process](#pull-request-process)
- [Code Style Guide](#code-style-guide)

---

## 📖 Code of Conduct

This project adheres to a Contributor Code of Conduct. By participating, you are expected to:

- Use welcoming and inclusive language
- Be respectful of differing opinions and experiences
- Accept constructive criticism gracefully
- Focus on what is best for the community
- Show empathy towards other community members

Unacceptable behavior includes:
- Harassment or discrimination
- Trolling or insulting comments
- Unwelcome sexual attention or advances
- Any other conduct considered inappropriate in a professional setting

---

## 🚀 Getting Started

### Prerequisites

- Java 17+
- Maven 3.9+
- Git
- IDE: IntelliJ IDEA, Eclipse, or VS Code
- Docker (optional)

### Fork and Clone

```bash
# Fork the repository on GitHub

# Clone your fork
git clone https://github.com/YOUR-USERNAME/advanced-sdet-automation-framework.git
cd advanced-sdet-automation-framework

# Add upstream repository
git remote add upstream https://github.com/Rahul23121995/advanced-sdet-automation-framework.git
```

---

## 💻 Development Setup

### 1. Install Dependencies

```bash
mvn clean install
```

### 2. IDE Configuration

#### IntelliJ IDEA

1. Open project: `File → Open → Select project directory`
2. Configure JDK: `Project Structure → Project → SDK → Java 17`
3. Enable Annotation Processing: `Settings → Build, Execution, Deployment → Compiler → Annotation Processors → Enable`

#### Eclipse

1. Import project: `File → Import → Existing Maven Projects`
2. Configure JDK: `Window → Preferences → Java → Installed JREs → Java 17`

#### VS Code

1. Install extensions:
   - Extension Pack for Java
   - TestNG Code Lens
   - REST Client

2. Configure `.vscode/settings.json`:

```json
{
  "java.configuration.runtimes": [
    {
      "name": "JavaSE-17",
      "path": "/path/to/jdk17",
      "default": true
    }
  ]
}
```

### 3. Verify Setup

```bash
mvn clean test
```

---

## 🔄 Making Changes

### Create Feature Branch

```bash
# Update main branch
git checkout main
git pull upstream main

# Create feature branch
git checkout -b feature/your-feature-name
```

### Branch Naming Convention

- `feature/description` - New features
- `bugfix/description` - Bug fixes
- `docs/description` - Documentation updates
- `test/description` - Test additions
- `refactor/description` - Code refactoring

Example: `feature/add-mobile-testing-support`

### Make Your Changes

1. Follow [Code Style Guide](#code-style-guide)
2. Write meaningful commit messages
3. Add/update tests for your changes
4. Update documentation if needed

---

## 📝 Commit Guidelines

### Commit Message Format

```
<type>(<scope>): <subject>

<body>

<footer>
```

### Type

- `feat` - A new feature
- `fix` - A bug fix
- `docs` - Documentation only changes
- `style` - Changes that don't affect code meaning (formatting, missing semicolons, etc.)
- `refactor` - Code change that neither fixes a bug nor adds a feature
- `test` - Adding or updating tests
- `chore` - Changes to build process, dependencies, or tooling

### Scope

Optional scope for the change (e.g., `api`, `ui`, `base`, `utils`)

### Subject

- Use imperative mood ("add" not "adds" or "added")
- Don't capitalize first letter
- No period at the end
- Limit to 50 characters

### Body

- Explain what and why, not how
- Limit lines to 72 characters
- Reference issues: `Closes #123`

### Examples

```
feat(ui): add page object for login page

Implement LoginPage class with common locators and methods
for login functionality testing.

Closes #45
```

```
fix(api): handle null response body in API tests

Add null check before parsing JSON response to prevent
NullPointerException during API testing.

Closes #67
```

---

## 🧪 Testing Guidelines

### Write Tests for New Features

```java
package com.sdet.tests;

import com.sdet.base.BaseTest;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class NewFeatureTest extends BaseTest {

    @Test(description = "Verify feature behavior")
    public void testNewFeature() {
        // Arrange
        
        // Act
        
        // Assert
        assertThat(result).isNotNull();
    }
}
```

### Test Naming Convention

```
test<Scenario><ExpectedResult>
```

Example: `testLoginWithValidCredentialsSucceeds()`

### Assertions

Use AssertJ for more readable assertions:

```java
// Good
assertThat(actualValue)
    .isNotNull()
    .isEqualTo(expectedValue)
    .contains(substring);

// Avoid
assert actualValue != null;
assert actualValue.equals(expectedValue);
```

### Run Tests Before Committing

```bash
mvn clean test
mvn clean test -Dbrowser=firefox  # Multi-browser testing
mvn clean test -DthreadCount=4    # Parallel execution
```

---

## 📤 Pull Request Process

### Before Creating PR

1. Ensure all tests pass:

```bash
mvn clean test
```

2. Check code quality:

```bash
mvn clean compile
```

3. Update documentation:
   - README.md (if applicable)
   - JavaDoc comments
   - CONTRIBUTING.md (if process changes)

4. Sync with upstream:

```bash
git fetch upstream
git rebase upstream/main
```

### Create Pull Request

1. Push your branch:

```bash
git push origin feature/your-feature-name
```

2. Create PR on GitHub with title following format:

```
[TYPE] Short description
```

Example: `[FEATURE] Add mobile automation support`

### PR Description Template

```markdown
## Description
Brief description of changes

## Type of Change
- [ ] New feature
- [ ] Bug fix
- [ ] Documentation update
- [ ] Breaking change

## Related Issue
Closes #123

## Changes Made
- Change 1
- Change 2
- Change 3

## Testing
- [ ] Added new tests
- [ ] Updated existing tests
- [ ] All tests pass

## Screenshots/Logs (if applicable)

## Checklist
- [ ] Code follows style guidelines
- [ ] No new warnings generated
- [ ] Tests added/updated
- [ ] Documentation updated
- [ ] No breaking changes (or documented)
```

### PR Review Process

1. Wait for maintainer review
2. Address requested changes
3. Request re-review after changes
4. PR will be merged once approved

---

## 🎨 Code Style Guide

### Java Code Style

#### Naming Conventions

```java
// Classes - PascalCase
public class LoginPage { }

// Methods - camelCase
public void clickLoginButton() { }

// Variables - camelCase
String username = "testuser";

// Constants - UPPER_SNAKE_CASE
private static final String BASE_URL = "https://example.com";

// Test methods - descriptive with test prefix
@Test
public void testLoginWithValidCredentials() { }
```

#### Formatting

```java
// 2-space indentation
public class Example {
  public void method() {
    if (condition) {
      doSomething();
    }
  }
}

// Line length: max 100 characters
String veryLongString = "This is a very long string that might exceed " +
                       "the maximum line length and should be wrapped";

// Braces on same line (Allman style)
if (condition) {
  doSomething();
} else {
  doSomethingElse();
}
```

#### Comments and Documentation

```java
/**
 * Brief description of what this method does.
 *
 * @param parameter1 description of parameter1
 * @return description of return value
 * @throws ExceptionType description of when thrown
 */
public String methodName(String parameter1) throws ExceptionType {
  // Implementation
}

// Inline comments for complex logic
if (condition1 && condition2) {  // Special case handling
  performAction();
}
```

#### Logging

```java
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

private static final Logger logger = LogManager.getLogger(ClassName.class);

public void method() {
  logger.info("Starting test execution");
  logger.debug("Debug information");
  logger.error("Error occurred", exception);
}
```

### Maven Best Practices

```xml
<!-- Organize dependencies by scope -->
<dependencies>
  <!-- Compile scope (default) -->
  <dependency>...</dependency>
  
  <!-- Test scope -->
  <dependency>
    <scope>test</scope>
  </dependency>
</dependencies>

<!-- Version management -->
<properties>
  <maven.compiler.source>17</maven.compiler.source>
  <maven.compiler.target>17</maven.compiler.target>
  <selenium.version>4.18.1</selenium.version>
</properties>
```

---

## 📚 Additional Resources

- [Java Code Conventions](https://www.oracle.com/java/technologies/javase/codeconventions-136091.html)
- [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)
- [Semantic Versioning](https://semver.org/)
- [Conventional Commits](https://www.conventionalcommits.org/)

---

## ❓ Questions?

- Open an issue for questions
- Start a discussion in GitHub Discussions
- Contact: rahul.sdet@example.com

---

**Thank you for contributing! 🎉**