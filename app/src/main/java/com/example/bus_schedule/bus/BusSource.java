package com.example.bus_schedule.bus;

import java.util.ArrayList;
import java.util.List;

public class BusSource {
    public static List<Bus> getBusSchedule() {
        List<Bus> schedule = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            schedule.add(new Bus("Jacksonville", i + ":00", false, "Volvo", "Dave Schapel"));
        }
        return schedule;
    }
}
