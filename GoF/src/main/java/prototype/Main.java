package prototype;

public class Main {
    public static void main(String[] args) {
        Human original = new Human("Pavel", 18);
        System.out.println("First human:");
        System.out.println(original);

        Human clone = (Human) original.copy();
        System.out.println("Clone:");
        System.out.println(clone);

        System.out.println("Check:");
        System.out.println(original.equals(clone));

        Car car = new Car("Black", 200, "BMW");
        System.out.println(car);
        Car car1 = (Car) car.copy();
        System.out.println(car1);
    }
}
