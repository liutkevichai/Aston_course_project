import algorithms.AltSorting;
import algorithms.BinarySearch;
import algorithms.Sorting;
import model.*;
import strategy.ContextFillingList;
import strategy.FillingList;
import strategy.impl.FillingListFromConsole;
import strategy.impl.FillingListRandomValue;
import strategy.utils.ConsoleInputBuilder;

import java.util.*;

public class Main {

    public static List<Car> carList = new ArrayList<>(Arrays.asList(
            new Car.Builder().model("Рено").power(401).build(),
            new Car.Builder().model("Ауди").power(600).build(),
            new Car.Builder().model("Ниссан").power(300).build())
    );

    public static List<Book> bookList = new ArrayList<>(Arrays.asList(
            new Book.Builder().author("Кинг С.").pageCount(460).build(),
            new Book.Builder().author("Лавкрафт Г.").pageCount(503).build(),
            new Book.Builder().author("Блох Р.").pageCount(208).build())
    );

    public static List<RootVegetable> rootVegetableList = new ArrayList<>(Arrays.asList(
            new RootVegetable.Builder().type("Репа").weight(3).build(),
            new RootVegetable.Builder().type("Морковь").weight(100).build(),
            new RootVegetable.Builder().type("Репа").weight(10).build())
    );

    public static Map<Integer, FillingList> fillingStrategies = Map.of(
            1, new FillingListFromConsole(),
            2, new FillingListRandomValue(),// ЗАМЕНИТЬ
            3, new FillingListRandomValue());

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            UserInput input = new UserInput();

            int classChoice = input.getClassChoice(scanner);
            int res;

            switch (classChoice) {
                case 0:
                    break;
                case 1:
                    res = processInput(Car.class, input, scanner);
                    if (res == 1) continue;
                    else if (res == -1) continue;
                    else break;
                case 2:
                    res = processInput(Book.class, input, scanner);
                    if (res == 1) continue;
                    else if (res == -1) continue;
                    else break;
                case 3:
                    res = processInput(RootVegetable.class, input, scanner);
                    if (res == 1) continue;
                    else if (res == -1) continue;
                    else break;
                default:
                    continue;
            }

            break;
        }
    }

    public static <T extends Comparable<T>> int processInput(Class<T> typeClass, UserInput input, Scanner scanner) {
        int fillingChoice = input.getFillingChoice(scanner);
        if (fillingChoice == 0) return 0;
        if (fillingChoice == -1) return -1;

        int amount = input.getAmountChoice(scanner);
        if (amount == 0) return 0;
        if (amount == -1) return -1;

        //List<Car> list = Main.carList; //Заменить на выбранную стратегию
        ContextFillingList cfl = new ContextFillingList();
        cfl.setFillingList(fillingStrategies.get(fillingChoice));
        List list = cfl.execute(typeClass, amount);

        int sortingChoice = input.getSortingChoice(scanner);
        if (sortingChoice == 0) return 0;
        if (sortingChoice == -1) return -1;

        applySorting(list, sortingChoice);

        if (sortingChoice == 1) {
            int searchChoice = input.getSearchChoice(scanner);
            if (searchChoice == 0) return 0;
            if (searchChoice == 2 || searchChoice == -1) return -1;

            int searchRes = BinarySearch.search(list,
                    ConsoleInputBuilder.setupWithInput(typeClass, scanner));

            if (searchRes == -1) System.out.println("Element not found\n");
            else System.out.println("Found by index: " + searchRes + "\n");
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
