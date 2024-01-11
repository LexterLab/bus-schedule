package com.example.bus_schedule.bus;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bus_schedule.R;

import java.util.List;

public class BusAdapter extends RecyclerView.Adapter<BusViewHolder> {
    private final List<Bus> schedule;
    private Context context;
    private BusEdit edit;

    public BusAdapter(List<Bus> schedule) {
        this.schedule = schedule;
    }

    @NonNull
    @Override
    public BusViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View scheduleView = inflater.inflate(R.layout.bus, parent, false );
        return new BusViewHolder(scheduleView);
    }

    @Override
    public void onBindViewHolder(@NonNull BusViewHolder holder, int position) {
        Bus bus = schedule.get(position);
        holder.setDeparture(bus.getDepartureTime());
        holder.setDestination(bus.getDestination());
        holder.setStatus(bus.isArrived());

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, BusInfoActivity.class);
            intent.putExtra("bus", bus);
            context.startActivity(intent);
        });

        holder.itemView.setOnLongClickListener(view -> {
            edit.editBus(bus, position);
            return false;
        });
    }

    public void setEdit(BusEdit edit) {
        this.edit = edit;
    }

    @Override
    public int getItemCount() {
        return schedule.size();
    }
}
