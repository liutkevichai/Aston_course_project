package Comparator;

import model.Car;

import java.util.Comparator;

public class CarComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return Comparator.comparing(Car::getModel)
                .thenComparingInt(Car::getYear)
                .thenComparingInt(Car::getPower)
                .compare(o1, o2);

    }
}