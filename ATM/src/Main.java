public class Main {
    public static void main(String[] args) {
        ATM atm1 = new ATM(1,1,1);
        atm1.addMoney(3,0,1);
        System.out.println("Текущая сумма в банкомате " + atm1.allMoney);
        atm1.takeOfMoney(127);
        System.out.println("Остаток суммы в банкомате " + atm1.allMoney);
    }
}
