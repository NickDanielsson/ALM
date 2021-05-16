package com.example.springdocker.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/*
Junit Lifecycle
● @BeforeEach
● @BeforeAll
○ måste vara ‘static’
● @AfterEach
● @AfterAll
○ måste vara ‘static’
  Dessa brukar användas för att initiera klassens ‘dependencies’.
*/

class MyMathCalcTest {

    MyMathCalc m;

    @BeforeEach
    public void beforeEach(){
        m = new MyMathCalc();
    }

    @Test
    @DisplayName("Testing add method")
    void add() {
        int first = 2;
        int second = 4;
        int result = m.add(first,second);
        assertEquals(6,result);
    }

    @Test
    @DisplayName("Testing multiply method")
    void multiply() {
        int expected = 10;
        int actual = m.multiply(2,5);
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Testing divide method")
    void divide() {
        double expected = 2;
        double actual = m.divide(6,3);
        assertEquals(expected,actual);
    }

     @Test
     @DisplayName("Testing divide method exception")
    void divideThrows(){
        assertThrows(ArithmeticException.class,() -> m.divide(0,6));
        assertThrows(ArithmeticException.class,() -> m.divide(0,0));
        assertThrows(ArithmeticException.class,() -> m.divide(20,0));
     }
}