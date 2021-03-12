package com.udemy.seleniumdesign.executeAround;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.function.Consumer;

public class MainPage {

    private final WebDriver driver;

    @FindBy(id = "a")
    private WebElement frameA;

    @FindBy(id = "b")
    private WebElement frameB;

    @FindBy(id = "c")
    private WebElement frameC;

    private FrameA aFrame;
    private FrameB bFrame;
    private FrameC cFrame;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.aFrame = PageFactory.initElements(driver, FrameA.class);
        this.bFrame = PageFactory.initElements(driver, FrameB.class);
        this.cFrame = PageFactory.initElements(driver, FrameC.class);

    }

    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/main.html");
    }

    public void onFrameA(Consumer<FrameA> frameA) {
        this.driver.switchTo().frame(this.frameA);
        frameA.accept(this.aFrame);
        this.driver.switchTo().defaultContent();
    }

    public void onFrameB(Consumer<FrameB> frameB) {
        this.driver.switchTo().frame(this.frameB);
        frameB.accept(this.bFrame);
        this.driver.switchTo().defaultContent();
    }

    public void onFrameC(Consumer<FrameC> frameC) {
        this.driver.switchTo().frame(this.frameC);
        frameC.accept(this.cFrame);
        this.driver.switchTo().defaultContent();
    }
}
