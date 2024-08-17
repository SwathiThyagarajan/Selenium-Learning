package com.swathi.ex_23July;

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

public class Lab328_SVG {
//
//    What is SVG - Scalable Vector Graphics to define graphics for web.
//    XML based language to create 2-D graphics/images with animation and interactivity.
//    Uses geometrical figures to draw an image.
//    <svg> tag is used as a container for SVG graphics.


    // SVG examples
    // If u go to Flipkart the search icon shown in search bar is an SVG

    // SVG uses less storage while compared to PNG and JPEG
    // In PNG if u zoom the image the clarity will decrease in SVG clarity will not decrease
    // SVG works with a tag which is SVG and path, circle, polygon
    // Generally we will find that SVG is containing path with -> g -> to create the shapes

    // By using SVG people have created Map of India

    // Problem -- 1 --> I want to search macmini and click on search icon and see the results
    // Go to Flipkart type macmini -> Inspect element
    // to type macmini in selenium I must know the locator check whether there is any unique locator for
    // macmini, we have class, name and placeholder
    // now click on search icon -> in inspect element u can find button inside it there is a svg inside it
    // there is a path, the path is unique
    // By using below we can find SVG
    // 1.  //*[local-name()='svg'] here * means find all the path
    // 2. //*[name()='svg']  ,like we have  contains(), text(), we have name() function

    // so the above svg will give us list of web elements

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
    @Description(" Testcase Description ")
    public void testVerifySVG(){

        driver.navigate().to("https://www.flipkart.com/");
        driver.getTitle();
        System.out.println(driver.getTitle());

        driver.findElement(By.name("q")).sendKeys("macmini");
        List<WebElement> SVGelements = driver.findElements(By.xpath("//*[local-name()='svg']"));
        SVGelements.get(0).click();





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
