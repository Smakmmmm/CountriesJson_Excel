package ru.web_java_course.countries_json;

import java.util.List;

public class Currencies {
    private List<Currency> currencies;

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    @Override
    public String toString() {
        return currencies.toString();
    }
}
