Tools

Cucumber - BDD framework and Reporting

Gherkin - Business Readable, Domain Specific Language  
Appium - Mobile Automation Library  
Java - Programming Language  
Maven - Build and Dependency Management  
Log4J2 - Logging framework  
TestNG - Testing framework  
IntelliJ - IDE


Framework features

Designed with Page Object Model   
Support parallel execution using TestNG  
Screenshot capture on scenario failure   
Video recording for each scenario   
Supports both Android and iOS  
Captures screenshot on Scenario Failure  
Supports Logging using Log4J2     
Start and stop Appium server Programatically   
Supports Cucumber-HTML-Reporter Plugin for detailed reports 


**Appium set up on MAC (Android):**

Install Homebrew
Install NodeJS (https://nodejs.org/en/download/package-manager)
Install Java JDK8 and IntelliJ IDEA 
Install Appium server using npm (CLI) or Appium desktop client
Install Android studio (https://developer.android.com/studio)
Install Appium Inspector(https://github.com/appium/appium-inspector/releases)
Set JAVA_HOME and ANDROID_HOME environment variables

 **Appium Doctor to verify the installations**

Install appium-doctor using command npm install -g appium-doctor
To view the list of available options appium-doctor --help
To check Android set up `appium-doctor --android`
To check ios set up `appium-doctor --ios`

**Android Virtual Device (Emulator) from Android Studio:**

Open Android Studio.
Click on Tools -> AVD Manager -> Create Virtual Device -> Select the device and OS version -> Finish.
Once Virtual device is created, click on Launch this AVD in the emulator.
Command to view the list of devices attached adb devices

 **Android Real Device Set up:**
 
Connect Android real device to the machine(Desktop/Laptop)
Turn on the developer options in android mobile
Enable USB debugging
Run command adb devices in cmd prompt to check whether the device is recognised
How to run the Project from Local machine  


**Start Android Emulator from Command line**

Command to stard AVD: `emulator -avd <avd_name>`
Command to stop/kill AVD: `adb -e emu kill`

**Pushing the App (.apk file) to Android Emulator:**

Copy the .apk file and paste it in the path - <path to sdk platform-tools>
Open the cmd terminal from the directory where APK file is placed and enter command adb install <apk filename>

**Android - Finding appPackage and appActivity:**

If the app is already installed on your device then we can make use of appPackage and appActivity to launch the app

Option 1 :

Open the app on the device, for which appPackage and appActivity is required.
Open powershell and enter command adb shell dumpsys window | grep -E 'mCurrentFocus|mFocusedApp' NOTE: This command may not work for newer Android OS (10 or 11). In that case, use command: adb shell "dumpsys activity activities | grep mResumedActivity"
Option 2 : Install APK info app to retrieve appPackage and appActivity for the app installed in your device



Pull the code into your machine and import in IDE (Eclipse/intelliJ).   
Run as Mvn test


NOTE

Make sure devices (Either Emulator/Simulator or Real-Device) are ready
