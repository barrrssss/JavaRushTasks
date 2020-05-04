package com.javarush.task.task14.task1417;

public class Hrivna extends Money {
    private String currencyName = "UAH";

    public Hrivna(double amount) {
        super(amount);
    }

    @Override
    public String getCurrencyName() {
        return currencyName;
    }
}
