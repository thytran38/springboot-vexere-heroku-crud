//package com.vexere.webservice.controllers;
//
//import com.vexere.webservice.models.promos.Promo;
//import com.vexere.webservice.models.trips.Trip;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.rest.webmvc.ResourceNotFoundException;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.vexere.webservice.models.*;
//import com.vexere.webservice.repos.*;
//
//import javax.validation.Valid;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/v1")
//public class PromoController {
//
//
//    @Autowired
//    private PromoRepository promoRepository;
//
//    @GetMapping("/promos")
//    public List<Promo> getAllTrips() {
//        return promoRepository.findAll();
//    }
//
//    @GetMapping("/promos/{id}")
//    public ResponseEntity<Promo> getTripById(@PathVariable(value = "id") Long promoID)
//            throws ResourceNotFoundException {
//        Promo promo = promoRepository.findById(promoID)
//                .orElseThrow(() -> new ResourceNotFoundException("Trip not found for this id :: " + promoID));
//        return ResponseEntity.ok().body(promo);
//    }
//
//    @PostMapping("/promos")
//    public Promo createTrip(@Valid @RequestBody Promo promo) {
//        return promoRepository.save(promo);
//    }
//
//    @PutMapping("/trips/{id}")
//    public ResponseEntity<Trip> updatePromo(@PathVariable(value = "id") Long promoID,
//                                                      @Valid @RequestBody Promo promoDetails) throws ResourceNotFoundException {
//        Promo promo = promoRepository.findById(promoID)
//                .orElseThrow(() -> new ResourceNotFoundException("Trip not found for this id :: " + promoID));
//
//        promo.setArrivalDatetime(tripDetails.getArrivalDatetime());
//        final Promo updatedPromo = promoRepository.save(promo);
//        return ResponseEntity.ok(updatedPromo);
//    }
//
//    @PutMapping("/trips/{id}")
//    public ResponseEntity<Trip> updateTripStartTime(@PathVariable(value = "id") Long tripID,
//                                                    @Valid @RequestBody Trip tripDetails) throws ResourceNotFoundException {
//        Promo promo = promoRepository.findById(tripID)
//                .orElseThrow(() -> new ResourceNotFoundException("Trip not found for this id :: " + tripID));
//
//        trip.setStartDatetime(tripDetails.getStartDatetime());
//        final Trip updatedTrip = promoRepository.save(trip);
//        return ResponseEntity.ok(trip);
//    }
//
//    @PutMapping("/trips/{id}")
//    public ResponseEntity<Trip> updateTripPrice(@PathVariable(value = "id") Long tripID,
//                                                @Valid @RequestBody Trip tripDetails) throws ResourceNotFoundException {
//        Trip trip = promoRepository.findById(tripID)
//                .orElseThrow(() -> new ResourceNotFoundException("Trip not found for this id :: " + tripID));
//
//        trip.setStartDatetime(tripDetails.getStartDatetime());
//        final Trip updatedTrip = promoRepository.save(trip);
//        return ResponseEntity.ok(updatedTrip);
//    }
//
//    @DeleteMapping("/trips/{id}")
//    public Map<String, Boolean> deleteTrip(@PathVariable(value="id") Long tripID) throws ResourceNotFoundException
//    {
//        Trip trip = promoRepository.findById(tripID)
//                .orElseThrow(() -> new ResourceNotFoundException("Trip not found for this id :: " + tripID));
//
//        promoRepository.delete(trip);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("Trip deleted", Boolean.TRUE);
//        return response;
//    }
//
//
//}
