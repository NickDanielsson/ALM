package com.example.springdocker.service;

import com.example.springdocker.model.Food;
import com.example.springdocker.repository.FoodRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// @DataMongoTest
@ExtendWith(MockitoExtension.class)
class FoodServiceTest {

    FoodService foodService;

    @Mock
    FoodRepository mockRepository;

    @BeforeEach
    void init(){
        foodService = new FoodService(mockRepository);


    }


    @Test
    void getCookableFoods() {
        Food mockFood1 = new Food("test1","testname",true,true);
        Food mockFood2 = new Food("test2","testname2",false,false);
        List<Food> testFood = new ArrayList<>();
        testFood.add(mockFood1);
        testFood.add(mockFood2);


        List<Food> actualCookable = testFood.stream().filter(Food::isCanICookIt).collect(Collectors.toList());
        System.out.println(actualCookable);
        when(mockRepository.findFoodByCanICookIt(true)).thenReturn(actualCookable);

        assertEquals(actualCookable.stream().map(Food::getName).collect(Collectors.toList()),foodService.getCookableFoods() );

    }
}