package com.task.Foodorderingsystem;

import com.task.Foodorderingsystem.data.dto.request.*;
import com.task.Foodorderingsystem.data.entity.Meal;
import com.task.Foodorderingsystem.enums.CuisineType;
import com.task.Foodorderingsystem.enums.DrinkType;
import com.task.Foodorderingsystem.enums.LunchType;
import com.task.Foodorderingsystem.enums.OtherType;
import com.task.Foodorderingsystem.service.DrinkService;
import com.task.Foodorderingsystem.service.MealService;
import com.task.Foodorderingsystem.service.OrderDrinkService;
import com.task.Foodorderingsystem.service.OrderMealServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class FoodOrderingSystemApplication {

	@Autowired
	OrderDrinkService orderService1	;
	@Autowired
	OrderMealServcie orderService;
	@Autowired
	DrinkService drinkService;
	@Autowired
	MealService mealService;


	public static void main(String[] args) {
		SpringApplication.run(FoodOrderingSystemApplication.class, args);
	}



	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {

//			MealCreateRequest build = MealCreateRequest.builder()
//					.name("Dolma")
//					.price(4.3)
//					.cuisineType(CuisineType.POLISH)
//					.lunchType(LunchType.MAIN)
//					.build();
//			System.err.println(mealService.createOneMeal(build));

//			OrderMealUpdateRequest build = OrderMealUpdateRequest.builder().mealId(List.of(1l)).build();
//			orderService.updateOneOrderMeal(5l,build);

			orderService.deleteOneOrderMeal(5L);
			System.err.println(orderService.getAllOrderMeals());

		};}}