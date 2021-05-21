package com.example.springdocker.repository;

import com.example.springdocker.model.Animal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository  extends MongoRepository <Animal, String> {

   // List<Animal> findAnimalByHasFourLegs(boolean hasFourLegs);
    List<Animal> findAnimalByNumberOfLegsGreaterThanEqual(int numberOfLegs);
    Animal findAnimalByName(String name);
}
