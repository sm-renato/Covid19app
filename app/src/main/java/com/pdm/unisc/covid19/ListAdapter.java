package com.pdm.unisc.covid19;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Country> {

    public ListAdapter(Context context, ArrayList<Country> countryArrayList) {
        super(context,R.layout.list_item,countryArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Country country = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        ImageView imageView = convertView.findViewById(R.id.country_flag);
        TextView countryName = convertView.findViewById(R.id.country_name);
        TextView countryConfirmed = convertView.findViewById(R.id.country_confirmed);

        imageView.setImageResource(country.imageId);
        countryName.setText(country.name);
        countryConfirmed.setText(country.confirmed);

        return convertView;
    }
}
