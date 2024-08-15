package com.swathi.ex_20July;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class waitHelpers {

    // Generally we create a class known as wait helpers
    // Generally we use explicit wait in real time

//         checkVisibility method is used to wait until a web element becomes visible
//    before performing any further actions on it. Here's a breakdown of what it does:
//
//    Parameters: It accepts two parameters:
//
//    WebDriver driver: The WebDriver instance being used.
//    By locator: The locator for the element you want to wait for.
//    WebDriverWait: It creates an instance of WebDriverWait, specifying a 10-second timeout.
//
//    ExpectedConditions: The wait.until() method uses
//    ExpectedConditions.visibilityOfElementLocated(locator) to check whether
//    the element is visible. It waits until the specified element becomes visible on the page
//    or times out after 10 seconds.

    public static void checkVisibility(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // above we are using wait for 10 secs, we are continuously checking the visibility of the element
    // for 10 secs. ex if u found at 6 secs then run the code.
    // we are continuously checking without any break

    // In fluent wait we do not check continuously, instead we can check with the frequency
    // by giving intervals and check again.
    // after each interval of 2 secs it will check




/*
Fluent Wait is a type of wait in Selenium that allows you to specify the conditions to wait for,
and the frequency with which to check those conditions. It’s more flexible than
the standard WebDriverWait because you can define how often to check the condition
and what exceptions to ignore.

Fluent Wait
Flexibility: Fluent Wait provides more control over the wait conditions.
 You can define the frequency with which the condition is checked and specify which exceptions to ignore.

Polling Interval: Allows you to set how often the condition is evaluated (e.g., every 5 seconds).

Exception Handling: You can specify which exceptions to ignore during the wait,
 allowing for more fine-grained control.

Usage: Ideal for situations where you need a more customizable wait strategy.


 */


}
