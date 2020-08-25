package com.example.test;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> items = Arrays.asList("검색기록1", "검색기록2", "검색기록3");
    private Button create_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.search_view);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        final SearchView searchView = findViewById(R.id.search_view);
        final TextView resultTextView = findViewById(R.id.textView);
        resultTextView.setText(getResult());

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) { return false; }

            @Override
            public boolean onQueryTextChange(String newText) {
                resultTextView.setText(search(newText));
                return true;
            }

        });

        create_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


        private String search(String query) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < items.size(); i++) {
                String item = items.get(i);
                if (item.toLowerCase().contains(query.toLowerCase())) {
                    sb.append(item);
                    if (i != items.size() - 1) {
                        sb.append("\n");
                    }
                }
            }
            return sb.toString();
        }

        private String getResult() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < items.size(); i++) {
                String item = items.get(i);
                if (i == items.size() - 1) {
                    sb.append(item);
                } else {
                    sb.append(item);
                    sb.append("\n");
                }
            }
            return sb.toString();
        }

}