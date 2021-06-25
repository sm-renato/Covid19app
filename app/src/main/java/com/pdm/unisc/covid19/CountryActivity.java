package com.pdm.unisc.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.pdm.unisc.covid19.databinding.ActivityCountryBinding;

public class CountryActivity extends AppCompatActivity {

    ActivityCountryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCountryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.covid_app);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));
        setTitle(getResources().getString(R.string.app_name));

        Intent intent = this.getIntent();

        if (intent != null) {
            String name = intent.getStringExtra("name");
            String population = intent.getStringExtra("population");
            String confirmed = intent.getStringExtra("confirmed");
            String recovered = intent.getStringExtra("recovered");
            String deaths = intent.getStringExtra("deaths");
            int imageid = intent.getIntExtra("imageid",R.drawable.covid_app);

            binding.nameCountry.setText(name);
            binding.populationCountry.setText(population);
            binding.confirmedCountry.setText(confirmed);
            binding.recoveredCountry.setText(recovered);
            binding.deathsCountry.setText(deaths);
            binding.countryFlag2.setImageResource(imageid);
        }
    }
}