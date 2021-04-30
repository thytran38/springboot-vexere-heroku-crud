package com.vexere.webservice.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.vexere.webservice.models.trips.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vexere.webservice.models.*;
import com.vexere.webservice.repos.*;

@RestController
@RequestMapping("/api/v1")
public class TripController {

    @Autowired
    private TripRepository tripRepository;

    @GetMapping("/trips")
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    @GetMapping("/trips/{id}")
    public ResponseEntity<Trip> getTripById(@PathVariable(value = "id") Long tripID)
            throws ResourceNotFoundException {
        Trip trip = tripRepository.findById(tripID)
                .orElseThrow(() -> new ResourceNotFoundException("Trip not found for this id :: " + tripID));
        return ResponseEntity.ok().body(trip);
    }

    @PostMapping("/trips")
    public Trip createTrip(@Valid @RequestBody Trip trip) {
        return tripRepository.save(trip);
    }

    @PutMapping("/trips/{id}")
    public ResponseEntity<Trip> updateTripArrivalTime(@PathVariable(value = "id") Long tripID,
                                                   @Valid @RequestBody Trip tripDetails) throws ResourceNotFoundException {
        Trip trip = tripRepository.findById(tripID)
                .orElseThrow(() -> new ResourceNotFoundException("Trip not found for this id :: " + tripID));

        trip.setArrivalDatetime(tripDetails.getArrivalDatetime());
        final Trip updatedTrip = tripRepository.save(trip);
        return ResponseEntity.ok(trip);
    }

    @PutMapping("/trips/{id}")
    public ResponseEntity<Trip> updateTripStartTime(@PathVariable(value = "id") Long tripID,
                                                      @Valid @RequestBody Trip tripDetails) throws ResourceNotFoundException {
        Trip trip = tripRepository.findById(tripID)
                .orElseThrow(() -> new ResourceNotFoundException("Trip not found for this id :: " + tripID));

        trip.setStartDatetime(tripDetails.getStartDatetime());
        final Trip updatedTrip = tripRepository.save(trip);
        return ResponseEntity.ok(trip);
    }

    @PutMapping("/trips/{id}")
    public ResponseEntity<Trip> updateTripPrice(@PathVariable(value = "id") Long tripID,
                                                    @Valid @RequestBody Trip tripDetails) throws ResourceNotFoundException {
        Trip trip = tripRepository.findById(tripID)
                .orElseThrow(() -> new ResourceNotFoundException("Trip not found for this id :: " + tripID));

        trip.setStartDatetime(tripDetails.getStartDatetime());
        final Trip updatedTrip = tripRepository.save(trip);
        return ResponseEntity.ok(updatedTrip);
    }

    @DeleteMapping("/trips/{id}")
    public Map<String, Boolean> deleteTrip(@PathVariable(value="id") Long tripID) throws ResourceNotFoundException
    {
        Trip trip = tripRepository.findById(tripID)
                .orElseThrow(() -> new ResourceNotFoundException("Trip not found for this id :: " + tripID));

        tripRepository.delete(trip);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Trip deleted", Boolean.TRUE);
        return response;
    }




}
