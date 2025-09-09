package com.example.clinicapp.activities.fragments;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.clinicapp.R;
import com.example.clinicapp.activities.AuthActivity;
import com.example.clinicapp.activities.utils.SharedPrefManager;
import com.example.clinicapp.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);

        SharedPrefManager pref = new SharedPrefManager(getActivity());

        binding.btnLogout.setOnClickListener(v -> {
            pref.logout();
            startActivity(new Intent(getActivity(), AuthActivity.class));
            getActivity().finish();
        });

        return binding.getRoot();
    }
}
