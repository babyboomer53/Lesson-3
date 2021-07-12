package cse41321.containers;

import java.util.Comparator;
import java.util.Random;

public class Homework3 {

    static class QuickSort {
        public static <T> void quickSort(T[] array, Comparator<? super T> comparator) {
            quickSortRecursive(array, 0, array.length - 1, comparator);
        }

        /**
         * @param array
         * @param i
         * @param k
         * @param comparator
         * @param <T>
         */
        private static <T> void quickSortRecursive(T[] array, int i, int k, Comparator<? super T> comparator) {
            // Stop the recursion when it is not possible to partition further
            if (i >= k) {
                return;
            }

            // Determine where to partition the elements
            int j = partition(array, i, k, comparator);

            // Sort the left partition
            quickSortRecursive(array, i, j, comparator);

            // Sort the right partition
            quickSortRecursive(array, j + 1, k, comparator);
        }

        private static <T> int partition(T[] array, int i, int k, Comparator<? super T> comparator) {

            // Use the median-of-three method to find the partition value
            T p = medianOfThree(array, i, k, comparator);

            // Create two partitions around the partition value
            --i;
            ++k;
            while (true) {
                // Move left until an element is found in the wrong partition
                do {
                    --k;
                } while (comparator.compare(array[k], p) > 0);

                // Move right until an element is found in the wrong partition
                do {
                    ++i;
                } while (comparator.compare(array[i], p) < 0);

                if (i >= k) {
                    // Stop partitioning when the left and right indices cross
                    break;
                } else {
                    // Swap the elements at the indices
                    T temp = array[i];
                    array[i] = array[k];
                    array[k] = temp;
                }
            }

            return k;
        }

        private static <T> T medianOfThree(T[] array, int i, int k, Comparator<? super T> comparator) {

            // Get 3 random values from the array
            Random random = new Random();
            T a = array[random.nextInt(k - i + 1) + i];
            T b = array[random.nextInt(k - i + 1) + i];
            T c = array[random.nextInt(k - i + 1) + i];

            // Return the median of the 3 values
            if (comparator.compare(a, b) > 0) {             // a > b
                if (comparator.compare(b, c) > 0) {         // a > b > c
                    return b;
                } else if (comparator.compare(a, c) > 0) {  // a > c > b
                    return c;
                } else {                                    // c > a > b
                    return a;
                }
            } else {                                        // b > a
                if (comparator.compare(a, c) > 0) {         // b > a > c
                    return a;
                } else if (comparator.compare(b, c) > 0) {  // b > c > a
                    return c;
                } else {                                    // c > b > a
                    return b;
                }
            }
        }
    }

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
        public int compare(Car thisCar, Car thatCar) {
            if (thisCar.getMake().compareTo(thatCar.getMake()) != 0) {
                return thisCar.getMake().compareTo(thatCar.getMake());
            } else {
                return thisCar.getModel().compareTo(thatCar.getModel());
            }
        }
    }

    static class CompareCarsByDescendingMPG implements Comparator<Car> {
        @Override
        public int compare(Car thisCar, Car thatCar) {
            return -Integer.compare(thisCar.getMpg(), thatCar.getMpg());
        }
    }

    static class CompareCarsByMakeThenDescendingMPG implements Comparator<Car> {
        @Override
        public int compare(Car thisCar, Car thatCar) {
            if (thisCar.getMake().compareTo(thatCar.getMake()) != 0) {
                return thisCar.getMake().compareTo(thatCar.getMake());
            } else {
                return new CompareCarsByDescendingMPG().compare(thisCar, thatCar);
            }
        }
    }

    public static void main(String[] arguments) {
        Car[] cars = {
                new Car("Toyota", "Camry", 33),
                new Car("Ford", "Focus", 40),
                new Car("Honda", "Accord", 34),
                new Car("Ford", "Mustang", 31),
                new Car("Honda", "Civic", 39),
                new Car("Toyota", "Prius", 48),
                new Car("Honda", "Fit", 35),
                new Car("Toyota", "Corolla", 35),
                new Car("Ford", "Taurus", 28)};

        System.out.println("\nHere is the list of cars in the original order…\n");
        for (Car car : cars) {
            System.out.println(car);
        }

        QuickSort.quickSort(cars, new CompareCarsByMakeThenModel());
        System.out.println("\nAfter sorting by make then Model…\n");
        for (Car car : cars) {
            System.out.println(car);
        }

        QuickSort.quickSort(cars, new CompareCarsByDescendingMPG());
        System.out.println("\nAfter sorting by descending MPG…\n");
        for (Car car : cars) {
            System.out.println(car);
        }

        QuickSort.quickSort(cars, new CompareCarsByMakeThenDescendingMPG());
        System.out.println("\nAfter sorting by make then descending MPG…\n");
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
