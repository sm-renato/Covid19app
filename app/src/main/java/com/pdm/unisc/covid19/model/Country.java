package com.pdm.unisc.covid19.model;

public class Country {
    private String name, country, continent, abbreviation;
    private Long population, confirmed, deaths, recovered;
    private int imageId;

    public String getName() {
        return name;
    }

    public Long getPopulation() {
        return population;
    }

    public Long getConfirmed() {
        return confirmed;
    }

    public Long getDeaths() {
        return deaths;
    }

    public Long getRecovered() {
        return recovered;
    }

    public String getCountry() {
        return country;
    }

    public String getContinent() {
        return continent;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public int getImageId() {
        return imageId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public void setConfirmed(Long confirmed) {
        this.confirmed = confirmed;
    }

    public void setDeaths(Long deaths) {
        this.deaths = deaths;
    }

    public void setRecovered(Long recovered) {
        this.recovered = recovered;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
