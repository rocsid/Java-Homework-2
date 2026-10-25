package ru.aston.hometask2.service;

import ru.aston.hometask2.model.Book;
import ru.aston.hometask2.model.Student;

import java.util.Comparator;
import java.util.List;

public class StudentProcessor {
    private static final int MIN_YEAR = 2000;
    private static final int STREAM_LIMIT = 3;

    public void processAndPrint(final List<Student> students) {
        students.stream()
                .peek(System.out::println)
                .map(Student::getBooks)
                .flatMap(List::stream)
                .sorted(Comparator.comparingInt(Book::getPages))
                .distinct()
                .filter(book -> book.getYear() > MIN_YEAR)
                .limit(STREAM_LIMIT)
                .map(Book::getYear)
                .findFirst()
                .ifPresentOrElse(
                        year -> System.out.println("Год выпуска найденной книги: " + year),
                        () -> System.out.println("Такая книга отсутствует")
                );
    }
}