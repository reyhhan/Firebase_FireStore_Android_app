package com.example.bakery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class home_activity extends AppCompatActivity {
BottomNavigationView navigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_activity);

        navigation=findViewById(R.id.bottom_nav);
        navigation.setOnNavigationItemSelectedListener(navlistener);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction().replace(R.id.frg_space,
                    new Product()).commit();
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navlistener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;

            switch (menuItem.getItemId()) {
                case R.id.nav_products:
                    menuItem.setChecked(true);
                    selectedFragment = new Product();
                    break;
                case R.id.nav_order:
                    menuItem.setChecked(true);
                    selectedFragment = new Order();
                    break;
                case R.id.nav_bills:
                    menuItem.setChecked(true);
                    selectedFragment = new Bills();
                    break;
            }

            getFragmentManager().beginTransaction().replace(R.id.frg_space,
                    selectedFragment).commit();

            return false;
        }
    };





}
