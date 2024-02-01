package adapter;
/** Adapter - help incompatible interfaces work together */
public class Main {
    public static void main(String[] args) {
        ISender sender = new Adapter();
        sender.send("\nYour login: Kseniya \npassword: qwerty");
        sender.send("\nYour login: Kseniya \npassword: qwerty");
        sender.send("\nYour login: Kseniya \npassword: qwerty");
        sender.send("\nYour login: Kseniya \npassword: qwerty");
        sender.send("\nYour login: Kseniya \npassword: qwerty");
        sender.send("\nYour login: Kseniya \npassword: qwerty");
    }
}
