package com.udemy.seleniumdesign.decorator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

    private WebDriver driver;

    @FindBy(css = "input#coupon")
    private WebElement couponTxtBox;

    @FindBy(css = "input#couponbtn")
    private WebElement applyCouponBtn;

    @FindBy(css = "input#cc")
    private WebElement creditCardTxtBox;

    @FindBy(css = "input#year")
    private WebElement ccExpiryYearBox;

    @FindBy(css = "input#cvv")
    private WebElement ccCVVBox;

    @FindBy(css = "input#buy")
    private WebElement buyBtn;

    @FindBy(css = "td#status")
    private WebElement orderStatus;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void applyCoupon(String promoCode) {
        this.couponTxtBox.sendKeys(promoCode);
        this.applyCouponBtn.click();
    }

    public void enterCreditCard(String cc, String year, String cvv) {
        this.creditCardTxtBox.sendKeys(cc);
        this.ccExpiryYearBox.sendKeys(year);
        this.ccCVVBox.sendKeys(cvv);
    }

    public void submitOrder() {
        this.buyBtn.click();
    }

    public String getOrderStatus() {
        return this.orderStatus.getText();
    }

    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-payment-screen.html");
    }

}
