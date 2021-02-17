package com.udemy.seleniumdesign.strategy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class PayPal implements PaymentOption {

    @FindBy(id = "paypal_username")
    private WebElement username;

    @FindBy(id = "paypal_password")
    private WebElement password;


    @Override
    public void enterPaymentInfo(Map<String, String> paymentDetails) {
        this.username.sendKeys(paymentDetails.get("username"));
        this.password.sendKeys(paymentDetails.get("password"));
    }
}
