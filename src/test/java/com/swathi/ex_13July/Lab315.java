package com.swathi.ex_13July;

import com.google.common.primitives.Bytes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Lab315 {

    // Testing start a free trial element in app.vwo.com


/*
      <input class="W(100%) Py(14px) input-text" placeholder="name@yourcompany.com" type="email" id="page-v1-step1-email" name="email" data-qa="page-su-step1-v1-email" required="">
     <button type="submit" disabled="" class="button button--disabled-primary W(100%) btn-modal-form-submit" data-qa="page-su-submit">Create a Free Trial Account</button>
<div class="D(f) Ai(c) ">
    <input class="Cur(p) Flxs(0) M(0)" type="checkbox" name="gdpr_consent_checkbox" id="page-264cu-gdpr-consent-checkbox" value="true" data-qa="page-gdpr-consent-checkbox" data-gtm-form-interact-field-id="0">
    <label for="page-264cu-gdpr-consent-checkbox" class="Ta(start) Cur(p) Fz($font-size-12) Mstart(10px) Us(n)">
        I agree to VWO's <a class="C($color-blue) white_C($color-white)" href="https://vwo.com/privacy-policy/" target="_blank">Privacy Policy</a> &amp; <a href="https://vwo.com/terms/" class="C($color-blue) white_C($color-white)" target="_blank">Terms</a>    </label>
</div>
<div class="C($color-red) Fz($font-size-12) Trsp($Op) Trsdu(0.15s) Op(0) invalid-input+Op(1) invalid-reason">An account with this email already exists. <a href="https://app.vwo.com" class="C($color-blue)" target="_blank">Login Here</a></div>
 */

    @Test
    public void testVerifyFREETrial(){

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");

//        WebElement freeTrialLink = driver.findElement(By.linkText("Start a free trial"));
        WebElement freeTrialLink = driver.findElement(By.partialLinkText("Start a free"));
        freeTrialLink.click();

        // since in Inspect - elements we cannot find email to be unique we are using id to test
        // email is required because emailInputBox is the element

        WebElement enterEmail = driver.findElement(By.id("page-v1-step1-email"));
        enterEmail.sendKeys("admin@admin.com");

        WebElement gdprConsentCheckbox = driver.findElement(By.name("gdpr_consent_checkbox"));
        gdprConsentCheckbox.click();


        // dynamic elements : if I use button class it will change device to device,
        // In computer it may be 1080 in ipad the resolution may change so, it is better to use other elements

        // Next step I want to click on Create a free Trial Button,
        // but I don't find id , name or linkText because this is not an anchor/ a tag.
        // so, in such cases I can use x path or css selector or data qa - custom selectors.
        // these will be learnt in next class

        // But if u want to somehow click on that button then you can use driver.findelements

        // this will give u a list of all the buttons available.
        // since it gives u a list use list in front of web elements

        List <WebElement> buttonList = driver.findElements(By.tagName("button"));
        buttonList.get(0).click(); // consider I want to click on 1st button

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // the above will work but u will not be able to create a free trial account
        // because u will get an error message as -> an account with this email already exists
        // we can verify the error message using partial class

//        WebElement error_msg_email_exist = driver.findElement(By.className("invalid-reason"));
//        System.out.println(error_msg_email_exist.getText());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();


    }

}
