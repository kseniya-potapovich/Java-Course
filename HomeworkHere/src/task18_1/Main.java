package task18_1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10;i++){
            list.add(scanner.nextInt());
        }
        list.stream()
                .distinct()
                .filter(number -> number%2==0)
                .forEach(System.out::println);

    }

}
