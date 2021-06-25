package com.pdm.unisc.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.pdm.unisc.covid19.databinding.ActivityCountryBinding;

public class CountryActivity extends AppCompatActivity {

    ActivityCountryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCountryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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