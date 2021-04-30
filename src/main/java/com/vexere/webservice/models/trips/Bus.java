package com.vexere.webservice.models.trips;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="buses")
public class Bus {
    public int busId;
    public BusBrand brand;
    public Driver driver;

    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public BusBrand getBrand() {
        return brand;
    }

    public void setBrand(BusBrand brand) {
        this.brand = brand;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
