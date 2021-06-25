package com.pdm.unisc.covid19;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {
    private final Retrofit retrofit;
    private final String urlBase = "https://covid-api.mmediagroup.fr/v1/";

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(this.urlBase)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Service getService() {
        return this.retrofit.create(Service.class);
    }

    public String getUrlBase() {
        return urlBase;
    }
}
