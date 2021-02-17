package com.udemy.seleniumdesign.command;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DismissalAlertValidator extends ElementValidator {

    private final WebElement dismissalAlert;

    public DismissalAlertValidator(WebElement element) {
        this.dismissalAlert = element;
    }

    @Override
    public boolean validate() {
        boolean result = this.dismissalAlert.isDisplayed(); //true
        this.dismissalAlert.findElement(By.cssSelector("button.close")).click();
        boolean resultAfterClick = this.dismissalAlert.isDisplayed(); //false
        System.out.println("Result" + (result && (!resultAfterClick)));
        return result && (!resultAfterClick);
    }
}
