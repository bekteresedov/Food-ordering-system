package com.task.Foodorderingsystem.data.dto.request;

import com.task.Foodorderingsystem.enums.DrinkType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class DrinkUpdateRequest {

    String name;

    Double price;

    DrinkType drinkType;
}
