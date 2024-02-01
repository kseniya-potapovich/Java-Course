package proxy.lesson;

public class Main {
    public static void main(String[] args) {
        Repository repository = new ProxyRepository();
        repository.insertDataToDatabase("Blah blah blah...");
    }
}
