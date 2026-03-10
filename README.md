# SERVLET – UC1 to UC4 Implementation

## Project Overview

This project demonstrates the fundamentals of **Java Servlets** by implementing a simple web application using **Apache Tomcat** and **Maven**. The application gradually builds functionality through four use cases (UC1–UC4), starting from a basic servlet and extending it to implement login functionality with validation.

The project is designed to help understand:

* Servlet architecture
* HTTP request and response handling
* Form submission using HTML
* Input validation using Java and Regular Expressions
* Deployment of web applications on Apache Tomcat

---

# Technologies Used

| Technology       | Purpose                                 |
| ---------------- | --------------------------------------- |
| Java             | Backend programming language            |
| Java Servlet API | Handling HTTP requests and responses    |
| Maven            | Dependency management and project build |
| Apache Tomcat    | Servlet container for deployment        |
| HTML             | Frontend user interface                 |
| JSP              | Displaying dynamic responses            |

---

# Project Structure

```
ServletProject
│
├── pom.xml
│
├── src
│   └── main
│       ├── java
│       │   └── com
│       │       └── bridgelabz
│       │           └── servlet
│       │               ├── FirstServlet.java
│       │               └── LoginServlet.java
│       │
│       └── webapp
│           ├── index.jsp
│           ├── login.html
│           ├── LoginSuccess.jsp
│           └── WEB-INF
│               └── web.xml
│
└── target
```

---

# UC1 – Create My First Servlet

## Objective

Create a simple servlet that responds with a message when accessed through a browser.

## Implementation

A servlet named **FirstServlet** is created which extends `HttpServlet`.

### Features

* Handles HTTP GET requests
* Sends an HTML response to the browser

### Access URL

```
http://localhost:8080/ServletProject-1.0-SNAPSHOT/FirstServlet
```

### Output

```
Hello World from First Servlet
```

---

# UC2 – Create a Simple Login with Predefined User

## Objective

Implement a login form that authenticates a predefined user.

## Components

### 1. login.html

HTML page containing a form to collect username and password.

### 2. LoginServlet

Processes the login request and validates credentials.

### 3. LoginSuccess.jsp

Displays a success message when login is successful.

## Login Credentials

```
Username : Tanmay
Password : Password1@
```

## Flow

```
login.html
     ↓
LoginServlet
     ↓
LoginSuccess.jsp
```

---

# UC3 – Username Validation

## Objective

Extend the login servlet to validate the username format.

## Validation Rules

1. Username must start with a **capital letter**
2. Username must have **minimum 3 characters**

## Regex Used

```
[A-Z][a-zA-Z]{2,}
```

## Example

Valid usernames:

```
Tanmay
Rahul
John
```

Invalid usernames:

```
tanmay
ab
1Rahul
```

If the validation fails, the system displays an error message and redirects the user back to the login page.

---

# UC4 – Password Validation

## Objective

Add password validation rules to improve security.

## Password Rules

1. Minimum **8 characters**
2. At least **1 uppercase letter**
3. At least **1 numeric digit**
4. Must contain **1 special character**

## Regex Used

```
^(?=.*[A-Z])(?=.*\d)(?=.*[@#$%^&+=!]).{8,}$
```

## Example

Valid Password:

```
Password1@
```

Invalid Password Examples:

```
password
Password
Pass123
```

If the password does not meet the rules, the user receives an error message and is redirected back to the login page.

---

# How to Build the Project

Run the following command in the project directory:

```
mvn clean package
```

This command compiles the project and generates a **WAR file** in the `target` directory.

Example:

```
target/ServletProject-1.0-SNAPSHOT.war
```

---

# Deploying to Tomcat

1. Copy the generated `.war` file

```
target/ServletProject-1.0-SNAPSHOT.war
```

2. Paste it inside the Tomcat `webapps` directory

```
apache-tomcat/webapps
```

3. Start Tomcat

```
startup.bat
```

4. Open the application in browser

```
http://localhost:8080/ServletProject-1.0-SNAPSHOT/login.html
```

---

# Application Flow

```
User opens login.html
        ↓
User enters username and password
        ↓
LoginServlet processes request
        ↓
UC3 validates username
        ↓
UC4 validates password
        ↓
If valid → LoginSuccess.jsp
If invalid → Error + redirect to login page
```

---

# Learning Outcomes

After completing this project, you will understand:

* How Servlets process HTTP requests
* How to build a Maven-based web application
* How to deploy Java applications on Tomcat
* How to validate user input using regular expressions
* Basic web application architecture

---

# Author

**Tanmay Bhosale**

Java Servlet Practice Project – UC1 to UC4 Implementation
