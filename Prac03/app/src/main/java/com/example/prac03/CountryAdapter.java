package com.example.prac03;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prac03.Country;
import com.example.prac03.R;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {
    private List<Country> countryList;
    private Context context;

    public CountryAdapter(List<Country> countryList, Context context) {
        this.countryList = countryList;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView capitalTextView;
        ImageView flagImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.countryName);
            capitalTextView = itemView.findViewById(R.id.countryCapital);
            flagImageView = itemView.findViewById(R.id.countryFlag);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.country_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Country country = countryList.get(position);
        holder.nameTextView.setText(country.getName());
        holder.capitalTextView.setText(country.getCapital());
        holder.flagImageView.setImageResource(country.getFlagResourceId());

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, CountryDetailActivity.class);
            intent.putExtra("country", country);
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }
}
