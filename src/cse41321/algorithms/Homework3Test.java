package cse41321.algorithms;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Homework3Test {

    Homework3.Car[] cars = {
            new Homework3.Car("Toyota", "Camry", 33),
            new Homework3.Car("Ford", "Focus", 40),
            new Homework3.Car("Honda", "Accord", 34),
            new Homework3.Car("Ford", "Mustang", 31),
            new Homework3.Car("Honda", "Civic", 39),
            new Homework3.Car("Toyota", "Prius", 48),
            new Homework3.Car("Honda", "Fit", 35),
            new Homework3.Car("Toyota", "Corolla", 35),
            new Homework3.Car("Ford", "Taurus", 28)};

    @BeforeMethod
    public void setUp() {
    }

    @AfterMethod
    public void tearDown() {
    }

    @Test
    public void testTheToStringMethodOfTheCarClass() {
        Homework3.Car car = new Homework3.Car("Toyota", "RAV4", 26);
        assertEquals(car.toString(), "Car{make='Toyota', model='RAV4', mpg=26}");
    }

    @Test
    public void testQuickSortWithMakeThenModelComparator() {
        Homework3.QuickSort.quickSort(cars, new Homework3.CompareCarsByMakeThenModel());
        // After sorting, I'm checking only the first and last elements.
        assertEquals(cars[0].getModel(), "Focus");
        assertEquals(cars[cars.length - 1].getModel(), "Prius");
    }

    @Test
    public void testQuicksortWithDescendingMPGComparator() {
        Homework3.QuickSort.quickSort(cars, new Homework3.CompareCarsByDescendingMPG());
        // After sorting, I'm checking only the first and last elements.
        assertEquals(cars[0].getModel(), "Prius");
        assertEquals(cars[cars.length - 1].getModel(), "Taurus");
    }

    @Test
    public void testQuickSortWithMakeThenDescendingMPGComparator() {
        Homework3.QuickSort.quickSort(cars, new Homework3.CompareCarsByMakeThenDescendingMPG());
        // After sorting, I'm checking only the first and last elements.
        assertEquals(cars[0].getModel(), "Focus");
        assertEquals(cars[cars.length - 1].getModel(), "Camry");
    }
}