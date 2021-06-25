package com.pdm.unisc.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.pdm.unisc.covid19.databinding.ActivityCountryListBinding;
import com.pdm.unisc.covid19.model.Country;

import java.util.ArrayList;

public class CountryListActivity extends AppCompatActivity {

    private ActivityCountryListBinding binding;

    private String[] name = {"Afghanistan","Aland","Albania","Algeria","Andorra","Angola",
            "Anguilla","Antarctica","Antigua and Barbuda","Argentina Republic","Armenia","Aruba",
            "Australia","Austria","Azerbaijan","Bahamas","Bahrain","Brazil"};
    private String[] population = {"643543243243","643543243243","643543243243","643543243243","643543243243","643543243243",
            "643543243243","643543243243","643543243243","643543243243","643543243243","643543243243",
            "643543243243","643543243243","643543243243","643543243243","643543243243","643543243243"};
    private String[] confirmed = {"8438443","32432","32424142","4242","412412412","4242142",
            "34562","78648352","574667553","63443","76563","6565343",
            "543436","6344355","6546","534643436","63543","43342654"};
    private String[] recovered = {"76563","76563","76563","76563","76563","76563",
            "76563","76563","76563","76563","76563","76563",
            "76563","76563","76563","76563","76563","76563"};
    private String[] deaths = {"6546","6546","6546","6546","6546","6546",
            "6546","6546","6546","6546","6546","6546",
            "6546","6546","6546","6546","6546","6546"};
    private int[] imageId = {R.drawable.af,R.drawable.ax,R.drawable.al,R.drawable.dz,R.drawable.ad,R.drawable.ao,
            R.drawable.ai,R.drawable.aq,R.drawable.ag,R.drawable.ar,R.drawable.am,R.drawable.aw,
            R.drawable.au,R.drawable.at,R.drawable.az,R.drawable.bs,R.drawable.bh,R.drawable.br};

    ArrayList<Country> countryArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCountryListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.covid_app);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));
        setTitle(getResources().getString(R.string.app_name));

        for (int i = 0; i < imageId.length; i++) {
            Country country = new Country();
            country.setName(name[i]);
            country.setPopulation(Long.valueOf(population[i]));
            country.setConfirmed(Long.valueOf(confirmed[i]));
            country.setRecovered(Long.valueOf(recovered[i]));
            country.setDeaths(Long.valueOf(deaths[i]));
            country.setImageId(imageId[i]);
            countryArrayList.add(country);
        }

        ListAdapter listAdapter = new ListAdapter(CountryListActivity.this,countryArrayList);

        binding.listView.setAdapter(listAdapter);
        binding.listView.setClickable(true);
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CountryListActivity.this, CountryActivity.class);
                intent.putExtra("name", name[position]);
                intent.putExtra("population", population[position]);
                intent.putExtra("confirmed", confirmed[position]);
                intent.putExtra("recovered", recovered[position]);
                intent.putExtra("deaths", deaths[position]);
                intent.putExtra("imageid", imageId[position]);
                startActivity(intent);
            }
        });
    }
}