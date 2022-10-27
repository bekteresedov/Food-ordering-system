package com.task.Foodorderingsystem.data.repository;

import com.task.Foodorderingsystem.data.entity.Meal;
import com.task.Foodorderingsystem.enums.CuisineType;
import com.task.Foodorderingsystem.enums.LunchType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MealRepository extends JpaRepository<Meal,Long> {

    Optional<List<Meal>>findByLunchType(LunchType lunchType);

    Optional<List<Meal>>findByCuisineType(CuisineType cuisineType);
}
