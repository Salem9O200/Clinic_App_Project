package com.example.clinicapp.activities.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.clinicapp.R;
import com.example.clinicapp.activities.adapters.AppointmentAdapter;
import com.example.clinicapp.activities.database.AppDatabase;
import com.example.clinicapp.activities.models.Appointment;
import com.example.clinicapp.activities.utils.SharedPrefManager;
import com.example.clinicapp.databinding.FragmentHomeBinding;

import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private AppointmentAdapter adapter;
    private List<Appointment> appointments;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        SharedPrefManager pref = new SharedPrefManager(getActivity());
        int userId = pref.getUserId();

        AppDatabase db = AppDatabase.getInstance(getActivity());
        appointments = db.appointmentDao().getAppointmentsByUserId(userId);

        adapter = new AppointmentAdapter(appointments);
        binding.rvUpcomingHome.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.rvUpcomingHome.setAdapter(adapter);

        binding.fabAddAppointment.setOnClickListener(v -> {
            // فتح Dialog لإضافة موعد جديد (يمكن نسخ نفس الكود من AppointmentsFragment)
        });

        return binding.getRoot();
    }
}
