package com.swathi.ex_20July;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lab326_WebTables {

/*
    A web table is a way of representing data in rows and columns
"<table>" - It defines a table. You can also say that it's the starting point of a table.
<thead>
<tbody>
"<th>" - It defines a header cell, which means you should define your headings inside th tag.
"<tr>" - It defines a row in a table.
"<td>" - It defines a cell in a table. "td" always lie inside the tr tag.

//table[@id="customers"]
//table[contains(@id,"cust")]

Static Table - Data will not change.
Dynamic Table - No of Col may change.

*/
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
    public void test(){

        String URL = "https://awesomeqa.com/webtable.html";
        driver.navigate().to(URL);
        System.out.println(driver.getTitle());

        // I want to print all the data into the table
        // and if name = Halen, I want to check which country she belongs to.

        // we will create dynamic xpath to solve this

        // 1. find the name Helen and Inspect element
        // <td style="border: 1px solid rgb(221, 221, 221); box-sizing: inherit; padding: 8px;">Helen Bennett</td>
        // Helen is present in a td of tr and table, we have a table with id

        // 2. How to find a table directly
        // by using this xpath I can find customers  //table[@id="customers"]
        // if I add /tbody I will be in tbody -> //table[@id="customers"]/tbody
        // to get rows I can do /tr-->  //table[@id="customers"]/tbody/tr
        // we can fix a row and in that row we can find
        // column/td --> //table[@id="customers"]/tbody/tr[2]/td

        // Therefore I can use following xpath to get :
        // Rows/tr --> //table[@id="customers"]/tbody/tr
        // Columns/td --> //table[@id="customers"]/tbody/tr[2]/td


//   this will find all the rows and columns and give the size
        int row = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr")).size();
        int columns = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr[2]/td")).size();

//   fixing a column / cell--> //table[@id="customers"]/tbody/tr[2]/td[3]
        // here tr[2] is like i  -> row -> 1 to 7
        // and td[3] is like j  -> column -> 1 to 3

        // If I want to reach any element within the web table I just have the change the value of i and j
        // ex: If I want to reach Helen then row i = 5 and cell j = 2
        // to find the country she belongs to i = 5 , j = 3
        // xpath -> //table[@id="customers"]/tbody/tr[5]/td[3]

        // using above xpath I can also find the following sibling
        // xpath --> //table[@id="customers"]/tbody/tr[5]/td[2]/following-sibling::td

        // I can also find Preceding sibling
        // xpath --> //table[@id="customers"]/tbody/tr[5]/td[2]/preceding-sibling::td

        // Now we can divide the xpath -> //table[@id="customers"]/tbody/tr[5]/td[3]

        // 1st part -> //table[@id="customers"]/tbody/tr[
        // 2nd part -> i]/td[
        // 3rd part -> j]

        String firstPart = "//table[@id=\"customers\"]/tbody/tr[";
        String secondPart = "]/td[";
        String thirdPart = "]";

        // Now I will use a for loop starting i from 2 to row and j from 1 to column
        // we are skipping the 1st row because it is heading

        for (int i = 2; i <=row ; i++) {
            for (int j = 1; j <=columns ; j++) {
                String dynamic_xpath = firstPart+i+secondPart+j+thirdPart;
                String data = driver.findElement(By.xpath(dynamic_xpath)).getText();
                System.out.println(data);
//                find the name Helen and check which country she belongs to.
                if(data.contains("Helen Bennett")){
                    // finding the country by using following
                    String country_path = dynamic_xpath+"/following-sibling::td";
                    String company_path = dynamic_xpath+"/preceding-sibling::td";
                    String country_Name = driver.findElement(By.xpath(country_path)).getText();
                    String company_Name = driver.findElement(By.xpath(company_path)).getText();
                    System.out.println("-----");
                    System.out.println("Helen Bennett is In - " + country_Name);
                    System.out.println("Helen Bennett works In the company - " + company_Name);
                }


                // In tables, we don't have Indexes we don't have cell 0. cell always starts from 123



            }

        }









    }

    @AfterTest
    public void closeBrowser(){

        driver.quit();
    }



}
