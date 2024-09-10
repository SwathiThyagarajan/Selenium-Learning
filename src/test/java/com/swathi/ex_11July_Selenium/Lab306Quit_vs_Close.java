package com.swathi.ex_11July_Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Lab306Quit_vs_Close {

    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com");


        // IMPORTANT INTERVIEW QUESTION
        //  QUIT VS CLOSE
        // let's understand this with simple example
        Thread.sleep(5000);
        driver.close();
        // close means after the given 5 secs sleep time the window app.vwo.com will be closed
        // it will close only the current Browser window not the full browser
        // As well as if u still see session ID is not null. session ID ! = NULL
        // which means session is still running

        driver.quit();
        // Close all the /sessions/windows and stop the browser
        // Session = null, Error - Session ID is null
    }
}
