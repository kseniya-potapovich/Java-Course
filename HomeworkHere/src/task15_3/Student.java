package task15_3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Student {
    private String name;
    private int group;
    private int course;
    private int[] grades;
    private final static List<Student> students = new ArrayList<>();

    public Student(String name, int group, int course, int[] grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }


    public static void certification(LinkedList<Student> students) {
        List<Student> studentsSendDown = new ArrayList<>();
        double GPA;
        for (int i = 0; i < students.size(); i++) {
            GPA = students.get(i).GPA();
            if (GPA < 3) {
                students.remove(students.get(i));
            } else {
                if (students.get(i).course == 4 && GPA >= 3) {
                    students.get(i).course = 100;
                } else {
                    students.get(i).course = students.get(i).course + 1;
                }
            }
        }
    }

    private double GPA() {
        int sum = 0;
        for (int i = 0; i < grades.length; i++) {
            sum = sum + grades[i];
        }
        return (double) sum / grades.length;
    }

    public static void printStudents(LinkedList<Student> students, int course){
        for (int i =0; i< students.size();i++){
            if (students.get(i).course == course){
                System.out.println(students.get(i).name);
            }
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", group=" + group +
                ", course=" + course +
                '}';
    }
}
