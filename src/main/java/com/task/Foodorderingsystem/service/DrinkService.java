package com.task.Foodorderingsystem.service;

import com.task.Foodorderingsystem.data.dto.request.DrinkCreateRequest;
import com.task.Foodorderingsystem.data.dto.request.DrinkUpdateRequest;
import com.task.Foodorderingsystem.data.dto.response.DrinkResponse;
import com.task.Foodorderingsystem.enums.DrinkType;

import java.util.List;

public interface DrinkService {

    DrinkResponse createOneDrink(DrinkCreateRequest createRequest);

    List<DrinkResponse>getAllDrinks();

    List<DrinkResponse>getDrinkType(DrinkType drinkType);

    void deleteOneDrink(Long drinkId);

    DrinkResponse updateOneDrink(Long drinkId, DrinkUpdateRequest drinkUpdate);

    DrinkResponse getOneDrink(Long drinkId);
}
