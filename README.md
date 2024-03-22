# TestNG Automation Framework with Selenium and Java

This project demonstrates an automation framework built using TestNG, Selenium WebDriver, and Java. It includes various features such as screen recording, screenshot capturing, different types of reports including Extent Reports, and parallel execution.

## Features

1. **TestNG:** Utilizes TestNG for test case management and execution.
2. **Selenium WebDriver:** Employs Selenium WebDriver for browser automation.
3. **Screen Recording:** Enables screen recording of test execution for better analysis and debugging.
4. **Screenshot Capturing:** Automatically captures screenshots on test failure to aid in debugging.
5. **Extent Reports:** Generates Extent Reports for detailed test execution reports with graphical representation.
6. **Parallel Execution:** Executes tests in parallel for faster execution and improved efficiency.

## Pre-requisites

1. Java Development Kit (JDK): Ensure JDK is installed and configured properly.
2. Maven: Maven should be installed to manage project dependencies.
3. TestNG: Install TestNG plugin in your preferred IDE (Eclipse/IntelliJ IDEA).
4. WebDriver: Download appropriate WebDriver binaries for browsers you intend to automate (e.g., ChromeDriver for Chrome).
5. Extent Reports: Add Extent Reports dependency in the Maven `pom.xml` file.

## Setup Instructions

1. **Clone the Repository:** Clone this repository to your local machine using Git.

    ```bash
    git clone https://github.com/your-username/your-repo.git
    ```

2. **Import Project:** Import the cloned project into your preferred Java IDE.

3. **Configure WebDriver:** Set the path to WebDriver binaries in the project configuration or specify them in system PATH.

4. **Install Dependencies:** Ensure all project dependencies are installed by running Maven.

    ```bash
    mvn clean install
    ```

5. **Run Tests:** Execute tests using TestNG either through IDE or command-line.

    ```bash
    mvn test
    ```

## Project Structure

- **src/test/java:** Contains test scripts written in Java.
- **src/main/java:** Houses additional utilities, helpers, and configurations.
- **testng.xml:** TestNG configuration file defining test suites, listeners, and parameters.
- **pom.xml:** Maven configuration file specifying project dependencies and build settings.
- **extent-config.xml:** Configuration file for Extent Reports customization.

## Reporting

Test results are documented using Extent Reports, providing detailed insights into test execution status, including passed, failed, and skipped tests. Screenshots of failed tests are captured automatically for better analysis. Additionally, screen recording of test execution can be enabled to observe the test steps and diagnose any issues effectively.

## Contribution

Contributions to enhance the framework's functionality, add new features, or fix issues are welcome. Please fork the repository, make your changes, and submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).

---

Feel free to customize this README according to your project's specifics. Happy Testing! 🚀
