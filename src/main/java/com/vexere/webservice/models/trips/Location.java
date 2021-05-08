package com.vexere.webservice.models.trips;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="locations")
public class Location {
    public int locaID;
    public String locaCode;
    public String locaName;

    public int getLocaID() {
        return locaID;
    }

    public String getLocaName() {
        return locaName;
    }

    public void setLocaName(String locaName) {
        this.locaName = locaName;
    }

    public void setLocaID(int locaID) {
        this.locaID = locaID;
    }

    public String getLocaCode() {
        return locaCode;
    }

    public void setLocaCode(String locaCode) {
        this.locaCode = locaCode;
    }
}
