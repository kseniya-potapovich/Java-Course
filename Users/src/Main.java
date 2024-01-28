import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Scanner scanner = new Scanner(System.in);
        int ID;
        int idClone;
        User userClone;
        System.out.println("Input id ");
        ID = scanner.nextInt();
        System.out.println("Which method to execute? " +
                "\nclone() -> 1" +
                "\ncloneGlobal() -> 2");
        idClone = scanner.nextInt();

        User[] users = new User[3];
        users[0] = new User(0, new Computer("Asus"));
        users[1] = new User(1, new Computer("Mac"));
        users[2] = new User(2, new Computer("Hp"));

        if (idClone == 1) {
            userClone = (User) users[ID].clone();
        } else {
            userClone = (User) users[ID].cloneGlobal();
        }

        System.out.println("Users[ID]: " + users[ID]);
        System.out.println("USERClone: " + userClone);
        System.out.println("------------------");
        userClone.getComputer().setModel("Dell");
        userClone.setId(3);
        System.out.println("Users[ID]: " + users[ID]);
        System.out.println("USERClone: " + userClone);

        /*System.out.println(users[ID].hashCode());
        System.out.println(userClone.hashCode());*/
    }
}
