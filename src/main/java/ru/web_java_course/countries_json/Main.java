package ru.web_java_course.countries_json;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CountriesJsonReader reader = new CountriesJsonReader();

        File file = new File("countries.json");

        List<Country> countriesList = reader.getCountries(file);

        int totalPopulation = 0;
        System.out.println("Список стран:");

        for (Country country : countriesList) {
            System.out.println(country);
            totalPopulation += country.getPopulation();
        }

        System.out.println("Суммарная численность населения по всем странам: " + totalPopulation);
        System.out.println(countriesList.size());
        System.out.println();

        System.out.println("Список валют всех стран:");
        List<Currencies> currenciesList = reader.getCurrencies(file);

        for (Currencies currency : currenciesList) {
            System.out.println(currency);
        }

        System.out.println();
        System.out.println("Страны с населением не менее 1 миллиона: ");

        List<Country> countriesWithMillion = countriesList.stream()
                .filter(country -> country.getPopulation() >= 1000000)
                .toList();

        countriesWithMillion.forEach(System.out::println);

        CountriesJsonWriter writer = new CountriesJsonWriter();
        writer.WriteCountriesJson("countriesWithMillionsOfPeople.json", countriesWithMillion);
    }
}
