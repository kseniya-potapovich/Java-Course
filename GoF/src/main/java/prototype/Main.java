package prototype;

public class Main {
    public static void main(String[] args) {
        Human original = new Human("Pavel", 18);
        System.out.println("First human: ");
        System.out.println(original);

        Human clone = (Human) original.copy();
        System.out.println("Clone: ");
        System.out.println(clone);

        System.out.println(original.equals(clone));
    }
}
