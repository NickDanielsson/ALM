package com.example.springdocker.service;

import com.example.springdocker.model.Animal;
import com.example.springdocker.repository.AnimalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class AnimalServiceTest {

    AnimalService animalService;

    @Mock
    AnimalRepository mockRepository;

    @BeforeEach
    void init() {
    animalService = new AnimalService(mockRepository);
    }

    @Test
    @DisplayName("Get all list of animals")
    void getAnimals() {
        Animal a = new Animal("Leo","Cat",4);
        animalService.saveNewAnimal(a);
        String expectedName = "Leo";
        int expectedNumberOfLegs = 4;

        when(mockRepository.findAll())
                .thenReturn(Arrays.asList(a));

        List<Animal> actual = animalService.getAnimals();

        assertEquals(expectedNumberOfLegs,actual.get(0).getNumberOfLegs());
        assertEquals(expectedName,actual.get(0).getName());
        assertEquals(1,actual.size());
        verify(mockRepository).findAll();
    }

    @Test
    @DisplayName("Saving a animal to db")
    void saveNewAnimal() {
        Animal a = new Animal("Fido","Dog",4);
        String expectedName = "Fido";
        int expectedNrOfLegs = 4;

        Animal a2 = new Animal("Leo","Cat",4);
       // animalService.saveNewAnimal(a);
        String expectedName2 = "Leo";
        int expectedNumberOfLegs2 = 4;

        when(mockRepository.save(a))
                .thenReturn(a);

        Animal actual = animalService.saveNewAnimal(a);



    }

    @Test
    @DisplayName("Finding an animal by name")
    void findByName() {
    }
}