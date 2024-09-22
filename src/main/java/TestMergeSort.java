import model.Car;
import algorithms.Sorting;
import model.CarComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestMergeSort {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        Car car = new Car.Builder()
                .model("lada vesta1111")
                .year(2010)
                .power(122)
                .build();
        Car car1 = new Car.Builder()
                .model("volkswagen")
                .year(2009)
                .power(122)
                .build();
        Car car2 = new Car.Builder()
                .model("Toyota")
                .year(2013)
                .power(122)
                .build();
        Car car3 = new Car.Builder()
                .model("volkswagen")
                .year(2000)
                .power(122)
                .build();

        cars.add(car);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        System.out.println(cars);

        Sorting.mergeSort(cars, new CarComparator());
        System.out.println(cars);


    }
}
