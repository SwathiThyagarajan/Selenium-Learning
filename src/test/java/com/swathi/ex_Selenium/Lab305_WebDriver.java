package com.swathi.ex_Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Lab305_WebDriver {

    public static void main(String[] args) {

        // Make it a practice to always use WebDriver for more functionalities

        WebDriver driver = new EdgeDriver();
        driver.get("https://sdet.live");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getPageSource());

    /*    WebDriver driver2 = new WebDriver();
        The statement WebDriver driver2 = new WebDriver(); is incorrect and will result in a compilation error.

        WebDriver driver2 = new WebDriver(); will not work because WebDriver is an interface and
        cannot be instantiated directly.
You need to instantiate one of the classes that implement WebDriver,
 such as ChromeDriver, EdgeDriver, or FirefoxDriver.


     */

    }
}
