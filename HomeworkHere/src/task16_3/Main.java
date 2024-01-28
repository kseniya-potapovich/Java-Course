package task16_3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (map.containsValue(str.charAt(i))) {
                stack.push(str.charAt(i));
            } else if (map.containsKey(str.charAt(i))) {
                if (stack.isEmpty() || stack.pop() != map.get(str.charAt(i))) {

                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("Скобки расставлены правильно");
        } else {
            System.out.println("Скобки расставлены неверно");
        }
    }
}
