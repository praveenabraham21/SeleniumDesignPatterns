package com.udemy.seleniumdesign.template.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonResultsPage {

    private WebDriverWait wait;
    private WebDriver driver;

    @FindBy(css = "a[class=\"a-link-normal a-text-normal\"]")
    private WebElement item;

    public AmazonResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void selectProduct() {
        this.wait.until((d) -> this.item.isDisplayed());
        this.item.click();
    }
}
