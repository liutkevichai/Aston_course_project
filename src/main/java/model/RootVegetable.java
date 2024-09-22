package model;

import java.util.Objects;

public class RootVegetable implements Comparable<RootVegetable> {
    private String type;
    private int weight;
    private String color;

    private RootVegetable(Builder builder) {
        this.type = builder.type;
        this.weight = builder.weight;
        this.color = builder.color;
    }

    @Override
    public int compareTo(RootVegetable o) {
        return (int) (this.weight - o.weight);
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
    public int compareTo(RootVegetable rv) {
        int typeComparison = this.type.compareTo(rv.type);
        if (typeComparison != 0) {
            return typeComparison;
        }
        return Double.compare(this.weight, rv.weight);
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
        return "RootVegetable{" +
                "type=" + type + " " +
                ", weight=" + weight +
                ", color=" + color +
                "}";
    }


}

