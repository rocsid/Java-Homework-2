package ru.aston.hometask2;

import ru.aston.hometask2.model.Book;
import ru.aston.hometask2.pattern.adapter.ExternalBook;
import ru.aston.hometask2.pattern.adapter.ExternalBookAdapter;
import ru.aston.hometask2.pattern.decorator.*;
import ru.aston.hometask2.pattern.proxy.*;
import ru.aston.hometask2.pattern.strategy.*;

import java.util.ArrayList;
import java.util.List;

public class MainPatterns {
    public static void main(String[] args) {
        System.out.println("=== 1. ПАТТЕРН БИЛДЕР ===");
        Book book1 = new Book.Builder("1984", "Оруэлл").pages(320).year(1949).build();
        Book book2 = new Book.Builder("Дюна", "Герберт").pages(688).year(1965).build();
        List<Book> books = new ArrayList<>(List.of(book1, book2));
        System.out.println("Созданы книги: " + books);

        System.out.println("\n=== 2. ПАТТЕРН СТРАТЕГИЯ ===");
        BookSorter sorter = new BookSorter();
        sorter.setStrategy(new SortByPagesStrategy());
        sorter.sort(books);
        System.out.println("Отсортировано по страницам: " + books);

        System.out.println("\n=== 3. ПАТТЕРН ДЕКОРАТОР ===");
        BookPrinter printer = new PagesDecorator(new YearDecorator(new SimpleBookPrinter()));
        System.out.print("Вывод через декоратор: ");
        printer.print(book1);
        System.out.println();

        System.out.println("\n=== 4. ПАТТЕРН ПРОКСИ ===");
        StudentService proxy = new CachedStudentServiceProxy(new RealStudentService());
        System.out.println("Первый вызов:");
        proxy.getStudents();
        System.out.println("Второй вызов:");
        proxy.getStudents();

        System.out.println("\n=== 5. ПАТТЕРН АДАПТЕР ===");
        ExternalBook ext = new ExternalBook("Гарри Поттер", "Роулинг", 332, 1997);
        Book adapted = ExternalBookAdapter.toInternalBook(ext);
        System.out.println("Адаптированная книга: " + adapted);

        System.out.println("\n=== 6. ПАТТЕРН ЦЕПОЧКА ОБЯЗАННОСТЕЙ ===");
        ru.aston.hometask2.pattern.chain.StudentValidator validator =
                new ru.aston.hometask2.pattern.chain.NameValidator();
        validator.linkWith(new ru.aston.hometask2.pattern.chain.BooksCountValidator());

        ru.aston.hometask2.model.Student realStudent = proxy.getStudents().get(0);
        System.out.println("Проверяем студента: " + realStudent.getName());
        boolean isValid = validator.validate(realStudent);
        System.out.println("Студент прошел валидацию: " + isValid);
    }
}