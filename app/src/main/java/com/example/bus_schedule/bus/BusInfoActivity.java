package com.example.bus_schedule.bus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.bus_schedule.R;

public class BusInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_info);
        TextView brand = findViewById(R.id.brandView);
        TextView driver = findViewById(R.id.driverView);
        TextView destination = findViewById(R.id.destinationView);
        TextView status = findViewById(R.id.statusView);
        TextView departure = findViewById(R.id.departureView);

        Bus bus = getIntent().getParcelableExtra("bus");

        if (bus != null) {
            brand.setText(bus.getMake());
            driver.setText(bus.getDriver());
            destination.setText(bus.getDestination());
            status.setText(String.valueOf(bus.isArrived()));
            departure.setText(bus.getDepartureTime());
        }


    }
}