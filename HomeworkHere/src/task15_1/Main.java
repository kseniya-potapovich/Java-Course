package task15_1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> nums = new HashSet<>();
        for (String num : scanner.next().split(",")) {
            if (!nums.contains(num)) {
                nums.add(num);
                System.out.print(num + " ");
            }
        }
    }
}
