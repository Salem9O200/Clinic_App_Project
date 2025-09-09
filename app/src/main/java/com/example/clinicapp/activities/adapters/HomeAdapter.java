package com.example.clinicapp.activities.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clinicapp.R;
import com.example.clinicapp.activities.models.Appointment;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    private List<Appointment> appointments;

    public HomeAdapter(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_home_appointment, parent, false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        Appointment appt = appointments.get(position);
        holder.tvDoctor.setText(appt.getDoctor());
        holder.tvDate.setText(appt.getDate());
    }

    @Override
    public int getItemCount() {
        return appointments.size();
    }

    public static class HomeViewHolder extends RecyclerView.ViewHolder {
        TextView tvDoctor, tvDate;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDoctor = itemView.findViewById(R.id.tvDoctor);
            tvDate = itemView.findViewById(R.id.tvDate);
        }
    }
}
