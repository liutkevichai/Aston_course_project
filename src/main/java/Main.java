import model.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
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

            int typeChoice = scanner.nextInt();
            if (typeChoice == 0 ) break;

            List<HasNumField<?>> list;
            int sortingType;

            try {
                switch (typeChoice) {
                    //Здесь будет вызов стратегий наполнения массива
                    case 1:
                        list = new ArrayList<>(Arrays.asList(
                                new Car.Builder().model("Рено").power(401).build(),
                                new Car.Builder().model("Ауди").power(600).build(),
                                new Car.Builder().model("Ниссан").power(300).build())
                        );

                        System.out.println(list + "\n");
                        sortingType = chooseSorting();
                        if (sortingType == -1) continue;
                        if (sortingType == 0) throw new InterruptedException();

                        applySorting(list, sortingType);

                        if (sortingType == 1 && chooseWillSearch()) {
                            Collections.binarySearch(list, setupWithInput(new Car.Builder()));
                        }
                        break;

                    case 2:
                        list = new ArrayList<>(Arrays.asList(
                                new Book.Builder().author("Кинг С.").pageCount(460).build(),
                                new Book.Builder().author("Лавкрафт Г.").pageCount(503).build(),
                                new Book.Builder().author("Блох Р.").pageCount(208).build())
                        );

                        System.out.println(list + "\n");
                        sortingType = chooseSorting();
                        if (sortingType == -1) continue;
                        if (sortingType == 0) throw new InterruptedException();

                        applySorting(list, sortingType);

                        if (sortingType == 1 && chooseWillSearch()) {
                            Collections.binarySearch(list, setupWithInput(new Book.Builder()));
                        }
                        break;
                    ;

                    case 3:
                        list = new ArrayList<>(Arrays.asList(
                                new RootVegetable.Builder().type("Репа").weight(3).build(),
                                new RootVegetable.Builder().type("Морковь").weight(100).build(),
                                new RootVegetable.Builder().type("Репа").weight(10).build())
                        );

                        System.out.println(list + "\n");
                        sortingType = chooseSorting();
                        if (sortingType == -1) continue;
                        if (sortingType == 0) throw new InterruptedException();

                        applySorting(list, sortingType);

                        if (sortingType == 1 && chooseWillSearch()) {
                            Collections.binarySearch(list, setupWithInput(new Book.Builder()));
                        }

                        break;

                    default:
                        System.out.println("Введите значение из предложенных вариантов (1, 2 или 3, либо 0, чтобы выйти)");
                        break;
                }

            } catch (InterruptedException e) {
                break;
            }

        }
    }

    public static int chooseSorting() {
        System.out.println("""
                    Выберите тип сортировки (введите цифру):
                    1 - По умолчанию
                    2 - Альтернативная
                    Для выхода из программы введите 0
                    """);

        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            System.out.println("Введенное значение не является числом");
            return -1;
        }

        int choice = scanner.nextInt();
        if (choice == 0 || choice == 1 || choice == 2) return choice;

        else {
            System.out.println("Введите значение из предложенных вариантов (1 или 2, либо 0, чтобы выйти)");
            return -1;
        }
    }

    public static boolean chooseWillSearch() {
        System.out.println("""
                            Выполнить поиск элемента в списке? (введите цифру):
                            1 - Да
                            Для выхода из программы введите 0
                            """);

        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            System.out.println("Введенное значение не является числом");
            return false;
        }

        int choice = scanner.nextInt();
        if (choice != 0 && choice != 1) {
            System.out.println("Введите значение из предложенных вариантов (1 либо 0, чтобы выйти)");
        }
        return choice == 1;
    }

    public static void applySorting(List<HasNumField<?>> list, int sortingType) {
        if (sortingType == 1) {
            list.sort(Comparator.comparing(a -> ((Comparable<Object>) a)));
        } else if (sortingType == 2) {
            altSort(list);
        }

        System.out.println(list + "\n");
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
