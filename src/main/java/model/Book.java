package model;

import java.util.Objects;

/**
 * Represents an immutable book with an author, title, and page count.
 * The class implements {@link Comparable} to allow comparisons between books and {@link HasNumField} to expose
 * a numeric field for sorting or other operations.
 */
public final class Book implements Comparable<Book>, HasNumField<Book> {
    private final String author;
    private final String title;
    private final int pageCount;

    /**
     * Private constructor to create a Book instance using the {@link Builder}.
     *
     * @param builder the builder used to set the book's fields
     */
    private Book(Builder builder) {
        this.author = builder.author != null ? builder.author : "empty";
        this.title = builder.title != null ? builder.title : "empty";
        this.pageCount = builder.pageCount;
    }

    /**
     * Builder for constructing instances of {@link Book}.
     */
    public static class Builder {
        private String author;
        private String title;
        private int pageCount;

        /**
         * Sets the author of the book.
         *
         * @param author the author's name
         * @return the builder itself for method chaining
         */
        public Builder author(String author) {
            this.author = author;
            return this;
        }

        /**
         * Sets the title of the book.
         *
         * @param title the title of the book
         * @return the builder itself for method chaining
         */
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        /**
         * Sets the page count of the book.
         *
         * @param pageCount the number of pages in the book
         * @return the builder itself for method chaining
         */
        public Builder pageCount(int pageCount) {
            this.pageCount = pageCount;
            return this;
        }

        /**
         * Builds and returns a new {@link Book} instance.
         *
         * @return the constructed {@link Book} object
         */
        public Book build() {
            return new Book(this);
        }
    }

    /**
     * Returns the author of the book.
     *
     * @return the book's author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Returns the title of the book.
     *
     * @return the book's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the number of pages in the book.
     *
     * @return the book's page count
     */
    public int getPageCount() {
        return pageCount;
    }

    /**
     * Compares this book to another book first by author, then by title, and finally by page count.
     *
     * @param o the other book to compare to
     * @return -1, 0, or 1 if this book is less than, equal to, or greater than the specified book
     */
    @Override
    public int compareTo(Book o) {
        int authorComparison = this.author.compareTo(o.author);
        if (authorComparison != 0) {
            return authorComparison;
        }
        int titleComparison = this.title.compareTo(o.title);
        if (titleComparison != 0) {
            return titleComparison;
        }
        return Integer.compare(this.pageCount, o.pageCount);
    }

    /**
     * Returns the value of the numeric field for this book, which is its page count.
     *
     * @return the page count of the book
     */
    @Override
    public int getNumField() {
        return this.getPageCount();
    }

    /**
     * Returns the name of the numeric field, which is "page count".
     *
     * @return the name of the numeric field
     */
    @Override
    public String getNumFieldName() {
        return "page count";
    }

    /**
     * @return the hash code value
     */
    @Override
    public int hashCode() {
        return Objects.hash(author, title, pageCount);
    }

    /**
     * @param obj the object to compare with
     * @return true if the books are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        return pageCount == other.pageCount
                && Objects.equals(author, other.author)
                && Objects.equals(title, other.title);
    }

    /**
     * @return a string representation of the book
     */
    @Override
    public String toString() {
        return new StringBuilder("\n{")
                .append("author: ").append(author).append(", ")
                .append("title: ").append(title).append(", ")
                .append("pageCount: ").append(pageCount).append("}").toString();
    }

}
