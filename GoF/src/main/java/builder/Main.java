package builder;

public class Main {
    public static void main(String[] args) {
        House house_1 = new House.Builder().setColor("Red").setRoof("Ecxelent").build();
        System.out.println(house_1);
    }
}
