package com.task.Foodorderingsystem.data.entity;

import com.task.Foodorderingsystem.enums.CuisineType;
import com.task.Foodorderingsystem.enums.LunchType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    Double price;




}
