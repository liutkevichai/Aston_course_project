package input.choice;

import java.util.Scanner;
import java.util.Set;

/**
 * input.choice.UserChoiceSource receives integer input from the console.
 */
public class UserChoiceSource {
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Prompts the user to enter a valid integer option from the provided set.
     *
     * @param message The message to display
     * @param options The set of valid options
     * @return the valid input as an integer
     */
    public int getIntInput(String message, Set<Integer> options) {
        int choice;
        while (true) {
            System.out.println(message);

            if (!scanner.hasNextInt()) {
                System.out.println("This value is not a valid number");
                scanner.nextLine();
                continue;
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            if (options.contains(choice)) break;
            else {
                System.out.println("There is no such option: " + choice);
            }
        }
        return choice;
    }

    /**
     * Prompts the user to enter any integer, allowing for unrestricted input.
     *
     * @param message The message to display
     * @return the input as an integer
     */
    public int getAnyIntInput(String message) {
        int choice;
        while (true) {
            System.out.println(message);

            if (!scanner.hasNextInt()) {
                System.out.println("This value is not a valid number");
                scanner.nextLine();
                continue;
            }

            choice = scanner.nextInt();
            scanner.nextLine();
            break;
        }
        return choice;
    }
}


