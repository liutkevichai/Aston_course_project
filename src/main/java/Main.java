import algorithms.AltSorting;
import algorithms.BinarySearch;
import algorithms.Sorting;

import input.UserChoiceSource;
import input.UserChoiceHandler;

import models.Book;
import models.Car;
import models.HasNumField;
import models.RootVegetable;

import fillstrategy.ContextFillingList;
import fillstrategy.FillingList;
import fillstrategy.impl.FillingListFromConsole;
import fillstrategy.impl.FillingListRandomValue;
import input.BuilderInvoker;

import java.util.List;
import java.util.Map;

public class Main {
    /**
     * A map containing strategies for filling the list.
     * <p>
     * Includes the following strategies:
     * <ul>
     *     <li>1 - {@link FillingListFromConsole} - fills the list through console input</li>
     *     <li>2 - {@link FillingListRandomValue} - fills the list from a file</li>
     *     <li>3 - {@link FillingListRandomValue} - fills the list with random values </li>
     * </ul>
     */
    public static final Map<Integer, FillingList> fillingStrategies = Map.of(
            1, new FillingListFromConsole(),
            2, new FillingListRandomValue(),
            3, new FillingListRandomValue());

    public static void main(String[] args) {
        while (true) {
            UserChoiceHandler input = new UserChoiceHandler(new UserChoiceSource());
            int classChoice = input.getClassChoice();
            int res;

            switch (classChoice) {
                case 0:
                    break;
                case 1:
                    res = processChoices(Car.class, input);
                    if (res == 0) break;
                    else continue;
                case 2:
                    res = processChoices(Book.class, input);
                    if (res == 0) break;
                    else continue;
                case 3:
                    res = processChoices(RootVegetable.class, input);
                    if (res == 0) break;
                    else continue;
                default:
                    continue;
            }
            break;
        }
    }

    /**
     * Processes user choices for the selected class type.
     * The user selects the method of filling, sorting, and whether to do a binary search (if applicable).
     *
     * @param <T> the type of object, which must be both Comparable and
     *           implement the {@link HasNumField} interface
     * @param typeClass the class of the object chosen by the user (e.g., Car, Book, RootVegetable)
     * @param input an object that handles user input
     * @return 1 if the process is successfully completed, or 0 if the user chooses to exit
     */
    public static <T extends Comparable<T> & HasNumField<T>>
    int processChoices(Class<T> typeClass, UserChoiceHandler input) {
        int fillingChoice = input.getFillingChoice();
        if (fillingChoice == 0) return 0;

        int amount = input.getAmountChoice();
        if (amount == 0) return 0;

        ContextFillingList cfl = new ContextFillingList();
        cfl.setFillingList(fillingStrategies.get(fillingChoice));
        List<T> list = cfl.execute(typeClass, amount);

        System.out.println(typeClass.getSimpleName() + " list: " + list + "\n");

        int sortingChoice = input.getSortingChoice();
        if (sortingChoice == 0) return 0;

        applySorting(list, sortingChoice);

        if (sortingChoice == 1) {
            int searchChoice = input.getSearchChoice();
            if (searchChoice == 0) return 0;
            if (searchChoice == 2) return 1;

            BuilderInvoker<T> invoker = new BuilderInvoker<>();
            int searchRes = BinarySearch.search(list,
                    invoker.setupWithInput(typeClass));

            if (searchRes == -1) System.out.println("Element not found");
            else System.out.println("Found by index: " + searchRes);
        }

        return 1;
    }

    /**
     * Applies sorting to the list of objects based on the user's choice.
     * If sorting type is 1, it uses merge sort and sorts the list in natural order.
     * If sorting type is 2, it applies alternative sorting algorithm based on the object's numerical field
     *
     * @param <T> the type of object to be sorted, which must be both Comparable and
     *           implement the {@link HasNumField} interface
     * @param list the list of objects to be sorted
     * @param sortingType the sorting method chosen by the user
     */
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
