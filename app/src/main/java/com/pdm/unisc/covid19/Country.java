package com.pdm.unisc.covid19;

public class Country {
    private String name, population, confirmed, deaths, recovered;
    private int imageId;

    public Country(String name, String population, String confirmed, String deaths, String recovered, int imageId) {
        this.name = name;
        this.population = population;
        this.confirmed = confirmed;
        this.recovered = recovered;
        this.deaths = deaths;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public String getPopulation() {
        return population;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public String getDeaths() {
        return deaths;
    }

    public String getRecovered() {
        return recovered;
    }

    public int getImageId() {
        return imageId;
    }
}
