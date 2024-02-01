package adapter;

/*
1 variant
public class Adapter extends NotificationService implements ISender{
    @Override
    public boolean send(String message) {
        return sendToEmail(message);
    }
}*/

public class Adapter implements ISender{
    private NotificationService notificationService = new NotificationService();
    @Override
    public boolean send(String message) {
        return notificationService.sendToEmail(message);
    }
}