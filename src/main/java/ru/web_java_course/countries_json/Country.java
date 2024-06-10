package ru.web_java_course.countries_json;

public class Country {
    private String name;
    private int population;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryName='" + name + '\'' +
                ", population='" + population + '\'' +
                '}';
    }
}
