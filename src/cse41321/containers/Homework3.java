package cse41321.containers;

import java.util.Comparator;

public class Homework3 {


    static class Car {
        private String make;
        private String model;
        private int mpg; // Miles per gallon

        public Car(String make, String model, int mpg) {
            this.make = make;
            this.model = model;
            this.mpg = mpg;
        }

        public String getMake() {
            return make;
        }

        public void setMake(String make) {
            this.make = make;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public int getMpg() {
            return mpg;
        }

        public void setMpg(int mpg) {
            this.mpg = mpg;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "make='" + make + '\'' +
                    ", model='" + model + '\'' +
                    ", mpg=" + mpg +
                    '}';
        }
    }

    static class CompareCarsByMakeThenModel implements Comparator<Car> {
        @Override
        public int compare(Car thisCar, Car anotherCar) {
            if (thisCar.getMake().compareTo(anotherCar.getMake()) != 0) {
                return thisCar.getMake().compareTo(anotherCar.getMake());
            } else {
                return thisCar.getModel().compareTo(anotherCar.getModel());
            }
        }
    }

    static class CompareCarsByDescendingMPG implements Comparator<Car> {
        @Override
        public int compare(Car thisCar, Car anotherCar) {
            return Integer.compare(thisCar.getMpg(),anotherCar.getMpg());
        }
    }

    static class CompareCarsByMakeThenDescendingMPG implements Comparator<Car> {
        @Override
        public int compare(Car thisCar, Car anotherCar) {
            return 0;
        }
    }

    public static void main(String[] arguments) {

    }
}
