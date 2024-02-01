package adapter;

public class NotificationService {
    public boolean sendToEmail(String message) {
        try {
            System.out.println("I send message to email: " + message);
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public void printMessage() {
        System.out.println("Print all message");
    }
}
