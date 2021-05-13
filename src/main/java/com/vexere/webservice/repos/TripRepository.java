package com.vexere.webservice.repos;

import com.vexere.webservice.models.trips.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vexere.webservice.models.*;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long>{
    List<Trip> findAll();
}

