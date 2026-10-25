package ru.aston.hometask2.pattern.strategy;

import ru.aston.hometask2.model.Book;
import java.util.List;

public class BookSorter {
    private BookSortStrategy strategy;

    public void setStrategy(BookSortStrategy strategy) {
        this.strategy = strategy;
    }

    public void sort(List<Book> books) {
        books.sort(strategy::compare);
    }
}