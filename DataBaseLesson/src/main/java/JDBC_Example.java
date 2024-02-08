import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_Example {
    public static void main(String[] args) {

    }

    public void findAll() {
        try {
            //1. Регистрация драйвера
            Class.forName("org.postgresql.Driver");

            //2. Создаем соединение (URL, login, password)
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/c71_database", "c71_database", "root");

            //3.
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
}
