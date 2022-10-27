package com.task.Foodorderingsystem.service.impl;

import com.task.Foodorderingsystem.data.dto.convert.ConvertDrink;
import com.task.Foodorderingsystem.data.dto.request.DrinkCreateRequest;
import com.task.Foodorderingsystem.data.dto.request.DrinkUpdateRequest;
import com.task.Foodorderingsystem.data.dto.response.DrinkResponse;
import com.task.Foodorderingsystem.data.entity.Drink;
import com.task.Foodorderingsystem.data.repository.DrinkRepository;
import com.task.Foodorderingsystem.enums.DrinkType;
import com.task.Foodorderingsystem.exception.GenericException;
import com.task.Foodorderingsystem.service.DrinkService;
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
public class DrinkServiceImpl implements DrinkService {

    final DrinkRepository drinkRepository;
    final ConvertDrink convertDrink;


    @Override
    public DrinkResponse createOneDrink(DrinkCreateRequest createRequest) {

        Drink drink=drinkRepository.save(convertDrink.convertEntity(createRequest));
        return convertDrink.convertDto(drink);
    }

    @Override
    public List<DrinkResponse> getAllDrinks() {

        return drinkRepository.findAll().stream().map(
                convertDrink::convertDto
        ).collect(Collectors.toList());
    }

    @Override
    public List<DrinkResponse> getDrinkType(DrinkType drinkType) {
        Optional<List<Drink>> drink = drinkRepository.findByDrinkType(drinkType);
        if(drink.get().size()==0)
            throw new  GenericException(HttpStatus.NOT_FOUND,"Can not find Drink with given DrinkType");
        return drink.get().stream().map(
                convertDrink::convertDto
        ).collect(Collectors.toList());
    }

    @Override
    public void deleteOneDrink(Long drinkId) {
        drinkRepository.deleteById(drinkId);
    }

    @Override
    public DrinkResponse updateOneDrink(Long drinkId, DrinkUpdateRequest drinkUpdate) {
        Optional<Drink> drink = drinkRepository.findById(drinkId);
        if (drink.isPresent()){
            Drink foundDrink = drink.get();
            foundDrink.setDrinkType(drinkUpdate.getDrinkType());
            foundDrink.setName(drinkUpdate.getName());
            foundDrink.setPrice(foundDrink.getPrice());

            return convertDrink.convertDto( drinkRepository.save(foundDrink));
        }
       throw new GenericException(HttpStatus.NOT_FOUND,"Can not find Drink with given id");
    }

    @Override
    public DrinkResponse getOneDrink(Long drinkId) {
        Optional<Drink> drink = drinkRepository.findById(drinkId);
        if (drink.isPresent())
            return convertDrink.convertDto(drink.get());
        throw new GenericException(HttpStatus.NOT_FOUND,"Can not find Drink with given id");
    }

    ;
    }

