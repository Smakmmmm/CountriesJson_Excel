package ru.web_java_course.countries_json;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountriesJsonReader {
    public List<Country> getCountries(File json) {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<Country> countriesList = new ArrayList<>();

        try {
            countriesList = Arrays.asList(mapper.readValue(json, Country[].class));
        } catch (IOException e) {
            System.out.println("Возникла ошибка! " + e.getMessage());
        }

        return countriesList;
    }

    public List<Currencies> getCurrencies(File json) {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<Currencies> currencies = new ArrayList<>();

        try {
            currencies = Arrays.asList(mapper.readValue(json, Currencies[].class));
        } catch (IOException e) {
            System.out.println("Возникла ошибка! " + e.getMessage());
        }

        return currencies;
    }
}
