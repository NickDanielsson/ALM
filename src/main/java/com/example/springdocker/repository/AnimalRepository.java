package com.example.springdocker.repository;

import com.example.springdocker.model.Animal;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AnimalRepository  extends MongoRepository <Animal, String> {

    List<Animal> findAnimalByHasFourLegs(boolean hasFourLegs);
}
