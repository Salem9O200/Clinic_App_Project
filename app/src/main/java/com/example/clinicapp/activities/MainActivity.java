package com.example.clinicapp.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.example.clinicapp.R;
import com.example.clinicapp.activities.fragments.AppointmentsFragment;
import com.example.clinicapp.activities.fragments.HomeFragment;
import com.example.clinicapp.activities.fragments.ProfileFragment;
import com.example.clinicapp.activities.fragments.RecordsFragment;
import com.example.clinicapp.activities.utils.SharedPrefManager;
import com.example.clinicapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPrefManager pref = new SharedPrefManager(this);
        if (!pref.isLoggedIn()) {
            startActivity(new Intent(this, AuthActivity.class));
            finish();
            return;
        }
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new HomeFragment());

        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            Fragment selected = null;
            int id = item.getItemId();

            if (id == R.id.nav_home) {
                selected = new AppointmentsFragment();
            } else if (id == R.id.nav_appointments) {
                selected = new AppointmentsFragment();
            } else if (id == R.id.nav_records) {
                selected = new RecordsFragment();
            } else if (id == R.id.nav_profile) {
                selected = new ProfileFragment();
            }

            if (selected != null) {
                replaceFragment(selected);
            }
            return true;
        });



    }
    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}