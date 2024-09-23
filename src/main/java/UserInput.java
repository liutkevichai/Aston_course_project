import java.util.Scanner;
import java.util.Set;

public class UserInput {
    Integer classChoice;
    Integer fillingChoice;
    Integer sortingChoice;
    Integer searchChoice;

    public int getClassChoice(Scanner scanner) {
        String message = """
                        Choose an object type (enter a number):
                        1 - Car
                        2 - Book
                        3 - Root vegetable
                        Or enter 0 to exit""";

        Set<Integer> options = Set.of(1,2,3,0);

        if (classChoice == null) {
            classChoice = getUserInput(message, scanner, options);
        }
        return classChoice;
    }

    public int getFillingTypeChoice(Scanner scanner) {
        String message = """
                        Choose how to fill a list (enter a number):
                        1 - Fill manually
                        2 - Load from a file
                        3 - Fill with random objects
                        Or enter 0 to exit""";

        Set<Integer> options = Set.of(1,2,3,0);
        if (fillingChoice == null) {
            fillingChoice = getUserInput(message, scanner,options);
        }
        return fillingChoice;
    }

    public int getSortingChoice(Scanner scanner) {
        String message = """
                        Choose how to sort the list (enter a number):
                        1 - Default sorting
                        2 - Alternative sorting
                        Or enter 0 to exit""";

        Set<Integer> options = Set.of(1,2,0);
        if (sortingChoice == null) {
           sortingChoice = getUserInput(message, scanner,options);
        }
        return sortingChoice;
    }

    public int getSearchChoice(Scanner scanner) {
        String message = """
                        Do you want to search for an element? (enter a number):
                        1 - Yes
                        2 - No
                        Or enter 0 to exit""";

        Set<Integer> options = Set.of(1,2,0);
        if (searchChoice == null) {
            searchChoice = getUserInput(message, scanner, options);
        }
        return searchChoice;
    }

    private int getUserInput(String message, Scanner scanner, Set<Integer> options) {
        int choice;
        while (true) {
            System.out.println(message);

            if (!scanner.hasNextInt()) {
                System.out.println("This value is not a number");
                continue;
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            if (options.contains(choice)) break;
            else {
                System.out.println("There is no such option: " + classChoice);
                return -1;
            }
        }
        return choice;
    }

}
