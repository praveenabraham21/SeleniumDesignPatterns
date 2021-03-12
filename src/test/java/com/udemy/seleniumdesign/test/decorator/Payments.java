package com.udemy.seleniumdesign.test.decorator;

import com.udemy.seleniumdesign.decorator.PaymentPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.function.Consumer;

public class Payments {

    //Final Assertion

    //payment status validation - success
    private static void paymentSuccess(String paymentStatus) {
        Assert.assertEquals(paymentStatus, "PASS");
    }

    //payment status vaidation - failure
    private static void paymentFailure(String paymentStatus) {
        Assert.assertEquals(paymentStatus, "FAIL");
    }

    //payment status validation
    private static final Consumer<PaymentPage> paymentSuccessValidation = (pp) -> paymentSuccess(pp.getOrderStatus());
    private static final Consumer<PaymentPage> paymentFailureValidation = (pp) -> paymentFailure(pp.getOrderStatus());

    //entering the payment details
    private static final Consumer<PaymentPage> enterValidCC = (pp) -> pp.enterCreditCard("4111111111111111", "2023", "123");
    private static final Consumer<PaymentPage> enterDiscountedPromo = (pp) -> pp.applyCoupon("PARTIALUDEMY");
    private static final Consumer<PaymentPage> enterFullPromo = (pp) -> pp.applyCoupon("FREEUDEMY");
    private static final Consumer<PaymentPage> enterInValidCC = (pp) -> pp.enterCreditCard("4111111111111111", "2021", "123");
    private static final Consumer<PaymentPage> submitOrder = (pp) -> pp.submitOrder();

    //Different Payment channel flows
    public static final Consumer<PaymentPage> validCC = enterValidCC.andThen(submitOrder).andThen(paymentSuccessValidation);
    public static final Consumer<PaymentPage> discountPromoAndValidCC = enterDiscountedPromo.andThen(enterValidCC).andThen(submitOrder).andThen(paymentSuccessValidation);
    public static final Consumer<PaymentPage> fullPromo = enterFullPromo.andThen(submitOrder).andThen(paymentSuccessValidation);
    public static final Consumer<PaymentPage> discountPromoAndInvalidCC = enterDiscountedPromo.andThen(enterInValidCC).andThen(submitOrder).andThen(paymentFailureValidation);
    public static final Consumer<PaymentPage> noPayment = submitOrder.andThen(paymentFailureValidation);

}
