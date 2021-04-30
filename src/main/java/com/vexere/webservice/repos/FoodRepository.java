package com.vexere.webservice.repos;

import com.vexere.webservice.models.food.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Meal, Long>
{
}
