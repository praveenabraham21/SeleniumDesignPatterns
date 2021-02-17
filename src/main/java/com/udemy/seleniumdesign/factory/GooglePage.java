package com.udemy.seleniumdesign.factory;

public abstract class GooglePage {
    public abstract void launchSite();

    public abstract void search(String searchKeyword);

    public abstract int getResultsCount();
}
