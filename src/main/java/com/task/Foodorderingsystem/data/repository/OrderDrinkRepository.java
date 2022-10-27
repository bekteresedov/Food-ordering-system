package com.task.Foodorderingsystem.data.repository;

import com.task.Foodorderingsystem.data.entity.OrderDrink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDrinkRepository extends JpaRepository<OrderDrink,Long> {
}
