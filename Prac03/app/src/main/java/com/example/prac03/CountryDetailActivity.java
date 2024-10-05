package com.example.prac03;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.prac03.Country;
import com.example.prac03.R;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CountryDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);


        Country country = (Country) getIntent().getSerializableExtra("country");


        if (country != null) {
            TextView nameTextView = findViewById(R.id.detailCountryName);
            TextView capitalTextView = findViewById(R.id.detailCountryCapital);
            TextView populationTextView = findViewById(R.id.detailCountryPopulation);
            TextView areaTextView = findViewById(R.id.detailCountryArea);
            TextView densityTextView = findViewById(R.id.detailCountryDensity);
            TextView worldShareTextView = findViewById(R.id.detailCountryWorldShare);
            ImageView flagImageView = findViewById(R.id.detailCountryFlag);


            nameTextView.setText("Nation: " + country.getName());
            capitalTextView.setText("Capital: " + country.getCapital());
            populationTextView.setText("Population: " + country.getPopulation()+" people");
            areaTextView.setText("Area: " + country.getArea() + " Km2");
            densityTextView.setText("Density: " + country.getDensity() + " people/km2");
            worldShareTextView.setText("World Share: " + country.getWorldShare() + " %");
            flagImageView.setImageResource(country.getFlagResourceId());
        } else {

            Toast.makeText(this, "Error loading country details", Toast.LENGTH_SHORT).show();
        }

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
