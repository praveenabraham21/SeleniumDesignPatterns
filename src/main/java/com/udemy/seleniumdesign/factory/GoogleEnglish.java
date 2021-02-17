package com.udemy.seleniumdesign.factory;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

class GoogleEnglish extends GooglePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    @FindBy(name = "q")
    private WebElement searchBox;
    @FindBy(name = "btnK")
    private WebElement searchBtn;
    @FindBy(css = "div.rc")
    private List<WebElement> results;

    public GoogleEnglish(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.google.com/");
    }

    @Override
    public void search(String searchKeyword) {
        for (char c : searchKeyword.toCharArray()) {
            Uninterruptibles.sleepUninterruptibly(5, TimeUnit.MILLISECONDS);
            this.searchBox.sendKeys(c + "");
        }
        this.wait.until((d) -> this.searchBtn.isDisplayed());
        this.searchBtn.click();

    }

    @Override
    public int getResultsCount() {
        this.wait.until((d) -> this.results.size() > 1);
        return this.results.size();
    }
}
