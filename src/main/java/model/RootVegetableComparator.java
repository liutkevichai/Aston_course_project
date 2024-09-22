package model;

import java.util.Comparator;

public class RootVegetableComparator implements Comparator<RootVegetable> {

    @Override
    public int compare(RootVegetable o1, RootVegetable o2) {
        return Comparator.comparing(RootVegetable::getType)
                .thenComparingInt(RootVegetable::getWeight)
                .thenComparing(RootVegetable::getColor)
                .compare(o1, o2);
    }
}
