package com.udemy.seleniumdesign.test.executeAround;

import com.udemy.seleniumdesign.executeAround.MainPage;
import com.udemy.seleniumdesign.test.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {

    private MainPage mainPage;

    @BeforeTest
    public void setMainPage() {
        this.mainPage = new MainPage(driver);
    }

    @Test
    public void frameTest() {
        this.mainPage.goTo();
        this.mainPage.onFrameA(a -> {
                    a.setFirstName("fn1");
                    a.setLastName("ln1");
                    a.setAddress("add1");
                    a.setTextBox("msg1");
                }
        );
        this.mainPage.onFrameB(b -> {
            b.setFirstName("fn2");
            b.setLastName("ln2");
            b.setAddress("add2");
            b.setTextBox("msg2");
        });
        this.mainPage.onFrameC(c -> {
            c.setFirstName("fn3");
            c.setLastName("ln3");
            c.setAddress("add3");
            c.setTextBox("msg3");
        });

    }
}
