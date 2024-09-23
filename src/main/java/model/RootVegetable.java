package model;

import java.util.Objects;

public class RootVegetable implements Comparable<RootVegetable>, HasNumField<RootVegetable> {
    private String type;
    private int weight;
    private String color;

    private RootVegetable(Builder builder) {
        this.type = builder.type != null ? builder.type : "empty";
        this.weight = builder.weight;
        this.color = builder.color != null ? builder.color : "empty";
    }

    public static class Builder {
        private String type;
        private int weight;
        private String color;

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder weight(int weight) {
            this.weight = weight;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public RootVegetable build() {
            return new RootVegetable(this);
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public int compareTo(RootVegetable o) {
        int typeComparison = this.type.compareTo(o.type);
        if (typeComparison != 0) {
            return typeComparison;
        }

        int weightComparison = Integer.compare(this.weight, o.weight);
        if (weightComparison != 0) {
            return weightComparison;
        }

        return this.color.compareTo(o.color);
    }

    public int getNumField() {
        return this.getWeight();
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, weight, color);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        RootVegetable other = (RootVegetable) obj;
        return Double.compare(other.weight, weight) == 0
                && Objects.equals(type, other.type) && Objects.equals(color, other.color);
    }

    @Override
    public String toString() {
        return new StringBuilder("RootVegetable{")
                .append("type: ").append(type).append(", ")
                .append("weight: ").append(weight).append(", ")
                .append("color: ").append(color).append("}").toString();
    }
}

