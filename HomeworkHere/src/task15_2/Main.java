package task15_2;

import java.awt.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Animals animals = new Animals(new Stack<>());
        animals.addName("Cat");
        animals.addName("Dog");
        animals.addName("Rabbit");
        System.out.println(animals);
        animals.deleteName();
        System.out.println(animals);
        animals.addName("Tiger");
        System.out.println(animals);
    }
}
