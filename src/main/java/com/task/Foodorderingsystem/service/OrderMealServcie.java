package com.task.Foodorderingsystem.service;

import com.task.Foodorderingsystem.data.dto.request.OrderMealCreateRequest;
import com.task.Foodorderingsystem.data.dto.request.OrderMealUpdateRequest;
import com.task.Foodorderingsystem.data.dto.response.OrderMealResponse;

import java.util.List;

public interface OrderMealServcie {

    OrderMealResponse orderMeal(OrderMealCreateRequest createRequest);

    List<OrderMealResponse>getAllOrderMeals();

    void deleteOneOrderMeal(Long orderId);

    OrderMealResponse getOneOrderMeal(Long orderId);

    OrderMealResponse updateOneOrderMeal(Long orderId, OrderMealUpdateRequest updateRequest);
}
