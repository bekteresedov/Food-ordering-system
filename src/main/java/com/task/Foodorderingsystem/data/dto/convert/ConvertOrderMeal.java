package com.task.Foodorderingsystem.data.dto.convert;

import com.task.Foodorderingsystem.data.dto.response.OrderMealResponse;
import com.task.Foodorderingsystem.data.entity.OrderMeal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ConvertOrderMeal {

    @Autowired
    ConvertMeal convertMeal;

    public OrderMealResponse convertDto(OrderMeal meal){

        return OrderMealResponse.builder()
                .id(meal.getId())
                .mealResponses(meal.getMeals().stream().map(
                        meal1 -> convertMeal.convertDto(meal1)
                ).collect(Collectors.toList()))
                .build();
    }
}
