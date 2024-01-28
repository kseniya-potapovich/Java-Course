public class WrongPasswordException extends Exception{
    private String mes;

    public WrongPasswordException() {
        System.out.println("Password isn't correct");
    }

    public WrongPasswordException(String message) {
        super(message);
        this.mes = message;
    }

    @Override
    public String toString() {
        return "WrongPasswordException: " + mes;
    }
}
