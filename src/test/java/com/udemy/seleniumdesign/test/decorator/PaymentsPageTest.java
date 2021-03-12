package com.udemy.seleniumdesign.test.decorator;

import com.udemy.seleniumdesign.decorator.PaymentPage;
import com.udemy.seleniumdesign.test.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.function.Consumer;

public class PaymentsPageTest extends BaseTest {

    private PaymentPage paymentPage;

    @BeforeTest
    public void setPaymentsPage() {
        this.paymentPage = new PaymentPage(driver);
    }

    @Test(dataProvider = "paymentChannels")
    public void paymentTest(Consumer<PaymentPage> payment) {
        this.paymentPage.goTo();
        payment.accept(this.paymentPage);
    }

    @DataProvider
    public Object[] paymentChannels() {
        return new Object[]{
                Payments.validCC,
                Payments.discountPromoAndValidCC,
                Payments.fullPromo,
                Payments.discountPromoAndInvalidCC,
                Payments.noPayment
        };
    }
}
