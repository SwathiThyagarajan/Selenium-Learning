package com.swathi.ex_23July_Actions_Class;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;


public class RelativeLocators1 {

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
    public void testRelativeLocators(){
    driver.navigate().to("https://awesomeqa.com/practice.html");

    // In the above url in Years of Experience if u want to select a particular year
    // Years of Experience this is a span element
    // the no. of years 1 2 3 4 5 6 7 they are input radio box
    // ex: currently the years of experience is 1. and I want to select the year right to 1
    // it will be 2 and index of it will be 1 and if I want to choose left to it. it is 1 with index 0

//    WebElement spanElement = driver.findElement(By.xpath("//span[.='Years of Experience']"));
//        OR
    WebElement spanElement = driver.findElement(By.xpath("//span[text()='Years of Experience']"));
    // using relative locators
    driver.findElement(with(By.id("exp-3")).toRightOf(spanElement)).click();


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
