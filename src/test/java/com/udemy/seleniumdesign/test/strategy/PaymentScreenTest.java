package com.udemy.seleniumdesign.test.strategy;

import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.seleniumdesign.strategy.PaymentOptionFactory;
import com.udemy.seleniumdesign.strategy.PaymentScreen;
import com.udemy.seleniumdesign.test.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Maps;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class PaymentScreenTest extends BaseTest {
    private PaymentScreen paymentScreen;

    @BeforeTest
    public void setPaymentScreen() {
        this.paymentScreen = new PaymentScreen(this.driver);
    }

    @Test(dataProvider = "getData")
    public void paymentTest(String paymentOption, Map<String, String> paymentDetails) {
        this.paymentScreen.goTo();
        this.paymentScreen.getUserInfo().enterPersonaInfo("praveen", "abraham", "test@test.com");
        this.paymentScreen.setPaymentOption(PaymentOptionFactory.get(paymentOption));
        this.paymentScreen.pay(paymentDetails);
        String orderNumber = this.paymentScreen.getBuyNow().placeOrder();
        System.out.println("Order Number : " + orderNumber);
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }

    @DataProvider
    public Object[][] getData() {

        Map<String, String> cc = Maps.newHashMap();
        cc.put("cc", "12222212121");
        cc.put("year", "2023");
        cc.put("cvv", "1232");

        Map<String, String> nb = Maps.newHashMap();
        nb.put("bank", "WELLS FARGO");
        nb.put("account", "myaccount123");
        nb.put("pin", "999");

        Map<String, String> pp = Maps.newHashMap();
        pp.put("username", "praveen");
        pp.put("password", "pass232");

        return new Object[][]{
                {"CC", cc},
                {"NB", nb},
                {"PP", pp}
        };
    }

}
