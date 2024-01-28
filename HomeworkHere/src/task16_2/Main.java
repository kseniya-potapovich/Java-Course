package task16_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character, Character> map = new HashMap<>();
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            strings.add(scanner.nextLine());
        }

        for (int i = 0; i < 5; i++) {
            map.put(strings.get(i).charAt(0), strings.get(i).charAt(strings.get(i).length() - 1));
        }
        System.out.println(map);
    }
}
