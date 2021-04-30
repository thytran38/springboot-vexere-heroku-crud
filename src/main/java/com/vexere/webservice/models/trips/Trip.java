package com.vexere.webservice.models.trips;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trips")
public class Trip {
    public int tripId;
    public String tripName;
    public String departLoca;
    public String desLoca;
    public String departStation;
    public int busId;
    public String busBrand;
    public int seatAvailable;
    public int price;
    public long startDatetime;
    public long arrivalDatetime;


    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public String getDepartLoca() {
        return departLoca;
    }

    public void setDepartLoca(String departLoca) {
        this.departLoca = departLoca;
    }

    public String getDesLoca() {
        return desLoca;
    }

    public void setDesLoca(String desLoca) {
        this.desLoca = desLoca;
    }

    public String getDepartStation() {
        return departStation;
    }

    public void setDepartStation(String departStation) {
        this.departStation = departStation;
    }

    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public String getBusBrand() {
        return busBrand;
    }

    public void setBusBrand(String busBrand) {
        this.busBrand = busBrand;
    }

    public int getSeatAvailable() {
        return seatAvailable;
    }

    public void setSeatAvailable(int seatAvailable) {
        this.seatAvailable = seatAvailable;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(long startDatetime) {
        this.startDatetime = startDatetime;
    }

    public long getArrivalDatetime() {
        return arrivalDatetime;
    }

    public void setArrivalDatetime(long arrivalDatetime) {
        this.arrivalDatetime = arrivalDatetime;
    }
}
