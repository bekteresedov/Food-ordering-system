package com.task.Foodorderingsystem.service;

import com.task.Foodorderingsystem.data.dto.request.MealCreateRequest;
import com.task.Foodorderingsystem.data.dto.request.MealUpdateRequest;
import com.task.Foodorderingsystem.data.dto.response.MealResponse;
import com.task.Foodorderingsystem.enums.CuisineType;
import com.task.Foodorderingsystem.enums.LunchType;

import java.util.List;

public interface MealService {

    MealResponse createOneMeal(MealCreateRequest createRequest);

    List<MealResponse>getAllMeals();

    List<MealResponse>getCuisineType(CuisineType cuisineType);

    List<MealResponse>getLunchType(LunchType lunchType);

    void deleteOneMeal(Long mealId);

    MealResponse getOneMeal(Long mealId);

    MealResponse updateOneMeal(Long mealId, MealUpdateRequest updateRequest);

}
