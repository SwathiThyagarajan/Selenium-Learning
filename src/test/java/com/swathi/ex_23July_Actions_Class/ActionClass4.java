package com.swathi.ex_23July_Actions_Class;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ActionClass4 {

    // Atomic Test Cases
    // TC who don't have any dep.
    // They serve single purpose 0


    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void openBrowser() {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(edgeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }


    @Test(groups = "QA")
    @Description(" Testcase Description ")
    public void testVerifyHoverHoverClick(){
        driver.navigate().to("https://app.vwo.com/#/test/ab/13/heatmaps/1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNzBiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&isHttpsOnly=1");
        // Get the handle of the current window
        String mainWindowHandle = driver.getWindowHandle();
        System.out.println("Before Click -> " + mainWindowHandle);

        // Perform some actions that might open a new window or tab
        // when normal click does not work we need to use actions.moveToElement.click
        List<WebElement> list_heatmaps = driver.findElements(By.cssSelector("[data-qa=\"yedexafobi\"]"));
 //                   I can use xpath as well
 //        List<WebElement> list_heatmaps = driver.findElements(By.xpath("//*[@data-qa='yedexafobi']"));


//         list_heatmaps.get(1).click();// normal click
        Actions actions = new Actions(driver);
        actions.moveToElement(list_heatmaps.get(1)).click().build().perform();

        // In the newly opened window if I want to verify the title
        // in Inspect element if I go to console and type -> document.title ->  u will get the title
        // If you need to ensure that the element is an-> a, div, span, or any specific tag,
        // you can further refine the XPath:
        // for anchor tag--> //a[@data-qa="yedexafobi"]
        // For a div tag: //div[@data-qa="yedexafobi"]
        // For a span tag: //span[@data-qa="yedexafobi"]

        // This refined XPath can be useful if the data-qa attribute is used across
        // different element types, and you want to target a specific type.


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
