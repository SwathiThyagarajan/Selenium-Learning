package com.swathi.ex_18July;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Lab319_ImplicitWait {

    WebDriver driver;

    @BeforeTest
    public void testOpenBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
    //    edgeOptions.addArguments("--start-maximized"); instead I can use below in test
        // driver.manage().window().maximize();
        driver = new EdgeDriver(edgeOptions);

    }

    @Test(groups = "QA")
    @Description("Testcase Description")
    public void testFindMacMini() {


        // 1st case
        // when we use Thread.sleep(5) for 5 secs
        // we are telling JVM to stop the execution, JVM will Halt everything - Worst type wait.
        // but, actually we need to tell web driver to Halt.
        // because web driver is someone who is finding the element

        // 2nd case -  Implicit Wait - Global
        // In the web driver I have given a global setting.
        // In global setting I am saying everyone will wait for 10secs
        // consider we have 3 elements E1, E2, E3
        // E1 is loaded in 5 secs
        // E2 is loaded in 1 sec
        // E3 is loaded in 10 secs
        // till E3 is loaded E1 and E2 must wait

        // 3rd Case  - Explicit wait - WebDriver
        // E1 is loaded in 5 secs
        // E2 is loaded in 1 sec
        // E3 is loaded in 10 secs
        // E1 and E2 loads quickly so, I will add condition only to E3
        // condition is -> if u find the E3 within 5 secs then click on it
        // if not give no such element exception

        // In framework, we add explicit waits only


        // Implicit Wait - Bad
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Gives No Such Element Exception.
        // by using Implicit Wait I am telling after finding the element wait for 10 seconds before u give the exception
        // Implicit Wait is Bad because it/driver adds wait after each step for 10secs.
        // it is like a global wait


        // 1. Navigate to the - https://www.ebay.com/b/Desktops-All-In-One-Computers/171957/bn_1643067
        driver.navigate().to("https://www.ebay.com/b/Desktops-All-In-One-Computers/171957/bn_1643067");
        System.out.println(driver.getTitle());

        // 2.  search Element.
        // #gh-ac
        // input[id="gh-ac"] -> xpath -> //input[@id="gh-ac"]
        driver.manage().window().maximize();
        WebElement searchBox = driver.findElement(By.cssSelector("abc"));
        // if I use wrong input it will give error/Exception
        searchBox.sendKeys("macmini");


        // 3.  click search
        // .gh-spr
        WebElement clickSearchButton = driver.findElement(By.cssSelector("input[id=\"gh-btn\"]"));
        clickSearchButton.click();




    }

    @AfterTest
    public void quitBrowser() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }




    }
