package com.swathi.ex_20July;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Lab322_FluentWait {

    WebDriver driver;

    public void openBrowser(){

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(edgeOptions);
    }

    @Test(groups = "QA")
    @Description("Testcase Description")
    public void testVerifyDashboardLoad(){

        driver.navigate().to("https://app.vwo.com/#/login");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.findElement(By.id("login-username")).sendKeys("LogintestPositive@1secmail.com");
        driver.findElement(By.id("login-password")).sendKeys("App*vwo2024");
        driver.findElement(By.id("js-login-btn")).click();




        // wait DashBoard to load - using Fluent wait

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2)) // so it will run 5 times
                .ignoring(NoSuchElementException.class);

        WebElement checkloggedin_username =  wait.until(driver -> driver.findElement(By.cssSelector("[data-qa='lufexuloga']")));
        System.out.println("Logged in User details -> " + checkloggedin_username.getText());
        Assert.assertEquals(checkloggedin_username.getText(),"Login Test");
    }


    @AfterTest
    public void closeBrowser(){

        driver.quit();
    }

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
