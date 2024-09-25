package input.fields;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class BuilderInvoker<T> {
    private final InputHandler inputHandler;
    private final InputParser inputParser;

    public BuilderInvoker() {
        this.inputHandler = new InputHandler();
        this.inputParser = new InputParser();
    }

    public T setupWithInput(Class<T> clazz) {
        Object builderInstance;

        try {
            Class<?> builderClass = Class.forName(clazz.getName() + "$Builder");
            builderInstance = builderClass.getDeclaredConstructor().newInstance();

            Field[] fields = builderClass.getDeclaredFields();
            System.out.println("New object " + clazz.getSimpleName() + ":");
            for (Field field : fields) {
                String fieldName = field.getName();
                Class<?> fieldType = field.getType();

                String inputValue = inputHandler.getInput(
                        "Enter field value: " + fieldName + " (" + fieldType.getSimpleName() + "): ");

                Object parsedValue = inputParser.parse(inputValue, fieldType);

                Method builderMethod = builderClass.getMethod(fieldName, fieldType);
                builderMethod.invoke(builderInstance, parsedValue);
            }

            Method buildMethod = builderClass.getMethod("build");

            return (T) buildMethod.invoke(builderInstance);

        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException |
                 ClassNotFoundException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    private class InputHandler  {
        private final Scanner scanner = new Scanner(System.in);

        public String getInput(String prompt) {
            System.out.println(prompt);
            return scanner.nextLine();
        }
    }

    private class InputParser {
        public Object parse(String input, Class<?> fieldType) {
            if (fieldType == int.class || fieldType == Integer.class) {
                if (input.isBlank()) return 0;
                try {
                    return (int) Math.round(Double.parseDouble(input));
                } catch (NumberFormatException e) { return 0; }
            }
            if (input.isBlank()) return "empty";
            return input;
        }
    }

}
