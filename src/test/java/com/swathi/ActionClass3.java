package com.swathi;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ActionClass3 {

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
    public void testVerifyMakeMyTrip(){

        driver.navigate().to("https://www.makemytrip.com/");

        // <span data-cy="closeModal" class="commonModal__close"></span>
        // Wait and close the popup if it appears
        WebElement popUpClose = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-cy='closeModal']")));
        popUpClose.click();

        // <input data-cy="fromCity" id="fromCity" type="text" class="fsw_inputField lineHeight36 latoBlack font30" readonly="" value="Delhi">
        // Wait for the 'fromCity' input field and interact with it
//        WebElement fromCity = wait.until(ExpectedConditions.elementToBeClickable(By.id("fromCity")));
        WebElement fromCity = driver.findElement(By.id("fromCity"));
        Actions actions = new Actions(driver);
        actions.moveToElement(fromCity).click().build().perform();
        actions.moveToElement(fromCity).click().sendKeys("New Delhi").build().perform();

        // when u enter DEL you will get a List of 0-15 index in order to get the list
        List <WebElement> list_auto_complete = driver.findElements(By.xpath("//ul[@class=\"react-autosuggest__suggestions-list\"]/li"));

        // to get the 1st option BLR
        for (WebElement e: list_auto_complete){ // for WebElement e In the list of elements
           if(e.getText().contains("New Delhi")){// if u find e.getText contains New Delhi
               e.click();// then click on it
               break;

           }

        }

        //<input data-cy="toCity" id="toCity" type="text" class="fsw_inputField lineHeight36 latoBlack font30" readonly="" value="Bengaluru">
        // Wait for the 'toCity' input field and interact with it
        WebElement destination = driver.findElement(By.id("toCity"));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(destination).click().build().perform();
        actions1.moveToElement(destination).sendKeys("Goa").build().perform();





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
