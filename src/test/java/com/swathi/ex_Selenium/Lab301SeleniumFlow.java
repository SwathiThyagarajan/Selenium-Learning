package com.swathi.ex_Selenium;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Lab301SeleniumFlow {

    @Test
    public void vwoLogin() {

//   First we need to understand the Selenium Flow
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://sdet.live");
        driver.quit();

 /*       Selenium Flow INTERVIEW QUESTION
      The moment u type new EdgeDriver(); in JVM EdgeDriver class will be loaded
      EdgeDriver extends from chrome Driver because Edge is copy-paste of chrome.
      Chrome Driver extends/ is getting everything from Remote Web Driver.
      Remote Web Driver(class) is getting everything/ implements Web Driver.
      Web Driver extends / is getting everything from SearchContext.

      Therefore, the Real Father is interface SearchContext.

      EdgeDriver class is present in External libraries once u download the dependency automatically they are available
 */
        // Selenium Flow
        // 1. Create SessionID - q09876q789e8wq89we87. The moment u type new EdgeDriver();
        // a session ID is created by Client - Java(Program).
        // Server is - Web driver Edge - by using Command W3C it is giving command to -> Edge browser
        // 2. In the Session -> Run the commands -to make a GET request -> GET Method using w3c Protocol will be executed
        // 3. EdgeDriver (Server) -> Tell the Edge Browser
        // 4. Open a Fresh copy of the Edge Browser and
        // Open the URL - https//sdet.live
        // 5. Driver - Command (POST) Request - Shutdown the browser. SessionID == null

    }

}
