package com.example.springdocker.controller;

import com.example.springdocker.model.Animal;
import com.example.springdocker.model.Food;
import com.example.springdocker.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class AnimalController {
    private final AnimalService service;

    @GetMapping("/animals")
    public List<Animal> getAllAnimals() {
        return service.getAnimals();
    }

    @PostMapping("/foods")
    public void saveNewFood(@RequestBody Animal animal) {
        service.saveNewAnimal(animal);
    }


    @GetMapping("/animals/hasfourlegs")
    public List<String> getAnimalsWithFourLegs() {
        return service.getAnimalWithFourLegs();
    }
}
