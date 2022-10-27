package com.task.Foodorderingsystem.data.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class OrderMealResponse {

    Long id;

    List<MealResponse>mealResponses;
}
