package strategy.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ConsoleInputBuilder {
    private final static Scanner scanner = new Scanner(System.in);

    public static <T> T setupWithInput(Class<T> clazz) {
        Object builderInstance;

        try {
            Class<?> builderClass = Class.forName(clazz.getName() + "$Builder");
            builderInstance = builderClass.getDeclaredConstructor().newInstance();

            Field[] fields = builderClass.getDeclaredFields();
            System.out.println("New object " + clazz.getSimpleName() + ":");
            for (Field field : fields) {
                String fieldName = field.getName();
                Class<?> fieldType = field.getType();

                System.out.println("Enter field value: " + fieldName + " (" + fieldType.getSimpleName() + "): ");
                String inputValue = scanner.nextLine();

                Object parsedValue = parseInput(inputValue, fieldType);

                Method builderMethod = builderClass.getMethod(fieldName, fieldType);
                builderMethod.invoke(builderInstance, parsedValue);
            }

            Method buildMethod = builderClass.getMethod("build");

            return (T) buildMethod.invoke(builderInstance);

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static Object parseInput(String input, Class<?> fieldType) {
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
