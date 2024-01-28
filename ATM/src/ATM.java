import java.util.Arrays;

public class ATM {
    int count20;
    int count50;
    int count100;
    int allMoney;

    public ATM(int count20, int count50, int count100) {
        this.count20 = count20;
        this.count50 = count50;
        this.count100 = count100;
        this.allMoney = count100 * 100 + count50 * 50 + count20 * 20;
    }

    void addMoney(int x20, int x50, int x100) {
        count20 += x20;
        count50 += x50;
        count100 += x100;
        allMoney += x100 * 100 + x50 * 50 + x20 * 20;
    }

    boolean takeOfMoney(int summaOfMoney) {
        if (summaOfMoney % 10 != 0) {
            System.out.println("Операция не выполнена");
            return false;
        }
        int n = count100, m = count50, k = count20;
        int[] array = new int[3];
        if (summaOfMoney <= allMoney) {
            int temp = summaOfMoney % 100;
            if (temp / 10 % 2 == 1) {
                if (m > 0) {
                    array[1]++;
                    m--;
                    summaOfMoney -= 50;
                    temp = summaOfMoney % 100;
                } else {
                    System.out.println("Операция не выполнена");
                    return false;
                }
            }
            temp = temp / 20;
            if (temp <= k) {
                array[2] += temp;
                summaOfMoney -= 20 * temp;
                k -= temp;
            } else {
                System.out.println("Операция не выполнена");
                return false;
            }
            temp = summaOfMoney / 100;
            if (temp <= n) {
                array[0] = temp;
                summaOfMoney -= 100 * temp;
                n -= temp;
            } else {
                array[0] = n;
                summaOfMoney -= 100 * n;
                n -= n;
            }
            temp = summaOfMoney / 50;
            if (temp > 0) {
                if (temp <= m) {
                    array[1] += temp;
                    m -= temp;
                } else {
                    System.out.println("Операция не выполнена");
                    return false;
                }
            }
            count100 = n;
            count50 = m;
            count20 = k;
            allMoney = n * 100 + m * 50 + k * 20;
            System.out.println(Arrays.toString(array));
            return true;
        } else {
            System.out.println("Операция не выполнена");
            return false;
        }
    }
}