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

public class ShadowDom {


//    Shadow DOM is a web standard that allows web components to encapsulate their functionality
//    and styling within a boundary, preventing the styles and behavior of the component
//    from affecting the rest of the page.

//    The DOM (Document Object Model) is a programming interface for web documents.
//    It represents the structure of a webpage as a tree of objects, where each object corresponds
//    to a part of the document. The DOM allows programming languages like JavaScript
//    to interact with and manipulate the content, structure, and styles of a webpage.

//  When automating web applications with Selenium, you might encounter elements inside Shadow DOMs
//  that are not directly accessible using standard WebDriver locators.
//
// To interact with elements inside a Shadow DOM, you need to navigate through the Shadow DOM boundary
// using JavaScript.


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
//        // JavascriptExecutor has 2 functions
//        js.executeScript("here you can type any Javascript code");
//        js.executeScript("alert(1)");
//        // ex: if u want to go to the Enter email inputBox then u can use this code -> document.querySelector("#shub8")
//        // and u can use return to return this element -> document.querySelector("#shub8")
//        //return document.querySelector("#shub8") this will return a web element of inputBox
//
//        WebElement inputBox = (WebElement) js.executeScript("return document.querySelector(\"#shub8\")");
//        inputBox.sendKeys("Hello How are you!!"); // JavascriptExecutor can execute this task


//        WebElement element = driver.findElement(By.xpath("//input[@id='pizza']"));
//        element.sendKeys("This will not work");

//  When automating web applications with Selenium, you might encounter elements inside Shadow DOMs
//  that are not directly accessible using standard WebDriver locators.
//
// To interact with elements inside a Shadow DOM, you need to navigate through the Shadow DOM boundary
// using JavaScript.


/*   To handle these kind of scenario's steps to follow
 1st find who is root for the web element present inside shadow dom where is the div present
 if u see in Inspect element parent ie; userName is also in div. In the userName we have the shadow Dom
 which is open, if it is closed selenium will not be able to find it.
 We can find the element userName by using id directly.
 But to find the shadow Dom we need to use Javascript concept
 Shadow Root: This is the root of the shadow tree, where the shadow DOM starts.
 You create it using JavaScript.

 document.querySelector("div#userName") -> this will find the full div
 In the full div we want to go to the shadow root so -> .shadowRoot
 In the shadow root we have another div so --> .querySelector("div")
 In this div we have another shadow root  so --> .shadowRoot
 In the shadow root we want pizza so --> .querySelector("input#pizza")


 */
// JavaScript code - document.querySelector("div#userName").shadowRoot.querySelector("div").shadowRoot.querySelector("input#pizza")
// This JavaScript code will give you WebElement

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

// we are using scroll to go to the parent class of Enter pizza name Box.
// this class is not within the shadow dom so, we can use xpath
        WebElement divScrollTo = driver.findElement(By.xpath("//div[@id='userName']"));
        js.executeScript("arguments[0].scrollIntoView(true)",divScrollTo);

        // Wait for the shadow host to be present
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='userName']")));

        // Access the input box inside the nested shadow DOM
        WebElement inputBoxPizza = (WebElement) js.executeScript("return document.querySelector(\"div#userName\").shadowRoot.querySelector(\"div\").shadowRoot.querySelector(\"input#pizza\")");
        // Send keys to the input box
        inputBoxPizza.sendKeys("FarmHouse");





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
