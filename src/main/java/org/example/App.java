package org.example;

import org.example.model.Student;
import org.example.service.StudentService;
import org.example.service.Impl.StudentServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static final Scanner scanner = new Scanner(System.in);
    public static final Scanner sc = new Scanner(System.in);
    public static void main( String[] args ) throws SQLException {
        StudentService studentService = new StudentServiceImpl();
        while (true){
            System.out.println("Number ");
            int a = scanner.nextInt();
            if(a == 1){
                studentService.createStudent();
            }
            else if(a == 2){
                System.out.println("name ");
                String name = scanner.nextLine();
                System.out.println("Age; ");
                int age = sc.nextInt();
                studentService.saveStudent(new Student(name,age));
            }
            else if(a == 3){
                studentService.dropStudent();
                System.out.println("done");
            }
            else if(a == 4){
                System.out.println("ID ");
                int id = sc.nextInt();
                studentService.findById((long) id);
            }
            else if(a == 5){
                System.out.println("delete id ");
                int id = sc.nextInt();
                studentService.deleteById((long) id);
            } else if (a == 6) {
                System.out.println("All students");
                studentService.findAllStudent().forEach(System.out::println);
            } else if (a == 7) {
                System.out.println("Student id ");
                int id = sc.nextInt();
                System.out.println("NAME ");
                String name = scanner.nextLine();
                System.out.println("Age ");
               int age = sc.nextInt();
               studentService.updateStudent((long) id, new Student(name,age));
            } else if (a == 8) {
                System.out.println("clean");
                studentService.cleanTable();
            }
            else {
                System.err.println("ERROR");
            }
        }

    }
}
