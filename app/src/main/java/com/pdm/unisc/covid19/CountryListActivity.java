package com.pdm.unisc.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.pdm.unisc.covid19.databinding.ActivityCountryListBinding;

import java.util.ArrayList;

public class CountryListActivity extends AppCompatActivity {

    ActivityCountryListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCountryListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String[] name = {"Afghanistan","Aland","Albania","Algeria","Andorra","Angola",
                "Anguilla","Antarctica","Antigua and Barbuda","Argentina Republic","Armenia","Aruba",
                "Australia","Austria","Azerbaijan","Bahamas","Bahrain","Brazil"};
        String[] population = {"643543243243","643543243243","643543243243","643543243243","643543243243","643543243243",
                "643543243243","643543243243","643543243243","643543243243","643543243243","643543243243",
                "643543243243","643543243243","643543243243","643543243243","643543243243","643543243243"};
        String[] confirmed = {"8438443","32432","32424142","4242","412412412","4242142",
                "34562","78648352","574667553","63443","76563","6565343",
                "543436","6344355","6546","534643436","63543","43342654"};
        String[] recovered = {"76563","76563","76563","76563","76563","76563",
                "76563","76563","76563","76563","76563","76563",
                "76563","76563","76563","76563","76563","76563"};
        String[] deaths = {"6546","6546","6546","6546","6546","6546",
                "6546","6546","6546","6546","6546","6546",
                "6546","6546","6546","6546","6546","6546"};
        int[] imageId = {R.drawable.af,R.drawable.ax,R.drawable.al,R.drawable.dz,R.drawable.ad,R.drawable.ao,
                R.drawable.ai,R.drawable.aq,R.drawable.ag,R.drawable.ar,R.drawable.am,R.drawable.aw,
                R.drawable.au,R.drawable.at,R.drawable.az,R.drawable.bs,R.drawable.bh,R.drawable.br};

        ArrayList<Country> countryArrayList = new ArrayList<>();

        for (int i = 0; i < imageId.length; i++) {
            Country country = new Country(name[i],population[i],confirmed[i],recovered[i],deaths[i],imageId[i]);
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