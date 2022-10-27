package com.task.Foodorderingsystem.data.dto.convert;

import com.task.Foodorderingsystem.data.dto.response.OrderDrinkResponse;
import com.task.Foodorderingsystem.data.entity.OrderDrink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ConvertOrderDrink {

    @Autowired
     ConvertDrink convertDrink;

    public OrderDrinkResponse convertDto(OrderDrink order){
     return OrderDrinkResponse.builder()
             .id(order.getId())
             .otherType(order.getOtherType())
             .drinkResponse(order.getDrink().stream().map(
                     drink -> convertDrink.convertDto(drink)
             ).collect(Collectors.toList()))
             .build();
    }
}
