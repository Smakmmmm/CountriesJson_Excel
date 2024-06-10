package ru.web_java_course.countries_json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CountriesJsonWriter {
    public boolean WriteCountriesJson(String fileName, List<Country> countries) {
        ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();

        File file = new File(fileName);

        try {
            writer.writeValue(file, countries);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return true;
    }
}
