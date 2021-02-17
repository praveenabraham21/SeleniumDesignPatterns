package com.udemy.seleniumdesign.strategy;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PaymentOptionFactory {

    private static final Supplier<PaymentOption> cc = () -> new CreditCard();
    private static final Supplier<PaymentOption> nb = () -> new CreditCard();
    private static final Supplier<PaymentOption> pp = () -> new CreditCard();

    private static final Map<String, Supplier<PaymentOption>> MAP = new HashMap<>();

    static {
        MAP.put("CC", cc);
        MAP.put("NB", nb);
        MAP.put("PP", pp);
    }

    public static PaymentOption get(String option) {
        return MAP.get(option).get();
    }

}
