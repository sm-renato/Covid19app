package com.pdm.unisc.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.pdm.unisc.covid19.model.All;
import com.pdm.unisc.covid19.model.Country;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView population, deaths, confirmed, recovered;
    private All all = new All();
    private Country country = new Country();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.covid_app);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));
        setTitle(getResources().getString(R.string.app_name));

        population = findViewById(R.id.population);
        recovered = findViewById(R.id.recovered);
        deaths = findViewById(R.id.deaths);
        confirmed = findViewById(R.id.confirmed);

        RetrofitConfig config = new RetrofitConfig();
        Call<All> call = config.getService().loadAll(config.getUrlBase() + "cases?country=Global");
        Log.d("OE", config.getUrlBase() + "country=Global");
        call.enqueue(new Callback<All>() {


            @Override
            public void onResponse(Call<All> call, Response<All> response) {
                Log.d("pop", response.body().toString());
                all = response.body();
                country = all.getCountry();
                Log.d("pop", country.toString());
                population.setText(String.valueOf(country.getPopulation()));
                deaths.setText(String.valueOf(country.getDeaths()));
                recovered.setText(String.valueOf(country.getRecovered()));
                confirmed.setText(String.valueOf(country.getConfirmed()));
            }

            @Override
            public void onFailure(Call<All> call, Throwable t) {

            }


        });
    }

    public void countryListClick(View view) {
        startActivity(new Intent(this, CountryListActivity.class));
    }
}