package com.swathi.ex_11July_Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Lab302_DynamicDispatch {
    public static void main(String[] args) {


        //Import Concept of OOPs ->
        // interface interfaceRef = new Class();
        //  1. Inheritance
        //  2. - Upcasting -> Dynamic Dispatch
        //  GrandFather interface can have an Object of child class.

        WebDriver driver = new EdgeDriver();// WebDriver is GrandFather, GrandFather can have EdgeDriver
        WebDriver driver1 = new ChromeDriver();
        WebDriver driver2 = new FirefoxDriver();
        WebDriver driver3 = new InternetExplorerDriver();
        WebDriver driver4 = new SafariDriver();


        //     // Opera - Selenium 4- Removed!

        // In Edge
        // In SearchContext(I) we have (2) functions
        // -> WebDriver(I)( 10) functions
        // -> RemoteWebDriver(C) (15) functions
        // -> ChromiumDriver(C) 25 functions
        // -> EdgeDriver(C) (45) functions

        //  In Chrome
        // SearchContext(I)
        // -> WebDriver(I)
        // -> RemoteWebDriver(C)
        // -> ChromiumDriver(C)
        // -> ChromeDriver(C)

        // Selenium - Architecture is nothing but - API
        // Create Session, Commands or Functions -> API Request to Browser Driver (
        // Pass the commands as API



    }
}
