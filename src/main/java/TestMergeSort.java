import model.Car;
import model.MergeSort;

import java.util.ArrayList;
import java.util.List;

public class TestMergeSort {
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();
        Car car = new Car.Builder()
                .model("lada vesta")
                .year(2010)
                .power(122)
                .build();
        Car car1 = new Car.Builder()
                .model("wolksvagen")
                .year(2009)
                .power(122)
                .build();
        Car car2 = new Car.Builder()
                .model("Toyota")
                .year(2013)
                .power(122)
                .build();
        Car car3 = new Car.Builder()
                .model("wolksvagen")
                .year(2000)
                .power(122)
                .build();

        MergeSort sort = new MergeSort();
        cars.add(car);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        System.out.println(sort.sortArray(cars));


    }
}
