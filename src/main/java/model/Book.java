package model;

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
}

