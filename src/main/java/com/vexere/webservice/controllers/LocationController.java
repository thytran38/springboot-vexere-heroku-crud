package com.vexere.webservice.controllers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.vexere.webservice.models.trips.Bus;
import com.vexere.webservice.models.trips.BusBrand;
import com.vexere.webservice.models.trips.Location;
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
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    @GetMapping("/locations")
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @GetMapping("/locations/{id}")
    public ResponseEntity<Location> getLocationByID(@PathVariable(value = "id") Long locationID)
            throws ResourceNotFoundException {
        Location location = locationRepository.findById(locationID)
                .orElseThrow(() -> new ResourceNotFoundException("Location not found for this id :: " + locationID));
        return ResponseEntity.ok().body(location);
    }

    @PostMapping("/location")
    public Location createLocation(@Valid @RequestBody Location location) {
        return locationRepository.save(location);
    }

    @PutMapping("/locations/{id}")
    public ResponseEntity<Location> updateLocation(@PathVariable(value = "id") Long locationID,
                                         @Valid @RequestBody Location locationDetails) throws ResourceNotFoundException {
        Location location = locationRepository.findById(locationID)
                .orElseThrow(() -> new ResourceNotFoundException("Trip not found for this id :: " + locationID));

        location.setLocaCode(location.getLocaCode());

        final Location updatedLocation = locationRepository.save(location);
        return ResponseEntity.ok(updatedLocation);
    }


    @DeleteMapping("/locations/{id}")
    public Map<String, Boolean> deleteTrip(@PathVariable(value="id") Long locationID) throws ResourceNotFoundException
    {
        Location location = locationRepository.findById(locationID)
                .orElseThrow(() -> new ResourceNotFoundException("Bus not found for this id :: " + locationID));

        locationRepository.delete(location);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Location deleted", Boolean.TRUE);
        return response;
    }
}
