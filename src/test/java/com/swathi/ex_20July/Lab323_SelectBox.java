package com.swathi.ex_20July;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lab323_SelectBox {

    // SelectBox nothing but dropdown list

    //    https://the-internet.herokuapp.com/dropdown
    // In the above link u can find a drop box if u right click inspect element u can see the elements
    // select with 2 options. if u find this html select element then it is very easy
    // because selenium has an inbuilt support to handle this
    // selenium  has a class known as select

    //  SelectBox is useful only when  HTML Select TAG IS USED.
    //     If  Select Tag is not used then - Another mechanism

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
    public void testVerifySelectBox(){

        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");
        System.out.println(driver.getTitle());

        // you can create an instance of select class, you need to give how to find the select box
        // that is the locator--> <select id="dropdown">
        //    <option value="" disabled="disabled" selected="selected">Please select an option</option>
        //    <option value="1">Option 1</option>
        //    <option value="2">Option 2</option>
        //  </select>
    // since there is id present we can use it

        WebElement element_select = driver.findElement(By.id("dropdown"));
        Select select = new Select(element_select);
 //       select.selectByIndex(1);
        select.selectByVisibleText("Option 2"); // we can do like this also

        //  SelectBox is useful only when  HTML Select TAG IS USED.
        //     If  Select Tag is not used then - Another mechanism



        // In real time many things may look like select box. But they are not.
        // if u right click Inspect element u can find that they are custom element
        // u cannot handle this using select class. You need to use JavaScript executor and other things




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
