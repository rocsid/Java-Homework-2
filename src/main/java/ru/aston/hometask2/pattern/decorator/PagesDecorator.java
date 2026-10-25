package ru.aston.hometask2.pattern.decorator;

import ru.aston.hometask2.model.Book;

public class PagesDecorator implements BookPrinter {
    private final BookPrinter wrapped;

    public PagesDecorator(BookPrinter wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void print(Book book) {
        wrapped.print(book);
        System.out.print(" [" + book.getPages() + " стр.]");
    }
}