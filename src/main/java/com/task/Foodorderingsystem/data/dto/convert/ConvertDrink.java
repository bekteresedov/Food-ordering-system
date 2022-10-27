package com.task.Foodorderingsystem.data.dto.convert;

import com.task.Foodorderingsystem.data.dto.request.DrinkCreateRequest;
import com.task.Foodorderingsystem.data.dto.request.DrinkUpdateRequest;
import com.task.Foodorderingsystem.data.dto.response.DrinkResponse;
import com.task.Foodorderingsystem.data.entity.Drink;
import org.springframework.stereotype.Component;

@Component
public class ConvertDrink {

    public Drink convertEntity(DrinkCreateRequest request){
        Drink drink=new Drink();
        drink.setName(request.getName());
        drink.setPrice(request.getPrice());
        drink.setDrinkType(request.getDrinkType());
        return drink;
    }

    public DrinkResponse convertDto(Drink drink){
        return DrinkResponse
                .builder()
                .id(drink.getId())
                .name(drink.getName())
                .price(drink.getPrice())
                .drinkType(drink.getDrinkType())
                .build();

    }

    public Drink convertEntity(DrinkResponse response){
        Drink drink=new Drink();
        drink.setId(response.getId());
        drink.setName(response.getName());
        drink.setPrice(response.getPrice());
        drink.setDrinkType(response.getDrinkType());
        return drink;
    }
}
