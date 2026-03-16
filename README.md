YieldMonitorApplication.java
5.Open the dashboard in your browser:
http://localhost:8080
The dashboard will load and you can begin inserting manual test records immediately.
Running the Automation Test
A Selenium UI test is included to validate yield calculation. The test scenario:
6.Open the dashboard in a browser
7.Click Manual Test to open the entry form
8.Insert 5 records for part number 001PN001
9.Set 3 as Passed and 2 as Failed
10.Load the pie chart and select the part number slice
11.Verify the displayed yield equals 60%
To execute the test, run:
YieldUITest.java
The test prints PASS or FAIL to the console depending on the result.
Cloud Deployment
The application can be deployed to platforms such as
Railway
or
Render
:
1.Push the project to a GitHub repository
2.Create a new project on Railway or Render
3.Connect the GitHub repository to the platform
4.Configure the build using Gradle
5.Start the Spring Boot application
Once deployed, the platform will provide a public URL where the dashboard can be accessed remotely.
