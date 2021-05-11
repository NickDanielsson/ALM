package com.example.springdocker.service;

import com.example.springdocker.model.Animal;
import com.example.springdocker.model.Food;
import com.example.springdocker.repository.AnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AnimalService {
    private final AnimalRepository animalRepository;

    public List<Animal> getAnimals() {
        return animalRepository.findAll();
    }

    public void saveNewAnimal(Animal animal) {
        animalRepository.save(animal);
    }

    public List<String> getAnimalWithFourLegs() {
        List<Animal> animalList = animalRepository.findAnimalByHasFourLegs(true);

        return animalList.stream().map(Animal::getName).collect(Collectors.toList());
    }
}
