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

public class Lab320_ExplicitWait {

    // using Implicit wait in app.vwo.com

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
    public void testVerifyFreeTrial(){

        // Explicit wait.
        // Explicit wait is with certain condition
        // they allow your code to halt program execution, or freeze the thread, until the condition you passed is resolved.
//  The following are the Expected Conditions that can be used in Selenium Explicit Wait
//        alertIsPresent()
//        elementSelectionStateToBe()
//        elementToBeClickable()
//        elementToBeSelected()
//        frameToBeAvaliableAndSwitchToIt()
//        invisibilityOfTheElementLocated()
//        invisibilityOfElementWithText()
//        presenceOfAllElementsLocatedBy()
//        presenceOfElementLocated()
//        textToBePresentInElement()
//        textToBePresentInElementLocated()
//        textToBePresentInElementValue()
//        titleIs()
//        titleContains()
//        visibilityOf()
//        visibilityOfAllElements()
//        visibilityOfAllElementsLocatedBy()
//        visibilityOfElementLocated()


        driver.navigate().to("https://app.vwo.com/#/login");
        System.out.println(driver.getTitle());

        // username
//<input type="email" class="text-input W(100%)" name="username" id="login-username" data-qa="hocewoqisi">
        driver.findElement(By.id("login-username")).sendKeys("contact+atb7x@thetestingacademy.com");
        driver.findElement(By.id("login-password")).sendKeys("Wingify@1234");
        driver.findElement(By.id("js-login-btn")).click();

// the above will work but u will not be able to create a free trial account
        // because u will get an error message as -> an account with this email already exists
        // we can verify the error message

 //        <div class="notification-box-description" id="js-notification-box-msg" data-qa="rixawilomi">Your email, password, IP address or location did not match</div>

        WebElement error_msg = driver.findElement(By.id("js-notification-box-msg"));
        System.out.println(error_msg.getText());

        // Explicit wait.
        // now we know error_msg takes time so, I will add wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.textToBePresentInElement(error_msg,"Your email, password, IP address or location did not match"));

        Assert.assertEquals(error_msg.getText(),"Your email, password, IP address or location did not match");


//
//        // In normal script without expicit wait this is what we would do
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//

 //  To fix this error in case if I add implicit wait
       // adding 10secs wait after every step is not a good way so, therefore we will add explicit wait

        // Explicit wait.
        // now we know error_msg takes time so, I will add wait
    }

    @AfterTest
    public void closeBrowser(){

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }




}
