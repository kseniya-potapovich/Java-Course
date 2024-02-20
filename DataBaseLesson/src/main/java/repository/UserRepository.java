package repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class UserRepository {

    private final static String SELECT_ALL_FROM_USERS = "SELECT * FROM users";
    private final static String SELECT_USER_FROM_USERS = "SELECT * FROM users WHERE id = ?";
    private final static String INSERT_USER_INTO_USERS = "INSERT INTO users(id, username, user_password, created, changed, age)" +
            "VALUES(DEFAULT,?,?,?,?,?)";
    private final static String UPDATE_USER_INTO_USERS = "UPDATE users SET username = ?, user_password = ?, changed = ?, age = ? WHERE id = ?";
    private final static String DELETE_USER_INTO_USERS = "DELETE FROM users WHERE id = ?";
    private final static String MOST_OLDER_USER = "{? = call max_old_from_users()}";
    private final static String DROP_TELEPHONE_TABLE = "call TRANCATE_TELEPHONE()";

    private Connection connection = null;

    public UserRepository() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/c71_database", "postgres", "root");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

   /* public List<model.User> findAll() {
        List<model.User> users = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_FROM_USERS);
            while (resultSet.next()) {
                model.User user = parseUser(resultSet);
                if (user.getId() != null) {
                    users.add(user);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return users;
    }

    *//**----------------CRUD------------------*//*

     *//**
     * ---------------READ----------------
     *//*
    //достать объект из БД
    public model.User getUserById(Long id) {
        model.User user = new model.User();
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

    *//**
     * --------------CREATE-----------------
     *//*
    public boolean createUser(model.User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_INTO_USERS);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getUserPassword());
            preparedStatement.setTimestamp(3, user.getCreated());
            preparedStatement.setTimestamp(4, user.getChanged());
            preparedStatement.setInt(5, user.getAge());
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    *//**
     * -----UPDATE-------
     *//*
    public boolean updateUser(model.User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_INTO_USERS);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getUserPassword());
            preparedStatement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            preparedStatement.setInt(4, user.getAge());
            preparedStatement.setLong(5, user.getId());
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    */

    /**
     * ------------DELETE------------------
     *//*
    public boolean deleteUser(Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_USER_INTO_USERS);
            statement.setLong(1, id);
            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public model.User parseUser(ResultSet resultSet) {
        model.User user = new model.User();
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

    public boolean checkTransaction() {
        try {
            connection.setAutoCommit(false);
            PreparedStatement statementAge = connection.prepareStatement("UPDATE users SET age = 100 WHERE id = 13");
            PreparedStatement statementUserName = connection.prepareStatement("UPDATE users SET username = 'USER_TRANSACTION' WHERE id = 13");
            PreparedStatement statementPassword = connection.prepareStatement("UPDATE users SET user_password = 'USER_PASS' WHERE id = 13");
            statementAge.executeUpdate();
            statementUserName.executeUpdate();
            statementPassword.executeUpdate();
            connection.commit();
            connection.setAutoCommit(true);
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            try {
                connection.rollback();
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        return false;
    }
*/
    public String getUsernameOfTheMostOldUserFunction() {
        String result_username = null;
        try {
            CallableStatement statement = connection.prepareCall(MOST_OLDER_USER);
            statement.registerOutParameter(1, Types.VARCHAR);
            statement.executeUpdate();
            result_username = statement.getString(1);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result_username;
    }

    public boolean dropTelephoneTableProcedure() {
        try {
            CallableStatement statement = connection.prepareCall(DROP_TELEPHONE_TABLE);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
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
