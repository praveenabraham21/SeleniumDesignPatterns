package com.udemy.seleniumdesign.test.factory;

import com.udemy.seleniumdesign.factory.GoogleFactory;
import com.udemy.seleniumdesign.factory.GooglePage;
import com.udemy.seleniumdesign.test.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseTest {

    private GooglePage googlePage;

    @Test(dataProvider = "getData")
    public void searchTest(String language, String searchKeyWord) {
        this.googlePage = GoogleFactory.get(language, this.driver);
        this.googlePage.launchSite();
        this.googlePage.search(searchKeyWord);
        int resultCount = this.googlePage.getResultsCount();

        System.out.println(resultCount);
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {"ENG", "Selenium"},
                {"TAM", "Docker"},
                {"HIN", "Design Patterns"},
                {"MAR","Page Factory"}
        };
    }
}
