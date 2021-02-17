package com.udemy.seleniumdesign.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class PaymentScreen {
    private WebDriver driver;
    private UserInfo userInfo;
    private BuyNow buyNow;
    private PaymentOption paymentOption;


    public PaymentScreen(WebDriver driver) {
        this.driver = driver;
        this.userInfo = PageFactory.initElements(driver, UserInfo.class);
        this.buyNow = PageFactory.initElements(driver, BuyNow.class);
    }

    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/strategy.html");
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public BuyNow getBuyNow() {
        return buyNow;
    }


    public void setPaymentOption(PaymentOption paymentOption) {
        this.paymentOption = paymentOption;
        PageFactory.initElements(driver, this.paymentOption);
    }

    public void pay(Map<String, String> paymentDetails) {
        this.paymentOption.enterPaymentInfo(paymentDetails);
    }
}
