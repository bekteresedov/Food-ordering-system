package com.task.Foodorderingsystem.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.task.Foodorderingsystem.enums.CuisineType;
import com.task.Foodorderingsystem.enums.LunchType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Meal extends BaseEntity{


    @Enumerated(EnumType.STRING)
    LunchType lunchType;

    @Enumerated(EnumType.STRING)
    CuisineType cuisineType;


}
