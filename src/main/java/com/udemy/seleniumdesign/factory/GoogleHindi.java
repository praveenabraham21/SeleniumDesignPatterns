package com.udemy.seleniumdesign.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

class GoogleHindi extends GoogleEnglish {


    @FindBy(linkText = "हिन्दी")
    private WebElement language;

    public GoogleHindi(WebDriver driver) {
        super(driver);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.google.com/");
        this.language.click();
    }

}
