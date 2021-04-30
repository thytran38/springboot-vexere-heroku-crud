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
}
