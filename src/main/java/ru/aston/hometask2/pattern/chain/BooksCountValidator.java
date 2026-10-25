package ru.aston.hometask2.pattern.chain;

import ru.aston.hometask2.model.Student;

public class BooksCountValidator extends StudentValidator {
    @Override
    public boolean validate(Student student) {
        if (student.getBooks().size() < 5) {
            System.out.println("Ошибка: у студента " + student.getName() + " меньше 5 книг.");
            return false;
        }
        return checkNext(student);
    }
}