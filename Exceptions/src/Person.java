public class Person {
    private String login;
    private String password;
    private String confirmPassword;

    static public boolean method(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        try {
            if (login.length() <= 20 && login.replaceAll(" ", "") == login) {
                System.out.println("Login is correct");
            } else {
                throw new WrongLoginException();
            }
            if (password.length() <= 20 && password.replaceAll(" ", "") == password && password.equals(confirmPassword)) {
                System.out.println("Password is correct");
            } else {
                throw new WrongPasswordException();
            }
            return true;
        } catch (WrongLoginException e) {
            e.toString();
        } catch (WrongPasswordException e) {
            e.toString();
        }
        return false;
    }
}
