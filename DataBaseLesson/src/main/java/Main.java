import java.sql.Timestamp;

public class Main {
    public static void main(String[] args) {
        JDBC_Example jdbc_example = new JDBC_Example();
        //System.out.println(jdbc_example.findAll());
        /*System.out.println(jdbc_example.getUserById(6L));

        User user = new User(7L,
                "Andrey",
                "qwerty123",
                new Timestamp(System.currentTimeMillis()),
                new Timestamp(System.currentTimeMillis()),
                30 );

        //System.out.println(jdbc_example.createUser(user));
       // System.out.println(jdbc_example.updateUser(user));

        System.out.println(jdbc_example.deleteUser(7L));*/

        jdbc_example.checkTransaction();

    }
}
