import algorithms.*;
import model.*;
import strategy.*;
import strategy.impl.*;
import strategy.utils.ConsoleInputBuilder;

import java.util.List;
import java.util.Map;

public class Main {
    public static final Map<Integer, FillingList> fillingStrategies = Map.of(
            1, new FillingListFromConsole(),
            2, new FillingListRandomValue(),// ЗАМЕНИТЬ
            3, new FillingListRandomValue());

    public static void main(String[] args) {
        while (true) {
            UserInput input = new UserInput();
            int classChoice = input.getClassChoice();
            int res;

            switch (classChoice) {
                case 0:
                    break;
                case 1:
                    res = processInput(Car.class, input);
                    if (res == 0) break;
                    else continue;
                case 2:
                    res = processInput(Book.class, input);
                    if (res == 0) break;
                    else continue;
                case 3:
                    res = processInput(RootVegetable.class, input);
                    if (res == 0) break;
                    else continue;
                default:
                    continue;
            }
            break;
        }
    }

    public static <T extends Comparable<T>> int processInput(Class<T> typeClass, UserInput input) {
        int fillingChoice = input.getFillingChoice();
        if (fillingChoice == 0) return 0;

        int amount = input.getAmountChoice();
        if (amount == 0) return 0;

        ContextFillingList cfl = new ContextFillingList();
        cfl.setFillingList(fillingStrategies.get(fillingChoice));
        List list = cfl.execute(typeClass, amount);

        System.out.println(typeClass.getSimpleName() + " list: " + list + "\n");

        int sortingChoice = input.getSortingChoice();
        if (sortingChoice == 0) return 0;

        applySorting(list, sortingChoice);

        if (sortingChoice == 1) {
            int searchChoice = input.getSearchChoice();
            if (searchChoice == 0) return 0;
            if (searchChoice == 2) return 1;

            int searchRes = BinarySearch.search(list,
                    ConsoleInputBuilder.setupWithInput(typeClass));

            if (searchRes == -1) System.out.println("Element not found");
            else System.out.println("Found by index: " + searchRes);
        }

        return 1;
    }

    public static <T extends Comparable<T> & HasNumField<T>> void applySorting(List<T> list, int sortingType) {
        if (sortingType == 1) {
            Sorting.mergeSort(list, T::compareTo);
            System.out.println("Sorted: " + list + "\n");
        } else if (sortingType == 2) {
            AltSorting.sort(list);
            System.out.println("Sorted by " + list.getFirst().getNumFieldName() + ": " + list + "\n");
        }
    }

}
