import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {


        List<Student> students = Files.readAllLines(Path.of("students.txt"))
                .stream()
                .map(line -> {
                    String[] parts = line.split(";");
                    Student student = new Student(parts[0]);
                    for (int i = 1; i < parts.length; i++) {
                        String[] b = parts[i].split(",");
                        student.addBook(new Book(b[0], b[1],
                                Integer.parseInt(b[2]), Integer.parseInt(b[3])));
                    }
                    return student;
                })
                .collect(Collectors.toList());


        students.stream()
                .peek(System.out::println)
                .map(Student::getBooks)
                .flatMap(List::stream)
                .sorted()
                .distinct()
                .filter(book -> book.getYear() > 2000)
                .limit(3)
                .map(Book::getYear)
                .findFirst()
                .ifPresentOrElse(
                        year -> System.out.println("Год выпуска найденной книги: " + year),
                        () -> System.out.println("Такая книга отсутствует")
                );
    }
}