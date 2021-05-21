package com.example.springdocker.controller;

import com.example.springdocker.model.Animal;
import com.example.springdocker.model.Food;
import com.example.springdocker.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class AnimalController {
    private final AnimalService service;

    @GetMapping("/animals")
    public List<Animal> getAllAnimals() {
        return service.getAnimals();
    }

    @GetMapping("/add")
    public String saveNewFood(@RequestParam String name,@RequestParam String typeOfAnimal, @RequestParam int numberOfLegs) {
       Animal animal = new Animal(name,typeOfAnimal,numberOfLegs);
        service.saveNewAnimal(animal);
        return "Djuret " + name + " lades till!";
    }

/*
    @GetMapping("/animals/hasfourlegs")
    public List<String> getAnimalsWithFourLegs() {
        return service.getAnimalWithFourLegs();
    }*/

    @GetMapping("/")
    public String hello(){
        return "Hello";
    }
}
