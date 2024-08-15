package com.swathi.ex_18July;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Lab317_CSS_Selectors {

    // Topics
//    1. CSS Selectors
//    2. Selenium Waits
//    3. Handle Select, alert and checkboxes.

public void testVerifyTrial(){

    EdgeOptions edgeOptions = new EdgeOptions();
    edgeOptions.addArguments("--start-maximized");
    edgeOptions.addArguments("--guest");

    WebDriver driver = new EdgeDriver(edgeOptions);
    driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
    System.out.println(driver.getTitle());


    // Xpath -> it is a Query language to find the element in the HTML document.
    // Types of xpath
    // 1. Relative - 99% used
    // 2. Absolute - Not body uses  ignore - 1%

    // Core Logic  ->  //tagName[@attribute=value]
    // Xpath - Functions -> text(), contains, start-with, end-with(), sub-string, normlize-space - trim the text
    // Xpath Axes -> Ancestors, following-sibling, parent, child, descendants, preceding-siblings


    // CSS Selector also supports ->  All of the above
    // css selector is similar to xpath

    // Logic -  tagName[attribute=value] ->  //tagName[@attribute=value]

        // CSS selectors are used to select elements in an HTML or XML document
    // in order to apply styles or other manipulations to those elements.

    // If you want to search an element using ID,
    // everywhere you will find there is a CSS selector associated with it

    // Normal selector that is used and corresponding css selector for it
    //  Normal Selector  -> Css Selector
    // 1. By.id -> #id
    // 2. className -> .class
    // 3. custom Attribute - <input type="text" data-qa="abc"/> ----> [data-qa="abc"]
    // you can convert xpath to -> css Selector also.

    // Css Selectors -> also has functions
    // contains Xpath contains() -> *
    // starts-with() - xpath -> ^
    // end-with() xpath -> $










}

}
