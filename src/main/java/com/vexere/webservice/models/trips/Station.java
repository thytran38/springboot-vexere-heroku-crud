package com.vexere.webservice.models.trips;

import com.vexere.webservice.models.trips.Location;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="stations")
public class Station {
    public int stationId;
    public String stationName;
    public Location location;

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
