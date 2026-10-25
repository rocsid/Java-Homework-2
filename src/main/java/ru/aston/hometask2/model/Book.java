package ru.aston.hometask2.model;

import java.util.Objects;

public class Book implements Comparable<Book> {
    private final String title;
    private final String author;
    private final int pages;
    private final int year;
    private final String genre;

    private Book(Builder builder) {
        this.title = builder.title;
        this.author = builder.author;
        this.pages = builder.pages;
        this.year = builder.year;
        this.genre = builder.genre;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPages() { return pages; }
    public int getYear() { return year; }
    public String getGenre() { return genre; }

    @Override
    public int compareTo(final Book other) {
        int pagesCompare = Integer.compare(this.pages, other.pages);
        if (pagesCompare != 0) return pagesCompare;
        int yearCompare = Integer.compare(this.year, other.year);
        if (yearCompare != 0) return yearCompare;
        int titleCompare = this.title.compareTo(other.title);
        if (titleCompare != 0) return titleCompare;
        return this.author.compareTo(other.author);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return pages == book.pages && year == book.year
                && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, pages, year);
    }

    @Override
    public String toString() {
        return "Book{" + title + ", " + author + ", " + pages + " стр., " + year + "}";
    }

    // Паттерн Билдер
    public static class Builder {
        private final String title;
        private final String author;
        private int pages;
        private int year;
        private String genre = "Unknown";

        public Builder(String title, String author) {
            this.title = title;
            this.author = author;
        }

        public Builder pages(int pages) { this.pages = pages; return this; }
        public Builder year(int year) { this.year = year; return this; }
        public Builder genre(String genre) { this.genre = genre; return this; }

        public Book build() {
            return new Book(this);
        }
    }
}