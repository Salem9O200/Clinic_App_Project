package com.example.clinicapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.clinicapp.activities.utils.SharedPrefManager;
import com.example.clinicapp.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {

    private ActivitySplashBinding binding;
    private static final int SPLASH_TIME = 2500; // 2.5 ثانية

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        new Handler().postDelayed(() -> {
            SharedPrefManager pref = new SharedPrefManager(this);

            if (isFirstLaunch()) {
                // أول تشغيل → Onboarding
                startActivity(new Intent(SplashActivity.this, OnboardingActivity.class));
            } else if (pref.getUserId() == -1) {
                // مش مسجل دخول → AuthActivity
                startActivity(new Intent(SplashActivity.this, AuthActivity.class));
            } else {
                // مسجل دخول → MainActivity
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }

            finish();
        }, SPLASH_TIME);
    }

    private boolean isFirstLaunch() {
        return getSharedPreferences("clinic_app_pref", MODE_PRIVATE)
                .getBoolean("first_launch", true);
    }
}
