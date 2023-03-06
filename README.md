Final Surge is the training and coaching platform that empowers athletes and coaches to reach fitness and performance 
excellence like never before.

Checklist:
1. Verify that user can log in/log out the system.
2. Verify that user can add workout.
3. Verify that user can add workout to library.
4. Verify that user can use ‘Other Calculators’ to calculate daily caloric needs.
5. Verify that user can use ‘Other Calculators’ to calculate pace.
6. Verify that user can use ‘Intensity calculator’.
7. Verify that user can use ‘Hansons calculator’.
8. Verify that user can use ‘McMillan calculator’.
9. Verify that user can use ‘Tinman calculator’.
10. Verify that user can use ‘Palladino calculator’.
11. Verify that user can change their data.
12. Verify that user can report on workouts of the selected type for the selected period.
13. Verify that user can open print page with workouts for the selected time period.
14. Verify that user can copy his activity to another day in calendar.(in work) Дима
15. Verify that user can view daily vitals for the selected time period.
16. Verify that user can quick add workout to the calendar.
17. Verify that user can't pay for the training with a non-existent card

Prerequisites installed:
1. Java JDK: 19
2. Maven version: 3.0.0-M5
3. Allure version: 2.10.0

Libraries used in the project:
1. Selenium-java version: 3.141.59;
2. WebDriverManager version: 5.3.0;
3. TestNG version: 7.4.0;
4. Lombok version: 1.18.24;
5. Log4j-core version: 2.19.0;
6. Allure-testng version: 2.20.1;

Setting up config:
1. Clone this repository.
2. Enter your email and password in config.properties.

Instructions for running tests:
All test: mvn clean test
Regression test: mvn clean test -DsuiteXmlFile="regressionTest.xml"
Negative test: mvn clean test -DsuiteXmlFile="negativeTest.xml"
Smoke test: mvn clean test -DsuiteXmlFile = "smokeTest.xml"


Generates a report:
allure generate
allure serve

