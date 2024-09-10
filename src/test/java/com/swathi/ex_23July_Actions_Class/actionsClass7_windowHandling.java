package com.swathi.ex_23July_Actions_Class;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class actionsClass7_windowHandling {

    WebDriver driver;


    @BeforeTest
    public void openBrowser() {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
//        edgeOptions.addArguments("--start-maximized");
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(edgeOptions);


    }


    @Test(groups = "QA")
    @Description(" Testcase Description ")
    public void testPositive() {

        driver.navigate().to("https://the-internet.herokuapp.com/windows");


        // Multi window scenario:-
        // click on the button click here it will navigate to a new window,
        // suppose I want to verify the new window and then switch back to previous window
         // and verify Opening a new window

        // every window in chrome is assigned with a unique 16 digit String

        String mainWindowHandle = driver.getWindowHandle();// this will give the no. of windows opened
        System.out.println("Before Click -> " + mainWindowHandle);// this will give 1 window
        WebElement link = driver.findElement(By.linkText("Click Here"));
        link.click();// after clicking, we will have 2 windows a set of String
        Set<String> windowHandles = driver.getWindowHandles(); // here why it gives Set why not List
        // It is Set because all the windows tab have a unique name
        for (String handle : windowHandles){
            driver.switchTo().window(handle);
            System.out.println("After Click -> " + handle);
            if (driver.getPageSource().contains("New Window")){
                System.out.println("Test Case Passed");

            }
        }

        // If I want to move back to original window
        driver.switchTo().window(mainWindowHandle);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));



    }

    @AfterTest
    public void closeBrowser() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

}