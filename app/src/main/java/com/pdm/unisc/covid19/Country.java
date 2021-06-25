package com.pdm.unisc.covid19;

public class Country {
    String name, population, confirmed, deaths, recovered;
    int imageId;

    public Country(String name, String population, String confirmed, String deaths, String recovered, int imageId) {
        this.name = name;
        this.population = population;
        this.confirmed = confirmed;
        this.recovered = recovered;
        this.deaths = deaths;
        this.imageId = imageId;
    }
}
