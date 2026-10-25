package ru.aston.hometask2.pattern.strategy;

import ru.aston.hometask2.model.Book;

public class SortByPagesStrategy implements BookSortStrategy {
    @Override
    public int compare(Book b1, Book b2) {
        return Integer.compare(b1.getPages(), b2.getPages());
    }
}