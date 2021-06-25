package com.pdm.unisc.covid19;

import com.pdm.unisc.covid19.model.All;
import com.pdm.unisc.covid19.model.Country;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Url;

public interface Service {
    @Headers("Content-Type: application/json")
    @GET
    Call<All> loadAll(@Url String url);

    @Headers("Content-Type: application/json")
    @GET
    Call<Object> loadCountryAll(@Url String url);


}
