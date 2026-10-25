package ru.aston.hometask2.pattern.proxy;

import ru.aston.hometask2.model.Student;
import java.util.List;

public interface StudentService {
    List<Student> getStudents();
}