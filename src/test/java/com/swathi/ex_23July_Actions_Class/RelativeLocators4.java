package com.swathi.ex_23July_Actions_Class;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators4 {

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
    public void testIframe(){
        driver.navigate().to("https://codepen.io/AbdullahSajjad/full/LYGVRgK");

        // iframe  -> is a html element it is a frame within a frame
        // An iframe (short for "inline frame") is an HTML element used to
        // embed another HTML document within the current document.
        // It essentially creates a window within a web page that can display content
        // from another source, such as another web page, video, or advertisement.

        // to find the child frame within the parent frame u must first switch to the child frame

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Now I need to switch to iframe for that you must use -> driver.switchTo().frame-
        // u must give id of the iframe
        driver.switchTo().frame("result");
            // to get the errors I need to directly click on the submit button
        WebElement submitButton = driver.findElement(By.xpath("//form[@id='form']/button"));
        submitButton.click();
        // now we will find the userName
        WebElement inputBoxUsername = driver.findElement(By.xpath("//input[@id='username']"));
        // we can find the error using relative locator
        WebElement errorUsername = driver.findElement(with(By.tagName("small")).below(inputBoxUsername));
        String errorText = errorUsername.getText();
        Assert.assertTrue(errorUsername.isDisplayed());
        Assert.assertEquals(errorText,"Username must be at least 3 characters");



    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
