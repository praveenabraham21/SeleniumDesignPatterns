package com.udemy.seleniumdesign.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

class GoogleMarati extends GoogleEnglish {


    @FindBy(linkText = "मराठी")
    private WebElement language;

    public GoogleMarati(WebDriver driver) {
        super(driver);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.google.com/es");
        this.language.click();
    }
}
