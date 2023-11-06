Basic Template
Getting started
This project contains Automation test Scripts for {Project_name}

In order to perform following automation test scripts, we need to install few softwares:

Java jdk-1.8 or higher

-> Link: https://www.oracle.com/in/java/technologies/downloads/

Integrated development environment (IDE)

You can download either IntelliJ Idea IDE or Eclipse IDE.

-> Link for IntelliJ: https://www.jetbrains.com/idea/

-> Link for Eclipse: https://www.eclipse.org/downloads/

If Eclipse is chosen,

Open the IDE and download Cucumber and TestNG Plugins from Help -> Eclipse Marketplace

Different browsers need to be installed (if cross-browser is performed).

On a safer side, chrome, firefox, and edge can be installed.

To open the automation framework, following two ways can be followed:

Clone the project repository and import it in the IDE. Or
Download the Zip file and set it up in your local workspace.
Introduction to Framework
This Test Automation Framework is created using Java + Selenium Web Driver + TestNG + Cucumber. Which can be used across different web based applications. Additionally, it offers the ability to capture screenshots for tests and generate error shots for failed test cases.

In this repository, we encourage the use of Behavior-Driven Development (BDD) with Cucumber and Java to develop automation scripts. We provide Step Definitions packaged under /{Project_name}/src/test/java/Stepdef/homeScreen.java . These Step Definitions can be customized according to your needs.

Tests are written in the Cucumber framework using the Gherkin syntax. If you're new to Gherkin and Cucumber, you can find more information at https://cucumber.io/docs/cucumber/

A typical test will have a structure similar to this:

Feature: Verify user redirection on web application
Scenario: Verify USer is redirected to correct url
Given Enter URL
When Browser is Open    
Then User is redirected to URL
Automation test scripts are implemented with PAGE OBJECT MODEL (POM) design pattern.

To better organize the test code and make it more maintainable, it is recommended to use the Page Object Design Pattern. With this pattern, the UI elements of the web application are modeled as objects within the test code. This approach reduces code duplication and allows easy updates if the UI changes. The Page Object pattern provides a solution by centralizing selectors (classes, Xpaths, IDs, etc) in separate .java files, where we can manage them along with the associated methods.

Framework Structure
The automation framework structure is as follows:

Under /{Project_name}/src/main/java, there are some important java classes (such as baseClass, browserSelector, utils,
etc) and page object classes.
Under /{Project_name}/src/test/java, there are Feature files, test runner class, and step definitions.
All the property files like configuration file are present under /{Project_name}/src/test/resources path.
Reports are generated at /{Project_name}/Reports/ExtentReport.html path.
There is a POM.xml file in which all dependencies and plugins are present.
There is also a testng.xml file located at /{Project_name}/testng.xml for cross browser testing such as Chrome, Firefox,
Microsoft Edge, etc.
<ins>Feature file description:<ins>

The Feature file is the essential segment of cucumber tool, which is used to write acceptance steps for automation
testing. Acceptance steps generally follow the application specification. A Feature file is usually a common file which
stores Feature, scenarios, and Feature description to be tested.

<ins>Step Definition description:<ins>

Steps definition file stores the mapping between each step of the scenario defined in the Feature file with a code of
function to be executed. So, now when Cucumber executes a step of the scenario mentioned in the Feature file, it scans
the step definition file and figures out which function is to be called.

Glimpse of Step Definition Class:

public class homeScreen extends browserSelector {
static homePage Obj = new homePage();

    // Step definition for Given
    @Given("Enter URL")
    public void verifyURL() {
        System.out.println("== Enter URL ==");
        // Add any additional code related to this step, if needed
    }

    // Step definition for When
    @When("Browser is Open")
    public void verifyBrowser() {
        Obj.verifyHomePage();
        System.out.println("== Browser is open ==");
        // Add any additional code related to this step, if needed
    }

    // Step definition for Then
    @Then("User is redirected to URL")
    public void verifyRedirection() {
        System.out.println("== User is redirected to URL ==");
        // Add any additional code related to this step, if needed
    }

}
<ins>Test Runner Class:<ins>

In Cucumber, the test runner file executes the Cucumber Feature files and coordinates the steps defined in those Feature
files with the corresponding step definitions. In short, runner class maps the Feature file steps to its corresponding
step definition code.

Glimpse of runner class:

// The CucumberOptions annotation is used to configure Cucumber test execution
@CucumberOptions(

        // Specify the location of your Feature files and package where your step definitions are located
        Feature = {"src/test/java/Feature"},
        glue = {"Stepdef"},

        // Configure the Cucumber plugin options
        plugin = {"pretty", "json:target/json-report/cucumber.json",
            "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        },

        // Display the Cucumber output in monochrome (removes color codes)
        monochrome = true,
        publish = true
)

public class testNgRunner extends AbstractTestNGCucumberTests {
// TestNG annotations or additional configurations can be added here if needed
}
<ins>To run the automation scripts, following ways can be followed:<ins>

Run the testng.xml file using TestNG. Single and cross browser testing can be performed using this file.
Run through command line. Open the cmd terminal where pom.xml file is located. Write and run the command (mvn clean install)
.
Run the Feature files individually using cucumber.
Run the TestRunner class using TestNG.
<ins>Test Data:<ins>

[Describe how to manage test data, if applicable]
[Include any sample test data files or templates or just write here]
<ins>POM File:<ins>

-> POM is basically Project Object Model. It is fundamental unit of work in Maven. It is an XML file that resides in the base directory of the project as pom.xml. The POM contains information about the project and various configuration detail used by Maven to build the project(s).

-> Some of the configuration that can be specified in the POM are:

Project Version
Build profiles
Plugins
Maven dependencies
-> POM Example:

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xmlns="http://maven.apache.org/POM/4.0.0"
xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
<modelVersion>4.0.0</modelVersion>

<groupId>org.example</groupId>
<artifactId>Basic_Template</artifactId>
<version>1.0-SNAPSHOT</version>
</project>
-> Note:

There should be a single POM file for each project.
Maven dependencies and plugins can vary as per the project use and requirements.
All POM files require the project element and three mandatory fields: groupId, artifactId and version.
-> Important plugins which are included are maven-cucumber-reporting , maven-compiler-plugin and maven-surefire-plugin.

-> Some important maven dependencies which are included in the POM file are as follows:

webdrivermanager
testng
cucumber-java
cucumber-testng
selenium-java
selenium-support
extentreports
extentreports-cucumber7-adapter
Reporting
Following reports will be generated with the screenshots for failed scenarios:

HTML Report

JSON Report

Extent Spark Reports

Contact Person:
QA Manager: Nishit Sheth
