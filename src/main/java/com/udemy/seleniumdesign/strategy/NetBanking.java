package com.udemy.seleniumdesign.strategy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class NetBanking implements PaymentOption {

    @FindBy(id = "bank")
    private WebElement bank;

    @FindBy(id = "acc_number")
    private WebElement account;

    @FindBy(id = "pin")
    private WebElement pin;

    @Override
    public void enterPaymentInfo(Map<String, String> paymentDetails) {
        Select bankDrpDwn = new Select(bank);
        bankDrpDwn.selectByValue(paymentDetails.get("bank"));
        this.account.sendKeys(paymentDetails.get("account"));
        this.account.sendKeys(paymentDetails.get("pin"));
    }
}
