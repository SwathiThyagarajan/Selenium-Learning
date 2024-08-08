package com.swathi.ex_Selenium;

import org.openqa.selenium.edge.EdgeDriver;

public class Lab307_get_vs_navigate {
    public static void main(String[] args) {


        EdgeDriver driver = new EdgeDriver();
        driver.get("https://bing.com");

        // In case of driver.get we cannot go back or forward.

        // generally when I open google.com using these symbols <-  ->
        // I can go back or forward

        // for this purpose u can use navigate.to it takes URL and add exception
        // the .to command will help u to go to the URL
        // by using navigate.to command I can go back or forward and also refresh.

        driver.navigate().to("https://app.vwo.com");
        driver.navigate().to("https://google.com");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }
}
