package com.task.Foodorderingsystem.service.impl;

import com.task.Foodorderingsystem.data.dto.convert.ConvertMeal;
import com.task.Foodorderingsystem.data.dto.request.MealCreateRequest;
import com.task.Foodorderingsystem.data.dto.request.MealUpdateRequest;
import com.task.Foodorderingsystem.data.dto.response.MealResponse;
import com.task.Foodorderingsystem.data.entity.Meal;
import com.task.Foodorderingsystem.data.repository.MealRepository;
import com.task.Foodorderingsystem.enums.CuisineType;
import com.task.Foodorderingsystem.enums.LunchType;
import com.task.Foodorderingsystem.exception.GenericException;
import com.task.Foodorderingsystem.service.MealService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class MealServiceImpl implements MealService {

    final MealRepository mealRepository;
    final ConvertMeal convertMeal;


    @Override
    public MealResponse createOneMeal(MealCreateRequest createRequest) {
        Meal meal = convertMeal.convertEntity(createRequest);
        return convertMeal.convertDto(mealRepository.save(meal));
    }

    @Override
    public List<MealResponse> getAllMeals() {

        return mealRepository.findAll().stream().map(
               convertMeal::convertDto
        ).collect(Collectors.toList());
    }

    @Override
    public List<MealResponse> getCuisineType(CuisineType cuisineType) {
        Optional<List<Meal>> meal = mealRepository.findByCuisineType(cuisineType);

        if(meal.get().size()==0)
            throw new  GenericException(HttpStatus.NOT_FOUND,"Can not find Drink with given CuisineType");
        return meal.get().stream().map(
                convertMeal::convertDto
        ).collect(Collectors.toList());
    }

    @Override
    public List<MealResponse> getLunchType(LunchType lunchType) {
        Optional<List<Meal>> meal = mealRepository.findByLunchType(lunchType);

        if(meal.get().size()==0)
            throw new  GenericException(HttpStatus.NOT_FOUND,"Can not find Drink with given LunchType");
        return meal.get().stream().map(
                convertMeal::convertDto
        ).collect(Collectors.toList());
    }


    @Override
    public void deleteOneMeal(Long mealId) {

        mealRepository.deleteById(mealId);
    }

    @Override
    public MealResponse getOneMeal(Long mealId) {

        Optional<Meal> meal = mealRepository.findById(mealId);
        if (meal.isPresent())
            return convertMeal.convertDto(meal.get());
         throw new GenericException(HttpStatus.NOT_FOUND,"Can not find Meal with given id");
    }

    @Override
    public MealResponse updateOneMeal(Long mealId, MealUpdateRequest updateRequest) {

        Optional<Meal> meal = mealRepository.findById(mealId);
        if(meal.isPresent()){
            Meal foundMeal = meal.get();
            foundMeal.setName(updateRequest.getName());
            foundMeal.setPrice(updateRequest.getPrice());
            foundMeal.setCuisineType(updateRequest.getCuisineType());
            foundMeal.setLunchType(updateRequest.getLunchType());
            return convertMeal.convertDto(mealRepository.save(foundMeal));
        }
        throw new GenericException(HttpStatus.NOT_FOUND,"Can not find Meal with given id");
    }
}
