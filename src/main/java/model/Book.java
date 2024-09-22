package model;

import java.util.Objects;

public class Book {
    private String author;
    private String title;
    private int pageCount;

    private Book(Builder builder) {
        this.author = builder.author;
        this.title = builder.title;
        this.pageCount = builder.pageCount;
    }

    public static class Builder {
        private String author;
        private String title;
        private int pageCount;

        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder pageCount(int pageCount) {
            this.pageCount = pageCount;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title, pageCount);
    }

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

    @Override
    public String toString() {
        return "Book{" +
                "author=" + author +
                ", title=" + title +
                ", pageCount=" + pageCount +
                "}";
    }

}

