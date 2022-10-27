package com.task.Foodorderingsystem.service.impl;

import com.task.Foodorderingsystem.data.dto.convert.ConvertDrink;
import com.task.Foodorderingsystem.data.dto.convert.ConvertOrderDrink;
import com.task.Foodorderingsystem.data.dto.request.OrderDrinkCreateRequest;
import com.task.Foodorderingsystem.data.dto.request.OrderDrinkUpdateRequest;
import com.task.Foodorderingsystem.data.dto.response.DrinkResponse;
import com.task.Foodorderingsystem.data.dto.response.OrderDrinkResponse;
import com.task.Foodorderingsystem.data.entity.Drink;
import com.task.Foodorderingsystem.data.entity.OrderDrink;
import com.task.Foodorderingsystem.data.repository.OrderDrinkRepository;
import com.task.Foodorderingsystem.exception.GenericException;
import com.task.Foodorderingsystem.service.DrinkService;
import com.task.Foodorderingsystem.service.OrderDrinkService;
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
public class OrderDrinkServiceImpl implements OrderDrinkService {
    
    final OrderDrinkRepository orderRepository;
    final DrinkService drinkService;
    final ConvertDrink convertDrink;
    final ConvertOrderDrink convertOrderDrink;


    @Override
    public OrderDrinkResponse orderDrink(OrderDrinkCreateRequest createRequest) {
        List<DrinkResponse> drinkResponses = createRequest.getDrinkId().stream().map(
                drink -> drinkService.getOneDrink(drink)
        ).collect(Collectors.toList());

        List<Drink> drinks = drinkResponses.stream().map(
                drink -> convertDrink.convertEntity(drink)
        ).collect(Collectors.toList());
        OrderDrink order=new OrderDrink();
        order.setDrink(drinks);
        order.setOtherType(createRequest.getOtherType());
        OrderDrink save = orderRepository.save(order);
        return OrderDrinkResponse.builder()
                .drinkResponse(save.getDrink().stream().map(
                        drink -> convertDrink.convertDto(drink)
                ).collect(Collectors.toList()))
                .id(save.getId())
                .otherType(save.getOtherType())
                .build();
    }

    @Override
    public List<OrderDrinkResponse> getAllOrderDrinks() {

        return  orderRepository.findAll().stream().map(
                e->convertOrderDrink.convertDto(e)
        ).collect(Collectors.toList());
    }

    @Override
    public void deleteOneOrderDrink(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public OrderDrinkResponse getOneOrderDrink(Long orderId) {

        Optional<OrderDrink> order = orderRepository.findById(orderId);
        if (order.isPresent())
            return convertOrderDrink.convertDto(order.get());
        throw new GenericException(HttpStatus.NOT_FOUND,"Can not find OrderDrink with given id");
    }

    @Override
    public OrderDrinkResponse updateOneOrderDrink(Long orderId, OrderDrinkUpdateRequest updateRequest) {
        Optional<OrderDrink> order = orderRepository.findById(orderId);
        if (order.isPresent()){
            OrderDrink foundOrder=order.get();
            foundOrder.setOtherType(updateRequest.getOtherType());
            List<Drink> drinks = updateRequest.getDrinkId().stream().map(
                    drink -> convertDrink.convertEntity(drinkService.getOneDrink(drink))
            ).collect(Collectors.toList());
            foundOrder.setDrink(drinks);

            return convertOrderDrink.convertDto(orderRepository.save(foundOrder));
        }

        throw new GenericException(HttpStatus.NOT_FOUND,"Can not find OrderDrink with given id");
    }


}
