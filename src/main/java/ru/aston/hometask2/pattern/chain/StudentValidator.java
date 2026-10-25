package ru.aston.hometask2.pattern.chain;

import ru.aston.hometask2.model.Student;

public abstract class StudentValidator {
    private StudentValidator next;

    public StudentValidator linkWith(StudentValidator next) {
        this.next = next;
        return next;
    }

    public abstract boolean validate(Student student);

    protected boolean checkNext(Student student) {
        if (next == null) return true;
        return next.validate(student);
    }
}