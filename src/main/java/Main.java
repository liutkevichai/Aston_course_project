import algorithms.*;
import model.*;
import strategy.*;
import strategy.impl.*;
import strategy.utils.ConsoleInputBuilder;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
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
