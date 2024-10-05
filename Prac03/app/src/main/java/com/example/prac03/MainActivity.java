package com.example.prac03;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        CountryAdapter adapter = new CountryAdapter(CountryData.getCountries(), this);
        recyclerView.setAdapter(adapter);
    }
    public static class CountryData {
        public static ArrayList<Country> getCountries() {
            ArrayList<Country> countries = new ArrayList<>();
            countries.add(new Country("India", "New Delhi",R.drawable.india, 1428600000, 2973190, 481, 17.76));
            countries.add(new Country("China", "Beijing", R.drawable.china, 1402112000, 9596960, 153, 18.47));
            countries.add(new Country("United States", "Washington DC", R.drawable.us, 331893745, 9833517, 36, 4.25));
            countries.add(new Country("Indonesia", "Jakarta", R.drawable.indo, 273753191, 1904569, 144, 3.51));
            countries.add(new Country("Pakistan", "Islamabad", R.drawable.pakistan, 234659332, 881913, 265, 2.92));
            countries.add(new Country("Nigeria", "Abuja", R.drawable.nigeria, 223804632, 923769, 243, 2.83));
            countries.add(new Country("Brazil", "Brasilia", R.drawable.brazil, 214326223, 8515767, 25, 2.73));
            countries.add(new Country("Bangladesh", "Dhaka", R.drawable.bangla, 172932932, 147570, 1172, 2.19));

            return countries;
        }
    }
}