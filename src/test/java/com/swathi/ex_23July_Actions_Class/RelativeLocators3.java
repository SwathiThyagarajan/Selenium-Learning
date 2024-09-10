package com.swathi.ex_23July_Actions_Class;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
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

public class RelativeLocators3 {


    EdgeDriver driver;


    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }


    @Test(groups = "QA")
    @Description("Test Case Description")
    public void testPositive() throws InterruptedException {
        driver.get("https://www.aqi.in/real-time-most-polluted-city-ranking");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

//        To filter and print only the polluted cities in India from the list,
//        you need to modify your loop to check if the city name belongs to India
//        before printing the data.

        // Go to search bar, type 'India', and hit enter
        WebElement searchBar = driver.findElement(By.xpath("//input[@id='search_city']"));
        searchBar.sendKeys("India" + Keys.ENTER);

        // Wait until the list of cities is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='example']/tbody/tr/td[2]")));

        List<WebElement> list_of_cities = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[2]"));

        // Iterate through the list of cities
        for (WebElement city : list_of_cities) {
            String cityName = city.getText();

            // Check if the city is in India
            if (cityName.contains("India")) {
                String aqi = driver.findElement(with(By.tagName("p")).toRightOf(city)).getText();
                String rank = driver.findElement(with(By.tagName("p")).toLeftOf(city)).getText();

                // Print the city name, AQI, and rank
                System.out.println(cityName + " | AQI: " + aqi + " | Rank: " + rank);


            }
        }






    }


    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
