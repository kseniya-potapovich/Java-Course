import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBC_Example {

    private final static String SELECT_ALL_FROM_USERS = "SELECT * FROM users";
    private final static String SELECT_USER_FROM_USERS = "SELECT * FROM users WHERE id = ?";

    private Connection connection = null;

    public JDBC_Example() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/c71_database", "postgres", "root");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_FROM_USERS);
            while (resultSet.next()) {
                User user = parseUser(resultSet);
                if (user.getId() != null) {
                    users.add(user);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return users;
    }

    /**----------------CRUD---------------*/

    /**
     * ---------------READ----------------
     */
    //достать объект из БД
    public User getUserById(Long id) {
        User user = new User();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_USER_FROM_USERS);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = parseUser(resultSet);
                if (user.getId() != null) {
                    return user;
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return user;
    }

    public User parseUser(ResultSet resultSet) {
        User user = new User();
        try {
            user.setId(resultSet.getLong("id"));
            user.setUsername(resultSet.getString("username"));
            user.setUserPassword(resultSet.getString("user_password"));
            user.setCreated(resultSet.getTimestamp("created"));
            user.setChanged(resultSet.getTimestamp("changed"));
            user.setAge(resultSet.getInt("age"));
        } catch (SQLException e) {
            System.out.println(e);
        }
        return user;
    }

    /* public void findAll() {
        try {
            //1. Регистрация драйвера
            Class.forName("org.postgresql.Driver");

            //2. Создаем соединение (URL, login, password)
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/c71_database", "postgres", "root");

            //3. Описать Statement(request) Statement(обычный), PrepareStatement(подготовленный), CallableStatement
            // Statement - редназначен для выполнения простых SQL-запросов без параметров;
            // содержит базовые методы для выполнения запросов и извлечения результатов.
            Statement statement = connection.createStatement();
            *//*statement.execute("DROP TABLE users"); //отправляет и возращает boolean
            statement.executeQuery("SELECT * FROM users"); //отправит и вернет вам ответ(ResultSet)
            statement.executeUpdate("CREATE DELETE UPDATE"); //используется для команд для обновления CREATE UPDATE DELETE*//*
            ResultSet select_all = statement.executeQuery(SELECT_ALL_FROM_USERS);

            //4. Парсинг ResultSet
            while (select_all.next()) {
                System.out.println("id: " + select_all.getLong("id") +
                        ", username: " + select_all.getString("username") +
                        ", user_password: " + select_all.getString("user_password") +
                        ", created: " + select_all.getTimestamp("created") +
                        ", changed:" + select_all.getTimestamp("changed") +
                        ", age: " + select_all.getInt("age"));
            }
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }*/
}
