<img width="1895" height="915" alt="image" src="https://github.com/user-attachments/assets/2473a167-5dfa-4f84-96be-eeb535b3300b" /># Yield Monitor Dashboard

> A web-based application for tracking and analyzing manufacturing test results with real-time yield statistics and automated UI testing.

---

## Table of Contents

- [Description](#description)
  - [Yield Formula](#yield-formula)
  - [Key Features](#key-features)
  - [REST API Endpoints](#rest-api-endpoints)
  - [Technologies](#technologies)
- [Installation](#installation)
  - [Prerequisites](#prerequisites)
  - [Local Setup](#local-setup)
  - [Running the Automation Test](#running-the-automation-test)
  - [Cloud Deployment](#cloud-deployment)

---

## Description

The Yield Monitor Dashboard is a web-based application for tracking and analyzing manufacturing test results. It enables manual entry of test records, displays real-time production statistics, and automates yield validation through Selenium UI testing.

### Yield Formula

Yield is calculated using the following formula:

```
Yield = (Passed Units / Total Tested Units) × 100
```

**Example:** 3 units passed out of 5 tested → **60% yield**

### Key Features

| Feature | Details |
|---|---|
| Backend API | Built with Spring Boot; exposes REST endpoints for test data management |
| Manual Entry | Dashboard form for inserting individual test records |
| Daily Volume Chart | Bar chart showing testing volume for the last 7 days |
| Part Distribution | Pie chart showing part number distribution |
| Yield Display | Per-part-number yield calculated and displayed on demand |
| Automation Test | Selenium UI test that verifies yield calculation end-to-end |

### REST API Endpoints

| Endpoint | Description |
|---|---|
| `POST /tests` | Insert a new test record |
| `GET /tests` | Retrieve all test records |
| `GET /stats` | Calculate yield statistics per part number |
| `GET /daily` | Return daily testing volume for the last 7 days |

### Technologies

| Technology | Purpose |
|---|---|
| Java Spring Boot | Backend REST API and application server |
| H2 Database | Embedded in-memory relational database |
| Chart.js | Frontend charting library (bar and pie charts) |
| Selenium WebDriver | UI test automation framework |
| Gradle | Build and dependency management tool |

---

## Installation

### Prerequisites

Before setting up the application, ensure the following are installed:

- Java Development Kit (JDK) 11 or higher
- IntelliJ IDEA (recommended IDE)
- Git
- Google Chrome and ChromeDriver (required for Selenium tests)

### Local Setup

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   ```

2. **Open the project** in IntelliJ IDEA

3. **Resolve dependencies** — allow Gradle to download all required packages

4. **Run the application** by launching the main class:
   ```
   YieldMonitorApplication.java
   ```

5. **Open the dashboard** in your browser:
   ```
   http://localhost:8080
   ```

The dashboard will load and you can begin inserting manual test records immediately.

### Running the Automation Test

A Selenium UI test is included to validate yield calculation. The test scenario:

1. Open the dashboard in a browser
2. Click **Manual Test** to open the entry form
3. Insert **5 records** for part number `001PN001`
4. Set **3 as Passed** and **2 as Failed**
5. Load the pie chart and select the part number slice
6. Verify the displayed yield equals **60%**

To execute the test, run:
```
YieldUITest.java
```

The test prints `PASS` or `FAIL` to the console depending on the result.

### Cloud Deployment

The application can be deployed to platforms such as [Railway](https://railway.app) or [Render](https://render.com):

1. Push the project to a GitHub repository
2. Create a new project on Railway or Render
3. Connect the GitHub repository to the platform
4. Configure the build using Gradle
5. Start the Spring Boot application

Once deployed, the platform will provide a public URL where the dashboard can be accessed remotely.




ScreenSchots 
<img width="1883" height="906" alt="image" src="https://github.com/user-attachments/assets/f03d5d31-cc0e-4952-a6fc-069f282aa4da" />
<img width="1892" height="914" alt="image" src="https://github.com/user-attachments/assets/23060602-f59c-40a7-8c1d-70d2d9f1d6a8" />
<img width="1897" height="908" alt="image" src="https://github.com/user-attachments/assets/626c6719-e95a-4d24-897f-32d8681608c5" />
<img width="1900" height="915" alt="image" src="https://github.com/user-attachments/assets/7f63e7e7-94f5-4399-b81d-5dca6c4183d9" />
<img width="1452" height="679" alt="image" src="https://github.com/user-attachments/assets/b1d59571-3ddb-4c83-9d00-a90834cab147" />
<img width="1514" height="1018" alt="image" src="https://github.com/user-attachments/assets/498d578a-cd9e-4e5b-a7a4-9e8c0fa6c7ca" />
<img width="1898" height="915" alt="image" src="https://github.com/user-attachments/assets/1aa6a504-309f-415e-bf29-dedc42dc1640" />
<img width="1895" height="915" alt="image" src="https://github.com/user-attachments/assets/3832b43e-9858-4240-9988-cf14d84c4f92" />




