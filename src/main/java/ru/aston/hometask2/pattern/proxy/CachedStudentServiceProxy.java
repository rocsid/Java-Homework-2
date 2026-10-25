package ru.aston.hometask2.pattern.proxy;

import ru.aston.hometask2.model.Student;
import java.util.List;

public class CachedStudentServiceProxy implements StudentService {
    private final StudentService realService;
    private List<Student> cache;

    public CachedStudentServiceProxy(StudentService realService) {
        this.realService = realService;
    }

    @Override
    public List<Student> getStudents() {
        if (cache == null) {
            System.out.println("--- Кэш пуст, читаем файл... ---");
            cache = realService.getStudents();
        } else {
            System.out.println("--- Отдаем данные из кэша ---");
        }
        return cache;
    }
}