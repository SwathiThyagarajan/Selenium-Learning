package com.swathi;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionClass {


/*   Actions class is an ability provided by Selenium for handling keyboard and mouse events.
Key Features of the Actions Class

1. Mouse Actions:
Click: Click on an element.
DoubleClick: Double-click on an element.
ContextClick: Right-click (context click) on an element.
MoveToElement: Move the mouse to a specific element.
DragAndDrop: Drag an element and drop it to another element.

2. Keyboard Actions:
SendKeys: Send keyboard inputs to an element.
KeyDown: Press and hold a key.
KeyUp: Release a key.

3. Combination Actions:
ClickAndHold: Click and hold an element.
Release: Release the mouse button after clicking and holding.


 */
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
    public void testEnterName(){
        driver.navigate().to("https://awesomeqa.com/practice.html");

//        driver.findElement(By.name("firstname")).sendKeys("thetestingacademy");
        // above if I want to enter thetestingacademy in capital
        // for this we must press shift and enter thetestingacademy and release shift
        // ie; Shift Keydown -> thetestingacademy -> Shift KeyUp
        // we can do it by using actions class

        // mention where u need to send the keys ie; thetestingacademy
        WebElement firstName = driver.findElement(By.name("firstname"));

        Actions actions = new Actions(driver);
        actions
                .keyDown(Keys.SHIFT)
                .sendKeys(firstName,"thetestingacademy") // find firstName and type thetestingacademy
                .keyUp(Keys.SHIFT)
                .build().perform();


        // 2. https://awesomeqa.com/practice.html
        // In the above same website if I want to click on something it is known as context click
        // suppose if I want to click on --> Click here to Download File
        // I can use xpath function --> contains

        try {
            Thread.sleep(13000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement link = driver.findElement(By.xpath("//a[contains(text(), 'Click here to Download File')]"));
        actions.contextClick(link).build().perform();

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
