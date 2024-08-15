package com.swathi.ex_20July;

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

import java.util.List;

public class Lab325_CheckBoxes {


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
    public void testVerifyCheckBoxes(){

        // CheckBoxes is similar to input boxes
        //<form id="checkboxes">
        //    <input type="checkbox" checked=""> checkbox 1<br>
        //    <input type="checkbox"> checkbox 2
        //  </form>

        driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");
        System.out.println(driver.getTitle());

//        WebElement checkBox = driver.findElement(By.id("checkboxes"));
//        checkBox.click();

        // since there are 2 checkboxes I can find both the elements using xpath List

        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type=\"checkbox\"]"));
        checkBoxes.get(0).click();
        checkBoxes.get(1).click();








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
