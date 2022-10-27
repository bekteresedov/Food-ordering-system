package com.task.Foodorderingsystem.data.entity;

import com.task.Foodorderingsystem.enums.OtherType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "orderDrink")
public class OrderDrink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    List<Drink> drink;

    @Enumerated(EnumType.STRING)
    OtherType otherType;

}
