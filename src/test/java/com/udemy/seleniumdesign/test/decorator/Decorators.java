package com.udemy.seleniumdesign.test.decorator;

import com.udemy.seleniumdesign.decorator.DashboardPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.function.Consumer;

public class Decorators {

    private static void shouldDisplay(List<WebElement> elements) {
        elements.forEach(element -> Assert.assertTrue(element.isDisplayed()));
    }

    private static void shouldNotDisplay(List<WebElement> elements) {
        elements.forEach(element -> Assert.assertFalse(element.isDisplayed()));
    }

    private static final Consumer<DashboardPage> adminComponentPresence = (dp) -> shouldDisplay(dp.getAdminComponents());
    private static final Consumer<DashboardPage> adminComponentNotPresent = (dp) -> shouldNotDisplay(dp.getAdminComponents());

    private static final Consumer<DashboardPage> superUserComponentPresence = (dp) -> shouldDisplay(dp.getSuperuserComponents());
    private static final Consumer<DashboardPage> superUserComponentNotPresent = (dp) -> shouldNotDisplay(dp.getSuperuserComponents());

    private static final Consumer<DashboardPage> guestComponentPresence = (dp) -> shouldDisplay(dp.getGuestComponents());
    private static final Consumer<DashboardPage> guestComponentNotPresent = (dp) -> shouldNotDisplay(dp.getGuestComponents());

    //role selection
    private static final Consumer<DashboardPage> adminSelection = (dp) -> dp.selectRole("admin");
    private static final Consumer<DashboardPage> superUserSelection = (dp) -> dp.selectRole("superuser");
    private static final Consumer<DashboardPage> guestSelection = (dp) -> dp.selectRole("guest");

    //user role pages
    public static final Consumer<DashboardPage> guestPage = guestSelection.andThen(guestComponentPresence).andThen(superUserComponentNotPresent).andThen(adminComponentNotPresent);
    public static final Consumer<DashboardPage> superUserPage = superUserSelection.andThen(guestComponentPresence).andThen(adminComponentNotPresent);
    public static final Consumer<DashboardPage> adminUserPage = adminSelection.andThen(adminComponentPresence).andThen(guestComponentPresence).andThen(superUserComponentPresence);
}
