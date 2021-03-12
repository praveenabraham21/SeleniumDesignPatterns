package com.udemy.seleniumdesign.executeAround;

import java.util.function.Consumer;

public class SampleConsumer {
    public static void main(String[] args) {
        test((d) -> System.out.println(d));
        test((d)-> System.out.println("Hello "+d));
    }

    public static void test(Consumer<String> consumer) {
        String s = "Praveen";
        consumer.accept(s);
    }
}
