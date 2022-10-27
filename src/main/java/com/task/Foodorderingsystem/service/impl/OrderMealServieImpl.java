package com.task.Foodorderingsystem.service.impl;

import com.task.Foodorderingsystem.data.dto.convert.ConvertMeal;
import com.task.Foodorderingsystem.data.dto.convert.ConvertOrderMeal;
import com.task.Foodorderingsystem.data.dto.request.OrderMealCreateRequest;
import com.task.Foodorderingsystem.data.dto.request.OrderMealUpdateRequest;
import com.task.Foodorderingsystem.data.dto.response.MealResponse;
import com.task.Foodorderingsystem.data.dto.response.OrderMealResponse;
import com.task.Foodorderingsystem.data.entity.Meal;
import com.task.Foodorderingsystem.data.entity.OrderMeal;
import com.task.Foodorderingsystem.data.repository.OrderMealRepository;
import com.task.Foodorderingsystem.exception.GenericException;
import com.task.Foodorderingsystem.service.MealService;
import com.task.Foodorderingsystem.service.OrderMealServcie;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Transactional
public class OrderMealServieImpl implements OrderMealServcie {

    final OrderMealRepository orderRepository;

    final MealService mealService;

    final ConvertMeal convertMeal;

    final ConvertOrderMeal convertOrderMeal;

    @Override
    public OrderMealResponse orderMeal(OrderMealCreateRequest createRequest) {

        List<MealResponse> mealResponses = createRequest.getMealId().stream().map(
                meal -> mealService.getOneMeal(meal)
        ).collect(Collectors.toList());

        List<Meal> meals = mealResponses.stream().map(
                mealResponse -> convertMeal.convertEntity(mealResponse)
        ).collect(Collectors.toList());

        OrderMeal orderMeal=new OrderMeal();
        orderMeal.setMeals(meals);
        OrderMeal save = orderRepository.save(orderMeal);
        return OrderMealResponse.builder()
                .id(save.getId())
                .mealResponses(save.getMeals().stream().map(
                        meal -> convertMeal.convertDto(meal)
                ).collect(Collectors.toList()))
                .build();
    }

    @Override
    public List<OrderMealResponse> getAllOrderMeals() {

        return  orderRepository.findAll().stream().map(
                meal -> convertOrderMeal.convertDto(meal)
        ).collect(Collectors.toList());

    }

    @Override
    public void deleteOneOrderMeal(Long orderId) {

        orderRepository.deleteById(orderId);
    }

    @Override
    public OrderMealResponse getOneOrderMeal(Long orderId) {

        Optional<OrderMeal> orderMeal = orderRepository.findById(orderId);
        if(orderMeal.isPresent())
        return convertOrderMeal.convertDto(orderMeal.get());
        throw new GenericException(HttpStatus.NOT_FOUND,"Can not find OrderMeal with given id");
    }

    @Override
    public OrderMealResponse updateOneOrderMeal(Long orderId, OrderMealUpdateRequest updateRequest) {

        Optional<OrderMeal> orderMeal = orderRepository.findById(orderId);
        if(orderMeal.isPresent()){
            OrderMeal foundOrderMeal = orderMeal.get();
            List<Meal> meals = updateRequest.getMealId().stream().map(
                    id -> convertMeal.convertEntity(mealService.getOneMeal(id))
            ).collect(Collectors.toList());
            foundOrderMeal.setMeals(meals);
            return convertOrderMeal.convertDto(orderRepository.save(foundOrderMeal));
        }

        throw new GenericException(HttpStatus.NOT_FOUND,"Can not find OrderMeal with given id");
    }
}
