package ru.aston.hometask2.model;

import java.util.Objects;

public class Book implements Comparable<Book> {
    private final String title;
    private final String author;
    private final int pages;
    private final int year;

    public Book(final String title, final String author, final int pages, final int year) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.year = year;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPages() { return pages; }
    public int getYear() { return year; }

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
}