package com.udemy.seleniumdesign.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserInfo {
    @FindBy(id = "fn")
    private WebElement firstName;

    @FindBy(id = "ln")
    private WebElement lastName;

    @FindBy(id = "email")
    private WebElement email;

    public UserInfo(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterPersonaInfo(String fName, String lName, String email) {
        this.firstName.sendKeys(fName);
        this.lastName.sendKeys(lName);
        this.email.sendKeys(email);
    }
}
