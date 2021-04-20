# Test Mobile and API Test

## Description and context 📖
---
This repository contains Appium mobile test and Api Rest Test using Rest-Assured.
Using POM (Page Object Model) design pattern.


## Execution 🚀
---
in console:

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
- Ubuntu 20
- SonarLint (plugin-IntelliJ)

### Tips and alternatives to execute
- use `appium-doctor` (npm i -g appium-doctor) to check the dependencies for appium for example:
  - node version
  - ANDROID_HOME
  - JAVA_HOME
  - adb
    
- use `start-android-emulator` (npm i -g start-android-emulator) for nodeJS to start Android-emulador in console
- use docker compose to start gradle test project: `TARGET=AllCases docker-compose up`
  before you must start appium-server and emulator
