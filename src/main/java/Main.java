import model.HasNumField;
import model.Book;
import model.Car;
import model.RootVegetable;


import java.lang.reflect.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        while (true) {
            System.out.println("""
                    Выберите тип объектов (введите цифру):
                    1 - Автомобили
                    2 - Книги
                    3 - Корнеплоды
                    Для выхода из программы введите 0
                    """);
            Scanner scanner = new Scanner(System.in);
            if (!scanner.hasNextInt()) {
                System.out.println("Введенное значение не является числом");
                continue;
            }

            List<HasNumField<?>> list;
            String className;

            int classChoice = scanner.nextInt();
            if (classChoice == 0 ) break;

            try {
                list = switch (classChoice) {
                    //Здесь будет вызов стратегий наполнения массива
                    case 1:
                        className = "model.Car";
                        yield new ArrayList<>(Arrays.asList(
                                new Car.Builder().model("Рено").power(401).build(),
                                new Car.Builder().model("Ауди").power(600).build(),
                                new Car.Builder().model("Ниссан").power(300).build())
                        );
                    case 2:
                        className = "model.Book";
                        yield new ArrayList<>(Arrays.asList(
                                new Book.Builder().author("Кинг С.").pageCount(460).build(),
                                new Book.Builder().author("Лавкрафт Г.").pageCount(503).build(),
                                new Book.Builder().author("Блох Р.").pageCount(208).build())
                        );
                    case 3:
                        className = "model.RootVegetable";
                        yield new ArrayList<>(Arrays.asList(
                                new RootVegetable.Builder().type("Репа").weight(3).build(),
                                new RootVegetable.Builder().type("Морковь").weight(100).build(),
                                new RootVegetable.Builder().type("Репа").weight(10).build())
                        );
                    default:
                        throw new IllegalArgumentException(
                                "Введите значение из предложенных вариантов (1, 2 или 3, либо 0, чтобы выйти)");

                };
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            System.out.println(list + "\n");

            System.out.println("""
                    Выберите тип сортировки (введите цифру):
                    1 - По умолчанию
                    2 - Альтернативная
                    Для выхода из программы введите 0
                    """);

            if (!scanner.hasNextInt()) {
                System.out.println("Введенное значение не является числом");
                continue;
            }

            int sortChoice = scanner.nextInt();
            if (sortChoice == 0 ) break;

            try {
                switch (sortChoice) {
                    case 1:
                        list.sort(Comparator.comparing(a -> ((Comparable<Object>) a)));
                        break;
                    case 2:
                        altSort(list);
                        break;
                    default:
                        throw new IllegalArgumentException(
                                "Введите значение из предложенных вариантов (1 или 2, либо 0, чтобы выйти)");
                }

                System.out.println(list + "\n");

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            if (sortChoice == 1) {
                System.out.println("""
                            Выполнить поиск элемента в списке? (введите цифру):
                            1 - Да
                            Для выхода из программы введите 0
                            """);

                int searchChoice = scanner.nextInt();
                if (searchChoice == 0 ) break;

                try {
                    if (searchChoice == 1) {
                        if (!list.isEmpty()) {
                            Class<?> clazz = Class.forName(className);
                            Class<?> builderClass = Class.forName(className + "$Builder");

                            Constructor<?> builderConstructor = builderClass.getDeclaredConstructor();
                            Object builder = builderConstructor.newInstance();

                            Field[] fields = clazz.getDeclaredFields();

                            for (Field field : fields) {
                                field.setAccessible(true);
                                System.out.println("Введите значение для поля " + field.getName() + ": ");
                                String input = scanner.nextLine();

                                Object value;
                                if (field.getType() == int.class) {
                                    value = Integer.parseInt(input);
                                } else {
                                    value = input;
                                }

                                String setterMethodName = field.getName();
                                Method builderSetter = builderClass.getDeclaredMethod(setterMethodName, field.getType());
                                builderSetter.invoke(builder, value);
                            }

                            Method buildMethod = builderClass.getDeclaredMethod("build");

                            Comparable<?> itemToSearch = (Comparable<?>) buildMethod.invoke(builder);

                            List<? extends Comparable<?>> listForSearch = list.stream()
                                    .map(item -> (Comparable<?>) item)
                                    .toList();

                            int index = Collections.binarySearch(listForSearch, itemToSearch);
                        }

                    } else {
                        throw new IllegalArgumentException(
                                "Введите значение из предложенных вариантов (1 либо 0, чтобы выйти)");
                    }

                    System.out.println(list + "\n");

                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
            }
        }

    }

    public static void altSort(List<HasNumField<?>> list) {

      List<HasNumField<?>> evenObjs = new ArrayList<>(list.stream()
              .filter(x -> x.getNumField() % 2 == 0)
              .sorted(Comparator.comparingInt(HasNumField::getNumField)).toList());

      int evenIndex = 0;

      for (int i = 0; i < list.size(); i++) {
        if (list.get(i).getNumField() % 2 == 0) {
          list.set(i, evenObjs.get(evenIndex));
          evenIndex++;
        }
      }

    }
}
