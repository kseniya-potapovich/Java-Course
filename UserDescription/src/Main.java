public class Main {
    public static void main(String[] args) {
        User user1 = new User("Valera", 24, 15);
        User user2 = new User("Valera", 24, 15);

        System.out.println(user1.equals(user2));
    }
}
