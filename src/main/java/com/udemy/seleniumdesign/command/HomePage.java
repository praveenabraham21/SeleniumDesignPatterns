package com.udemy.seleniumdesign.command;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class HomePage {
    private final WebDriver driver;

    //Buttons

    @FindBy(css = "div.button-box>button.btn-info")
    private WebElement infoButton;

    @FindBy(css = "div.button-box>button.btn-warning")
    private WebElement warnButton;

    @FindBy(css = "div.button-box>button.btn-success")
    private WebElement successButton;

    @FindBy(css = "div.button-box>button.btn-danger")
    private WebElement dangerButton;

    //Notifications

    @FindBy(css = "div.jq-has-icon.jq-icon-info")
    private WebElement infoAlert;

    @FindBy(css = "div.jq-has-icon.jq-icon-warning")
    private WebElement warnAlert;

    @FindBy(css = "div.jq-has-icon.jq-icon-success")
    private WebElement successAlert;

    @FindBy(css = "div.jq-has-icon.jq-icon-error")
    private WebElement dangerAlert;

    //Dismiss info alert

    @FindBy(css = "div.card-body div.row div:nth-child(2) div.alert-info")
    private WebElement dismissInfoAlert;

    @FindBy(css = "div.card-body div.row div:nth-child(2) div.alert-success")
    private WebElement dismissSuccessAlert;

    @FindBy(css = "div.card-body div.row div:nth-child(2) div.alert-danger")
    private WebElement dismissDangerAlert;

    @FindBy(css = "div.card-body div.row div:nth-child(2) div.alert-warning")
    private WebElement dismissWarnAlert;

    public HomePage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        this.driver.get("https://wrappixel.com/demos/admin-templates/admin-pro/main/ui-notification.html");
    }

    public List<ElementValidator> getElementValidators() {
        return Arrays.asList(
                //notification
                new NotificationValidator(this.infoButton, this.infoAlert),
                new NotificationValidator(this.warnButton, this.warnAlert),
                new NotificationValidator(this.successButton, this.successAlert),
                new NotificationValidator(this.dangerButton, this.dangerAlert)

                //dismiss
//                new DismissalAlertValidator(this.dismissInfoAlert),
//                new DismissalAlertValidator(this.dismissSuccessAlert),
//                new DismissalAlertValidator(this.dismissWarnAlert),
//                new DismissalAlertValidator(this.dismissDangerAlert)
        );
    }
}