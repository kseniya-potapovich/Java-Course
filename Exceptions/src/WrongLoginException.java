public class WrongLoginException extends Exception {
    private String mes;

    public WrongLoginException() {
        System.out.println("Login isn't correct");
    }

    public WrongLoginException(String message) {
        super(message);
        this.mes=message;
    }

    @Override
    public String toString() {
        return "WrongLoginException: " + mes;
    }
}
