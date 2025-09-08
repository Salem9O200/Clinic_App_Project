package com.example.clinicapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.clinicapp.R;
import com.example.clinicapp.activities.adapters.OnboardingAdapter;
import com.example.clinicapp.activities.models.OnboardingItem;
import com.example.clinicapp.databinding.ActivityOnboardingBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class OnboardingActivity extends AppCompatActivity {

    ActivityOnboardingBinding binding;
    private OnboardingAdapter onboardingAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOnboardingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        setupOnboardingItems();

        new TabLayoutMediator(binding.tabIndicator, binding.viewPagerOnboarding,
                (tab, position) -> {}).attach();

        binding.btnNext.setOnClickListener(v -> {
            if (binding.viewPagerOnboarding.getCurrentItem() + 1 < onboardingAdapter.getItemCount()) {
                binding.viewPagerOnboarding.setCurrentItem(binding.viewPagerOnboarding.getCurrentItem() + 1);
            } else {
                startActivity(new Intent(OnboardingActivity.this, AuthActivity.class));
                finish();
            }
        });
    }

    private void setupOnboardingItems() {
        onboardingAdapter = new OnboardingAdapter(getOnboardingItems());
        binding.viewPagerOnboarding.setAdapter(onboardingAdapter);
    }

    private List<OnboardingItem> getOnboardingItems() {
        List<OnboardingItem> items = new ArrayList<>();
        items.add(new OnboardingItem(R.drawable.ic_launcher_background,
                "Welcome", "Book your doctors easily"));
        items.add(new OnboardingItem(R.drawable.ic_launcher_background,
                "Appointments", "Manage your upcoming & past visits"));
        items.add(new OnboardingItem(R.drawable.ic_launcher_background,
                "Records", "Keep track of your medical history"));
        return items;
    }

}
