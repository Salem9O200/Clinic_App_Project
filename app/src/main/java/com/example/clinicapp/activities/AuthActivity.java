package com.example.clinicapp.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.clinicapp.R;
import com.example.clinicapp.activities.adapters.AuthPagerAdapter;
import com.example.clinicapp.databinding.ActivityAuthBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class AuthActivity extends AppCompatActivity {

    ActivityAuthBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAuthBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AuthPagerAdapter adapter = new AuthPagerAdapter(this);
        binding.viewPagerAuth.setAdapter(adapter);

        new TabLayoutMediator(binding.tabLayout, binding.viewPagerAuth,
                (tab, position) -> {
                    tab.setText(position == 0 ? "Login" : "Register");
                }).attach();
    }
}
