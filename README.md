Appium mobile website tests
=============================
This repository contains sample Appium tests for two mobile websites using Java with Android emulator.

## What will you need before running test?

1. [Appium desktop app](https://github.com/appium/appium-desktop/releases/tag/v1.6.2). You can also install Appium via NPM, please find the instruction [here](https://www.edgewordstraining.co.uk/2017/07/05/install-appium-server-windows/).
2. Tool to run emulator:
[Android Studio](https://developer.android.com/studio/) - AVD Manager or [Genymotion](https://www.genymotion.com/).
4. Some IDE e.g. [IntelliJ](https://www.jetbrains.com/idea/).

## Design / implementation decisions
Test framework was created by using Java with Appium - open source test automation framework - that allows you to automate websites running on mobile devices. 

Tests are implemented in Gradle project which use JUnit4 dependencies to run our tests. Dependencies are added inside build.gradle file.

## Project structure
![image](https://user-images.githubusercontent.com/20278819/41817870-7d696386-779b-11e8-8b9b-7204476f3c9e.png)

Tests were created inside appium package. Since tests are written for two different websites I have decided to split them into separate packages: travelex, wikipedia and utils contains AppiumSetup that other test and page classes inherit from.

## Design Pattern
![image](https://user-images.githubusercontent.com/20278819/41817903-0704bd98-779c-11e8-9514-fae402d405a3.png)

I have decided to use Page Object Model to be able to create reusable components that represent application under test. Apart from reusability, POM improves the readability and maintenance of the tests significantly. What is more, the tester usually names the methods in those classes generally with the domain driven language which provides better understandability for new people joining the project.

In the `...Page` classes there are WebElements and methods that perform desired actions on them. In the `...Test` classes there are tests implemented that reuse methods from `...Page` classes and they can be reused throughout our Page Object implementations. 


## AppiumSetup class

`setCapabilities()` allow you to specify environment where tests will be executed. It can be web browser, real mobile device, Android emulator or iOS simulator. There are many capabilities you can specify for your testing needs. Desired capabilities are the keys that user provides at the beginning of test session. In my project I used [MobileCapabilityType](https://appium.github.io/java-client/io/appium/java_client/remote/MobileCapabilityType.html) class.

To specify on which device tests should run you need to provide deviceName in setCapabilities. Device name can be checked by running command in terminal `adb devices` that would list all running/connected devices. In my AppiumSetup class you will notice that `deviceName` is `emulator-5554` which is default name for the first emulator opened.

`getDriver()` this method launches AppiumDriver and allows communication and test execution between Appium server and testing framework. Please read more about various types of drivers [here](https://discuss.appium.io/t/what-is-the-use-or-difference-between-androiddriver-iosdriver-appiumdriver-and-remote-webdriver/8750)

## Run tests from IDE
f
1. Clone the project from the repository.
2. Open it in your IDE.
3. Start Appium server from desktop app or [Terminal](https://www.edgewordstraining.co.uk/2017/07/05/install-appium-server-windows/)
4. Start one of the emulators from AVD Manager
5. Navigate to `src/test/java/appium`
6. Right click on the package and select `Run Tests in Appium`

![image](https://user-images.githubusercontent.com/20278819/41817909-2c6cf15e-779c-11e8-9cd9-6b6fb8071e48.png)


## Run tests from Terminal

1. Open Terminal / Command line and navigate to project directory.
2. Start Appium server
3. Start one of the emulators from AVD Manager
2. Run command:

`./gradlew test`
