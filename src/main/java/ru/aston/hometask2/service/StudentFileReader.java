package ru.aston.hometask2.service;

import ru.aston.hometask2.exception.DataReadException;
import ru.aston.hometask2.model.Book;
import ru.aston.hometask2.model.Student;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class StudentFileReader {
    private static final String FILE_NAME = "students.txt";
    private static final String STUDENT_DELIMITER = ";";
    private static final String BOOK_DELIMITER = ",";
    private static final int MIN_BOOKS = 5;
    private static final int IDX_TITLE = 0;
    private static final int IDX_AUTHOR = 1;
    private static final int IDX_PAGES = 2;
    private static final int IDX_YEAR = 3;

    public List<Student> readStudents() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(FILE_NAME);
        if (inputStream == null) {
            throw new DataReadException("Файл " + FILE_NAME + " не найден в resources", null);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            List<String> lines = reader.lines().toList();
            List<Student> students = new ArrayList<>();

            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i).trim();
                if (line.isEmpty()) continue;
                try {
                    students.add(parseStudent(line));
                } catch (Exception e) {
                    throw new DataReadException("Ошибка в строке " + (i + 1) + ": " + e.getMessage(), e);
                }
            }
            return students;
        } catch (Exception e) {
            throw new DataReadException("Ошибка при чтении файла", e);
        }
    }

    private Student parseStudent(final String line) {
        String[] parts = line.split(STUDENT_DELIMITER);
        if (parts.length < 2) throw new IllegalArgumentException("Нет данных о книгах");

        String studentName = parts[0].trim();
        List<Book> books = new ArrayList<>();

        for (int i = 1; i < parts.length; i++) {
            String[] bookParts = parts[i].split(BOOK_DELIMITER);
            if (bookParts.length != 4) throw new IllegalArgumentException("Неверный формат книги: " + parts[i]);

            books.add(new Book.Builder(bookParts[IDX_TITLE].trim(), bookParts[IDX_AUTHOR].trim())
                    .pages(Integer.parseInt(bookParts[IDX_PAGES].trim()))
                    .year(Integer.parseInt(bookParts[IDX_YEAR].trim()))
                    .build());
        }
        if (books.size() < MIN_BOOKS) throw new IllegalArgumentException("Меньше " + MIN_BOOKS + " книг");
        return new Student(studentName, books);
    }
}