# BBCTask
**Manual test cases:**

1. The project contains the feature file under resources/Features/BBC. 
The file contains both automated and manual scenarios. 
Automated scenarios are tagged using @automated and manual scenarios are tagged using @manual.

**Running from CLI:**

2. The project can be run as a cucumber feature from IDE or can be initialised using a maven command. 
"**mvn clean test -Dcucumber.options='--tags @automated'**" will run only the automated tagged features from CLI.

3. System.getProperty("browser") will be getting the browser property. 
The same can be set using CLI to run test on chrome or firefox. 
The code doesn't cover edge chromium but that can also be added easily. 
If the system property is not present then by default chrome will be used. 

**Set up pre requisite:**

4. As a pre requisite the drivers needs to be placed under C:/driver/
Chrome -> chromedriver.exe
Firefox -> geckodriver.exe

The project is built and tested only on windows 11. 
For linux and macbook, the driver path can be customised based on a new system property or based on maven parameter. 
