import repository.UserRepository;

public class Main {
    public static void main(String[] args) {
        UserRepository jdbc_example = new UserRepository();
        //System.out.println(jdbc_example.findAll());
        /*System.out.println(jdbc_example.getUserById(6L));

        model.User user = new model.User(7L,
                "Andrey",
                "qwerty123",
                new Timestamp(System.currentTimeMillis()),
                new Timestamp(System.currentTimeMillis()),
                30 );

        //System.out.println(jdbc_example.createUser(user));
       // System.out.println(jdbc_example.updateUser(user));

        System.out.println(jdbc_example.deleteUser(7L));*/

        /*jdbc_example.checkTransaction();*/
        /*System.out.println(jdbc_example.dropTelephoneTableProcedure());
        System.out.println(jdbc_example.getUsernameOfTheMostOldUserFunction());*/
    }
}
