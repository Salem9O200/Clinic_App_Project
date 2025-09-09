package com.example.clinicapp.activities.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.clinicapp.activities.models.Doctor;
import com.example.clinicapp.databinding.ItemDoctorBinding;
import java.util.List;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.DoctorViewHolder> {

    private final List<Doctor> doctors;

    public DoctorAdapter(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    @NonNull
    @Override
    public DoctorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemDoctorBinding binding = ItemDoctorBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new DoctorViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorViewHolder holder, int position) {
        Doctor doctor = doctors.get(position);
        holder.binding.tvName.setText(doctor.getName());
        holder.binding.tvCategory.setText(doctor.getCategory());
    }

    @Override
    public int getItemCount() {
        return doctors.size();
    }

    static class DoctorViewHolder extends RecyclerView.ViewHolder {
        ItemDoctorBinding binding;
        public DoctorViewHolder(@NonNull ItemDoctorBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
