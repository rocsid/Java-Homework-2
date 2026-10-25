package ru.aston.hometask2.pattern.decorator;

import ru.aston.hometask2.model.Book;

public class SimpleBookPrinter implements BookPrinter {
    @Override
    public void print(Book book) {
        System.out.print(book.getTitle() + " - " + book.getAuthor());
    }
}