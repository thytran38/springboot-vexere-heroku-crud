package com.vexere.webservice.models.trips;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="drivers")
public class Driver {
    public String fullName;
    public String employeeId;
}
