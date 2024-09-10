package com.swathi.ex_23July_Actions_Class;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class seleniumException1 {

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
    public void testStaleElement(){

        try {
        driver.navigate().to("https://google.com");
        WebElement element1 = driver.findElement(By.xpath("//*[@class=\"gLFyf\"]"));
        driver.navigate().refresh();// after finding the element u are doing refresh
        WebElement element2 = driver.findElement(By.xpath("//*[@class=\"gLFyf\"]"));
        element2.sendKeys("The Testing Academy");
        // Stale element occurs when I do Refresh, Navigate other Page,
        // change in DOM elements (Ajax Calls) - VueJS, AngularJS

        // when an element is removed -> No such element exception will be thrown
        //  suppose there is an element in b1 - u found it using  driver
        // b1 removed after some time
        // If u do b1.click -> ? No such element exception will be thrown

        // if I try to find a frame or alert which does not exist it will give error as no such frame exist

        // we can handle all of the above exceptions by using try and catch
        // u can use throws also if u want to

        } catch (StaleElementReferenceException | NoSuchElementException e) {
            e.printStackTrace();
        } catch (Exception ex) {// this is daddy if u don't know what all exceptions u may get
            ex.printStackTrace();
        }




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
