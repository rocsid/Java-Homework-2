package ru.aston.hometask2.pattern.proxy;

import ru.aston.hometask2.model.Student;
import ru.aston.hometask2.service.StudentFileReader;
import java.util.List;

public class RealStudentService implements StudentService {
    private final StudentFileReader reader = new StudentFileReader();

    @Override
    public List<Student> getStudents() {
        return reader.readStudents();
    }
}