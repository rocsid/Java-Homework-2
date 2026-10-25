package ru.aston.hometask2.pattern.adapter;

import ru.aston.hometask2.model.Book;

public class ExternalBookAdapter {
    public static Book toInternalBook(ExternalBook ext) {
        return new Book.Builder(ext.name, ext.writer)
                .pages(ext.pageCount)
                .year(ext.publishYear)
                .build();
    }
}