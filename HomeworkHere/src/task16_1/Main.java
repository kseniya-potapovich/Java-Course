package task16_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Boolean> map = new HashMap<>();
        //int n = scanner.nextInt();
        String[] strings = new String[5];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = scanner.nextLine();
        }

        for (int i = 0; i < strings.length; i++) {
            if (map.containsKey(strings[i])) {
                map.put(strings[i], true);
            } else {
                map.put(strings[i], false);
            }
        }
        System.out.println(map);
    }
}
