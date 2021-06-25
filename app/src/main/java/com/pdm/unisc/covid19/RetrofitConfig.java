package com.pdm.unisc.covid19;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitConfig {
    private final Retrofit retrofit;
    private final String urlBase = "https://covid-api.mmediagroup.fr/v1/";

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(this.urlBase)
                .addConverterFactory(ScalarsConverterFactory.create())
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