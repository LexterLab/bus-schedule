package com.example.bus_schedule.bus;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bus_schedule.R;

public class BusViewHolder extends RecyclerView.ViewHolder {
    private final TextView destination;
    private final TextView departure;
    private final TextView status;
    public BusViewHolder(@NonNull View itemView) {
        super(itemView);
        destination = itemView.findViewById(R.id.destination);
        departure = itemView.findViewById(R.id.departure);
        status = itemView.findViewById(R.id.status);
    }

    public void setDestination(String destination) {
        this.destination.setText(destination);
    }

    public void setDeparture(String departure) {
        this.departure.setText(departure);
    }

    public void setStatus(boolean status) {
        this.status.setText(String.valueOf(status));
    }
}
