package com.example.clinicapp.activities.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.clinicapp.R;
import com.example.clinicapp.activities.adapters.AppointmentAdapter;
import com.example.clinicapp.activities.database.AppDatabase;
import com.example.clinicapp.activities.models.Appointment;
import com.example.clinicapp.activities.utils.SharedPrefManager;
import com.example.clinicapp.databinding.FragmentHomeBinding;

import java.util.List;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;
    private List<Appointment> appointments;
    private AppointmentAdapter adapter;
    private AppDatabase db;
    private int userId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);

        db = AppDatabase.getInstance(getActivity());
        SharedPrefManager pref = new SharedPrefManager(getActivity());
        userId = pref.getUserId();

        appointments = db.appointmentDao().getAppointmentsByUserId(userId);

        adapter = new AppointmentAdapter(appointments);
        binding.rvUpcomingAppointments.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.rvUpcomingAppointments.setAdapter(adapter);

        binding.fabAddAppointment.setOnClickListener(v -> showAddAppointmentDialog());


        return binding.getRoot();
    }

    private void showAddAppointmentDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("New Appointment");

        View dialogView = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_add_appointment, null);
        EditText etDoctor = dialogView.findViewById(R.id.etDoctor);
        EditText etDate = dialogView.findViewById(R.id.etDate);

        builder.setView(dialogView);
        builder.setPositiveButton("Save", (dialog, which) -> {
            String doctor = etDoctor.getText().toString().trim();
            String date = etDate.getText().toString().trim();

            if (!doctor.isEmpty() && !date.isEmpty()) {
                Appointment newApp = new Appointment(doctor, date, userId);
                db.appointmentDao().insert(newApp);

                appointments.clear();
                appointments.addAll(db.appointmentDao().getAppointmentsByUserId(userId));
                adapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("Cancel", null);
        builder.show();
    }
}
