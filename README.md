# Test Mobile and API Test

## Description and context 📖
---
This repository contains Appium mobile test and Api Rest Test using Rest-Assured.
Using POM (Page Object Model) design pattern.


## Execution 🚀
---
in terminal:

```bash
gradle clean test aggregate
```
for mobile tests you must run appium server and put de capabilities in `MyCustomDriver.class`
in `Runner` you can select the different Tags to run separate test cases or the entire test set:

`@ AllCases`
`@ MobileCases, @ ApiCases`
`@ TestCase_1, @ TestCase_2 ...`

### Tools and technologies used 🛠
---
- Gradle
- Java (1.8)
- Appium 1.19.1
- Cucumber
- Selenium
- Rest-Assured
- Gherkin
- Serenity
- IDE IntelliJ