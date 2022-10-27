package com.task.Foodorderingsystem.data.repository;

import com.task.Foodorderingsystem.data.entity.Drink;
import com.task.Foodorderingsystem.enums.DrinkType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DrinkRepository extends JpaRepository<Drink,Long> {

   Optional< List<Drink>>findByDrinkType(DrinkType drinkType);
}
