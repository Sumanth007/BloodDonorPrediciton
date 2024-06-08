# Future Blood Donor Prediction and Analysis 

## Overview
This project is a web application developed using Java Servlet, JSP, MySQL, and Machine Learning (ML) techniques. It combines predictive analytics and classification algorithms to predict future blood donors and classify them into various categories.

## Features
- Predictive Analytics: The system predicts future blood donors based on past donation patterns using regression algorithms.
- Blood Donor Classification: The system classifies blood donors into various categories using K-means clustering algorithms.
- Visualization of the result is provided.

## Dependencies
- Java (JDK)
- Apache Tomcat
- MySQL
- Front-end: HTML, CSS, JavaScript, JSP

## Installation
1. Clone the repository: `git clone <repository-url>`
2. Set up the MySQL database:
   - Create a database named `bloodbank`
   - And create tables with help with the sql dataset given.
3. Configure the MySQL database connection in the `DBConnection.java` file.
5. Build and deploy the project on Apache Tomcat.

## Usage
1. Access the web application using the URL: `http://localhost:8080/BloodDonationSystem/`
2. Single or Multiple Future blood donors can be predicted by filling the form manually or by choosing the CSV file.
2. Classification of High and Low blood donating regions is also provided.
