package models;

import java.io.Serializable;
import java.util.Objects;

/**
 * Represents an immutable car with a model, year, and power.
 * The class implements {@link Comparable} to allow comparisons between cars and {@link HasNumField} to
 * expose a numeric field for sorting or other operations.
 */
public final class Car implements Comparable<Car>, HasNumField<Car>, Serializable {
    private final String model;
    private final int year;
    private final int power;

    /**
     * Private constructor to create a Car instance using the {@link Builder}.
     *
     * @param builder the builder used to set the car's fields
     */
    private Car(Builder builder) {
        this.model = builder.model != null ? builder.model : "empty";
        this.year = builder.year;
        this.power = builder.power;
    }

    /**
     * Builder for constructing instances of {@link Car}.
     */
    public static class Builder {
        private String model;
        private int year;
        private int power;

        /**
         * Sets the model of the car.
         *
         * @param model the model name
         * @return the builder itself for method chaining
         */
        public Builder model(String model) {
            this.model = model;
            return this;
        }

        /**
         * Sets the year of manufacture of the car.
         *
         * @param year the year of manufacture
         * @return the builder itself for method chaining
         */
        public Builder year(int year) {
            this.year = year;
            return this;
        }

        /**
         * Sets the engine power of the car.
         *
         * @param power the engine power in horsepower
         * @return the builder itself for method chaining
         */
        public Builder power(int power) {
            this.power = power;
            return this;
        }

        /**
         * Builds and returns a new {@link Car} instance.
         *
         * @return the constructed {@link Car} object
         */
        public Car build() {
            return new Car(this);
        }
    }

    /**
     * Returns the model of the car.
     *
     * @return the car's model
     */
    public String getModel() {
        return model;
    }

    /**
     * Returns the year of manufacture of the car.
     *
     * @return the car's year
     */
    public int getYear() {
        return year;
    }

    /**
     * Returns the engine power of the car in horsepower.
     *
     * @return the car's power
     */
    public int getPower() {
        return power;
    }

    /**
     * Compares this car to another car first by model, then by year, and finally by power.
     *
     * @param o the other car to compare to
     * @return -1, 0, or 1 if this car is less than, equal to, or greater than the specified car
     */
    @Override
    public int compareTo(Car o) {
        int modelComparison = String.CASE_INSENSITIVE_ORDER.compare(this.model, o.model);
        if (modelComparison != 0) {
            return modelComparison;
        }
        int yearComparison = Integer.compare(this.year, o.year);
        if (yearComparison != 0) {
            return yearComparison;
        }
        return Integer.compare(this.power, o.power);
    }

    /**
     * Returns the value of the numeric field for this car, which is its engine power.
     *
     * @return the power of the car
     */
    @Override
    public int getNumField() {
        return this.getPower();
    }

    /**
     * Returns the name of the numeric field, which is "power".
     *
     * @return the name of the numeric field
     */
    @Override
    public String getNumFieldName() {
        return "power";
    }

    /**
     * @return the hash code value
     */
    @Override
    public int hashCode() {
        return Objects.hash(model, year, power);
    }

    /**
     * @param obj the object to compare with
     * @return true if the cars are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Car other = (Car) obj;
        return year == other.year
                && power == other.power
                && model.equalsIgnoreCase(other.model);
    }

    /**
     * @return a string representation of the car
     */
    @Override
    public String toString() {
        return new StringBuilder("\n{")
                .append("model: ").append(model).append(", ")
                .append("year: ").append(year).append(", ")
                .append("power: ").append(power).append("}").toString();
    }
}
