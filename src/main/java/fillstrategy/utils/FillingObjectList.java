package fillstrategy.utils;

import models.Book;
import models.Car;
import models.RootVegetable;

import java.time.LocalDate;
import java.util.*;

/***
 * Class for create objects list and fill their a random data
 * This class contains final variables for fields different classes
 * and uses their for fill list of objects
 */
public class FillingObjectList {
    private final static int MAX_POWER = 400;
    private final static int MIN_POWER = 20;
    private final static int CURRENT_YEAR = LocalDate.now().getYear();
    private final static int OLD_CAR_YEAR = 1980;
    private final static List<String> CAR_MODEL_LIST = List.of(
                    "Audi", "BMW", "Cadillac", "Chevrolet", "Citroen", "Dodge", "Ferrari", "Fiat",
                    "Ford", "Geely", "Honda", "Hummer", "Hyundai", "Infiniti", "Jeep", "Opel", "Nissan",
                    "Mitsubishi", "Mercedes-Benz", "Mazda", "Maserati", "Livan", "Lexus",
                    "Land Rover", "Lamborghini", "Lada", "Peugeot", "Porsche", "RAM", "Renault");
    private final static List<List<String>> BOOK_LIBRARY = List.of(
                    List.of("T L Swan", "My Rules (Kingston Lane Book 2)", "503"),
                    List.of("Elsie Silver", "Wild Eyes", "407"),
                    List.of("Meghan Quinn", "Bridesmaid Undercover", "498"),
                    List.of("Pippa Grant", "The Secret Hook-Up", "311"),
                    List.of("Pippa Grant", "The Last Eligible Billionaire", "352"),
                    List.of("Alina Jacobs", "Mr. Absolutely Not!: A Romantic Comedy", "541"),
                    List.of("Meghan Quinn", "Bridesmaid For Hire", "450"),
                    List.of("Meghan Quinn", "The Way I Hate Him", "524"),
                    List.of("Meagan Brandy", "Say You Swear", "550"),
                    List.of("Jennifer Hartmann", "Still Beating", "314"),
                    List.of("Barry Powell", "A land of slaves", "267"),
                    List.of("Dilara Aksoy", "Lost Form", "111"),
                    List.of("H. Barcau", "Echoes of the Lost", "184"),
                    List.of("Joe Egan", "Losing Lee", "259"),
                    List.of("Debra Coleman Jeter", "The Ticket: A Southern Coming of Age Novel", "213"),
                    List.of("R. F. Whong", "Blazing China", "278"),
                    List.of("R. F. Whong", "Detour to Agape", "199"),
                    List.of("R. F. Whong", "Prestige of Hearts", "205"),
                    List.of("Mary Davis", "The Quilting Circle Box Set", "1234"),
                    List.of("Joe Egan", "Run to the Rio", "302"));
    private final static int MIN_WEIGHT_ROOT_VEGETABLE = 10;
    private final static int MAX_WEIGHT_ROOT_VEGETABLE = 1000;
    private final static List<String> COLOR_LIST = List.of(
                    "Orange", "Purple", "Yellow", "White", "Gray", "Red", "Green");
    private final static List<String> TYPE_ROOT_VEGETABLE_LIST = List.of(
                    "Carrots", "Radishes", "Onions", "Garlic",
                    "Parsnips", "Beets", "Turnips", "Rutabaga",
                    "Celeriac", "Salsify", "Turmeric", "Ginger",
                    "Jerusalem artichokes", "Jicama", "Bamboo shoots", "Peanuts",
                    "Horseradish", "Yuca", "Potatoes", "Sweet potatoes",
                    "Yams", "Taro", "Lotus roots");

    /***
     * Create and fill car list
     * If param method less or equal zero then method return empty method
     * @param count number element that will consist of car list
     * @return car list
     */
    public List fillCarList(int count) {
        List carList;
        if (count > 0) {
            carList = new ArrayList<Car>(count);
            int year, power, indexModel;

            for (int i = 0; i < count; i++) {
                year = generateRandomInRangeIncludeEnd(OLD_CAR_YEAR, CURRENT_YEAR);
                power = generateRandomInRangeIncludeEnd(MIN_POWER, MAX_POWER);
                indexModel = generateRandomInRangeNotIncludeEnd(0, CAR_MODEL_LIST.size());
                carList.add(new Car.Builder().
                        year(year).
                        power(power).
                        model(CAR_MODEL_LIST.get(indexModel)).
                        build());
            }
        } else {
            carList = new ArrayList<Car>(0);
        }
        return carList;
    }

    /***
     * Create and fill book list
     * If param method less or equal zero then method return empty method.
     * Also method have logic for situation when param 'count' may more than
     * size 'BOOK_LIBRARY'. In this case book list will fill from the beginning 'BOOK_LIBRARY'.
     * @param count number element that will consist of book list
     * @return book list
     */
    public List fillBookList(int count) {
        List bookList;
        if (count > 0) {
            bookList = new ArrayList<Book>();
            String author, title;
            int pageCount;
            int sizeBookLibrary = BOOK_LIBRARY.size();
            for (int i = 0; i < count; i++) {
                List<String> book = BOOK_LIBRARY.get(generateRandomInRangeNotIncludeEnd(0, sizeBookLibrary));
                author = book.get(0);
                title = book.get(1);
                pageCount = Integer.parseInt(book.get(2));
                bookList.add(new Book.Builder()
                        .author(author)
                        .title(title)
                        .pageCount(pageCount)
                        .build());
                // if param 'count' will be more than size 'bookLibrary'
                if (i == sizeBookLibrary - 1) {
                    i = -1;
                    count -= sizeBookLibrary;
                }
            }
        } else {
            bookList = new ArrayList<Book>(0);
        }
        return bookList;
    }
    /***
     * Create and fill rootVegetable list
     * If param method less or equal zero then method return empty method.
     * @param count number element that will consist of car list
     * @return book list
     */
    public List fillRootVegetableList(int count) {
        List RootVegetableList;
        if (count > 0) {
            RootVegetableList = new ArrayList<RootVegetable>(count);
            int weight, indexColor, indexRootVegetable;

            for (int i = 0; i < count; i++) {
                weight = generateRandomInRangeIncludeEnd(MIN_WEIGHT_ROOT_VEGETABLE, MAX_WEIGHT_ROOT_VEGETABLE);
                indexColor = generateRandomInRangeNotIncludeEnd(0, COLOR_LIST.size());
                indexRootVegetable = generateRandomInRangeNotIncludeEnd(0, TYPE_ROOT_VEGETABLE_LIST.size());

                RootVegetableList.add(new RootVegetable.Builder()
                        .type(TYPE_ROOT_VEGETABLE_LIST.get(indexRootVegetable))
                        .weight(weight)
                        .color(COLOR_LIST.get(indexColor))
                        .build());
            }
        } else {
            RootVegetableList = new ArrayList<RootVegetable>(0);
        }
        return RootVegetableList;
    }

    /***
     * Method for generate random number in range include the 'finish'
     * @param start first number of range
     * @param finish last number of range
     * @return random number
     */
    private int generateRandomInRangeIncludeEnd(int start, int finish){
        return (int) (Math.random() * (finish - start + 1) + start);
    }

    /***
     * Method for generate random number in range not include the 'finish'
     * @param start first number of range
     * @param finish last number of range
     * @return random number
     */
    private int generateRandomInRangeNotIncludeEnd(int start, int finish){
        return (int) (Math.random() * (finish - start) + start);
    }
}
