package com.vexere.webservice.models.trips;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="seats")
public class Seat {
    public int seatNumber;
    public int busId;
    public int tripId;

}
