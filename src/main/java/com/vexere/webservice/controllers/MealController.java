package com.vexere.webservice.controllers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.vexere.webservice.models.food.Meal;
import com.vexere.webservice.models.trips.Bus;
import com.vexere.webservice.models.trips.BusBrand;
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
public class MealController {
    @Autowired
    private FoodRepository foodRepository;

    @GetMapping("/meals")
    public List<Meal> getAllMeals() {
        return foodRepository.findAll();
    }

    @GetMapping("/meals/{id}")
    public ResponseEntity<Meal> getMealByID(@PathVariable(value = "id") Long mealID)
            throws ResourceNotFoundException {
        Meal meal = foodRepository.findById(mealID)
                .orElseThrow(() -> new ResourceNotFoundException("Meal not found for this id : " + mealID));
        return ResponseEntity.ok().body(meal);
    }

    @PostMapping("/meals")
    public Meal createMeals (@Valid @RequestBody Meal meal) {
        return foodRepository.save(meal);
    }

    @PutMapping("/meals/{id}")
    public ResponseEntity<Meal> updateMeal(@PathVariable(value = "id") Long mealID,
                                         @Valid @RequestBody Meal mealDetails) throws ResourceNotFoundException {
        Meal meal = foodRepository.findById(mealID)
                .orElseThrow(() -> new ResourceNotFoundException("Meal not found for this id : " + mealID));
        meal.setMealPrice(mealDetails.getMealPrice());
        final Meal updatedMeal = foodRepository.save(meal);
        return ResponseEntity.ok(updatedMeal);
    }

    @DeleteMapping("/meals/{id}")
    public Map<String, Boolean> deleteMeal(@PathVariable(value="id") Long mealID) throws ResourceNotFoundException
    {
        Meal meal = foodRepository.findById(mealID)
                .orElseThrow(() -> new ResourceNotFoundException("Meal not found for this id : " + mealID));

        foodRepository.delete(meal);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Meal deleted", Boolean.TRUE);
        return response;
    }
}
