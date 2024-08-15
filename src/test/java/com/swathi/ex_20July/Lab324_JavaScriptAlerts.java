package com.swathi.ex_20July;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Lab324_JavaScriptAlerts {

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
    public void testVerifyJavaScriptAlert(){

        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        System.out.println(driver.getTitle());

        //  1.  click for JS Alert Button
        // <button onclick="jsAlert()">Click for JS Alert</button>
        // This is xpath //button[@onclick="jsAlert()"]
        // This is xpath using text //button[text()='Click for JS Alert']
        // This is css selector --> button[onclick="jsAlert()"]


        // 2. click for JS Confirm button
        // <button onclick="jsConfirm()">Click for JS Confirm</button>
        // 2 scenarios we will have here 1. if u click ok. 2. if u click cancel

        // 3. click for JS prompt button
        // here u need to enter something, only difference is u can send keys in alert
        //       <li><button onclick="jsPrompt()">Click for JS Prompt</button></li>

        //  1.  click for JS Alert Button
//        WebElement element = driver.findElement(By.cssSelector("button[onclick=\"jsAlert()\"]"));
//        element.click();// after finding the element I need to click on it
   //  when I click on the element a pop-up comes, we need to wait

        // 2. click for JS Confirm button
//        WebElement elementConfirm = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
//        elementConfirm.click();

        // 3. click for JS prompt button
        WebElement elementPrompt = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        elementPrompt.click();


     // when running the code in AWS, Docker machines Alert is slow, Alert will come after sometime.
        // so, we need to wait. Therefore, I am using webdriver wait

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
     //   alert.accept();
     //   alert.dismiss();
        alert.sendKeys("SWATHI");
        alert.accept();
        //   alert.dismiss();

//  Why It’s Done:
//Switching Context to the Alert:
//When a JavaScript alert pops up on a webpage, it essentially "takes control" of the browser
// until the user either accepts or dismisses the alert.
//The method driver.switchTo().alert() tells Selenium to switch the context
// from the webpage (where your test is currently focused) to the alert box that has appeared.
//
// Accepting the Alert:
//Once the context is switched to the alert, alert.accept() is called to simulate
// the user pressing the OK button on the alert.
//In the case of a simple alert (with only one button, usually labeled "OK"),
// this action closes the alert and allows the test to proceed with further steps.

        // After the Alert pop-up u will see the below result message
        // Result:
        //You successfully clicked an alert
    //    <p id="result" style="color:green">You successfully clicked an alert</p>

        // Verifying result after the alert is accepted
        String result = driver.findElement(By.id("result")).getText();
     //   Assert.assertEquals(result,"You successfully clicked an alert");
     //   Assert.assertEquals(result, "You clicked: Ok");
    //    Assert.assertEquals(result,"You clicked: Cancel");
        Assert.assertEquals(result,"You entered: SWATHI");
     //   Assert.assertEquals(result,"You entered: null");
//        String result is used to store the text content of the element,
//        which you then compare to the expected result in the assertion.















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
