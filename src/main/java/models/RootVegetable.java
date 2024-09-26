package models;

import java.io.Serializable;
import java.util.Objects;

/**
 * Represents an immutable root vegetable with a type, weight, and color.
 * The class implements {@link Comparable} to allow comparisons between root vegetables and {@link HasNumField}
 * to expose a numeric field for sorting or other operations.
 */
public final class RootVegetable implements Comparable<RootVegetable>, HasNumField<RootVegetable>, Serializable {
    private final String type;
    private final int weight;
    private final String color;

    /**
     * Private constructor to create a RootVegetable instance using the {@link Builder}.
     *
     * @param builder the builder used to set the root vegetable's fields
     */
    private RootVegetable(Builder builder) {
        this.type = builder.type != null ? builder.type : "empty";
        this.weight = builder.weight;
        this.color = builder.color != null ? builder.color : "empty";
    }

    /**
     * Builder for constructing instances of {@link RootVegetable}.
     */
    public static class Builder {
        private String type;
        private int weight;
        private String color;

        /**
         * Sets the type of the root vegetable.
         *
         * @param type the type of the root vegetable (e.g., carrot, potato)
         * @return the builder itself for method chaining
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * Sets the weight of the root vegetable in kilograms.
         *
         * @param weight the weight of the root vegetable
         * @return the builder itself for method chaining
         */
        public Builder weight(int weight) {
            this.weight = weight;
            return this;
        }

        /**
         * Sets the color of the root vegetable.
         *
         * @param color the color of the root vegetable
         * @return the builder itself for method chaining
         */
        public Builder color(String color) {
            this.color = color;
            return this;
        }

        /**
         * Builds and returns a new {@link RootVegetable} instance.
         *
         * @return the constructed {@link RootVegetable} object
         */
        public RootVegetable build() {
            return new RootVegetable(this);
        }
    }

    /**
     * Returns the type of the root vegetable.
     *
     * @return the root vegetable's type
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the weight of the root vegetable in kilograms.
     *
     * @return the root vegetable's weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Returns the color of the root vegetable.
     *
     * @return the root vegetable's color
     */
    public String getColor() {
        return color;
    }

    /**
     * Compares this root vegetable to another root vegetable first by type, then by weight, and finally by color.
     *
     * @param o the other root vegetable to compare to
     * @return -1, 0, or 1 if this root vegetable is less than, equal to, or greater than the specified root vegetable
     */
    @Override
    public int compareTo(RootVegetable o) {

        int typeComparison = String.CASE_INSENSITIVE_ORDER.compare(this.type, o.type);
        if (typeComparison != 0) {
            return typeComparison;
        }
        int weightComparison = Integer.compare(this.weight, o.weight);
        if (weightComparison != 0) {
            return weightComparison;
        }
        return String.CASE_INSENSITIVE_ORDER.compare(this.color, o.color);
    }

    /**
     * Returns the value of the numeric field for this root vegetable, which is its weight.
     *
     * @return the weight of the root vegetable
     */
    @Override
    public int getNumField() {
        return this.getWeight();
    }

    /**
     * Returns the name of the numeric field, which is "weight".
     *
     * @return the name of the numeric field
     */
    @Override
    public String getNumFieldName() {
        return "weight";
    }


    /**
     * @return the hash code value
     */
    @Override
    public int hashCode() {
        return Objects.hash(type, weight, color);
    }

    /**
     * @param obj the object to compare with
     * @return true if the root vegetables are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        RootVegetable other = (RootVegetable) obj;
        return weight == other.weight
                && type.equalsIgnoreCase(other.type)
                && color.equalsIgnoreCase(other.color);
    }

    /**
     * @return a string representation of the root vegetable
     */
    @Override
    public String toString() {
        return new StringBuilder("\n{")
                .append("type: ").append(type).append(", ")
                .append("weight: ").append(weight).append(", ")
                .append("color: ").append(color).append("}").toString();
    }
}
