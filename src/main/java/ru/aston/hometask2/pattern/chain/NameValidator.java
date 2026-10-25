package ru.aston.hometask2.pattern.chain;

import ru.aston.hometask2.model.Student;

public class NameValidator extends StudentValidator {
    @Override
    public boolean validate(Student student) {
        if (student.getName() == null || student.getName().isBlank()) {
            System.out.println("Ошибка: пустое имя.");
            return false;
        }
        return checkNext(student);
    }
}
