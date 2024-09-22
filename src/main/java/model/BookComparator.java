package model;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        return Comparator.comparing(Book::getAuthor)
                .thenComparingInt(Book::getPageCount)
                .thenComparing(Book::getTitle)
                .compare(o1, o2);
    }
}
