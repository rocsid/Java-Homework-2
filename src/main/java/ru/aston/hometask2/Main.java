package ru.aston.hometask2;

import ru.aston.hometask2.model.Student;
import ru.aston.hometask2.service.StudentFileReader;
import ru.aston.hometask2.service.StudentProcessor;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentFileReader reader = new StudentFileReader();
        StudentProcessor processor = new StudentProcessor();
        List<Student> students = reader.readStudents();
        processor.processAndPrint(students);
    }
}