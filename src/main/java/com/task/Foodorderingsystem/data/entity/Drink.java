package com.task.Foodorderingsystem.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.task.Foodorderingsystem.enums.CuisineType;
import com.task.Foodorderingsystem.enums.DrinkType;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Drink extends BaseEntity{

    @Enumerated(EnumType.STRING)
    DrinkType drinkType;

}
