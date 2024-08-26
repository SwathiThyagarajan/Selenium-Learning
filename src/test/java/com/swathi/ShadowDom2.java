package com.swathi;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ShadowDom2 {

//    Shadow Dom
//
//1. Click on the selectorshub.com/xpath-practice-page/ learnignHub Link
//2. Enter the pizza name in the pizza

    WebDriver driver;

    @BeforeTest
    public void openBrowser() {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(edgeOptions);

    }

    @Test(groups = "QA")
    @Description(" Testcase Description ")
    public void testVerifyShadowDom() {
        driver.navigate().to("https://selectorshub.com/xpath-practice-page/");

        JavascriptExecutor js = (JavascriptExecutor) driver;// JavascriptExecutor is an Interface
        // JavascriptExecutor has 2 functions
//        js.executeScript("here you can type any Javascript code");
//        js.executeScript("alert(1)");
        // ex: if u want to go to the Enter email inputBox then u can use this code -> document.querySelector("#shub8")
        // and u can use return to return this element -> document.querySelector("#shub8")
        //return document.querySelector("#shub8") this will return a web element of inputBox

//        Interacting with Shadow DOM in Selenium:
//        When automating web applications using Selenium,
//        if you need to interact with elements inside a Shadow DOM, you must first access the Shadow Host,
//        and then use JavaScript to traverse into the Shadow DOM using methods like shadowRoot.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


        // Access the shadow root for the "LearningHub" link
        WebElement shadowHost = (WebElement) js.executeScript("return document.querySelector('shadow-host-selector')");
        WebElement shadowRoot = (WebElement) js.executeScript("return arguments[0].shadowRoot", shadowHost);
        WebElement learningHubLink = (WebElement) js.executeScript("return arguments[0].querySelector('a#learningHub')", shadowRoot);
        learningHubLink.click();

        // Access the shadow root for the pizza input box
        WebElement pizzaShadowHost = (WebElement) js.executeScript("return document.querySelector('pizza-shadow-host-selector')");
        WebElement pizzaShadowRoot = (WebElement) js.executeScript("return arguments[0].shadowRoot", pizzaShadowHost);
        WebElement pizzaInput = (WebElement) js.executeScript("return arguments[0].querySelector('input#pizza')", pizzaShadowRoot);
        pizzaInput.sendKeys("Pepperoni");
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
