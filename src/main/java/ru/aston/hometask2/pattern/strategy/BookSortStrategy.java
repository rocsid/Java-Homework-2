package ru.aston.hometask2.pattern.strategy;

import ru.aston.hometask2.model.Book;

public interface BookSortStrategy {
    int compare(Book b1, Book b2);
}