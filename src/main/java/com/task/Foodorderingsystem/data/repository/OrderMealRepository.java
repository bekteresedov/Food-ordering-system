package com.task.Foodorderingsystem.data.repository;

import com.task.Foodorderingsystem.data.entity.OrderMeal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMealRepository extends JpaRepository<OrderMeal,Long> {
}
