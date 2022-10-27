package com.task.Foodorderingsystem.data.dto.convert;

import com.task.Foodorderingsystem.data.dto.request.MealCreateRequest;
import com.task.Foodorderingsystem.data.dto.response.MealResponse;
import com.task.Foodorderingsystem.data.entity.Meal;
import org.springframework.stereotype.Component;

@Component
public class ConvertMeal {

    public Meal convertEntity(MealCreateRequest request){
        Meal meal=new Meal();
        meal.setName(request.getName());
        meal.setPrice(request.getPrice());
        meal.setLunchType(request.getLunchType());
        meal.setCuisineType(request.getCuisineType());
        return meal;
    }

    public MealResponse convertDto(Meal meal){
        return MealResponse.builder()
                .id(meal.getId())
                .name(meal.getName())
                .price(meal.getPrice())
                .cuisineType(meal.getCuisineType())
                .lunchType(meal.getLunchType())
                .build();
    }

    public Meal convertEntity(MealResponse response){
        Meal meal=new Meal();
        meal.setId(meal.getId());
        meal.setName(response.getName());
        meal.setPrice(response.getPrice());
        meal.setLunchType(response.getLunchType());
        meal.setCuisineType(response.getCuisineType());
        return meal;
    }
}
