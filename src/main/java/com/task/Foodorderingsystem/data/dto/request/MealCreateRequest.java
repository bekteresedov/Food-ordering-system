package com.task.Foodorderingsystem.data.dto.request;

import com.task.Foodorderingsystem.enums.CuisineType;
import com.task.Foodorderingsystem.enums.LunchType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class MealCreateRequest {


    String name;

    Double price;

    CuisineType cuisineType;

    LunchType lunchType;
}
