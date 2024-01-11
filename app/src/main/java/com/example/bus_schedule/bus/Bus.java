package com.example.bus_schedule.bus;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Bus implements Parcelable {
    private final String destination;
    private final String departureTime;
    private boolean arrived;
    private final String make;
    private final String driver;

    public Bus(String destination, String departureTime, boolean arrived, String make, String driver) {
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrived = arrived;
        this.make = make;
        this.driver = driver;
    }

    protected Bus(Parcel in) {
        destination = in.readString();
        departureTime = in.readString();
        arrived = in.readByte() != 0;
        make = in.readString();
        driver = in.readString();
    }

    public static final Creator<Bus> CREATOR = new Creator<Bus>() {
        @Override
        public Bus createFromParcel(Parcel in) {
            return new Bus(in);
        }

        @Override
        public Bus[] newArray(int size) {
            return new Bus[size];
        }
    };

    public String getDestination() {
        return destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public boolean isArrived() {
        return arrived;
    }

    public String getMake() {
        return make;
    }

    public String getDriver() {
        return driver;
    }

    public void setArrived(boolean arrived) {
        this.arrived = arrived;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(destination);
        parcel.writeString(departureTime);
        parcel.writeByte((byte) (arrived ? 1 : 0));
        parcel.writeString(make);
        parcel.writeString(driver);
    }
}
