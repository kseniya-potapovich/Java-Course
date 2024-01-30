package fabric_method;

import fabric_method.fabric.ICourse;
import fabric_method.fabric.JavaCourse;

public class Main {
    public static void main(String[] args) {
        ICourse course = new JavaCourse();
        System.out.println(course.getDeveloper());
        course.courseInfo();
    }
}
