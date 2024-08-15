package com.swathi.ex_13July;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Lab309_edgeOptions {

    /*
         TOPICS
         1. Options - class ChromeOption, EdgeOption
         2. HTML element
         3. Web Elements
         4. Locators strategy
     */
    public static void main(String[] args) throws InterruptedException {

        // whenever we open the edge browser we get a pop-up - personalise your web experience
        // we can remove this pop-up by using Options class
        // whenever u work with any type of Browsers you can add extensions to them.
        // you can do multiple things. you can ur browser in headless mode or full mode.

        // 1. headless mode means -> (no UI ), performance will be good and fast execution.
        // The advantage is, suppose I have 10 test case I can run it in a machine with UI.
        // But if I have more than 1000 testcase daily it is not practical to see the UI of all 1000 testcases

        // 2. In full mode - there will be UI, performance will lag( when u have testcases more than 100)

        // 3. Options:- Apart from above u have options in the Browser
        // you can - start maximize, add extension, add options or param

        EdgeOptions options = new EdgeOptions();
 //       options.addArguments("--start-maximized");//if u do this the google page will not be maximized.
 //       to maximize the page u need to add options in brackets of new EdgeDriver();
 //       now it will become parameterized constructor
        // what we are doing here is we are saying whatever edge you're opening, open it in a maximized screen

 //        options.addArguments("--window-size=800,600");
 //         options.addArguments("--guest"); // u can remove the pop-up - personalise your web experience

        // we can add proxy also.
        // proxy means instead of directly connecting from client to server.
        // we connect client to proxy and proxy to internet
        // to pass the proxy we want free proxy list

        Proxy proxy = new Proxy();
        proxy.setHttpProxy("222.129.35.173:57114");
        options.setCapability("proxy", proxy);


        WebDriver driver = new EdgeDriver(options);
        driver.get("https://google.com");
        driver.manage().window().maximize();// u can maximize the window by using this also
        Thread.sleep(5000);// this is the worst way to add wait in the script
        driver.quit();

        // the .addArguments is a Browser options list
        // in this link u can find all the list. peter.sh/experiments/chromium-command-line-switches/


    }
}
