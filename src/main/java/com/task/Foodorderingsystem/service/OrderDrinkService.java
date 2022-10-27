package com.task.Foodorderingsystem.service;

import com.task.Foodorderingsystem.data.dto.request.OrderDrinkCreateRequest;
import com.task.Foodorderingsystem.data.dto.request.OrderDrinkUpdateRequest;
import com.task.Foodorderingsystem.data.dto.response.OrderDrinkResponse;

import java.util.List;

public interface OrderDrinkService {

    OrderDrinkResponse orderDrink(OrderDrinkCreateRequest createRequest);

    List<OrderDrinkResponse>getAllOrderDrinks();

    void deleteOneOrderDrink(Long orderId);

    OrderDrinkResponse getOneOrderDrink(Long orderId);

    OrderDrinkResponse updateOneOrderDrink(Long orderId, OrderDrinkUpdateRequest updateRequest);
}
