package task15_3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LinkedList<Student> students = new LinkedList<>();

        Student student1 = new Student("Lexa", 7, 3, new int[]{4, 6, 2});
        Student student2 = new Student("Alina", 5, 2, new int[]{7, 1, 2, 3});
        Student student3 = new Student("Kirill", 4, 4, new int[]{5, 2, 3, 8});
        Student student4 = new Student("Nastya", 3, 1, new int[]{1, 1, 1, 4});

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        System.out.println(students);

        System.out.println("-----------------------");
        Student.certification(students);
        System.out.println(students);
        Student.printStudents(students, 4);


    }
}
