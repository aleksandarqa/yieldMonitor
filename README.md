Yield Monitor Dashboard

This project is a simple web-based Yield Monitoring application. It allows manual entry of test results, displays production statistics on a dashboard, and validates yield calculation using a Selenium automation test.

Yield is calculated using the formula:

Yield = (Passed Units / Total Tested Units) × 100

Example: 3 passed out of 5 tested = 60% yield.

Features

Backend API built with Spring Boot:

POST /tests – insert a test record

GET /tests – return all test records

GET /stats – calculate yield statistics per part number

GET /daily – return daily testing volume for the last 7 days

Dashboard functionality:

Manual test entry form

Daily testing volume bar chart

Part number distribution pie chart

Yield display for selected part number

Charts are implemented using Chart.js.

Setup

Clone the repository.

Open the project in IntelliJ IDEA.

Run the Spring Boot application:

YieldMonitorApplication.java

Open a browser and go to:

http://localhost:8080

The dashboard will load and you can insert manual test records.

Automation Test

A Selenium UI test verifies the yield calculation.

Test scenario:

Open the dashboard

Click Manual Test

Insert 5 records for part number 001PN001

Set 3 Passed and 2 Failed

Load the pie chart

Select the part number slice

Verify that the yield equals 60%

Run the test class:

YieldUITest.java

The test prints PASS or FAIL depending on the result.

Deployment

The project can be deployed on platforms such as Railway or Render.

Basic deployment steps:

Push the project to a GitHub repository.

Create a new project on Railway or Render.

Connect the GitHub repository.

Build the project using Gradle.

Start the Spring Boot application.

The platform will provide a public URL where the dashboard can be accessed.

Technologies

Java
Spring Boot
H2 Database
Chart.js
Selenium WebDriver
Gradle
