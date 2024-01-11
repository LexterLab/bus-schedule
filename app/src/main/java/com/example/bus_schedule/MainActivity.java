package com.example.bus_schedule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bus_schedule.bus.Bus;
import com.example.bus_schedule.bus.BusAdapter;
import com.example.bus_schedule.bus.BusEdit;
import com.example.bus_schedule.bus.BusSource;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements BusEdit {

    private List<Bus> schedule;
    private EditText driver;
    private EditText make;
    private TextView status;
    private TextView departure;
    private TextView destination;
    private Handler handler;
    private  int position;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        schedule = BusSource.getBusSchedule();
        BusAdapter adapter = new BusAdapter(schedule);
        adapter.setEdit(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        driver = findViewById(R.id.driverEdit);
        make = findViewById(R.id.brandEdit);
        status = findViewById(R.id.statusView2);
        departure = findViewById(R.id.departureView2);
        destination = findViewById(R.id.destinationView2);
        handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(modifyItem,2000);

        findViewById(R.id.save).setOnClickListener(view -> {
            Bus bus = new Bus(destination.getText().toString(), departure.getText().toString(),
                    Boolean.parseBoolean(status.getText().toString()), make.getText().toString(),
                    driver.getText().toString());
            schedule.set(position, bus);
            Objects.requireNonNull(recyclerView.getAdapter()).notifyItemChanged(position);
        });
    }


    public  final Runnable modifyItem = new Runnable() {
        @Override
        public void run() {
            handler.postDelayed(this, 2000);
            Random random = new Random();
            int randomPos = random.nextInt(schedule.size());
            Bus bus = schedule.get(randomPos);
            bus.setArrived(!bus.isArrived());
            schedule.set(randomPos, bus);
            Objects.requireNonNull(recyclerView.getAdapter()).notifyItemChanged(randomPos);
        }
    };

    @Override
    public void editBus(Bus bus, int pos) {
        driver.setText(bus.getDriver());
        make.setText(bus.getMake());
        status.setText(String.valueOf(bus.isArrived()));
        departure.setText(bus.getDepartureTime());
        destination.setText(bus.getDestination());
        position = pos;
        findViewById(R.id.frame).setVisibility(View.VISIBLE);
    }
}