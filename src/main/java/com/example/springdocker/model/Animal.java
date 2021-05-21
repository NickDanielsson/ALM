package com.example.springdocker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
    String id;
    String typeOfAnimal;
    String name;
    int numberOfLegs;


    public Animal(String name, String typeOfAnimal, int numberOfLegs) {
        this.name = name;
        this.typeOfAnimal = typeOfAnimal;
        this.numberOfLegs = numberOfLegs;

    }
}
