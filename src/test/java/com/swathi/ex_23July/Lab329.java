package com.swathi.ex_23July;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
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

public class Lab329 {

    // Question find Tripura and click on it
    // steps
    //1. go to the website click on Tripura in map then do Inspect element
    //2. 1st we need to find from where the svg starts
    // 3. In the svg we have totally 7 g. the 1st g inside it, we have the path
    // 4. Inside the 7th g we have the data here we have path for each and every state
    // 5. aria-label="Nagaland" like this aria title is given for all states
    // 6. so the xpath would be to go one by one
    // 7. xpath -> //*[name()='svg']-> this will give us the svg
    // 8. In the svg we have g element -> //*[name()='svg']/*[name()='g'] this will give 19 g
    //9. we are interested in 7th g -> //*[name()='svg']/*[name()='g'][7]
    //10. In 7th g we have 2 more g -> //*[name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']
    //11.Now we need to find path of all states -> //*[name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path']
    //12.

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
    public void testVerifySVGmapIndia(){

        driver.navigate().to("https://www.amcharts.com/svg-maps/?map=india");

        List<WebElement> states = driver.findElements(By.xpath("//*[name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path']"));
        for (WebElement state : states) {// from states I want state
            System.out.println(state.getAttribute("aria-label"));
            // I can use Aria-label attribute which gives name of all the state
            if (state.getAttribute("aria-label").contains("Tripura")){
                state.click();
                // if my state.getAttribute of aria-label contains Tripura then click on it


            }
        }

    }

    @AfterTest
    public void closeBrowser(){

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }


}
