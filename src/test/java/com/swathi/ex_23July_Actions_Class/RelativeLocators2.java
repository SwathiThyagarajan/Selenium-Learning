package com.swathi.ex_23July_Actions_Class;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocators2 {

    // this is a website with list of 100 most polluted cities in the world
    // I can print the most polluted city and the AQI which is right to the city and the ranking to the left

    WebDriver driver;

    @BeforeTest
    public void openBrowser(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--guest");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);

    }

    @Test(groups = "QA")
    @Description("Testcase Description")
    public void testRelativeLocators(){
        driver.navigate().to("https://www.aqi.in/real-time-most-polluted-city-ranking");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // go to search bar type India and hit enter
        WebElement searchBar = driver.findElement(By.xpath("//input[@id='search_city']"));
        searchBar.sendKeys("India" + Keys.ENTER);

        // when u run the above code the list of companies it gives is a webtable
        // xpath for list of elements-> //table[@id='example']/tbody/tr/td[2]

        // after finding the table I need to find where is my data.
        // data is not available in head it is available in tbody
        // in tbody we have tr in the tr td1 does not have the data td2 has the data

        // so xpath is //table[@id='example'] this will find the table
        // followed by tbody followed by td 2nd no. it means 2nd td column
        // xpath for list of elements-> //table[@id='example']/tbody/tr/td[2]

        // Wait until the list of states is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='example']/tbody/tr/td[2]")));

        List<WebElement> list_of_states = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[2]"));
//  Now from the above list whatever element the list_of_states is, from it,
//  I want left and right elements to get the rank and AQI

        // we will use for each loop to iterate over them
        for (WebElement state : list_of_states){
            // the AQI is a ptag element it is available to the right of state
            String s1 = driver.findElement(with(By.tagName("p")).toRightOf(state)).getText();
            String s2 = driver.findElement(with(By.tagName("p")).toLeftOf(state)).getText();
            String s3 = driver.findElement(with(By.tagName("p")).above(state)).getText();
            String s4 = driver.findElement(with(By.tagName("p")).below(state)).getText();
            System.out.println(state.getText() + " | " + s1 + " | " + s2);
            System.out.println(state.getText() + " | " + s3 + " | " + s4);
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
