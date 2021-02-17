package com.udemy.seleniumdesign.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuyNow {
    @FindBy(id = "buy")
    private WebElement buyNow;

    @FindBy(id = "ordernumber")
    private WebElement orderNumber;

    public void BuyNow(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String placeOrder() {
        this.buyNow.click();
        return orderNumber.getText();
    }
}
