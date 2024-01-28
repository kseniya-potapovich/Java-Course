import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] strs = new String[3];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = scanner.nextLine();
        }

        String theLongest = null;
        int theMaxLength = 0;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() > theMaxLength) {
                theLongest = strs[i];
                theMaxLength = strs[i].length();
            }
        }

        int theMinLength = strs[0].length();
        String theShortest = strs[0];
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < theMinLength) {
                theShortest = strs[i];
                theMinLength = strs[i].length();
            }
        }

        System.out.println("The longest string is " + "'" + theLongest + "'" + " with length " + theMaxLength);
        System.out.println("The shortest string is " + "'" + theShortest + "'" + " with length " + theMinLength);

        System.out.println("-------------------");
        int[] sizeOfString = new int[strs.length];
        int[] count = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            sizeOfString[i] = strs[i].length();
            count[i] = i;
        }
        for (int i = 0; i < strs.length - 1; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (sizeOfString[i] > sizeOfString[j]) {
                    int temp = count[i];
                    count[i] = count[j];
                    count[j] = temp;
                }
            }
        }
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[count[i]]);
        }

        System.out.println("-------------------");
        double sum = 0;
        for (int i = 0; i < strs.length; i++) {
            sum += sizeOfString[i];
        }
        sum = sum / strs.length;
        //System.out.println(sum);
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < sum) {
                System.out.println(strs[i] + "\t" + strs[i].length());
            }
        }

        System.out.println("-------------------");
        String[] words1 = strs[0].split(" ");
        String[] words2 = strs[1].split(" ");
        String[] words3 = strs[2].split(" ");
        int size = words1.length + words2.length + words3.length;
        /*for (int i =0;i<words1.length;i++){
            System.out.println(words1[i]);
        }
        for (int i =0;i< words2.length;i++){
            System.out.println(words2[i]);
        }
        for (int i =0;i< words3.length;i++){
            System.out.println(words3[i]);
        }*/
        System.out.println("Пункта 4 не будет");

        System.out.println("-------------------");
        String text = scanner.nextLine();
        System.out.println("Пункта 5 тоже кажись не будет");
    }
}
