public class Main {
    public static void main(String[] args) {
        JDBC_Example jdbc_example = new JDBC_Example();
        //System.out.println(jdbc_example.findAll());
        System.out.println(jdbc_example.getUserById(6L));
    }
}
