package com.udemy.seleniumdesign.srp.result;

import com.udemy.seleniumdesign.srp.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultStat extends AbstractComponent {

    @FindBy(id = "result-stats")
    private WebElement resultStat;

    public ResultStat(WebDriver driver) {
        super(driver);
    }

    public String getStat() {
        return this.resultStat.getText();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((D) -> this.resultStat.isDisplayed());
    }
}
