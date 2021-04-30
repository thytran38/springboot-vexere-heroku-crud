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
    public List<Location> getAllBuses() {
        return locationRepository.findAll();
    }

    @GetMapping("/locations/{id}")
    public ResponseEntity<Bus> getEmployeeById(@PathVariable(value = "id") Long busID)
            throws ResourceNotFoundException {
        Bus bus = locationRepository.findById(busID)
                .orElseThrow(() -> new ResourceNotFoundException("Bus not found for this id :: " + busID));
        return ResponseEntity.ok().body(bus);
    }

    @PostMapping("/buses")
    public Bus createBus(@Valid @RequestBody Bus bus) {
        return busRepository.save(bus);
    }

    @PutMapping("/buses/{id}")
    public ResponseEntity<Bus> updateBus(@PathVariable(value = "id") Long busID,
                                         @Valid @RequestBody Bus busDetails) throws ResourceNotFoundException {
        Bus bus = busRepository.findById(busID)
                .orElseThrow(() -> new ResourceNotFoundException("Trip not found for this id :: " + busID));

        bus.setBrand(busDetails.getBrand());
        final Bus updatedBus = busRepository.save(bus);
        return ResponseEntity.ok(updatedBus);
    }


    @DeleteMapping("/buses/{id}")
    public Map<String, Boolean> deleteTrip(@PathVariable(value="id") Long busID) throws ResourceNotFoundException
    {
        Bus bus = busRepository.findById(busID)
                .orElseThrow(() -> new ResourceNotFoundException("Bus not found for this id :: " + busID));

        busRepository.delete(bus);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Bus deleted", Boolean.TRUE);
        return response;
    }
}
