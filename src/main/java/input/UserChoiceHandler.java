package input;

import java.util.Set;

/**
 * input.UserChoiceHandler handles the logic for asking different user choices.
 */
public class UserChoiceHandler {
    private final UserChoiceSource source;

    /**
     * A constructor to create a input.UserChoiceHandler instance.
     *
     * @param source the instance of {@link UserChoiceSource}
     */
    public UserChoiceHandler(UserChoiceSource source) {
        this.source = source;
    }

    /**
     * Prompts the user to choose an object type.
     *
     * @return an integer representing the chosen object type
     */
    public int getClassChoice() {
        String message = """
                        \nChoose an object type (enter a number):
                        1 - Car
                        2 - Book
                        3 - Root vegetable
                        Or enter 0 to exit""";
        Set<Integer> options = Set.of(1, 2, 3, 0);
        return source.getIntInput(message, options);
    }

    /**
     * Prompts the user to choose how to fill a list.
     *
     * @return an integer representing the list filling method
     */
    public int getFillingChoice() {
        String message = """
                        Choose how to fill a list (enter a number):
                        1 - Fill manually
                        2 - Load from a file
                        3 - Fill with random objects
                        Or enter 0 to exit""";
        Set<Integer> options = Set.of(1, 2, 3, 0);
        return source.getIntInput(message, options);
    }

    /**
     * Prompts the user to choose an amount of elements.
     *
     * @return an integer representing the amount of elements chosen
     */
    public int getAmountChoice() {
        String message = """
                        Choose an amount of elements (enter a number):
                        Or enter 0 to exit""";
        int amount;
        while (true) {
            amount = source.getAnyIntInput(message);
            if (amount >= 0) break;
            System.out.println("You can't choose a negative amount: " + amount);
        }
        return amount;
    }

    /**
     * Prompts the user to choose a sorting method.
     *
     * @return an integer representing the chosen sorting method
     */
    public int getSortingChoice() {
        String message = """
                        Choose how to sort the list (enter a number):
                        1 - Default sorting
                        2 - Alternative sorting
                        Or enter 0 to exit""";
        Set<Integer> options = Set.of(1, 2, 0);
        return source.getIntInput(message, options);
    }

    /**
     * Prompts the user to decide if they want to search for an element.
     *
     * @return an integer representing the user's decision
     */
    public int getSearchChoice() {
        String message = """
                        Do you want to search for an element? (enter a number):
                        1 - Yes
                        2 - No
                        Or enter 0 to exit""";
        Set<Integer> options = Set.of(1, 2, 0);
        return source.getIntInput(message, options);
    }
}
