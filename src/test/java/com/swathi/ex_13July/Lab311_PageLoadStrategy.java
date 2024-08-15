package com.swathi.ex_13July;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Lab311_PageLoadStrategy {
    public static void main(String[] args) {

        // by defult if u dont mention the Page Load Strategy type it will use normal

        WebDriver driver = new EdgeDriver();

        driver.get("https://app.vwo.com/#/login");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        driver.quit();


    }
}
