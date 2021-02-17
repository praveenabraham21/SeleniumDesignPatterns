package com.udemy.seleniumdesign.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

class GoogleTamil extends GoogleEnglish {

    @FindBy(linkText = "தமிழ்")
    private WebElement language;

    public GoogleTamil(WebDriver driver) {
        super(driver);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.google.com/");
        this.language.click();
    }

}
