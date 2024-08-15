package com.swathi.ex_20July;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.swathi.ex_20July.waitHelpers.checkVisibility;

public class Lab321 {

    WebDriver driver;

    @BeforeTest
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

        // wait DashBoard to load
// <span class="Fw(semi-bold) ng-binding" data-qa="lufexuloga">Login Test</span>
//   You can use CSS selectors to target elements with specific attributes
        // css locator -->   [data-qa='lufexuloga']


//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-qa='lufexuloga']")));

        // we can use waitHelpers instead of using the above. waitHelpers is the class that we created
        // this is a smaller and cleaner function
        checkVisibility(driver,By.cssSelector("[data-qa=\"lufexuloga\"]"));


        WebElement loggedin_username = driver.findElement(By.cssSelector("[data-qa='lufexuloga']"));
        System.out.println("Logged in User details -> " + loggedin_username.getText());
        Assert.assertEquals(loggedin_username.getText(),"Login Test");

 //  We can get an element using ID, name, class. But if they are not unique or
        //    When You  don't find id , name or class then we can go with linkText or partial Text
        //    but linkText or partial Text work with only an anchor/ a tag.
        //    so, in such cases I can use x path or css selector






    }

    @AfterTest
    public void closeBrowser(){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
