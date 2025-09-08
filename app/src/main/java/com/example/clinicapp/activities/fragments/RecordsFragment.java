package com.example.clinicapp.activities.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;

import com.example.clinicapp.R;
import com.example.clinicapp.activities.adapters.RecordAdapter;
import com.example.clinicapp.activities.database.AppDatabase;
import com.example.clinicapp.activities.models.Record;
import com.example.clinicapp.activities.utils.SharedPrefManager;
import com.example.clinicapp.databinding.FragmentRecordsBinding;

import java.util.List;

public class RecordsFragment extends Fragment {

    FragmentRecordsBinding binding;
    private List<Record> records;
    private RecordAdapter adapter;
    private AppDatabase db;
    private int userId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentRecordsBinding.inflate(inflater, container, false);

        db = AppDatabase.getInstance(getActivity());
        SharedPrefManager pref = new SharedPrefManager(getActivity());
        userId = pref.getUserId();

        records = db.recordDao().getRecordsByUserId(userId);

        adapter = new RecordAdapter(records);
        binding.recordsRV.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.recordsRV.setAdapter(adapter);

        binding.fabAddRecord.setOnClickListener(v -> showAddRecordDialog());

        return binding.getRoot();
    }

    private void showAddRecordDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("New Record");

        View dialogView = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_add_record, null);
        EditText etDiagnosis = dialogView.findViewById(R.id.etDiagnosis);
        EditText etDescription = dialogView.findViewById(R.id.etDescription);

        builder.setView(dialogView);
        builder.setPositiveButton("Save", (dialog, which) -> {
            String diagnosis = etDiagnosis.getText().toString().trim();
            String description = etDescription.getText().toString().trim();

            if (!diagnosis.isEmpty() && !description.isEmpty()) {
                Record newRecord = new Record(diagnosis, description, userId);
                db.recordDao().insertRecord(newRecord);

                records.clear();
                records.addAll(db.recordDao().getRecordsByUserId(userId));
                adapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("Cancel", null);
        builder.show();
    }
}
