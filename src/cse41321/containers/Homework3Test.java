package cse41321.containers;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Homework3Test {
    @Test
    public void testTheToStringMethodOfTheCarClass() {
        Homework3.Car car = new Homework3.Car("Toyota", "RAV4", 26);
        assertEquals(car.toString(), "Car{make='Toyota', model='RAV4', mpg=26}");
    }
}