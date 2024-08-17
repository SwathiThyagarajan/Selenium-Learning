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

public class Lab327_DynamicTables {

//    Dynamic web Tables
    // These tables have data that changes over time, and hence the number of rows and columns
    // might also change depending upon the data shifts. Due to the dynamic nature of their content,
    // they are called Dynamic web tables

    // here we use a tag system

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
    @Description("TestCase Description")
    public void testDynamicTable(){

        String URL = "https://awesomeqa.com/webtable1.html";
        driver.navigate().to(URL);

        // we can use this xpath to go from 1 element to another //table[@border="1"]/tbody/tr/td
        // Alternatively we can also use //table[@summary="Sample Table"]/tbody/tr/td
        // since summary="Sample Table" is a custom locator we can use this

        // This will give u the table, 1st find the table
        WebElement dynamicTable = driver.findElement(By.xpath("//table[@summary=\"Sample Table\"]/tbody"));
        // we have list of web elements ie; rows of a table, from the table we can find rows
        List<WebElement> rows_table = dynamicTable.findElements(By.tagName("tr"));
        System.out.println(rows_table.size());// finding the size
        // printing the table data using for loop
        for (int i = 2; i < rows_table.size(); i++) {
            // from the rows I want to get columns
            List<WebElement> columns_table = rows_table.get(i).findElements(By.tagName("td"));
            for (WebElement c:columns_table){
                System.out.println(c.getText());

            }

            // By using a tag name also we can navigate rather than creating dynamic xpath

            // Another Example
            // orangeHRM -> this is also a web table it contains 8 columns and column 8 contains 2 children
            // you can use dynamic xpath with i, j, k

            // suppose I want to find the 1st terminated employee
            // I can use this xpath to find the rows -> //div[@class='oxd-table-body']/div[@class='oxd-table-row']

            // to find the cell
            // I can use this xpath -> //div[@class='oxd-table-body']/div[@class='oxd-table-row']/

            // you can find this question related to web table in sedt.club docs Automation - web tables


        }





    }




    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
