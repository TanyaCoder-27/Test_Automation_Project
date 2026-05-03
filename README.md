# 🧪 Test Automation Project

A scalable **Selenium Test Automation Framework** built with **Java, Selenium WebDriver, and TestNG**, applying the **Page Object Model (POM)** design pattern for maintainable and modular test design.

---

## 📂 Project Structure
- **src/test** → Core test scripts following POM
- **testData** → External test data files
- **reports** → Automated test execution reports
- **screenshots** → Captured screenshots for failure analysis
- **test-output** → TestNG default output
- **pom.xml** → Maven dependencies and build configuration
- **testng.xml / parallel.xml** → TestNG suite configuration

---

## 🚀 Features
- Automated **end-to-end workflows**:
  - Login
  - Registration
  - Add-to-cart
  - Checkout
  - Logout
- **Page Object Model (POM)** for clean, reusable test code
- **Parallel execution** support via TestNG XML
- **Automated reporting** with detailed logs
- **Screenshot capture** on test failures for debugging
- **Scalable design** for adding new test cases easily
- **Jenkins CI/CD Integration** for automated build and test execution

---

## 🛠️ Tech Stack
- **Language**: Java  
- **Automation Tool**: Selenium WebDriver  
- **Test Framework**: TestNG  
- **Build Tool**: Maven  
- **CI/CD**: Jenkins  
- **Reporting**: ExtentReports  
- **Data Management**: Apache POI (Excel)  

---

## ▶️ How to Run Tests
1. Clone the repository:
   ```bash
   git clone https://github.com/TanyaCoder-27/Test_Automation_Project.git
   ```
2. Navigate to the project directory:
  ```bash
  cd Test_Automation_Project
  ```
3. Run tests using Maven:
  ```bash
  mvn clean test
  ```
4. View reports in the reports/ or test-output/ folder.

---

## 🔄 Jenkins Integration

This test automation framework is **fully integrated with Jenkins** for continuous integration and continuous deployment (CI/CD). The Jenkins pipeline automates the entire testing process, ensuring code quality and reliability.

### 🚀 Jenkins Pipeline Features:
- **Automated test execution** on every code commit
- **Real-time build monitoring** with console output
- **Test result visualization** with ExtentReports
- **Failure notifications** and screenshot capture
- **Historical test trends** and performance metrics
- **Cross-browser testing** support in Jenkins environment

### 📊 Jenkins Build Documentation

For detailed information about the Jenkins integration build execution results and console outputs, please refer to the documentation:

📎 **[Jenkins Integration Documentation](Jenkins_Integrated_OP.pdf)**

*This PDF contains actual Jenkins build console outputs, test execution results, and build history demonstrating the successful integration of the test automation framework with Jenkins CI/CD.*

---

# 📊 Reporting & Analysis

- **HTML reports** generated automatically after execution  
- **Failure screenshots** stored for quick debugging  
- **Logs** available for detailed execution trace  
- **Jenkins dashboard** for build history and trends  
- **ExtentReports** integration for professional test reporting  

---

## 👩‍💻 Author

**TanyaCoder-27**  
Building robust automation frameworks with **Selenium & TestNG** and **Jenkins CI/CD integration**.

---

## 📜 License

This project is licensed under the **MIT License** – feel free to use and adapt.
