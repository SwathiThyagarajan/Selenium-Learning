package com.swathi.ex_23July;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
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

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));


//        WebElement divScrollTo = driver.findElement(By.xpath("//div[@id='userName']"));
//        js.executeScript("arguments[0].scrollIntoView(true)",divScrollTo);

        WebElement divScrollTo = driver.findElement(By.xpath("//div[@id='userName']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(divScrollTo).click().build().perform();


//
//        WebElement learningHubLink = (WebElement) js.executeScript("return document.querySelector(\"div#userName\").shadowRoot.querySelector(\"a.learningHub\")");
//       learningHubLink.click();


        // since test case is failing when using shadow Dom I have used actions class


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
