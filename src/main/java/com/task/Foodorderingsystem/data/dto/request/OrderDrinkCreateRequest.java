package com.task.Foodorderingsystem.data.dto.request;

import com.task.Foodorderingsystem.enums.OtherType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class OrderDrinkCreateRequest {

   List<Long> drinkId;

    OtherType otherType;


}
