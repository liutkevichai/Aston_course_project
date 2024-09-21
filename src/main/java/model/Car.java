package model;

import java.util.Objects;

public class Car implements Comparable<Car> {
    @Override
    public int compareTo(Car o) {
        return this.year - o.year;
    }

    private String model;
    private int year;
    private int power;

    private Car(Builder builder) {
        this.model = builder.model;
        this.year = builder.year;
        this.power = builder.power;
    }

    public static class Builder {
        private String model;
        private int year;
        private int power;

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder year(int year) {
            this.year = year;
            return this;
        }

        public Builder power(int power) {
            this.power = power;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, year, power);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Car other = (Car) obj;
        return year == other.year && power == other.power && Objects.equals(model, other.model);
    }

    @Override
    public String toString() {
        return "Car{" +
                "model=" + model +
                ", year=" + year +
                ", power=" + power +
                "}";
    }

}

