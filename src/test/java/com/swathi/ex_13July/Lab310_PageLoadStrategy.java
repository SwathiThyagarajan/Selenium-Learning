package com.swathi.ex_13July;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Lab310_PageLoadStrategy {

    public static void main(String[] args) {

        // There are 3 types of PageLoadStrategy
        // EAGER, NONE and NORMAL

/*
    1. NORMAL:

This is the default strategy.
WebDriver waits for the page to fully load before returning control to the test.
The loading process is considered complete when the document.readyState is complete.

    2. EAGER:

WebDriver waits until the DOM is interactive, which means that the basic HTML document has been loaded,
 but other resources like images or stylesheets may still be loading.
This strategy may be useful if you want to start interacting with the page
 before all resources are fully loaded.

    3. NONE:

WebDriver does not wait for the page to load. Control is returned to the test
as soon as the initial HTML document has been received.
This can be useful if you're performing operations that don't require the page to be fully loaded
or if you want to manually manage page loading.

by defult it will use normal
 */
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);


        WebDriver driver = new EdgeDriver(edgeOptions);

        driver.get("https://app.vwo.com/#/login");
        System.out.println(driver.getTitle());
        driver.quit();



    }
}
