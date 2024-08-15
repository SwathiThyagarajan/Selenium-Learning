package com.swathi.ex_18July;

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

public class Lab318 {

    //  REAL TIME Project
    // Navigate to the - https://www.ebay.com/b/Desktops-All-In-One-Computers/171957/bn_1643067
    // Find MacMini, click search
    // print all the titles.

    // here in this Lab318 we can add before and after test which acts as a boilerplate.
    // In Before test ie; before running the test
    // we can add Initiating the edgeoptions and setting the page format and setting the driver
    // In After Test we can include Thread.sleep and driver.quit();


    WebDriver driver;

    @BeforeTest
            public void testOpenBrowser() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(edgeOptions);

    }

    @Test(groups = "QA")
    @Description("Testcase Description")
    public void testFindMacMini(){

        // 1. Navigate to the - https://www.ebay.com/b/Desktops-All-In-One-Computers/171957/bn_1643067
        driver.navigate().to("https://www.ebay.com/b/Desktops-All-In-One-Computers/171957/bn_1643067");
        System.out.println(driver.getTitle());

        // 2.  search Element. let's use css selector for this
        // Go to the above URL-> right click select Inspect -> Element->
        // In Top bar click on left side 1st symbol of select element -> Now in the URL website click on
        // search bar-> In elements tab all the elements related to it will be highlighted
        // the below is the element
        //<input type="text" class="gh-tb ui-autocomplete-input" aria-autocomplete="list"
        // aria-expanded="false" size="50" maxlength="300" aria-label="Search for anything"
        // placeholder="Search for anything" id="gh-ac" name="_nkw" autocapitalize="off"
        // autocorrect="off" spellcheck="false" autocomplete="off" aria-haspopup="true"
        // role="combobox" aria-owns="ui-id-1">

        // So how to use CSS selector is press ctrl+f and type the below
        //  type the tag name  -> input[id="gh-ac"]
        // OR you can type this also ->  #gh-ac

        // you can convert the css selector to xpath also
        // css selector -> input[id="gh-ac"] -> xpath -> //input[@id="gh-ac"]

        // 3. Find MacMini

        WebElement searchBox = driver.findElement(By.cssSelector("input[id=\"gh-ac\"]"));
        searchBox.sendKeys("macmini");

        // 4. click search
        // <input type="submit" class="btn btn-prim gh-spr" id="gh-btn" value="Search" form="gh-f">

        WebElement clickSearchButton = driver.findElement(By.cssSelector("input[id=\"gh-btn\"]"));
        clickSearchButton.click();

        // above we used id, instead we can use class name or value
        // to use class name 1st we need to check whether it is unique
        // do ctrl+f and type .gh-spr   (since we are checking class name we are using .dot in front of gh
        // check if it's unique
        // I can use this also -> input[value="Search"]

//        WebElement clickSearchButton = driver.findElement(By.cssSelector(".gh-spr"));
//        WebElement clickSearchButton = driver.findElement(By.cssSelector("input[value=\"Search\"]"));

        // 5.  Search and print all the titles.
        // <span role="heading" aria-level="3"><!--F#f_0
        // -->Apple Mac Mini 2018 8GB 16GB 32GB 64GB All Storage Intel i3 i5 i7 - Excellent<!--F/--></span>

        // the title is a span containing heading
        // it comes under the div
        // <div class="s-item__title"><span role="heading" aria-level="3"><!--F#f_0-->Apple Mac Mini 2018 8GB 16GB 32GB 64GB All Storage Intel i3 i5 i7 - Excellent<!--F/--></span></div>
        // class is -> .s-item__title . let's check if it is unique
        // we are getting all 62 results
        // since we want to print all the titles we will use this

        // Let's use Thread.sleep because after clickSearchButton results has to load it may take sometime


        try {
            Thread.sleep(3000); // we can replace this in future
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Search all the titles
        // since we have 62 results we will use List and driver.findElements
        List<WebElement> searchAllTitles = driver.findElements(By.cssSelector(".s-item__title"));
        // we can get the price also
        List<WebElement> searchAllPrices = driver.findElements(By.cssSelector(".s-item__price"));
        
//        // using for loop to printAllTitles
//        for (WebElement title : searchAllTitles){// enter from where I want.
//            // enter wht I want
//            System.out.println(title.getText());
//        }
//
//        // using for loop to printAllPrices
//        for (WebElement prices : searchAllPrices){
//            System.out.println(prices.getText());
//        }

        // here we have printed Titles and Prices one below another. Suppose u want to print them side by side
        // searchAllTitles can be 62, searchAllPrices can be 63.  
        // so it is better to  know how many elements are there and then print

        // we are using min to Ensure both lists are of the same size to avoid IndexOutOfBoundsException
        // this makes the difference between a good coder and bad coder by using min
        int size = Math.min(searchAllTitles.size(),searchAllPrices.size());
        for (int i = 0; i < size; i++) {
//            System.out.println("Title : " + searchAllTitles.get(i).getText());
//            System.out.println("Prices : " + searchAllPrices.get(i).getText());
            // u can print both title and price in same line also
            System.out.println("Title : " + searchAllTitles.get(i).getText() + " || " + "Prices : " + searchAllPrices.get(i).getText());
            System.out.println(); // adding a line after each loop to easily understand
        }

        // CSS functions
       // Where they are useful? - dynamic text or elements
       // They are useful when in the attribute value - some are constant and some are dynamic(heep changing)
        // contains() -> *
        // starts-with()  -> ^
        // end-with()  -> $

        // u can go to flipkart for this click on Flipkart icon and see
        // <img src="https://static-assets-web.flixcart.com/batman-returns/batman-returns/p/images/fkheaderlogo_exploreplus-44005d.svg"
        // width="160" height="40" title="Flipkart">

        // img[title*="Flip"] - contains
        // img[title^="Flip"] - starts-with
        // img[title$="Flip"] - end-with

        // go to this website -> https://awesomeqa.com/css/ here u can find the list of elements
        // if I do ctrl+f in elements tab and type div it will give a list of all the elements
        // div.first > span -> using this u can navigate between the divisions
        // we can use nth child function also we can mention to which element we want to go
        // div.first > span:nth-child(1)
        // div.first > span:nth-child(2n+1) -> used to find the elements with even numbers
        // > this symbol indicates find
        // ex: div > span -> it  means in the div find the span


        // we have 2 types of select boxes ie; dropdown
        // Select -> simple, custom Select(div, ui-li) -( different approach)


//        Why Do We Need Waits In Selenium?
//                - Web applications are developed using Ajax and Javascript.
//                - New JS frameworks are more advanced and use AJax, react, and angular.
//                elements which we want to interact with may load at different time intervals.

        // we are telling do this
        // Thread.sleep(3) - when we use Thread.sleep
        // we are telling JVM to stop the execution - Worst type wait. - Halt JVM
        // do that - for 3 secs

        // Types of wait-> 1.  Implicit Wait 2. Explicit Wait

        // Implicit Wait - Bad
     //   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Gives No Such Element Exception.




    }

    @AfterTest
    public void quitBrowser(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();

    }
}
