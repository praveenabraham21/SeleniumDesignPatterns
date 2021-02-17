package com.udemy.seleniumdesign.factory;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class GoogleFactory {

    private static final Function<WebDriver, GooglePage> ENG = (d) -> new GoogleEnglish(d);
    private static final Function<WebDriver, GooglePage> TAM = (d) -> new GoogleTamil(d);
    private static final Function<WebDriver, GooglePage> HIN = (d) -> new GoogleHindi(d);
    private static final Function<WebDriver, GooglePage> MAR = (d) -> new GoogleMarati(d);
    private static final Map<String, Function<WebDriver, GooglePage>> MAP = new HashMap<>();

    static {
        MAP.put("ENG", ENG);
        MAP.put("TAM", TAM);
        MAP.put("HIN", HIN);
        MAP.put("MAR", MAR);
    }

    public static GooglePage get(String language, WebDriver driver) {
        return MAP.get(language).apply(driver);
    }

}
