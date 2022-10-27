package com.task.Foodorderingsystem.data.dto.response;

import com.task.Foodorderingsystem.enums.OtherType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDrinkResponse {

    Long id;

    List<DrinkResponse> drinkResponse;

    OtherType otherType;
}
